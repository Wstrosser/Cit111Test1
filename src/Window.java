import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//import java.awt.*;


public class Window extends Application {
    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Casino");


        primaryStage.setScene(mainWindow());
        primaryStage.show();
    }

    private MenuBar menuBar() {
        MenuItem addMoney = new MenuItem("Add $100");
        addMoney.setOnAction(event -> Casino.ac.userBalance += 100);
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Settings");
        menu.getItems().add(addMoney);
        menuBar.getMenus().add(menu);
        return menuBar;
    }

    private Scene WarWindow() {

        Button shuffleDeck = new Button("Shuffle");
        Button betButton = new Button("Bet");

        BorderPane warPane = new BorderPane();
        Scene warScene = new Scene(warPane, 400, 400);

        TextField bet = new TextField();

        HBox betBox = new HBox(25);
        HBox allOfBet = new HBox();

        Text gamePlay = new Text();
        gamePlay.setText("This is the game of War.\nYou and the computer both will be dealt a card.\nWho ever has the highest card wins.\nAce is low.\nPlace your bet below.");
        Button home = home(gamePlay);
        allOfBet.getChildren().addAll(bet, betButton);
        betBox.getChildren().addAll(home, allOfBet, shuffleDeck);
        bet.setMaxWidth(50);

        shuffleDeck.setMinWidth(50);
        home.setOnAction(event -> {
            primaryStage.setScene(mainWindow());
            primaryStage.show();
        });
        betButton.setOnAction(event -> {
            try {
                Casino.ac.betPlace = Integer.parseInt(bet.getText());
                if (Casino.ac.validBet()) {
                    War.war();
                    warPane.setTop(menu());
                    gamePlay.setText(War.text);
                }
            } catch (Exception e) {
                System.out.print(e);
            }
        });

        shuffleDeck.setOnAction(event -> {
            Casino.card.resetChecker();
            gamePlay.setText(Casino.card.text);
        });
        warPane.setCenter(gamePlay);
        warPane.setBottom(betBox);
        betBox.setAlignment(Pos.CENTER);
        warPane.setTop(menu());

        return warScene;
    }

    private Scene mainWindow() {
        BorderPane border = new BorderPane();
        Label userBalance = Casino.ac.userBalance();
        HBox buttons = new HBox(10);
        Scene mainWindow = new Scene(border, 400, 400);
        Scene warWindow = WarWindow();

        buttons.setPadding(new Insets(1));
        buttons.setPrefWidth(mainWindow.getWidth() * .15);

        Button btn0 = new Button("High and Low");
        Button btn1 = new Button("War");
        Button btn2 = new Button("Blackjack");
        Button btn3 = new Button("Slots");
        HBox.setHgrow(buttons, Priority.ALWAYS);
        buttons.getChildren().addAll(btn0, btn1, btn2, btn3);
        buttons.setAlignment(Pos.BOTTOM_CENTER);

        btn0.setMinWidth(buttons.getPrefWidth());
        btn1.setMinWidth(buttons.getPrefWidth());
        btn2.setMinWidth(buttons.getPrefWidth());
        btn3.setMinWidth(buttons.getPrefWidth());
        btn0.setOnAction(e -> {
            primaryStage.setScene(highLowScene());
            primaryStage.show();
        });
        btn1.setOnAction(event -> {
            primaryStage.setScene(warWindow);
            primaryStage.show();
        });
        // btn2.setOnAction(event -> primaryStage.setScene(blackJackScene));
        btn3.setOnAction(event -> primaryStage.setScene(slotScene()));

        border.setBottom(buttons);
        border.setTop(menuBar());
        border.setLeft(userBalance);

        return mainWindow;
    }

    private Scene highLowScene() {
        BorderPane border = new BorderPane();
        Button higher, lower;
        Scene highLow = new Scene(border, 400, 400);
        lower = new Button("Lower");
        higher = new Button("Higher");
        TextField bet = new TextField();
        HBox bottom = new HBox(15);

        border.setBottom(bottom);

        border.setTop(menu());


        if (!HighLow.started) HighLow.startHighLower();

        bottom.setAlignment(Pos.BOTTOM_CENTER);
        Text gamePlay = new Text("This is the game of High or Low.\nYou have been dealt a card below.\nPlace your bet below.\nOnce placed, your bet is lock until a lost.\nEvery 4 correct guess will net you your money back." + HighLow.text);
        Button home = home(gamePlay);
        bottom.getChildren().addAll(home, bet, higher, lower);
        lower.setOnAction(event -> {
            HighLow.userGuess = "Lower";
            try {
                if (Casino.ac.betPlace == 0) {
                    try {
                        Casino.ac.betPlace = Integer.parseInt(bet.getText());
                    } catch (Exception e) {
                        Casino.ac.betPlace = 0;
                    }

                } else if (Casino.ac.validBet()) {
                    HighLow.HighLow();


                    HighLow.startHighLower();
                    gamePlay.setText(HighLow.text);
                }
                border.setTop(menu());
            } catch (Exception e) {
                System.out.println(e);
            }
        });
        higher.setOnAction(event -> {
            HighLow.userGuess = "Higher";
            try {
                if (Casino.ac.betPlace == 0) {
                    Casino.ac.betPlace = Integer.parseInt(bet.getText());

                }
                if (Casino.ac.validBet()) {
                    HighLow.HighLow();

                    HighLow.startHighLower();
                    gamePlay.setText(HighLow.text);

                }
                border.setTop(menu());
            } catch (Exception e) {
                System.out.println(e);
            }
        });


        border.setCenter(gamePlay);
        return highLow;
    }

    private Scene slotScene() {
        BorderPane border = new BorderPane();

        HBox top = new HBox(5);
        TextField bet = new TextField();
        Button spin = new Button("Spin");
        HBox betbottom = new HBox(15);

        VBox center = new VBox(10);

        Text gamePlay = new Text("Welcome to the card slots\n" +
                "\t\tPayouts\nTriple Aces:\t 15 Free spins\n" +
                "Any Straight:\t x5 Bet\n" +
                "Any Triples:\t x7 Bet\n" +
                "Any Pairs:\t\t x2 Bet\n" +
                "All Royals:\t x4 Bet\n" +
                "Flush:\t\t x4 Bet\n");

        top.setAlignment(Pos.CENTER);
        top.getChildren().add(gamePlay);
        border.setTop(menu());
        home(gamePlay);
        //grid.setGridLinesVisible(true);
        spin.setOnAction(event -> {
            try {
                Casino.ac.betPlace = Integer.parseInt(bet.getText());
                if (Casino.ac.validBet()) {
                    Slot.slot();
                    border.setTop(menu());

                    /*Text gamePlay03 = new Text(Slot.cards[0]);
                    Text gamePlay13 = new Text(Slot.cards[1]);
                    Text gamePlay23 = new Text(Slot.cards[2]);
                    middle.getChildren().removeAll(gamePlay03, gamePlay13, gamePlay23);*/

                    HBox middle = new HBox(10);
                    VBox payout = new VBox(10);
                    middle.getChildren().addAll(new Text(Slot.cards[0]),new Text(Slot.cards[1]), new Text(Slot.cards[2]));
                    payout.getChildren().remove(middle);
                    payout.getChildren().add(middle);
                    payout.getChildren().add(new Text(Slot.payoutText));

                    border.setCenter(payout);
                }
            } catch (Exception e) {
                System.out.print(e);
            }

        });

        border.setCenter(top);
        betbottom.getChildren().addAll(home(gamePlay), bet, spin);
        border.setBottom(betbottom);
        betbottom.setAlignment(Pos.BOTTOM_CENTER);
        return new Scene(border, 400, 400);
    }


    private Button home(Text gamePlay) {
        Button home = new Button("Home");
        home.setOnAction(event -> {
            primaryStage.setScene(mainWindow());
            primaryStage.show();
            gamePlay.setText(null);
        });
        return home;
    }

    private VBox menu() {

        return new VBox(menuBar(), Casino.ac.userBalance());
    }
}

