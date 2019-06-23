package Controller;

import View.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements  Initializable{

    public Button logo;

    @FXML
    public SplitPane splitPane1;

    public ImageView glavnaSlika, doleLevoSlika, doleDesnoSlika;

    public Pane glavniPane, leviPane, desniPane;


    public void init(){

        splitPane1.setDisable(true);

        glavnaSlika.fitWidthProperty().bind(glavniPane.widthProperty());
        glavnaSlika.fitHeightProperty().bind(glavniPane.heightProperty());

        doleLevoSlika.fitWidthProperty().bind(leviPane.widthProperty());
        doleLevoSlika.fitHeightProperty().bind(leviPane.heightProperty());

        doleDesnoSlika.fitWidthProperty().bind(desniPane.widthProperty());
        doleDesnoSlika.fitHeightProperty().bind(desniPane.heightProperty());

    }


    public void pritisnutLogo() {
        /** Korisnik pritisnuo LOGO*/

        try {

            Parent root = FXMLLoader.load(getClass().getResource("..\\FXML\\Katalog.fxml"));

            Main.scene.setRoot(root);

        } catch (Exception e) {

        }
    }


    public void traziPritisnut() {
        /** Korisnik pritisnuo pretragu za proizvode */

        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\Katalog.fxml"));
            Parent root = (Parent) loader.load();

            KatalogController pc = loader.getController();
            pc.pritisnutLogo();

            Main.scene.setRoot(root);
        }catch (Exception ex){}
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
