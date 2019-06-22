package Controller;

import View.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController{

    public Button logo;

//    public static ImageView glavnaSlika, doleLevoSlika, doleDesnoSlika;

    public static void init() {
        /** OVO NE RADI JBMGA */
//        glavnaSlika.fitWidthProperty().bind(Main.window.widthProperty());

//        doleLevoSlika.fitWidthProperty().bind(Main.window.widthProperty());

//        doleDesnoSlika.fitWidthProperty().bind(Main.window.widthProperty());
    }

    public void pritisnutLogo() {
        /** Korisnik pritisnuo LOGO*/

        try {

            Parent root = FXMLLoader.load(getClass().getResource("..\\FXML\\new.fxml"));

            Main.scene.setRoot(root);

        } catch (Exception e) {

        }
    }


    public void traziPritisnut() {
        /** Korisnik pritisnuo pretragu za proizvode */
    }

    public void nalogPritisnut() {
        /** Korisnik pritisnuo dugme za pregled svog naloga */
    }

    public void listaZeljaPritisnuta() {
        /** Korisnik pritisnuo dugme za pregled svoje liste zelja */
    }

    public void korpaPritisnuta() {
        /** Korisnik pritisnuo dugme za pregled svoje korpe*/
    }


    public void glavnaSlikaPritisnuta() {


    }

    public void levaSlikaPritisnuta() {

    }

    public void desnaSlikaPritisnuta() {


    }


    public static Image loadImageFrom(String directory) {
        FileInputStream inputstream = null;
        try {
            inputstream = new FileInputStream(directory);
            return new Image(inputstream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
