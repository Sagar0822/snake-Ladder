package com.example.snakeladdergame22dec;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class SnakeLadder extends Application {
    public static final int tileSize = 40, width = 10, height = 10;
    int lowerLine = height * tileSize;

    int diceValue;
    Label rolledDiceValueLabel;
    boolean firstPlayerTurn = true, secondPlayerTurn = false, gameStarted = false;
    Button startGameButton;

    Player firstPlayer = new Player(tileSize, Color.BLACK, "Sagar");
    Player secondPlayer = new Player(tileSize-10, Color.WHITE, "Amit");

    Pane createContent() {
        Pane root = new Pane();
        root.setPrefSize(width * tileSize, height * tileSize+100); //pane size

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Tile tile = new Tile(tileSize);
                //tile position
                tile.setTranslateX(j * tileSize);
                tile.setTranslateY(i * tileSize);
                root.getChildren().add(tile);
            }
        }
        //set image
        Image img = new Image("C:\\SnakeLadderGame22Dec\\src\\main\\SnakeLadderGame22Dec.jpg");
        ImageView boardImage = new ImageView();
        boardImage.setImage(img);
        boardImage.setFitWidth(width * tileSize);
        boardImage.setFitHeight(height * tileSize);

        Button playerOneButton = new Button("Player One");
        playerOneButton.setTranslateX(20);
        playerOneButton.setTranslateY(lowerLine + 20);

        playerOneButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent actionEvent){
                if(gameStarted){
                    if(firstPlayerTurn){
                        setDiceValue();
                        firstPlayer.movePlayer(diceValue);
                        if(firstPlayer.playerWon() != null) {
                            rolledDiceValueLabel.setText(firstPlayer.playerWon());
                            firstPlayerTurn = true;
                            secondPlayerTurn = false;
                            gameStarted = false;
                        }
                        firstPlayerTurn = false;
                        secondPlayerTurn = true;
                    }
                }
            }
        });

        Button playerTwoButton = new Button("Player Two");
        playerTwoButton.setTranslateX(300);
        playerTwoButton.setTranslateY(lowerLine + 20);

        playerTwoButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent actionEvent){
                if(gameStarted){
                    if(secondPlayerTurn){
                        setDiceValue();
                        secondPlayer.movePlayer(diceValue);
                        if(secondPlayer.playerWon() != null) {
                            rolledDiceValueLabel.setText(firstPlayer.playerWon());
                            firstPlayerTurn = true;
                            secondPlayerTurn = false;
                            gameStarted = false;
                            startGameButton.setDisable(false);
                            startGameButton.setText("Start Game");
                        }
                        secondPlayerTurn = false;
                        firstPlayerTurn = true;

                    }
                }
            }
        });

        startGameButton = new Button("Start");
        startGameButton.setTranslateX(170);
        startGameButton.setTranslateY(lowerLine+50);
        startGameButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent actionEvent){
                gameStarted = true;
                startGameButton.setText("Ongoingt Game");
                startGameButton.setDisable(true);
            }
        });

        rolledDiceValueLabel = new Label("Start The Game");
        rolledDiceValueLabel.setTranslateX(150);
        rolledDiceValueLabel.setTranslateY(lowerLine + 20);

        root.getChildren().addAll(boardImage, playerOneButton, playerTwoButton,
                firstPlayer.getCoin(), secondPlayer.getCoin()
                , rolledDiceValueLabel,startGameButton
        );
        return root;
    }
    private void setDiceValue(){
        diceValue = (int)(Math.random()*6+1);
        rolledDiceValueLabel.setText("Dice Value :" +diceValue);
        }

    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(SnakeLadder.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(createContent());
        stage.setTitle("SnakeLadder Game");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}