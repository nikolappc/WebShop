package Controller;

import Model.Kupac;
import View.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class MenadzerKontroler implements Initializable {

    @FXML
    private Label imePrezime;

    /** dodavanje novog proizvoda u web shop */
    @FXML
    private void dodajProizvodPritisnut(ActionEvent event){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\DodavanjeProizvoda.fxml"));
            Parent root = loader.load();
            DodajProizvodController dpc = loader.getController();
            Main.scene.setRoot(root);
        } catch(Exception e) { e.printStackTrace(); }
    }

    /** dodavanje nove kategorije proizvoda u web shop*/
    @FXML
    private void dodajKategorijuPritisnut(ActionEvent event){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\DodavanjeKategorije.fxml"));
            Parent root = loader.load();
            Main.scene.setRoot(root);
        } catch(Exception e) { e.printStackTrace(); }
    }

    /** Pregled svih narudzbina web shopa */
    @FXML
    private void pregledNarudzinePritisnut(ActionEvent event){

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\NarudzbineStefan.fxml"));
            Parent root = (Parent) loader.load();
            NarudzbineControllerStefan nc = loader.getController();
            nc.ucitaj();
            Main.scene.setRoot(root);
        }
        catch (Exception e) { e.printStackTrace(); }

    }

    /** Odjavljivanje sa korisnickog naloga */
    @FXML
    private void logoutPritisnut(ActionEvent event){
        try {
            Main.webshop.ulogovaniKorisnik = new Kupac();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\glavni.fxml"));
            Parent root = (Parent) loader.load();
            MainController inc = loader.getController();
            Main.scene.setRoot(root);
        }
        catch (Exception e) { e.printStackTrace(); }
    }
    
    /**
     * Izmena menadzerskog naloga
     */
    @FXML
    private void izmeniNalog(ActionEvent event) {
    	try {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\izmenaNaloga.fxml"));
	        Parent root = (Parent) loader.load();
	        IzmenaNalogaController inc = loader.getController();
	        Main.scene.setRoot(root);
    	}
        catch (Exception e) { e.printStackTrace(); }
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imePrezime.setText(Main.webshop.ulogovaniKorisnik.getKorIme());
    }
}
