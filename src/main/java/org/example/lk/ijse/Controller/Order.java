package org.example.lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Order {

    @FXML
    private Text DATE;

    @FXML
    private ComboBox<?> ItemCodeCombo;

    @FXML
    private Text cusnametxt;

    @FXML
    private ComboBox<?> customerTeleCombo;

    @FXML
    private Text customerteletitile;

    @FXML
    private Text customerteletitile1;

    @FXML
    private Text datetxt;

    @FXML
    private Text description;

    @FXML
    private Text descriptiontxt;

    @FXML
    private Text itemCodeTitle;

    @FXML
    private Button newCustomerAdd;

    @FXML
    private Text oidtxt;

    @FXML
    private Text orderIDtitle;

    @FXML
    private Text price;

    @FXML
    private Text pricetxt;

    @FXML
    private Text qoh;

    @FXML
    private Text qohtxt;

    @FXML
    private Text qty;

    @FXML
    private TextField qtytxt;

    @FXML
    private Text title;

    @FXML
    private Text titletxt;

    @FXML
    void PLACEORDER(ActionEvent event) {

    }

    @FXML
    void addtoCart(ActionEvent event) {

    }

    @FXML
    void openCustomerForm(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/Customer.fxml"))));
        stage.show();
        stage.centerOnScreen();
        stage.setTitle("Item Form");
    }

}
