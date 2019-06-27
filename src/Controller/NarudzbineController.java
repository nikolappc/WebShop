package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Model.Kupac;
import Model.Narudzbina;
import View.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class NarudzbineController implements Initializable {

	
	@FXML
	private VBox vBox;
	
    
    public Parent test() throws Exception {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\N.fxml"));
        Parent root = (Parent) loader.load();
        NarudzbineController pc = loader.getController();
        return root;
    }
	
	private void startuj() {
		Kupac k = (Kupac)Main.webshop.ulogovaniKorisnik;
		for (Narudzbina n: k.getNarudzbine()) {			
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\ElemNarudzbine.fxml"));
				AnchorPane hb = (AnchorPane) loader.load();
				ElemController elem = loader.getController();
				elem.postaviLabelu(n.getID());
				elem.setNarudzbina(n);
				elem.postaviStanje(n.getTrenutnoStanje());
	            vBox.getChildren().add(hb);
			}catch (Exception e) {e.printStackTrace(); }
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		startuj();
	}

}
