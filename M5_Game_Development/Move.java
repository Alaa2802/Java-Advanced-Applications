package org.example;

public class Move {
    public int player;
    public Hexagon hexagon;

    public Move(int player, Hexagon hexagon) {
        this.player = player;
        this.hexagon = hexagon;
    }
}