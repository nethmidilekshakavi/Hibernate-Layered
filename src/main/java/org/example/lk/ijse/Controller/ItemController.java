package org.example.lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import org.example.lk.ijse.BO.BOFactory;
import org.example.lk.ijse.BO.custom.ItemBo;
import org.example.lk.ijse.Entity.Item;

import java.sql.SQLException;


public class ItemController {

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
    private TableView<?> itemTable;

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

}
