import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
import javafx.stage.Stage;


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

    private Scene WarWindow() {
        Button home = new Button("Home");
        Button shuffleDeck = new Button("Shuffle");
        Button betButton = new Button("Bet");

        BorderPane warPane = new BorderPane();

        Scene warScene = new Scene(warPane, 400, 400);

        TextField bet = new TextField();

        HBox betBox = new HBox(25);
        HBox allOfBet = new HBox();

        Text gamePlay = new Text();
        gamePlay.setText("This is the game of War.\nYou and the computer both will be dealt a card.\nWho ever has the highest card wins.\nAce is low.\nPlace your bet below.");

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
                    warPane.setTop(Casino.ac.userBalance());
                    Casino.ac.casinoBalance();
                    gamePlay.setText(War.text);
                }
            } catch (Exception e) {
                // System.out.print(e);
            }
        });

        shuffleDeck.setOnAction(event -> {
            Casino.card.resetChecker();
            gamePlay.setText(Casino.card.text);
        });
        warPane.setCenter(gamePlay);
        warPane.setTop(Casino.ac.userBalance());
        warPane.setBottom(betBox);
        betBox.setAlignment(Pos.CENTER);


        return warScene;
    }

    private Scene mainWindow() {
        BorderPane border = new BorderPane();
        Label userBalance = Casino.ac.userBalance();
        Label casinoBalance = Casino.ac.casinoBalance();
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
        //btn3.setOnAction(event -> primaryStage.setScene(slotScene));

        border.setBottom(buttons);
        border.setTop(userBalance);
        border.setLeft(casinoBalance);

        return mainWindow;
    }

    private Scene highLowScene() {
        BorderPane border = new BorderPane();
        Button higher, lower, home;
        Scene highLow = new Scene(border, 400, 400);
        home = new Button("Home");
        lower = new Button("Lower");
        higher = new Button("Higher");
        TextField bet = new TextField();
        HBox bottom = new HBox(10);
        bottom.getChildren().addAll(home, bet, higher, lower);
        border.setBottom(bottom);
        bottom.setAlignment(Pos.BOTTOM_CENTER);
        Text gamePlay = new Text();
        border.setTop(Casino.ac.userBalance());
        HighLow.startHighLower();
        lower.setOnAction(event -> {
            HighLow.userGuess = "Lower";
            try {
                if (Casino.ac.betPlace == 0) {
                    Casino.ac.betPlace = Integer.parseInt(bet.getText());
                }
                if (Casino.ac.validBet()) {
                    HighLow.HighLow();
                    border.setTop(Casino.ac.userBalance());
                    gamePlay.setText(HighLow.text);
                }
            }catch(Exception e){
                System.out.println(e);
            }
        });
        higher.setOnAction(event -> {
            HighLow.userGuess = "Higher";
            try {
                if (Casino.ac.betPlace == 0) {
                    Casino.ac.betPlace = Integer.parseInt(bet.getText());
                    Casino.ac.userBalance-=Casino.ac.betPlace;
                }
                if (Casino.ac.validBet()) {
                    HighLow.HighLow();
                    border.setTop(Casino.ac.userBalance());
                    gamePlay.setText(HighLow.text);
                }
            }catch(Exception e){
                System.out.println(e);
            }
        });
        home.setOnAction(event -> {
            primaryStage.setScene(mainWindow());
            primaryStage.show();
        });
        gamePlay.setText(HighLow.text);
        border.setCenter(gamePlay);
            return highLow;
        }

    }