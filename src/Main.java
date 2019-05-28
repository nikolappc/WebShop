import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button b =  new Button();
        VBox layout = new VBox();
        layout.getChildren().add(b);
        Scene s = new Scene(layout,300,300);

        primaryStage.setScene(s);
        primaryStage.show();
    }
}
