package Controller;

import Model.Kupac;
import Model.ListaZelja;
import Model.UlogovaniKorisnik;
import Model.Webshop;
import View.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class KorisnickiNalogController implements Initializable {

    @FXML
    private Label imePrezime;


    /** promena osnoivnih podataka o korisniku*/
    @FXML
    public void izmenaPodatakaPritisnuta(){
    	try {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\izmenaNaloga.fxml"));
	        Parent root = (Parent) loader.load();
	        IzmenaNalogaController inc = loader.getController();
	        Main.scene.setRoot(root);
    	}
        catch (Exception e) { e.printStackTrace(); }
    }


    /** pregled svih narudzbina trenutnog korisnika */
    @FXML
    public void pregledNarudzbinaPritisnut(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\NarudzbineStefan.fxml"));
            Parent root = (Parent) loader.load();
            NarudzbineControllerStefan nc = loader.getController();
            nc.ucitaj();

            Main.scene.setRoot(root);
        }
        catch (Exception e) { e.printStackTrace(); }
    }


    /** pregled liste zelja trenutnog korisnika*/
    @FXML
    public void listaZeljaPritisnuta(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\ListaZelja.fxml"));
            Parent root = (Parent) loader.load();
            ListaZeljaController inc = loader.getController();
            Main.scene.setRoot(root);
        }
        catch (Exception e) { e.printStackTrace(); }
    }


    /** pregled korpe trenutnog korisnika */
    @FXML
    public void korpaPritisnuta(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\korpa.fxml"));
            Parent root = (Parent) loader.load();
            KorpaController inc = loader.getController();
            Main.scene.setRoot(root);
        }
        catch (Exception e) { e.printStackTrace(); }
    }

    /**
     * Pregled prodavnica
     */
    @FXML
    public void pregledProdavnica() {
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\prodavnice.fxml"));
            Parent root = (Parent) loader.load();
            Main.scene.setRoot(root);
        }
        catch (Exception e) { e.printStackTrace(); }
    }
    
    /** odjava iz aplikacije */
    @FXML
    public void logOutPritisnut(){
        try {
            Main.webshop.ulogovaniKorisnik = new Kupac();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\glavni.fxml"));
            Parent root = (Parent) loader.load();
            MainController inc = loader.getController();
            Main.scene.setRoot(root);
        }
        catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imePrezime.setText(Main.webshop.ulogovaniKorisnik.getIme()+" "+Main.webshop.ulogovaniKorisnik.getPrezime());
    }
}
