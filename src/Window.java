import javafx.event.ActionEvent;
import javafx.application.*;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.text.*;


public class Window extends Application {
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Casino");
        Group root = new Group();


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


        root.getChildren().add(buttons);

        root.setAutoSizeChildren(true);

        Label userBalance = new Label("$ " + Casino.ac.userBalance + " Balance");
        Label casinoBalance = new Label("$ " + Casino.ac.balanceCasino + " Casino's Balance");
        root.getChildren().addAll(userBalance, casinoBalance);
        border.setBottom(buttons);
        border.setTop(userBalance);
        border.setLeft(casinoBalance);

        primaryStage.setScene(mainScene);
        primaryStage.show();

        Button home = new Button("Home");


        BorderPane warPane = new BorderPane();
        Button betButton = new Button("Bet");
        TextField bet = new TextField();
        HBox betBox = new HBox();
        betBox.getChildren().addAll(home,bet, betButton);
        bet.setTranslateX(50);
        bet.setMaxWidth(50);
        betButton.setTranslateX(100);
        betButton.setMinWidth(50);
        Text userBalanceWar = new Text("$"+Casino.ac.getUserBalance());
        warPane.getChildren().add(userBalanceWar);
        warPane.setLeft(userBalanceWar);

        home.setOnAction(event ->{
                primaryStage.show();
                primaryStage.setScene(mainScene);});

        betButton.setOnAction(event -> {
        try {
            Casino.ac.betPlace = Integer.parseInt(bet.getText());
            if(Casino.ac.validBet()){Casino.ac.setCasinoBalance();
           userBalance.setText("$ " + Casino.ac.getUserBalance() + " Balance");
           casinoBalance.setText("$"+ Casino.ac.getCasinoBalance()+" Casino Balance");
            System.out.print(Casino.ac.balanceCasino);}
        } catch (Exception e) {
            System.out.print(e);
        }});
        warPane.setBottom(betBox);
        Scene warScene = new Scene(warPane, 400, 400);
        btn1.setOnAction(event -> {
            primaryStage.show();
            primaryStage.setScene(warScene);
        });
    }


}
