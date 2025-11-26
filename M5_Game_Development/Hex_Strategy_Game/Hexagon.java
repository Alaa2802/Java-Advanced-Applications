package org.example;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Hexagon extends Polygon {
    public int row;
    public int col;
    public int player;
    public int cellNum;
    public int networkNumber;
    public HexagonBoard board;
    public boolean isFinished;

    // متغيرات للفوز
    private boolean rFirstFound = false;
    private boolean rLastFound = false;
    private boolean bFirstFound = false;
    private boolean bLastFound = false;

    public Hexagon(HexagonBoard board, int row, int col, double side) {
        this.board = board;
        this.row = row;
        this.col = col;
        this.player = 0;
        this.isFinished = false;

        this.cellNum = row * board.getNumRowsNumColumns() + col;
        this.networkNumber = this.cellNum;

        double r = side * Math.cos(Math.toRadians(30));
        double h = side * Math.sin(Math.toRadians(30));

        getPoints().addAll(
                0.0, r,
                h, 0.0,
                side + h, 0.0,
                side + 2 * h, r,
                side + h, 2 * r,
                h, 2 * r
        );

        double x = (col * (side + h)) + (row * (side + h) / 2.0) + board.startX;
        double y = (row * 2 * r) + board.startY;

        setLayoutX(x);
        setLayoutY(y);

        setStroke(Color.BLACK);
        setStrokeWidth(1.5);
        setFill(Color.WHITE);
        setOpacity(1.0);
    }

    public void setNetworkNumber(int networkNumber) {
        this.networkNumber = networkNumber;
        checkNeighbor(row - 1, col, networkNumber);
        checkNeighbor(row - 1, col + 1, networkNumber);
        checkNeighbor(row, col - 1, networkNumber);
        checkNeighbor(row, col + 1, networkNumber);
        checkNeighbor(row + 1, col - 1, networkNumber);
        checkNeighbor(row + 1, col, networkNumber);
        checkWinCondition(networkNumber);
    }

    private void checkNeighbor(int r, int c, int newNetNum) {
        if (r >= 0 && r < board.getNumRowsNumColumns() && c >= 0 && c < board.getNumRowsNumColumns()) {
            Hexagon neighbor = board.getGrid()[r][c];
            if (neighbor.player == this.player && neighbor.networkNumber != newNetNum) {
                neighbor.setNetworkNumber(newNetNum);
            }
        }
    }

    private void checkWinCondition(int currentNetNum) {
        rFirstFound = false; rLastFound = false;
        bFirstFound = false; bLastFound = false;
        int size = board.getNumRowsNumColumns();

        if (this.player == 1) {
            for (int i = 0; i < size; i++) {
                if (board.getGrid()[0][i].networkNumber == currentNetNum && board.getGrid()[0][i].player == 1) rFirstFound = true;
                if (board.getGrid()[size - 1][i].networkNumber == currentNetNum && board.getGrid()[size - 1][i].player == 1) rLastFound = true;
            }
            if (rFirstFound && rLastFound) {
                this.isFinished = true;
                board.gameFinished(1);
            }
        } else if (this.player == 2) {
            for (int i = 0; i < size; i++) {
                if (board.getGrid()[i][0].networkNumber == currentNetNum && board.getGrid()[i][0].player == 2) bFirstFound = true;
                if (board.getGrid()[i][size - 1].networkNumber == currentNetNum && board.getGrid()[i][size - 1].player == 2) bLastFound = true;
            }
            if (bFirstFound && bLastFound) {
                this.isFinished = true;
                board.gameFinished(2);
            }
        }
    }
}