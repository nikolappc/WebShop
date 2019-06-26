package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Model.ContentMenadzer;
import Model.Kupac;
import View.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

public class IzmenaNalogaController implements Initializable{

    @FXML
    private TextField ime;

    @FXML
    private TextField prezime;

    @FXML
    private TextField lozinka;
    
    @FXML
    private TextField lozinka1;
    
    @FXML
    private TextField mail;

    @FXML
    private TextField adresa;

    @FXML
    private TextField brojTelefona;

    @FXML
    private TextField korisnickoIme;

    @FXML
    private Font x3;

    /*
     * 
    @FXML
    private HeaderController someId;
     */

    @FXML
    void potvrdaIzmena(ActionEvent event) {
    }

    @FXML
    void nazadAkcija(ActionEvent event) {
    	
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\KorisnickiNalog.fxml"));
    		Parent root;
			root = (Parent) loader.load();
			KorisnickiNalogController inc = loader.getController();
			Main.scene.setRoot(root);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	
    }


    /**
     * Ucitava vrednosti atributa korisnika u odgovarajuca polja
     */
    void ucitaj() {
    	if (Main.webshop.ulogovaniKorisnik == null)
    		return;
    	if (Main.webshop.ulogovaniKorisnik instanceof Kupac) {
    		Kupac k = (Kupac) Main.webshop.ulogovaniKorisnik;
    		korisnickoIme.setText(k.getKorIme());
    		ime.setText(k.getIme());
    		prezime.setText(k.getPrezime());
    		adresa.setText(k.getAdresa());
    		//brojTelefona.setText(k.getBrojTelefona());
    		mail.setText(k.getEmail());
    	}
    	else if (Main.webshop.ulogovaniKorisnik instanceof ContentMenadzer) {
    		ContentMenadzer k = (ContentMenadzer) Main.webshop.ulogovaniKorisnik;
    		korisnickoIme.setText(k.getKorIme());
    		ime.setText(k.getIme());
    		prezime.setText(k.getPrezime());
    		adresa.setText(k.getAdresa());
    		//brojTelefona.setText(k.getBrojTelefona());
    		mail.setText(k.getEmail());
    	}
    	
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ucitaj();
		
	}

}
