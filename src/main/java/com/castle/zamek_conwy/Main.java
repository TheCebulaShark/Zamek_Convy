package com.castle.zamek_conwy;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.AudioClip;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Zamek Conwy");
        stage.setResizable(false);
        stage.setScene(scene);
        Media media = new Media(getClass().getResource("/assets/background.mp3").toExternalForm());
        AudioClip mediaPlayer = new AudioClip(media.getSource());
        mediaPlayer.setVolume(0.25);
        mediaPlayer.setCycleCount(AudioClip.INDEFINITE);
        mediaPlayer.play();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}