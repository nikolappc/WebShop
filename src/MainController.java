import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class MainController  {

    public Button logo;


    public void logoPressed(){

        try{

            Parent root = FXMLLoader.load(getClass().getResource("new.fxml"));

            Main.scene.setRoot(root);

            //Scene scene = new Scene(root, 1000, 800);

            //Main.window.setScene(scene);

        }catch (Exception e){

        }
    }


}
