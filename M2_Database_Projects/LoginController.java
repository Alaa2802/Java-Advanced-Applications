package com.example.grup2fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    Button btnCancel;

    @FXML
    Button btnLogin;

    @FXML
    TextField txtUsername;

    @FXML
    PasswordField txtPassword;

    @FXML
    Label lblMessage;

    public void btnCancelOnAction(ActionEvent event){
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }
    public void btnLoginOnAction(ActionEvent event){
        if(txtUsername.getText().isBlank() == false && txtPassword.getText().isBlank() == false )
            lblMessage.setText("You are trying to login");
        else
            lblMessage.setText("Please, enter a username and password");
    }

}