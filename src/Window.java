import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


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
        buttons.setHgrow(buttons, Priority.ALWAYS);
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


        Scene warScene = new Scene();
        
    }


}
