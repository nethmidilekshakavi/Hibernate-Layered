package org.example.lk.ijse.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import org.example.lk.ijse.BO.BOFactory;
import org.example.lk.ijse.BO.custom.ItemBo;
import org.example.lk.ijse.DTO.Tm.ItemTm;
import org.example.lk.ijse.Entity.Item;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;


public class ItemController implements Initializable {

    ItemBo itemBo = (ItemBo) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ITEM);

    @FXML
    private TableColumn<?, ?> COLPRICE;

    @FXML
    private TextField codetxt;

    @FXML
    private TableColumn<?, ?> colcode;

    @FXML
    private TableColumn<?, ?> colname;

    @FXML
    private TableColumn<?, ?> colqty;

    @FXML
    private Button deletebtn;

    @FXML
    private TableView<ItemTm> itemTable;

    @FXML
    private TextField nametxt;

    @FXML
    private TextField pricetxt;

    @FXML
    private TextField qtytxt;

    @FXML
    private Button savebtn;

    @FXML
    private Text title;

    @FXML
    private Button updatebtn;

    @FXML
    void deleteOnAction(ActionEvent event) {
        int code = Integer.parseInt(codetxt.getText());

        boolean c = false;

        try {
            c = itemBo.deleteItem(code);
        } catch (SQLException e) {
            throw new RuntimeException(String.valueOf(c));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        if (c){
            new Alert(Alert.AlertType.ERROR,"Item not delete");
        }
        else {
            new Alert(Alert.AlertType.CONFIRMATION,"Item delete Success").show();

        }
    }

    @FXML
    void saveOnAction(ActionEvent event) {
        int code = Integer.parseInt(codetxt.getText());
        String name = nametxt.getText();
        int qty = Integer.parseInt(qtytxt.getText());
        String price = pricetxt.getText();

        Item item = new Item(code,name,qty,price);
        boolean i = false;

        i = itemBo.saveItem(item);


        if (i){
            new Alert(Alert.AlertType.ERROR,"Item not Save");
        }
        else {
            new Alert(Alert.AlertType.CONFIRMATION,"Item Save Success").show();

        }
    }

    @FXML
    void updateOnAction(ActionEvent event) {
        int code = Integer.parseInt(codetxt.getText());
        String name = nametxt.getText();
        int qty = Integer.parseInt(qtytxt.getText());
        String price = pricetxt.getText();

        Item item = new Item(code,name,qty,price);
        boolean i = false;

        i = itemBo.UpdateItem(item);


        if (i){
            new Alert(Alert.AlertType.ERROR,"Item not Update");
        }
        else {
            new Alert(Alert.AlertType.CONFIRMATION,"Item Update Success").show();

        }
    }

    public void loadallvalues() throws SQLException {

        List<Item> allItem = itemBo.getAllItem();


        for (Item item : allItem) {
            System.out.println(item.getCode() + ": " + item.getName() + " - " + item.getQty() + " - " + item.getPrice());
        }


        ObservableList<ItemTm> observableList = FXCollections.observableArrayList();

        for (int i = 0; i < allItem.size(); i++) {
            ItemTm itemTm = new ItemTm(
                    allItem.get(i).getCode(),
                    allItem.get(i).getName(),
                    allItem.get(i).getQty(),
                    allItem.get(i).getPrice()
            );

            observableList.add(itemTm);
        }

        itemTable.setItems(observableList);
    }

    public void setValues(){
        colcode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colname.setCellValueFactory(new PropertyValueFactory<>("name"));
        colqty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        COLPRICE.setCellValueFactory(new PropertyValueFactory<>("price"));
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setValues();
        try {
            loadallvalues();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
