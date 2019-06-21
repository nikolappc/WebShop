import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class Main extends Application {



    Stage window;
    Scene scene1,scene2;
    Button button;

    @Override
    public void start(Stage primaryStage) throws Exception{

        window = primaryStage;
        window.setTitle("PRODAVNICA");

        Parent root = FXMLLoader.load(getClass().getResource("new.fxml"));

        Scene scene = new Scene(root, 1000, 800);

        window.setScene(scene);


        window.show();
    }


    public static void main(String[] args)
    {
        launch(args);
    }
}
