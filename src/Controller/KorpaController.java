package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import View.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;

public class KorpaController implements Initializable {




    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button lupa;

    @FXML
    private Button logo;

    @FXML
    private SplitPane splitPane1;

    public void pritisnutLogo() {
        /** Korisnik pritisnuo LOGO*/

        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\glavni.fxml"));
            Parent root = (Parent) loader.load();

            MainController pc = loader.getController();

            Main.scene.setRoot(root);

        }catch (Exception ex){ ex.printStackTrace();}
    }


    public void traziPritisnut() {
        /** Korisnik pritisnuo pretragu za proizvode */

        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\Katalog.fxml"));
            Parent root = (Parent) loader.load();

            KatalogController pc = loader.getController();
            pc.prikaziSve();

            Main.scene.setRoot(root);
        }catch (Exception ex){}
    }

    public void nalogPritisnut() {
        /** Korisnik pritisnuo dugme za pregled svog naloga */

        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\Prijava.fxml"));
            Parent root = (Parent) loader.load();

            PrijavaController pc = loader.getController();

            Main.scene.setRoot(root);

        }catch (Exception ex){ ex.printStackTrace();}
    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
}
