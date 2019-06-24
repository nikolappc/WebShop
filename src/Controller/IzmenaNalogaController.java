package Controller;

import java.net.URL;
import java.util.ResourceBundle;

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
    private Hyperlink izmena;

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

    void probaj() {
    	
    	
    	korisnickoIme.setText("Mijat");
    	lozinka.setText("Silni");
    	izmena.setText("MijatSilni");
    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {

		probaj();
		
	}

}
