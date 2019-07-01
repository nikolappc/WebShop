package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Model.ContentMenadzer;
import Model.Kupac;
import Model.Pretraga;
import Model.UlogovaniKorisnik;
import View.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
    
    private UlogovaniKorisnik korisnik;
    
    
    /**
     * Funkcija koja se aktivira kada se potvrde izmene
     */
    @FXML
    void potvrdaIzmena(ActionEvent event) {
    	
    	boolean korBool = proveriUserName();
    	
    	boolean lozBool = proveriPassword();
    	
    	if(!(korBool || lozBool)) {
    		promeniInformacije();
    		obavestenjeIzmena();
    		ucitaj();
    	}
    	
    }

    
    
    /**
     * Funkcija koja izmenjuje nalog
     * 
     */
    private void promeniInformacije() {

		korisnickoIme.setStyle("-fx-text-box-border: grey;");
		lozinka1.setStyle("-fx-text-box-border: grey;");
    	korisnik.setKorIme(korisnickoIme.getText());
    	korisnik.setIme(ime.getText());
    	korisnik.setPrezime(prezime.getText());
    	if(!lozinka.getText().equals("")) {
    		korisnik.setLozinka(lozinka.getText());
    	}
    	if (Main.webshop.ulogovaniKorisnik instanceof Kupac) {
    		Kupac k = (Kupac) Main.webshop.ulogovaniKorisnik;
    		k.setAdresa(adresa.getText());
    		k.setEmail(mail.getText());
    	}
    	else if (Main.webshop.ulogovaniKorisnik instanceof ContentMenadzer) {
    		ContentMenadzer k = (ContentMenadzer) Main.webshop.ulogovaniKorisnik;
    		k.setAdresa(adresa.getText());
    		k.setEmail(mail.getText());
    	}
    	
    }
    
    /**
     * Funkcija koja kreira dialog i obavestava korisnika da je izmenio nalog.
     */
    private void obavestenjeIzmena() {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Izmena izvrsena");
    	alert.setHeaderText(null);
    	alert.setContentText("Uspesno ste izmenili podatke");

    	alert.showAndWait();
    }
    
    
    /**
     * Funkcija za proveru username. Vraca true ukoliko ima gresku
     * @return
     */
    private boolean proveriUserName() {
    	
    	if(korisnik.getKorIme().equals(korisnickoIme.getText())) {
    		return false;
    	}
    	else if(korisnickoIme.getText().equals("")) {
    		korisnickoIme.setPromptText("Polje je obavezno");
    		korisnickoIme.setStyle("-fx-text-box-border: red;");
    		return true;
    	}
    	UlogovaniKorisnik u = Pretraga.pretragaKupacaKorisnicko(Main.webshop.getKupci(), 
    			Main.webshop.getContentMenadzeri(), korisnickoIme.getText());
    	
    	if(u == null || u.getKorIme().equals(korisnik.getKorIme())) {
    		return false;
    	}
    	
    	korisnickoIme.setPromptText("Korisnicko ime vec postoji");
		korisnickoIme.setStyle("-fx-text-box-border: red;");
    	return true;
    }
    
    /**
     * Funkcija za proveru password-a. Vraca true ukoliko ima gresku
     * @return
     */
    private boolean proveriPassword() {
    	
    	if(lozinka.getText().equals(lozinka1.getText())) {
    		return false;
    	}
    	lozinka1.setPromptText("Sifra se ne poklapaju");
    	lozinka1.setStyle("-fx-text-box-border: red;");
    	return true;
    }
    
    /**
     * Funkcija koja menja trenutni prozor na meni korisnika
     */
    @FXML
    void nazadAkcija(ActionEvent event) {
    	
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\KorisnickiNalog.fxml"));
    		Parent root;
			root = (Parent) loader.load();
			KorisnickiNalogController inc = loader.getController();
			Main.scene.setRoot(root);
		} catch (Exception e) { e.printStackTrace(); }
    }


    /**
     * Ucitava vrednosti atributa korisnika u odgovarajuca polja
     */
    void ucitaj() {
    	korisnik = Main.webshop.ulogovaniKorisnik;
    	if (Main.webshop.ulogovaniKorisnik == null)
    		return;
    	korisnickoIme.setText(korisnik.getKorIme());
		ime.setText(korisnik.getIme());
		prezime.setText(korisnik.getPrezime());
    	if (Main.webshop.ulogovaniKorisnik instanceof Kupac) {
    		Kupac k = (Kupac) Main.webshop.ulogovaniKorisnik;
    		adresa.setText(k.getAdresa());
    		mail.setText(k.getEmail());
    	}
    	else if (Main.webshop.ulogovaniKorisnik instanceof ContentMenadzer) {
    		ContentMenadzer k = (ContentMenadzer) Main.webshop.ulogovaniKorisnik;
    		adresa.setText(k.getAdresa());
    		mail.setText(k.getEmail());
    	}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ucitaj();
		
	}

}
