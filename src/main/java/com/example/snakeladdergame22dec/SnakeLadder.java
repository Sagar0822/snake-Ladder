package com.example.snakeladdergame22dec;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class SnakeLadder extends Application {
    public static final int tileSize = 40, width = 10, height = 10;
    //int lowerLine = height * tileSize;

    Pane createContent(){
    Pane root = new Pane();
    root.setPrefSize(width*tileSize, height*tileSize); //pane size

    for(int i = 0; i < width; i++){
        for(int j = 0; j < height; j++){
            Tile tile = new Tile(tileSize);
            //tile position
            tile.setTranslateX(j*tileSize);
            tile.setTranslateY(i*tileSize);
            root.getChildren().add(tile);
        }
    }
    //set image
        Image img = new Image("C:\\SnakeLadderGame22Dec\\src\\main\\SnakeLadderGame22Dec.jpg");
    ImageView boardImage = new ImageView();
    boardImage.setImage(img);
    boardImage.setFitWidth(width * tileSize);
    boardImage.setFitHeight(height * tileSize);

    root.getChildren().add(boardImage);
    return root;

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