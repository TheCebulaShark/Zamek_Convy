package com.castle.zamek_conwy;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.List;
import java.util.Random;

public class Board {

    public static final int OFFSET_X_LEFT = 1;
    public static final int OFFSET_X_RIGHT = 73;
    public static final int OFFSET_Y_TOP = 59;
    public static final int OFFSET_Y_BOTTOM = 87;
    public static final int CHEST_FIELD = 0;
    public static final int SHOP_FIELD = 6;
    public static final int CROSS_FIELD = 12;
    public static final int SIGNPOST_FIELD = 18;
    public static final int NUMBER_OF_FIELDS = 24;
    public static final int TURNS_TO_REOPEN_SHOP = 3;


    public int whichPlayerTurn;

    private int selectedChar1;
    private int selectedChar2;
    private int selectedChar3;
    private int selectedChar4;

    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;

    public Shop shop = new Shop();

    public Scene scene;
    public Board() {
        this.selectedChar1 = 0;
        this.selectedChar2 = 1;
        this.selectedChar3 = 2;
        this.selectedChar4 = 3;
    }
    public void setSelectedChars(int selectedChar1, int selectedChar2, int selectedChar3, int selectedChar4) {
        this.selectedChar1 = selectedChar1;
        this.selectedChar2 = selectedChar2;
        this.selectedChar3 = selectedChar3;
        this.selectedChar4 = selectedChar4;
    }
    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void gameInit() {
        ThrowDiceButton.setDisable(false);
        whichPlayerTurn = 0;
        fieldsInit();
        shopInit();
        playersInit();
        displayStats();
        displayPlayerInventory();
        playersAlive = 4;
    }


    public void playersInit() {
        player1 = new Player(selectedChar1 + 1, Character.Color.YELLOW);
        setCharacterImageView(0, selectedChar1);
        player1.setImage(playerOne[selectedChar1]);
        player1.setName("Gracz 1");
        player2 = new Player(selectedChar2 + 1, Character.Color.LIMEGREEN);
        setCharacterImageView(1, selectedChar2);
        player2.setImage(playerTwo[selectedChar2]);
        player2.setName("Gracz 2");
        player3 = new Player(selectedChar3 + 1, Character.Color.DEEPSKYBLUE);
        setCharacterImageView(2, selectedChar3);
        player3.setImage(playerThree[selectedChar3]);
        player3.setName("Gracz 3");
        player4 = new Player(selectedChar4 + 1, Character.Color.RED);
        setCharacterImageView(3, selectedChar4);
        player4.setImage(playerFour[selectedChar4]);
        player4.setName("Gracz 4");
        playerTurn = player1;
    }

    public void displayStats() {
        Health1.setText(Integer.toString(player1.character.getHealth()));
        Attack1.setText(Integer.toString(player1.character.getAttack()));
        Coins1.setText(Integer.toString(player1.character.getMoney()));
        Health2.setText(Integer.toString(player2.character.getHealth()));
        Attack2.setText(Integer.toString(player2.character.getAttack()));
        Coins2.setText(Integer.toString(player2.character.getMoney()));
        Health3.setText(Integer.toString(player3.character.getHealth()));
        Attack3.setText(Integer.toString(player3.character.getAttack()));
        Coins3.setText(Integer.toString(player3.character.getMoney()));
        Health4.setText(Integer.toString(player4.character.getHealth()));
        Attack4.setText(Integer.toString(player4.character.getAttack()));
        Coins4.setText(Integer.toString(player4.character.getMoney()));
    }

    public void displayPlayerInventory() {
        String path = playerTurn.inventory.getWeapon().getTexturePath();
        InventoryWeapon.setImage(new Image(getClass().getResourceAsStream(path)));

        InventoryArmor1.setVisible(playerTurn.inventory.getArmor().helmet.isOwned());
        InventoryArmor2.setVisible(playerTurn.inventory.getArmor().chestplate.isOwned());
        InventoryArmor3.setVisible(playerTurn.inventory.getArmor().leggings.isOwned());
        InventoryArmor4.setVisible(playerTurn.inventory.getArmor().boots.isOwned());

        InventoryTrophies.setText(String.valueOf(playerTurn.getTrophies()));
    }

    public static class Field {
        int type;

        public Field() {
            int type = 0;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getType() {
            return type;
        }
    }

    @FXML
    ImageView InventoryWeapon;
    @FXML
    ImageView InventoryArmor1;
    @FXML
    ImageView InventoryArmor2;
    @FXML
    ImageView InventoryArmor3;
    @FXML
    ImageView InventoryArmor4;
    @FXML
    Text InventoryTrophies;
    @FXML
    ImageView diceImage;
    @FXML
    ImageView PawnChar1;
    @FXML
    ImageView PawnChar2;
    @FXML
    ImageView PawnChar3;
    @FXML
    ImageView PawnChar4;
    @FXML
    ImageView CharDisplay1;
    @FXML
    ImageView CharDisplay2;
    @FXML
    ImageView CharDisplay3;
    @FXML
    ImageView CharDisplay4;
    @FXML
    public Button ThrowDiceButton;
    @FXML
    private Button Field0;
    @FXML
    private Button Field1;
    @FXML
    private Button Field2;
    @FXML
    private Button Field3;
    @FXML
    private Button Field4;
    @FXML
    private Button Field5;
    @FXML
    private Button Field6;
    @FXML
    private Button Field7;
    @FXML
    private Button Field8;
    @FXML
    private Button Field9;
    @FXML
    private Button Field10;
    @FXML
    private Button Field11;
    @FXML
    private Button Field12;
    @FXML
    private Button Field13;
    @FXML
    private Button Field14;
    @FXML
    private Button Field15;
    @FXML
    private Button Field16;
    @FXML
    private Button Field17;
    @FXML
    private Button Field18;
    @FXML
    private Button Field19;
    @FXML
    private Button Field20;
    @FXML
    private Button Field21;
    @FXML
    private Button Field22;
    @FXML
    private Button Field23;
    @FXML
    private Text Health1;
    @FXML
    private Text Attack1;
    @FXML
    private Text Coins1;
    @FXML
    private Text Health2;
    @FXML
    private Text Attack2;
    @FXML
    private Text Coins2;
    @FXML
    private Text Health3;
    @FXML
    private Text Attack3;
    @FXML
    private Text Coins3;
    @FXML
    private Text Health4;
    @FXML
    private Text Attack4;
    @FXML
    private Text Coins4;

    boolean isGameOver = false;
    private boolean isDicePressed = false;
    public boolean playerMoved = true;
    private int diceValue;

    @FXML
    public void handleButtonStartGameplay(ActionEvent event) {
        Button sourceButton = (Button) event.getSource();
        String buttonId = sourceButton.getId();
        if (buttonId.equals("StartGameplayButton")) {
            sourceButton.setVisible(false);
            sourceButton.setDisable(true);
            gameInit();
        }
    }

    @FXML
    public void handleButtonDice(ActionEvent event) {
        Button sourceButton = (Button) event.getSource(); // Get the button that was pressed
        String buttonId = sourceButton.getId();
        Turn turn = new Turn();
        if (buttonId.equals("ThrowDiceButton") && !isDicePressed) {
            turn.startTurn();
        }
    }

    public void playerMovement(int pos, Player player) {
        double posX = fields[pos].getLayoutX();
        double posY = fields[pos].getLayoutY();
        int color = player.character.getColor().getColor();
        double offsetX,offsetY;
        if(color == 0) {
            offsetX = OFFSET_X_LEFT;
            offsetY = OFFSET_Y_TOP;
        }
        else if (color == 1) {
            offsetX = OFFSET_X_RIGHT;
            offsetY = OFFSET_Y_TOP;
        }
        else if (color == 2) {
            offsetX = OFFSET_X_LEFT;
            offsetY = OFFSET_Y_BOTTOM;
        }
        else {
            offsetX = OFFSET_X_RIGHT;
            offsetY = OFFSET_Y_BOTTOM;
        }
        player.setPosition(pos);
        setPawnPosition(player,posX+offsetX,posY+offsetY);
    }

    public void setPawnPosition(Player player,double posX,double posY) {
        int color = player.character.getColor().getColor();
        if (color == 0) {
            setPawn1Position(posX, posY);
        }
        else if (color == 1) {
            setPawn2Position(posX, posY);
        }
        else if (color == 2) {
            setPawn3Position(posX, posY);
        }
        else {
            setPawn4Position(posX, posY);
        }
    }

    public void setPawn1Position(double posX,double posY) {
        PawnChar1.setLayoutX(posX);
        PawnChar1.setLayoutY(posY);
    }

    public void setPawn2Position(double posX,double posY) {
        PawnChar2.setLayoutX(posX);
        PawnChar2.setLayoutY(posY);
    }

    public void setPawn3Position(double posX,double posY) {
        PawnChar3.setLayoutX(posX);
        PawnChar3.setLayoutY(posY);
    }

    public void setPawn4Position(double posX,double posY) {
        PawnChar4.setLayoutX(posX);
        PawnChar4.setLayoutY(posY);
    }


    public Button[] fields;


    public void fieldsInit(){
        fields = new Button[]{Field0, Field1, Field2, Field3, Field4, Field5, Field6, Field7, Field8, Field9, Field10,
                Field11, Field12, Field13, Field14, Field15, Field16, Field17, Field18, Field19, Field20,
                Field21, Field22, Field23};
    }

    public double getFieldsPositionX(int pos)
    {
        return fields[pos].getLayoutX();
    }
    public double getFieldsPositionY(int pos)
    {
        return fields[pos].getLayoutY();
    }


    private final Image dices[] = {new Image(getClass().getResourceAsStream("/assets/textures/dice/dice1.png")),
            new Image(getClass().getResourceAsStream("/assets/textures/dice/dice2.png")),
            new Image(getClass().getResourceAsStream("/assets/textures/dice/dice3.png")),
            new Image(getClass().getResourceAsStream("/assets/textures/dice/dice4.png")),
            new Image(getClass().getResourceAsStream("/assets/textures/dice/dice5.png")),
            new Image(getClass().getResourceAsStream("/assets/textures/dice/dice6.png"))
    };

    @FXML
    public void displayDice(int value) {
        diceImage.setImage(dices[value - 1]);
    }

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

    public void setCharacterImageView(int color, int type) {
        if (color == 0)
        {
            PawnChar1.setImage(playerOne[type]);
            CharDisplay1.setImage(playerOne[type]);
        }
        else if (color == 1)
        {
            PawnChar2.setImage(playerTwo[type]);
            CharDisplay2.setImage(playerTwo[type]);
        }
        else if (color == 2)
        {
            PawnChar3.setImage(playerThree[type]);
            CharDisplay3.setImage(playerThree[type]);
        }
        else
        {
            PawnChar4.setImage(playerFour[type]);
            CharDisplay4.setImage(playerFour[type]);
        }
    }

    public void setSelectedChar1(int selectedChar1) {
        this.selectedChar1 = selectedChar1;
    }

    public void setSelectedChar2(int selectedChar2) {
        this.selectedChar2 = selectedChar2;
    }

    public void setSelectedChar3(int selectedChar3) {
        this.selectedChar3 = selectedChar3;
    }

    public void setSelectedChar4(int selectedChar4) {
        this.selectedChar4 = selectedChar4;
    }

    public void hidePlayer(int whichPlayer) {
        if (whichPlayer == 0) {
            PawnChar1.setVisible(false);
        }
        else if (whichPlayer == 1) {
            PawnChar2.setVisible(false);
        }
        else if (whichPlayer == 2) {
            PawnChar3.setVisible(false);
        }
        else {
            PawnChar4.setVisible(false);
        }
    }
    public String buttonId1;
    public String buttonId2;
    public int fieldPressed;
    public int possiblePos1;
    public int possiblePos2;

    public boolean isExtraPositionAvailable = false;
    Player playerTurn;

    private int playersAlive;

    @FXML
    Pane shopBackground;
    @FXML
    Pane visualTurnIndicator;
    @FXML
    ImageView shopItem1;
    @FXML
    ImageView shopItem2;
    @FXML
    ImageView shopItem3;
    @FXML
    ImageView priceImage1;
    @FXML
    ImageView priceImage2;
    @FXML
    ImageView priceImage3;
    @FXML
    Text priceText1;
    @FXML
    Text priceText2;
    @FXML
    Text priceText3;
    @FXML
    Button buyItem1;
    @FXML
    Button buyItem2;
    @FXML
    Button buyItem3;
    @FXML
    Button exitShop;

    public void shopInit() {
        shopItem1.setImage(new Image(getClass().getResourceAsStream(shop.getItem1().getTexturePath())));
        priceText1.setText(Integer.toString(shop.getPrice1()));
        shopItem2.setImage(new Image(getClass().getResourceAsStream(shop.getItem2().getTexturePath())));
        priceText2.setText(Integer.toString(shop.getPrice2()));
        shopItem3.setImage(new Image(getClass().getResourceAsStream(shop.getItem3().getTexturePath())));
        priceText3.setText(Integer.toString(shop.getPrice3()));
    }

    public void showShop() {
        exitShop.setDisable(false);
        exitShop.setVisible(true);
        shopBackground.setVisible(true);
        if(!shop.isBought1())
        {
            shopItem1.setVisible(true);
            priceImage1.setVisible(true);
            priceText1.setVisible(true);
            buyItem1.setVisible(true);
            buyItem1.setDisable(false);
        }
        if(!shop.isBought2())
        {
            shopItem2.setVisible(true);
            priceImage2.setVisible(true);
            priceText2.setVisible(true);
            buyItem2.setVisible(true);
            buyItem2.setDisable(false);
        }
        if(!shop.isBought3())
        {
            shopItem3.setVisible(true);
            priceImage3.setVisible(true);
            priceText3.setVisible(true);
            buyItem3.setVisible(true);
            buyItem3.setDisable(false);
        }
    }

    public void hideShop() {
        exitShop.setDisable(true);
        exitShop.setVisible(false);
        shopBackground.setVisible(false);

        shopItem1.setVisible(false);
        priceImage1.setVisible(false);
        priceText1.setVisible(false);
        buyItem1.setVisible(false);
        buyItem1.setDisable(true);

        shopItem2.setVisible(false);
        priceImage2.setVisible(false);
        priceText2.setVisible(false);
        buyItem2.setVisible(false);
        buyItem2.setDisable(true);

        shopItem3.setVisible(false);
        priceImage3.setVisible(false);
        priceText3.setVisible(false);
        buyItem3.setVisible(false);
        buyItem3.setDisable(true);
    }

    public boolean isShop = false;
    public boolean isShopOpen = true;

    public int turnsSinceShopClosed;

    @FXML
    private void buyItemOne(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        String buttonId = clickedButton.getId();

        if(buttonId.equals("buyItem1"))
        {
            if(playerTurn.character.getMoney() >= shop.getPrice1())
            {
                shop.setBought1(true);
                if(shop.isBought1() && shop.isBought2() && shop.isBought3())
                {
                    isShopOpen = false;
                    turnsSinceShopClosed = 0;
                }
                shopItem1.setVisible(false);
                priceImage1.setVisible(false);
                priceText1.setVisible(false);
                buyItem1.setVisible(false);
                buyItem1.setDisable(true);

                playerTurn.playerGetItem(shop.getItem1());
                playerTurn.character.setMoney(playerTurn.character.getMoney() - shop.getPrice1());
                displayStats();
                displayPlayerInventory();
            }
        }
    }

    @FXML
    private void buyItemTwo(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        String buttonId = clickedButton.getId();

        if(buttonId.equals("buyItem2"))
        {
            if(playerTurn.character.getMoney() >= shop.getPrice2())
            {
                shop.setBought2(true);
                if(shop.isBought1() && shop.isBought2() && shop.isBought3())
                {
                    isShopOpen = false;
                }
                shopItem2.setVisible(false);
                priceImage2.setVisible(false);
                priceText2.setVisible(false);
                buyItem2.setVisible(false);
                buyItem2.setDisable(true);

                playerTurn.playerGetItem(shop.getItem2());
                playerTurn.character.setMoney(playerTurn.character.getMoney() - shop.getPrice2());
                displayStats();
                displayPlayerInventory();
            }
        }
    }

    @FXML
    private void buyItemThree(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        String buttonId = clickedButton.getId();

        if(buttonId.equals("buyItem3"))
        {
            if(playerTurn.character.getMoney() >= shop.getPrice3())
            {
                shop.setBought3(true);
                if(shop.isBought1() && shop.isBought2() && shop.isBought3())
                {
                    isShopOpen = false;
                }
                shopItem3.setVisible(false);
                priceImage3.setVisible(false);
                priceText3.setVisible(false);
                buyItem3.setVisible(false);
                buyItem3.setDisable(true);

                playerTurn.playerGetItem(shop.getItem3());
                playerTurn.character.setMoney(playerTurn.character.getMoney() - shop.getPrice3());
                displayStats();
                displayPlayerInventory();
            }
        }
    }

    @FXML
    private void setExitShop(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        String buttonId = clickedButton.getId();

        if(buttonId.equals("exitShop"))
        {
            hideShop();
            isShop = false;
            displayPlayerInventory();
            PauseTransition pause = new PauseTransition(Duration.seconds(2));
            pause.setOnFinished(e -> {
                nextPlayer();
            });
            pause.play();
            displayPlayerInventory();
            isDicePressed = false;
        }
    }


    public void fieldEvent() {
        Random random = new Random();
        int playerPosition = playerTurn.getPosition();
        if (playerPosition == CHEST_FIELD)
        {
            int rand = random.nextInt(3) + 3;
            CardDisplay coin = new CardDisplay();
            coin.displayCoins(rand);

            coin.slideCenter(scene);

            playerTurn.character.setMoney(Math.min(playerTurn.character.getMoney() + rand, 9));

            coin.pauseClear(coin, scene, false);
        }
        else if(playerPosition == SHOP_FIELD)
        {
            if(!shop.isBought1() || !shop.isBought2() || !shop.isBought3())
            {
                isShop = true;
                showShop();
            }
        }
        else if(playerPosition == CROSS_FIELD)
        {
            int rand = random.nextInt(4);
            CardDisplay cross = new CardDisplay();
            cross.displayCrossEvent(rand != 0);

            cross.slideCenter(scene);

            if(rand == 0)
            {
                playerTurn.character.setHealth(playerTurn.character.getHealth() - 1);
                if(playerTurn.character.getHealth() <= 0)
                    playerTurn.setDead();
            }
            else
            {
                if (playerTurn.character.getHealth() < 9)
                    playerTurn.character.setHealth(playerTurn.character.getHealth() + 1);
            }
            displayStats();
            cross.pauseClear(cross, scene, false);
        }
        else if(playerPosition != SIGNPOST_FIELD)
        {
            Player enemy = null;
            int enemyHealth = 0;
            int enemyID = 0;
            if(player1.getPosition() == playerPosition && whichPlayerTurn != 0 && !player1.isDead())
            {
                if(player1.character.getHealth() > enemyHealth)
                {
                    enemy = player1;
                    enemyHealth = player1.character.getHealth();
                }
            }
            if(player2.getPosition() == playerPosition && whichPlayerTurn != 1 && !player2.isDead())
            {
                if(player2.character.getHealth() > enemyHealth)
                {
                    enemy = player2;
                    enemyID = 1;
                    enemyHealth = player2.character.getHealth();
                }
            }
            if(player3.getPosition() == playerPosition && whichPlayerTurn != 2 && !player3.isDead())
            {
                if(player3.character.getHealth() > enemyHealth)
                {
                    enemy = player3;
                    enemyID = 2;
                    enemyHealth = player3.character.getHealth();
                }
            }
            if(player4.getPosition() == playerPosition && whichPlayerTurn != 3 && !player4.isDead())
            {
                if(player4.character.getHealth() > enemyHealth)
                {
                    enemy = player4;
                    enemyID = 3;
                    enemyHealth = player4.character.getHealth();
                }
            }
            if(enemyHealth != 0)
            {
                Combat combat = new Combat();
                CardDisplay card1 = new CardDisplay();
                CardDisplay card2 = new CardDisplay();

                card1.displayPlayerInfo(playerTurn);
                card2.displayPlayerInfo(enemy);

                List<Integer> res = combat.vsPlayer(playerTurn, enemy);
                card1.enterCombat(res, card2, scene);
                card1.showCombatResult(res.get(0), scene);

                card1.pauseClear(card1, scene, true);
                if(enemy.isDead()) {
                    hidePlayer(enemyID);
                    decreasePlayerAlive();
                }
            }
            else {
                CardHandler cardHandler = new CardHandler("hand");

                cardHandler.drawCard(playerTurn);
                CardDisplay drawedCard = cardHandler.getCardDisplay();

                if (cardHandler.getType().equals(CardHandler.Type.MONSTER)) {
                    Combat combat = new Combat();
                    CardDisplay card1 = new CardDisplay();
                    card1.displayPlayerInfo(playerTurn);


                    Enemies.Enemy monster = cardHandler.getEnemy();
                    List<Integer> res = combat.vsEnemy(monster, playerTurn);
                    card1.enterCombat(res, drawedCard, scene);

                    card1.showCombatResult(res.get(0), scene);

                    if (res.get(0) == 1)
                    {
                        playerTurn.setTrophies(playerTurn.getTrophies() + monster.getAttack());
                        playerTurn.addBonusAttackOfTrophies();
                        displayStats();
                    }
                    else {
                        if (playerTurn.getHealth() == 0)
                            hidePlayer(whichPlayerTurn);
                    }

                    drawedCard.pauseClear(card1, scene, true);
                }
                else {
                    drawedCard.slideCenter(scene);

                    drawedCard.pauseClear(drawedCard, scene, false);
                }
            }
        }
        displayStats();
        if (playerTurn.isDead()) {
            hidePlayer(whichPlayerTurn);
            decreasePlayerAlive();
        }
    }

    public void decreasePlayerAlive(){
        playersAlive--;
        if(playersAlive == 1) {
            isGameOver = true;
            ThrowDiceButton.setDisable(true);
            PauseTransition pause = new PauseTransition(Duration.seconds(4));
            pause.setOnFinished(e -> {
                CardDisplay win = new CardDisplay();
                win.showCombatResult(1024, scene);
            });
            pause.play();
        }
    }

    @FXML
    private void handleButtonClick(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        String buttonId = clickedButton.getId();

        if ((buttonId.equals(buttonId1) || buttonId.equals(buttonId2) || (isExtraPositionAvailable && buttonId.equals(fields[SHOP_FIELD].getId()))) && !playerMoved) {
            playerMoved = true;
            if (isExtraPositionAvailable && buttonId.equals(fields[SHOP_FIELD].getId())) {
                fieldPressed = SHOP_FIELD;
            }
            else if (buttonId.equals(buttonId1)) {
                fieldPressed = possiblePos1;
            }
            else {
                fieldPressed = possiblePos2;
            }

            if (isExtraPositionAvailable) {
                isExtraPositionAvailable = false;
                fields[SHOP_FIELD].setOpacity(0);
            }
            fields[possiblePos1].setOpacity(0);
            fields[possiblePos2].setOpacity(0);

            playerMovement(fieldPressed, playerTurn);
            fieldEvent();
            if(!isShop)
            {
                displayPlayerInventory();
                PauseTransition pause = new PauseTransition(Duration.seconds(4));
                pause.setOnFinished(e -> {
                    if (!isGameOver)
                        nextPlayer();
                });
                pause.play();
                displayPlayerInventory();
                isDicePressed = false;
            }
        }
    }
    public void nextPlayer() {
        do {
            whichPlayerTurn++;
            if(whichPlayerTurn == 4)
                whichPlayerTurn = 0;
            if(whichPlayerTurn == 0)
                playerTurn = player1;
            else if(whichPlayerTurn == 1)
                playerTurn = player2;
            else if (whichPlayerTurn == 2)
                playerTurn = player3;
            else if (whichPlayerTurn == 3)
                playerTurn = player4;
        } while (playerTurn.isDead());

        displayPlayerInventory();

        if (!isShopOpen)
        {
            turnsSinceShopClosed++;
            if (turnsSinceShopClosed > TURNS_TO_REOPEN_SHOP) {
                Item item = new Item();
                item.generateItem();
                shop.setItem1(item);
                item.generateItem();
                shop.setItem2(item);
                item.generateItem();
                shop.setItem3(item);
                isShopOpen = true;
            }
        }
        visualTurnIndicator.setStyle("-fx-background-color: " + playerTurn.character.getColor().toString());
        ThrowDiceButton.setDisable(false);
    }

    public class Turn {
        Dice dice =  new Dice();
        public void startTurn() {
            ThrowDiceButton.setDisable(true);
            isDicePressed = true;
            diceValue = dice.rollDice();
            displayDice(diceValue);

            possiblePos1 = playerTurn.getPosition() - diceValue;
            possiblePos2 = playerTurn.getPosition() + diceValue;

            if (possiblePos1 < 0) {
                possiblePos1 = NUMBER_OF_FIELDS + possiblePos1;
            }
            if (possiblePos2 > NUMBER_OF_FIELDS - 1) {
                possiblePos2 = possiblePos2 - NUMBER_OF_FIELDS;
            }

            if (playerTurn.character.getCharacterID() == 4) {
                if (playerTurn.getPosition() != SHOP_FIELD) {
                    if (possiblePos1 == SHOP_FIELD - 1 || possiblePos1 == SHOP_FIELD + 1 || possiblePos2 == SHOP_FIELD - 1 || possiblePos2 == SHOP_FIELD + 1) {
                        isExtraPositionAvailable = true;
                        fields[SHOP_FIELD].setOpacity(0.25);
                    }
                }
            }

            buttonId1 = fields[possiblePos1].getId();
            buttonId2 = fields[possiblePos2].getId();
            fields[possiblePos1].setOpacity(0.25);
            fields[possiblePos2].setOpacity(0.25);
            playerMoved = false;
        }
    }
}