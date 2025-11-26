package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Test extends Application {

    static Button goBackButton;
    static Button exitButton;

    @Override
    public void start(Stage stage) throws Exception {
        VBox startLayout = new VBox(20);
        startLayout.setAlignment(Pos.CENTER);

        VBox optionsLayout = new VBox(15);
        optionsLayout.setAlignment(Pos.CENTER);

        StackPane gamePane = new StackPane();
        gamePane.setAlignment(Pos.CENTER);

        int sceneWidth = 1000;
        int sceneHeight = 800;
        int defaultSize = 10;
        int cellSize = 20;

        Scene startingScene = new Scene(startLayout, sceneWidth, sceneHeight);
        Scene optionsScene = new Scene(optionsLayout, sceneWidth, sceneHeight);
        Scene gameScene = new Scene(gamePane, sceneWidth, sceneHeight);

        Label mainTitle = new Label("HEX GAME");
        mainTitle.setFont(Font.font("Arial", FontWeight.BOLD, 30));

        Button startGameButton = new Button("Start Default Game (10x10)");
        Button optionsButton = new Button("Choose Board Size");
        exitButton = new Button("Exit");

        setButtonSize(startGameButton, optionsButton, exitButton);

        startLayout.getChildren().addAll(mainTitle, startGameButton, optionsButton, exitButton);

        Label optionsTitle = new Label("Select Board Size");
        optionsTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        Button btn5 = createSizeButton(5, cellSize, gamePane, gameScene, stage);
        Button btn8 = createSizeButton(8, cellSize, gamePane, gameScene, stage);
        Button btn12 = createSizeButton(12, cellSize, gamePane, gameScene, stage);
        Button btn16 = createSizeButton(16, cellSize, gamePane, gameScene, stage);
        Button btn20 = createSizeButton(20, cellSize, gamePane, gameScene, stage);

        HBox customRow = new HBox(10);
        customRow.setAlignment(Pos.CENTER);
        TextField customField = new TextField();
        customField.setPromptText("Ex: 25");
        customField.setPrefWidth(80);
        Button btnCustom = new Button("Set Custom");
        customRow.getChildren().addAll(new Label("Custom: "), customField, btnCustom);

        goBackButton = new Button("Go Back");
        goBackButton.setPrefWidth(150);

        optionsLayout.getChildren().addAll(optionsTitle, btn5, btn8, btn12, btn16, btn20, customRow, goBackButton);

        startGameButton.setOnAction(e -> {
            startGame(defaultSize, cellSize, gamePane, gameScene, stage);
        });

        optionsButton.setOnAction(e -> stage.setScene(optionsScene));
        goBackButton.setOnAction(e -> stage.setScene(startingScene));
        exitButton.setOnAction(e -> stage.close());

        btnCustom.setOnAction(e -> {
            try {
                int size = Integer.parseInt(customField.getText());
                startGame(size, cellSize, gamePane, gameScene, stage);
            } catch (NumberFormatException ex) {
                customField.setText("");
                customField.setPromptText("Numbers only!");
            }
        });

        stage.setTitle("HexGame");
        stage.setScene(startingScene);
        stage.show();
    }
    private Button createSizeButton(int size, int cellSize, StackPane gamePane, Scene gameScene, Stage stage) {
        Button btn = new Button(size + " x " + size + " Board");
        btn.setPrefWidth(200);
        btn.setOnAction(e -> startGame(size, cellSize, gamePane, gameScene, stage));
        return btn;
    }
    private void startGame(int size, int cellSize, StackPane gamePane, Scene gameScene, Stage stage) {
        gamePane.getChildren().clear();
        HexagonBoard hexagonBoard = new HexagonBoard(size, cellSize);

        VBox boardContainer = new VBox(hexagonBoard.getRoot());
        boardContainer.setAlignment(Pos.CENTER);

        boardContainer.setPadding(new Insets(100, 0, 0, 0));

        gamePane.getChildren().add(boardContainer);

        stage.setScene(gameScene);
    }

    private void setButtonSize(Button... buttons) {
        for (Button b : buttons) {
            b.setPrefSize(200, 40);
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}