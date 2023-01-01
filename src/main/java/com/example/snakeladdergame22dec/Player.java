package com.example.snakeladdergame22dec;

import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Player {
    private Circle coin;
    private String name;
    private int coinPosition;
    private static Board gameBoard = new Board();

    public Player(int tileSize, Color coinColor, String playerName){
        coinPosition = 1;
        name = playerName;
        coin = new Circle(tileSize/2);
        coin.setFill(coinColor);
        coin.setTranslateX(20);  //tilesize 40
        coin.setTranslateY(380);   //total height 400
    }
    public void movePlayer(int diceValue){
        if(coinPosition + diceValue <= 100){
            coinPosition += diceValue;
//            coin.setTranslateX(gameBoard.getXCoordinate(coinPosition)); //coin move speedily
//            coin.setTranslateY(gameBoard.getYCoordinate(coinPosition));
            translatePlayer();  //control coin speed
            int newPosition = gameBoard.getNextPosition(coinPosition);
            if(newPosition != coinPosition)
                coinPosition = newPosition;
                translatePlayer();
        }
    }

    public String playerWon(){
        if(coinPosition == 100)
            return name + (" Won The Game");
        return null;
    }
    private void translatePlayer(){
        TranslateTransition move = new TranslateTransition(Duration.millis(1000),this.coin);
        move.setToX(gameBoard.getXCoordinate(coinPosition));
        move.setToY(gameBoard.getYCoordinate(coinPosition));
        move.setAutoReverse(false);
        move.play();
    }

    public Circle getCoin() {
        return coin;
    }

    public String getName() {
        return name;
    }

    public int getCoinPosition() {
        return coinPosition;
    }
}
