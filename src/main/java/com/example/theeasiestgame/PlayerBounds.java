package com.example.theeasiestgame;

public class PlayerBounds {
    private final double start;
    private final double left;
    private final double right;
    private final double bottom;
    private final double top;

    public PlayerBounds(double start, double left, double right, double bottom, double top) {
        this.start = start;
        this.left = left;
        this.right = right;
        this.bottom = bottom;
        this.top = top;
    }
    public void setBounds(Player1 player1) {
        if(player1.getPlayer().getTranslateX() <= left) {
            player1.getPlayer().setTranslateX(left);
        }
        if(player1.getPlayer().getTranslateX() >= right) {
            player1.getPlayer().setTranslateX(right);
        }
        if(player1.getPlayer().getTranslateY() <= top) {
            player1.getPlayer().setTranslateY(top);
        }
        if(player1.getPlayer().getTranslateY() >= bottom) {
            player1.getPlayer().setTranslateY(bottom);
        }
    }

}
