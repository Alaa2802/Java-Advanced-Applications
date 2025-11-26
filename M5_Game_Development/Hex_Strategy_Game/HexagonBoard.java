package org.example;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HexagonBoard {
    private Hexagon[][] grid;
    private int cellSize;
    private int numRowsNumColumns;
    private Color Player1Color;
    private Color Player2Color;
    private int currentPlayer;
    private Group root;

    public double startX = 50.0;
    public double startY = 50.0;

    public List<Move> moves;
    public int turn;
    public Button swapButton;
    public Text turnNumber;
    public Text lastTurner;
    public Text winText;
    private boolean isFinished;

    public HexagonBoard(int numRowsNumColumns, int cellSize) {
        this.Player1Color = Color.RED;
        this.Player2Color = Color.BLUE;
        this.currentPlayer = 1;
        this.root = new Group();
        this.turn = 0;

        this.swapButton = new Button("Swap Move");
        this.turnNumber = new Text("Turn: 0");
        this.lastTurner = new Text("Start Game!");
        this.winText = new Text();
        this.isFinished = false;
        this.moves = new ArrayList<>();
        this.cellSize = cellSize;
        this.numRowsNumColumns = numRowsNumColumns;
        this.grid = new Hexagon[numRowsNumColumns][numRowsNumColumns];

        for(int i = 0; i < numRowsNumColumns; ++i) {
            for(int j = 0; j < numRowsNumColumns; ++j) {
                this.grid[i][j] = new Hexagon(this, i, j, cellSize);
                this.grid[i][j].setOnMouseClicked(this::handleMouseClick);
                this.root.getChildren().add(this.grid[i][j]);
            }
        }

        double boardHeight = (numRowsNumColumns * 2 * (cellSize * Math.cos(Math.toRadians(30)))) + 150;

        this.swapButton.setLayoutX(numRowsNumColumns * cellSize * 3 + 50);
        this.swapButton.setLayoutY(100);
        this.swapButton.setPrefSize(100, 40);

        this.turnNumber.setX(50);
        this.turnNumber.setY(boardHeight + 20);
        this.turnNumber.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        this.lastTurner.setX(50);
        this.lastTurner.setY(boardHeight + 50);
        this.lastTurner.setFont(Font.font("Arial", 18));

        this.winText.setX(50);
        this.winText.setY(boardHeight + 100);
        this.winText.setFont(Font.font("Arial", FontWeight.BOLD, 40));

        this.swapButton.setDisable(true);
        this.swapButton.setOnAction((e) -> this.handleButtonEvent());

        this.root.getChildren().addAll(this.swapButton, this.turnNumber, this.lastTurner, this.winText);
    }

    public int getNumRowsNumColumns() { return this.numRowsNumColumns; }
    public Hexagon[][] getGrid() { return this.grid; }
    public Group getRoot() { return this.root; }

    private void handleMouseClick(MouseEvent mouseEvent) {
        if (this.isFinished) return;
        Hexagon cell = (Hexagon) mouseEvent.getSource();

        if (cell.player == 0) {
            cell.player = this.currentPlayer;
            if (this.currentPlayer == 1) {
                this.lastTurner.setText("Player 1 (Red) moved.");
                this.lastTurner.setFill(Player1Color);
                cell.setFill(this.Player1Color);
                this.currentPlayer = 2;
            } else {
                this.lastTurner.setText("Player 2 (Blue) moved.");
                this.lastTurner.setFill(Player2Color);
                cell.setFill(this.Player2Color);
                this.currentPlayer = 1;
            }

            this.turn++;
            this.moves.add(new Move(cell.player, cell));
            this.turnNumber.setText("Turn: " + this.turn);

            if (this.turn == 1) {
                this.swapButton.setDisable(false);
            } else {
                this.swapButton.setDisable(true);
            }

            cell.setNetworkNumber(cell.cellNum);
        }
    }

    public void handleButtonEvent() {
        if (this.moves.size() == 1) {
            Hexagon firstHex = this.moves.get(0).hexagon;

            firstHex.setFill(this.Player2Color);
            firstHex.player = 2;

            this.lastTurner.setText("Player 2 Swapped! Now Player 1 turn.");
            this.lastTurner.setFill(this.Player2Color);

            this.currentPlayer = 1;

            this.swapButton.setDisable(true);
        }
    }

    public void gameFinished(int winnerPlayer) {
        this.isFinished = true;
        this.winText.setText("Player " + winnerPlayer + " WINS!");
        if (winnerPlayer == 1) this.winText.setFill(Player1Color);
        else this.winText.setFill(Player2Color);

        Button exitBtn = new Button("Exit Game");
        exitBtn.setLayoutX(300);
        exitBtn.setLayoutY(this.winText.getY() + 50);
        exitBtn.setOnAction(e -> System.exit(0));
        this.root.getChildren().add(exitBtn);
    }
}