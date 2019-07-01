package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Model.ContentMenadzer;
import Model.Pretraga;
import Model.UlogovaniKorisnik;
import View.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class DodavanjeMenController implements Initializable {

	
	@FXML
	private TextField ime;
	
	@FXML
	private TextField prezime;
	
	@FXML
	private TextField lozinka;
	
	@FXML
	private TextField korIme;
	
	@FXML
	private TextField mail;
	
	@FXML
	private TextField adresa;
	
	
	@FXML
    void napraviNalog(ActionEvent event) {

		korIme.setPromptText("");
		korIme.setStyle("-fx-text-box-border: grey;");
		lozinka.setPromptText("");
		lozinka.setStyle("-fx-text-box-border: grey;");
		boolean user = proveriUserName();
		
		if(lozinka.getText().equals("")) {
			lozinka.setPromptText("Polje je obavezno");
			lozinka.setStyle("-fx-text-box-border: red;");
			return;
		}
		
		if(!user) {
			ContentMenadzer m = new ContentMenadzer(korIme.getText(), lozinka.getText(), ime.getText()
					, prezime.getText(), mail.getText(), adresa.getText());
			Main.webshop.addContentMenadzer(m);
			obavestenjeKreiranja();
			nazad();
		}
			
	}

	/**
	 * Funkcija za ucitavanje adminskog menija
	 * 
	 */
	private void nazad() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\AdminMain.fxml"));
    	Parent root;
		try {
			root = (Parent) loader.load();
			AdminKontroler pc = loader.getController();
	        Main.scene.setRoot(root);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Dialog koji obavestava admina da je kreirao menadzera
	 * 
	 */
	private void obavestenjeKreiranja() {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Kreiran menadzer");
    	alert.setHeaderText(null);
    	alert.setContentText("Uspesno ste kreirali menadzera!");

    	alert.showAndWait();
    }
	
	/**
     * Funkcija za proveru username. Vraca true ukoliko ima gresku
     * @return
     */
    private boolean proveriUserName() {
    	

    	if(korIme.getText().equals("")) {
    		korIme.setPromptText("Polje je obavezno");
    		korIme.setStyle("-fx-text-box-border: red;");
    		return true;
    	}
    	UlogovaniKorisnik u = Pretraga.pretragaKupacaKorisnicko(Main.webshop.getKupci(), 
    			Main.webshop.getContentMenadzeri(), korIme.getText());
    	
    	if(u == null) {
    		return false;
    	}
    	
    	korIme.setPromptText("Korisnicko ime vec postoji");
    	korIme.setStyle("-fx-text-box-border: red;");
    	return true;
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
}
