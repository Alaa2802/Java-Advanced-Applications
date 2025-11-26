package edu.erciyes.fxform;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class RegistrationForm extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25, 25, 25, 25));

        Label lblTitle = new Label("Registration Form");
        lblTitle.setFont(Font.font("Arial",24.0));
        lblTitle.setTextFill(Color.DARKBLUE);
        root.add(lblTitle, 1, 0, 2, 1);

        Label lblName = new Label("Name");
        lblName.setAlignment(Pos.CENTER_RIGHT);
        root.add(lblName,1,1);
        TextField txtName = new TextField("Name");
        txtName.setAlignment(Pos.CENTER_LEFT);
        root.add(txtName,2,1);


        Label lblSurname = new Label("Surname");
        lblSurname.setAlignment(Pos.CENTER_RIGHT);
        root.add(lblSurname,1,2);
        TextField txtSurname = new TextField("Surname");
        txtSurname.setAlignment(Pos.CENTER_LEFT);
        root.add(txtSurname,2,2);

        Label lblGender = new Label("Gender: ");
        ToggleGroup genderGroup = new ToggleGroup();
        RadioButton rbMale = new RadioButton("Male");
        rbMale.setToggleGroup(genderGroup);
        RadioButton rbFemale = new RadioButton("Female");
        rbFemale.setToggleGroup(genderGroup);

        HBox genderBox = new HBox();
        genderBox.setSpacing(10.0);
        genderBox.getChildren().addAll(lblGender, rbMale, rbFemale);
        root.add(genderBox, 1, 3, 2,1);

        Label lblSkills = new Label("Skills:");
        lblSurname.setAlignment(Pos.TOP_RIGHT);
        root.add(lblSkills, 1, 4);

        CheckBox cbJava = new CheckBox("Java");
        CheckBox cbCPP = new CheckBox("C++");
        CheckBox cbCS = new CheckBox("C#");
        VBox boxSkill = new VBox();
        boxSkill.setSpacing(10.0);
        boxSkill.getChildren().addAll(cbJava, cbCPP, cbCS);
        root.add(boxSkill, 2, 4);


        Label lblUni = new Label("University:");
        root.add(lblUni, 1, 5);
        ComboBox<String> cmbUniversity = new ComboBox<>();
        cmbUniversity.getItems().addAll(
                "Erciyes University",
                "Abdullah Gul University",
                "Nuh Naci Yazgan University",
                "Kayseri University"
        );
        cmbUniversity.setPromptText("University");
        cmbUniversity.setEditable(false);
        root.add(cmbUniversity, 2, 5);

        ImageView imSubmit = new ImageView("https://cdn-icons-png.flaticon.com/512/1933/1933005.png");
        imSubmit.setFitHeight(20.0);
        imSubmit.setFitWidth(20.0);
        Button btnSubmit = new Button("Submit", imSubmit);
        root.add(btnSubmit, 2,6);

        Scene scene = new Scene(root, 600, 600);
        stage.setScene(scene);
        stage.show();

    }
}
