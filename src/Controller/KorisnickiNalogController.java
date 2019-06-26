package Controller;

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


    public void izmenaPodatakaPritisnuta(){
    	try {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\izmenaNaloga.fxml"));
	        Parent root = (Parent) loader.load();
	        IzmenaNalogaController inc = loader.getController();
	        Main.scene.setRoot(root);
    	}
        catch (Exception e) {
        }
    }

    public void pregledNarudzbinaPritisnut(){

    }

    public void listaZeljaPritisnuta(){

    }

    public void korpaPritisnuta(){

    }

    public void logOutPritisnut(){

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imePrezime.setText(Main.webshop.ulogovaniKorisnik.getIme()+" "+Main.webshop.ulogovaniKorisnik.getPrezime());
    }
}
