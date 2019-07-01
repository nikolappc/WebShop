package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.sun.rowset.internal.InsertRow;

import Model.Prodavnica;
import View.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class IzmenaProdavniceController implements Initializable{

	@FXML
	private GridPane grid;

	/**
	 * Kreiranje pogleda na prodavnice
	 */
	private void ucitaj() {
		int brojac = 1;
		for (Prodavnica prod : Main.webshop.getProdavnice()) {
			postaviNaziv(brojac,prod.getNaziv());
			postaviAdresu(brojac, prod.getAdresa());
			postaviSliku(brojac, prod.getSlika());
			
			brojac++;
		}
		VBox v = (VBox)grid.getParent();
		Insets inset = new Insets(0,0,0,0);
		v.setPadding(inset);
		//v.setPadding(new I);
		grid.setGridLinesVisible(true);
	}
	
	/**
	 * Pomocna funkcija koja kreira labelu za prodavnicu
	 */
	private void postaviNaziv(int row, String nazivProd) {
		Label naziv = new Label(nazivProd);
		naziv.setMinHeight(50);
		naziv.setMaxWidth(Double.MAX_VALUE);
		naziv.setMaxHeight(Double.MAX_VALUE);
		naziv.setAlignment(Pos.CENTER);
		grid.add(naziv, 0, row);
	}
	
	/**
	 * Pomocna funkcija za kreiranje labele za adresu
	 */
	private void postaviAdresu(int row, String adresaProd) {
		Label adresa = new Label(adresaProd);
		adresa.setMaxWidth(Double.MAX_VALUE);
		adresa.setMaxHeight(Double.MAX_VALUE);
		adresa.setAlignment(Pos.CENTER);
		grid.add(adresa, 1, row);
	}

	/**
	 * Pomocna funkcija za postavljanje slike
	 */
	private void postaviSliku(int row, String path) {
		if(path == null) {
			return;
		}
		Image im = new Image("file:" + path);
		ImageView iv = new ImageView(im);
		iv.setPreserveRatio(false);
		//Pane p = new Pane();
		iv.maxWidth(Double.MAX_VALUE);
		iv.maxHeight(Double.MAX_VALUE);
		grid.add(iv, 2, row);
	}

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ucitaj();
		
	}
	
}
