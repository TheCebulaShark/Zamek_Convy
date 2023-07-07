package com.castle.zamek_conwy;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuManager {
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    public void switchToMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToInstruction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("instruction.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToAuthors(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("authors.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToGame(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("board.fxml"));
        Parent root = loader.load();
        Board board = loader.getController();
        board.setSelectedChars(selectedChar1, selectedChar2, selectedChar3, selectedChar4);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        board.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToCharacters(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("characters.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void exitApplication(ActionEvent event) throws IOException {
        Platform.exit();
    }

    @FXML
    ImageView DisplayedChar1;
    @FXML
    ImageView DisplayedChar2;
    @FXML
    ImageView DisplayedChar3;
    @FXML
    ImageView DisplayedChar4;

    private int selectedChar1 = 0, selectedChar2 = 1, selectedChar3 = 2, selectedChar4 = 3;

    private Image playerOne[] = {new Image(getClass().getResourceAsStream("/assets/textures/characters/char1/char1yellow.png")),
            new Image(getClass().getResourceAsStream("/assets/textures/characters/char2/char2yellow.png")),
            new Image(getClass().getResourceAsStream("/assets/textures/characters/char3/char3yellow.png")),
            new Image(getClass().getResourceAsStream("/assets/textures/characters/char4/char4yellow.png"))};

    private Image playerTwo[] = {new Image(getClass().getResourceAsStream("/assets/textures/characters/char1/char1green.png")),
            new Image(getClass().getResourceAsStream("/assets/textures/characters/char2/char2green.png")),
            new Image(getClass().getResourceAsStream("/assets/textures/characters/char3/char3green.png")),
            new Image(getClass().getResourceAsStream("/assets/textures/characters/char4/char4green.png"))};

    private Image playerThree[] = {new Image(getClass().getResourceAsStream("/assets/textures/characters/char1/char1blue.png")),
            new Image(getClass().getResourceAsStream("/assets/textures/characters/char2/char2blue.png")),
            new Image(getClass().getResourceAsStream("/assets/textures/characters/char3/char3blue.png")),
            new Image(getClass().getResourceAsStream("/assets/textures/characters/char4/char4blue.png"))};

    private Image playerFour[] = {new Image(getClass().getResourceAsStream("/assets/textures/characters/char1/char1red.png")),
            new Image(getClass().getResourceAsStream("/assets/textures/characters/char2/char2red.png")),
            new Image(getClass().getResourceAsStream("/assets/textures/characters/char3/char3red.png")),
            new Image(getClass().getResourceAsStream("/assets/textures/characters/char4/char4red.png"))};



    @FXML
    public void displayImagePlayerOneRight() {
        selectedChar1++;
        if(selectedChar1 >= 4) selectedChar1 = 0;
        DisplayedChar1.setImage(playerOne[selectedChar1]);
    }

    @FXML
    public void displayImagePlayerOneLeft() {
        selectedChar1--;
        if(selectedChar1 <= -1) selectedChar1 = 3;
        DisplayedChar1.setImage(playerOne[selectedChar1]);
    }

    @FXML
    public void displayImagePlayerTwoRight() {
        selectedChar2++;
        if(selectedChar2 >= 4) selectedChar2 = 0;
        DisplayedChar2.setImage(playerTwo[selectedChar2]);
    }

    @FXML
    public void displayImagePlayerTwoLeft() {
        selectedChar2--;
        if(selectedChar2 <= -1) selectedChar2 = 3;
        DisplayedChar2.setImage(playerTwo[selectedChar2]);
    }

    @FXML
    public void displayImagePlayerThreeRight() {
        selectedChar3++;
        if(selectedChar3 >= 4) selectedChar3 = 0;
        DisplayedChar3.setImage(playerThree[selectedChar3]);
    }

    @FXML
    public void displayImagePlayerThreeLeft() {
        selectedChar3--;
        if(selectedChar3 <= -1) selectedChar3 = 3;
        DisplayedChar3.setImage(playerThree[selectedChar3]);
    }

    @FXML
    public void displayImagePlayerFourRight() {
        selectedChar4++;
        if(selectedChar4 >= 4) selectedChar4 = 0;
        DisplayedChar4.setImage(playerFour[selectedChar4]);
    }

    @FXML
    public void displayImagePlayerFourLeft() {
        selectedChar4--;
        if(selectedChar4 <= -1) selectedChar4 = 3;
        DisplayedChar4.setImage(playerFour[selectedChar4]);
    }

    public int getSelectedChar1() {
        return selectedChar1;
    }

    public int getSelectedChar2() {
        return selectedChar2;
    }

    public int getSelectedChar3() {
        return selectedChar3;
    }

    public int getSelectedChar4() {
        return selectedChar4;
    }
}
