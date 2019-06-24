package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Model.ContentMenadzer;
import Model.Kupac;
import View.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
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
    private TextField mail;

    @FXML
    private TextField adresa;

    @FXML
    private TextField lozinka1;

    @FXML
    private TextField brojTelefona;

    @FXML
    private Button lupa;

    @FXML
    private Button logo;

    @FXML
    private TextField korisnickoIme;

    @FXML
    private Font x3;


    @FXML
    private LogoController someIdController;

    @FXML
    void potvrdaIzmena(ActionEvent event) {

    }

    @FXML
    void nazadAkcija(ActionEvent event) {

    }

    @FXML
    void traziPritisnut(ActionEvent event) {

    }

    @FXML
    void izmenaNaloga(ActionEvent event) {

    }

    @FXML
    void korpaPritisnuta(ActionEvent event) {

    }

    @FXML
    void pritisnutLogo(ActionEvent event) {

    }
    
    void ucitaj() {
    	if (Main.webshop.ulogovaniKorisnik == null)
    		return;
    	if (Main.webshop.ulogovaniKorisnik instanceof Kupac) {
    		Kupac k = (Kupac) Main.webshop.ulogovaniKorisnik;
    		korisnickoIme.setText(k.getKorIme());
    		//izmena.setText(k.getKorIme());
    		ime.setText(k.getIme());
    		prezime.setText(k.getPrezime());
    		adresa.setText(k.getAdresa());
    		//brojTelefona.setText(k.getBrojTelefona());
    		mail.setText(k.getEmail());
    	}
    	else if (Main.webshop.ulogovaniKorisnik instanceof ContentMenadzer) {
    		ContentMenadzer k = (ContentMenadzer) Main.webshop.ulogovaniKorisnik;
    		korisnickoIme.setText(k.getKorIme());
    		//izmena.setText(k.getKorIme());
    		ime.setText(k.getIme());
    		prezime.setText(k.getPrezime());
    		adresa.setText(k.getAdresa());
    		//brojTelefona.setText(k.getBrojTelefona());
    		mail.setText(k.getEmail());
    	}
    	
    }

    void probaj() {
    	
    	
    	korisnickoIme.setText("Mijat");
    	lozinka.setText("Silni");
    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {

		ucitaj();
		
	}

}
