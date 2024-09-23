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
import org.example.lk.ijse.BO.custom.CustomerBO;
import org.example.lk.ijse.Entity.Customer;
import org.example.lk.ijse.DTO.Tm.CusromerTM;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class CustomerController implements Initializable {

    CustomerBO customerBO = (CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);

    @FXML
    private TableColumn<?, String> addresstbl;

    @FXML
    private TextField addresstxt;

    @FXML
    private TableColumn<?, Integer> contacttbl;

    @FXML
    private TextField contatctxt;

    @FXML
    private TableView<CusromerTM> customertable;

    @FXML
    private Button deletebtn;

    @FXML
    private TableColumn<?, Integer> idtbl;

    @FXML
    private TextField idtxt;

    @FXML
    private TableColumn<?, String> nametbl;

    @FXML
    private TextField nametxt;

    @FXML
    private Button savebtn;

    @FXML
    private Text title;

    @FXML
    private Button updatebtn;

    @FXML
    void deleteOnAction(ActionEvent event) {
        int id = Integer.parseInt(idtxt.getText());

        boolean c = false;

        try {
            c = customerBO.deleteCustomer(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        if (c){
            new Alert(Alert.AlertType.ERROR,"Customer not delete");
        }
        else {
            new Alert(Alert.AlertType.CONFIRMATION,"Customer delete Success").show();

        }
    }

    @FXML
    void saveOnAction(ActionEvent event) {
        int id = Integer.parseInt(idtxt.getText());
        String nam = nametxt.getText();
        String address = addresstxt.getText();
        int contact = Integer.parseInt(contatctxt.getText());

        Customer customer = new Customer(id,nam,address,contact);
        boolean c = false;

        try {
            c = customerBO.saveCustomer(customer);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        if (c){
           new Alert(Alert.AlertType.ERROR,"Customer not Save");
        }
        else {
            new Alert(Alert.AlertType.CONFIRMATION,"Customer Save Success").show();

        }
    }


    @FXML
    void updateOnAction(ActionEvent event) {
        int id = Integer.parseInt(idtxt.getText());
        String name = nametxt.getText();
        String address = addresstxt.getText();
        int contact = Integer.parseInt(contatctxt.getText());



        boolean c  = false;
        try {
            c = customerBO.updateCustomer(new Customer(id,name,address,contact));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        if (c){
            new Alert(Alert.AlertType.ERROR,"Customer not Update");
        }
        else {
            new Alert(Alert.AlertType.CONFIRMATION,"Customer Update Success").show();

        }
    }

    public void loadallvalues() throws SQLException {

        List<Customer> allcustomer = customerBO.getAllCustomer();


        for (Customer customer : allcustomer) {
            System.out.println(customer.getId() + ": " + customer.getName() + " - " + customer.getAddress() + " - " + customer.getContact());
        }


        ObservableList<CusromerTM> observableList = FXCollections.observableArrayList();

        for (int i = 0; i < allcustomer.size(); i++) {
            CusromerTM customerTM = new CusromerTM(
                    allcustomer.get(i).getId(),
                    allcustomer.get(i).getName(),
                    allcustomer.get(i).getAddress(),
                    allcustomer.get(i).getContact()
            );

            observableList.add(customerTM);
        }

        customertable.setItems(observableList);
    }


    public void setValues(){
        idtbl.setCellValueFactory(new PropertyValueFactory<>("id"));
        nametbl.setCellValueFactory(new PropertyValueFactory<>("name"));
        addresstbl.setCellValueFactory(new PropertyValueFactory<>("address"));
        contacttbl.setCellValueFactory(new PropertyValueFactory<>("contact"));
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
