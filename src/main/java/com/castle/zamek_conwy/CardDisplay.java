package com.castle.zamek_conwy;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import javafx.animation.ScaleTransition;

import java.util.List;

public class CardDisplay extends StackPane {
    public static final int CLEAR_DEALEY_IN_SEC = 4;
    private ImageView backgroundImageView;
    private ImageView imageView;
    private Text nameText;
    private Text attackText;

    public CardDisplay() {
        backgroundImageView = new ImageView(new Image(getClass().getResourceAsStream("/assets/textures/card/CardOpen.png")));
        imageView = new ImageView();
        nameText = new Text();
        attackText = new Text();

        cardStyle();
    }

    public void cardStyle() {
        // Ustawianie stylu tekstu
        Font customFont = Font.loadFont(getClass().getResourceAsStream("/assets/font/ZamekConvy.ttf"), 20);
        nameText.setFont(customFont);
        attackText.setFont(customFont);
        nameText.setFill(Color.ANTIQUEWHITE);
        attackText.setFill(Color.ANTIQUEWHITE);

        // Dodawanie elementów do kontenera
        getChildren().addAll(backgroundImageView, imageView, nameText, attackText);

        // Ustawianie pozycji elementów
        StackPane.setMargin(nameText, new Insets(90, 0, 0, 0));
        StackPane.setMargin(attackText, new Insets(150, 0, 0, 0));
        imageView.setTranslateY(-45);
    }

    public void displayCoinBag(int amount) {
        imageView.setImage(new Image(getClass().getResourceAsStream("/assets/textures/items/coin.png")));
        imageView.setFitWidth(80);
        imageView.setFitHeight(80);
        nameText.setText("Worek złota");
        attackText.setText("Monety: " + amount);
    }

    public void displayCrossEvent(boolean win) {
        imageView.setFitWidth(80);
        imageView.setFitHeight(80);
        nameText.setText("Kapliczka");
        if (win) {
            imageView.setImage(new Image(getClass().getResourceAsStream("/assets/textures/heart.png")));
            attackText.setText("Odzyskujesz życie!");
        }
        else {
            imageView.setImage(new Image(getClass().getResourceAsStream("/assets/textures/heart_broken.png")));
            attackText.setText("Tracisz życie!");
        }
    }

    public void displayEnemyInfo(Enemies.Enemy enemy) {
        imageView.setImage(enemy.getImage());
        nameText.setText(enemy.getName());
        attackText.setText("Siła " + enemy.getAttack());
    }

    public void displayPlayerInfo(Player player) {
        imageView.setImage(player.getImage());
        imageView.setFitWidth(120);
        imageView.setFitHeight(120);
        nameText.setText(player.getName());
        attackText.setText("Siła " + player.getAttack());
    }

    public void displayArmorInfo(Armor.ArmorPart armour, String armourName) {
        imageView.setImage(new Image(getClass().getResourceAsStream(armour.getTexturePath())));
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);
        nameText.setText(armourName);
        attackText.setText("  -1 do siły \nprzeciwnika");
    }

    public void displayWeaponInfo(Weapon weapon) {
        imageView.setImage(new Image(getClass().getResourceAsStream(weapon.getTexturePath())));
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);
        if (weapon.getAttack() == 1) nameText.setText("Włócznia");
        else if (weapon.getAttack() == 2) nameText.setText("Miecz");
        else if (weapon.getAttack() == 3) nameText.setText("Topór");
        attackText.setText("+" + weapon.getAttack() + " do siły");
    }

    public void slideIn(double startX, double startY, double endX, double endY, Duration duration) {
        setTranslateX(startX);
        setTranslateY(startY);

        TranslateTransition slideIn = new TranslateTransition(duration, this);
        slideIn.setFromX(startX);
        slideIn.setFromY(startY);
        slideIn.setToX(endX);
        slideIn.setToY(endY);
        slideIn.play();
    }

    public void slideCenter(Scene scene) {
        Pane root = (Pane) scene.getRoot();
        root.getChildren().add(this);

        double startX = root.getWidth() + this.getWidth();
        double startY = (root.getHeight() - this.getHeight()) / 2;
        double endX = (root.getWidth() - this.getWidth()) / 2;
        double endY = startY;
        Duration duration = Duration.seconds(2);

        slideIn(startX, startY, endX, endY, duration);
    }

    public void fadeIn(StackPane imageView, Scene scene) {
        Pane root = (Pane) scene.getRoot();
        imageView.setScaleX(0);
        imageView.setScaleY(0);
        double targetScale = 1.0;
        double targetOpacity = 1.0;
        Duration fadeDuration = Duration.seconds(0.5);
        Duration duration = Duration.seconds(2);

        ScaleTransition scaleTransition = new ScaleTransition(duration, imageView);
        scaleTransition.setFromX(0);
        scaleTransition.setFromY(0);
        scaleTransition.setToX(targetScale);
        scaleTransition.setToY(targetScale);

        FadeTransition fadeTransition = new FadeTransition(fadeDuration, imageView);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(targetOpacity);

        scaleTransition.play();
        fadeTransition.play();
    }

    public void enterCombat(List<Integer> results, CardDisplay enemyCard, Scene scene) {
        Pane root = (Pane) scene.getRoot();
        enemyCard.setId("enemyId");
        root.getChildren().addAll(this, enemyCard);

        double startX = -this.getWidth();
        double startY = (root.getHeight() - this.getHeight()) / 2;
        double endX = (root.getWidth() - this.getWidth()) / 2 - 150;
        double endY = startY;
        Duration duration = Duration.seconds(2);

        this.slideIn(startX, startY, endX, endY, duration);

        startX = root.getWidth() + this.getWidth();
        endX += 300;

        enemyCard.slideIn(startX, startY, endX, endY, duration);

        ImageView swordImageView = new ImageView(new Image(getClass().getResourceAsStream("/assets/textures/combat/sword.png")));
        StackPane swordPane = new StackPane(swordImageView);
        swordPane.setId("swordId");

        root.getChildren().add(swordPane);
        swordPane.setLayoutX(startX);

        startX = (root.getWidth() - swordPane.getWidth()) / 2;
        startY = (root.getHeight() - swordPane.getHeight()) / 2;
        swordPane.setLayoutX(startX);
        swordPane.setLayoutY(startY);

        fadeIn(swordPane, scene);

        showStats(results, scene);
    }

    public void showStats(List<Integer> results, Scene scene) {
        Pane root = (Pane) scene.getRoot();
        String dicePath = "/assets/textures/dice/dice" + results.get(1) + ".png";
        ImageView resultImageView = new ImageView(new Image(getClass().getResourceAsStream(dicePath)));
        StackPane playerDice = new StackPane(resultImageView);
        playerDice.setId("playerDice");

        double startX = (root.getWidth() - playerDice.getWidth()) / 2 - 350;
        double startY = (root.getHeight() - playerDice.getHeight()) / 2;
        root.getChildren().add(playerDice);
        playerDice.setLayoutX(startX);
        playerDice.setLayoutY(startY);

        Text text = new Text(String.valueOf(results.get(2)));

        StackPane playerStrength = setText(text, root);

        playerStrength.setLayoutX(startX);
        playerStrength.setLayoutY(startY - 100);

        dicePath = "/assets/textures/dice/dice" + results.get(3) + ".png";
        ImageView enemyDiceImag = new ImageView(new Image(getClass().getResourceAsStream(dicePath)));
        StackPane enemyDice = new StackPane(enemyDiceImag);
        enemyDice.setId("enemyDice");

        startX = (root.getWidth() - enemyDice.getWidth()) / 2 + 350;
        startY = (root.getHeight() - enemyDice.getHeight()) / 2;
        root.getChildren().add(enemyDice);
        enemyDice.setLayoutX(startX);
        enemyDice.setLayoutY(startY);

        fadeIn(enemyDice, scene);

        text = new Text(String.valueOf(results.get(4)));

        StackPane enemyStrength = setText(text, root);

        enemyStrength.setLayoutX(startX);
        enemyStrength.setLayoutY(startY - 100);


        fadeIn(playerStrength, scene);
        fadeIn(playerDice, scene);
        fadeIn(enemyDice, scene);
        fadeIn(enemyStrength, scene);
    }

    public void showCombatResult(int result, Scene scene) {
        Pane root = (Pane) scene.getRoot();
        Text text;

        if (result == 1024) {
            text = new Text("GameOver!");
        } else if (result == 1) {
            text = new Text("Wygrana!");
        } else if (result == 0) {
            text = new Text("Remis!");
        } else {
            text = new Text("Przegrana!");
        }

        StackPane textPane = setText(text, root);

        textPane.setLayoutX((root.getWidth() - this.getWidth()) / 2);
        textPane.setLayoutY((root.getHeight() - this.getHeight()) / 2 - 250);

        fadeIn(textPane, scene);
    }

    public StackPane setText(Text text, Pane root){
        Font font = Font.loadFont(getClass().getResourceAsStream("/assets/font/ZamekConvy.ttf"), 150);
        text.setFont(font);
        text.setFill(Color.rgb(255, 213, 65));
        text.setStroke(Color.BLACK);

        StackPane textPane = new StackPane();
        textPane.getChildren().add(text);
        textPane.setId("textDelete");
        root.getChildren().add(textPane);

        return textPane;
    }

    public void clearScreen(Scene scene, boolean combat) {
        Pane root = (Pane) scene.getRoot();
        if (combat) {
            root.getChildren().remove(this);
            root.getChildren().removeIf(node -> "textDelete".equals(node.getId()));
            root.getChildren().removeIf(node -> "swordId".equals(node.getId()));
            root.getChildren().removeIf(node -> "enemyId".equals(node.getId()));
            root.getChildren().removeIf(node -> "playerDice".equals(node.getId()));
            root.getChildren().removeIf(node -> "enemyDice".equals(node.getId()));
        } else {
            root.getChildren().remove(this);
        }
    }

    public void pauseClear(CardDisplay card, Scene scene, boolean combat) {
        PauseTransition pause = new PauseTransition(Duration.seconds(CLEAR_DEALEY_IN_SEC));
        pause.setOnFinished(e -> {
            card.clearScreen(scene, combat);
        });
        pause.play();
    }
}
