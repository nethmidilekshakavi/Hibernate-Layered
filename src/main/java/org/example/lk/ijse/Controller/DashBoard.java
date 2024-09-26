package org.example.lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class DashBoard {

    @FXML
    private Button btncustomer;

    @FXML
    private Button btnitrm;

    @FXML
    private Button btnorder;

    @FXML
    private Text dashboardtxt;

    @FXML
    void customerOnAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/Customer.fxml"))));
        stage.show();
        stage.centerOnScreen();
        stage.setTitle("Customer Form");

    }

    @FXML
    void itrmOnAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/Item.fxml"))));
        stage.show();
        stage.centerOnScreen();
        stage.setTitle("Item Form");
    }

    @FXML
    void orderOnAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/Order.fxml"))));
        stage.show();
        stage.centerOnScreen();
        stage.setTitle("Item Form");
    }

}
