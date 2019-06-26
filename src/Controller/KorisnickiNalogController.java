package Controller;

import Model.Kupac;
import Model.ListaZelja;
import Model.UlogovaniKorisnik;
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

    @FXML
    public void pregledNarudzbinaPritisnut(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\Narudzbine.fxml"));
            Parent root = (Parent) loader.load();
            NarudzbineController nc = loader.getController();
            Main.scene.setRoot(root);
        }
        catch (Exception e) { e.printStackTrace(); }
    }

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


    @FXML
    public void korpaPritisnuta(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\korpa.fxml"));
            Parent root = (Parent) loader.load();
            IzmenaNalogaController inc = loader.getController();
            Main.scene.setRoot(root);
        }
        catch (Exception e) { e.printStackTrace(); }
    }

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
