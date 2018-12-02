import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Window extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Casino");

        BorderPane border = new BorderPane();
        HBox buttons = new HBox(10);
        Scene mainScene = new Scene(border, 400, 400);

        buttons.setPadding(new Insets(1));
        buttons.setPrefWidth(mainScene.getWidth() * .15);

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

        Label userBalance = new Label("$ " + Casino.ac.userBalance + " Your Current Balance");
        Label casinoBalance = new Label("$ " + Casino.ac.balanceCasino + " Casino's Balance");
        border.setBottom(buttons);
        border.setTop(userBalance);
        border.setLeft(casinoBalance);

        primaryStage.setScene(mainScene);
        primaryStage.show();

        Button home = new Button("Home");

        Button shuffleDeck= new Button("Shuffle");
        BorderPane warPane = new BorderPane();
        Button betButton = new Button("Bet");
        TextField bet = new TextField();
        HBox betBox = new HBox(25);
        HBox allOfBet = new HBox();
        allOfBet.getChildren().addAll(bet, betButton);
        betBox.getChildren().addAll(home, allOfBet,shuffleDeck);
        //bet.setTranslateX(50);
        bet.setMaxWidth(50);
        //betButton.setTranslateX(50);
       // shuffleDeck.setTranslateX(100);
        shuffleDeck.setMinWidth(50);

        home.setOnAction(event -> {
            primaryStage.show();
            primaryStage.setScene(mainScene);
            border.setTop(userBalance);
            warPane.getChildren().remove(userBalance);
        });
        Text gamePlay = new Text();
        betButton.setOnAction(event -> {
            try {
                Casino.ac.betPlace = Integer.parseInt(bet.getText());
                if (Casino.ac.validBet()) {
                    War.war();
                    userBalance.setText("$ " + Casino.ac.getUserBalance() + " Balance");
                    casinoBalance.setText("$" + Casino.ac.getCasinoBalance() + " Casino Balance");
                    gamePlay.setText(War.text);
                }
            } catch (Exception e) {
                // System.out.print(e);
            }
        });

        shuffleDeck.setOnAction(event ->{
            Casino.card.resetChecker();
            gamePlay.setText(Casino.card.text);
        });
        warPane.setCenter(gamePlay);

        warPane.setBottom(betBox);
        betBox.setAlignment(Pos.CENTER);
        Scene warScene = new Scene(warPane, 400, 400);
        btn1.setOnAction(event -> {
            primaryStage.show();
            border.getChildren().remove(userBalance);
            warPane.setTop(userBalance);
            primaryStage.setScene(warScene);
            gamePlay.setText("This is the game of War.\nYou and the computer both will be dealt a card.\nWho ever has the highest card wins.\nAce is low.\nPlace your bet below.");
        }


        );
    }


}
