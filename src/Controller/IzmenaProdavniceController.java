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
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class IzmenaProdavniceController implements Initializable{

	@FXML
	private GridPane grid;

	private Font font;

	/**
	 * Kreiranje pogleda na prodavnice
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		font = new Font("System",16);
		int brojac = 1;
		grid.setVgap(20);
		for (Prodavnica prod : Main.webshop.getProdavnice()) {
			postaviNaziv(brojac,prod.getNaziv());
			postaviAdresu(brojac, prod.getAdresa());
			postaviSliku(brojac, prod.getSlika());
			brojac++;
		}
	}
	
	/**
	 * Pomocna funkcija koja kreira labelu za prodavnicu
	 */
	private void postaviNaziv(int row, String nazivProd) {
		Label naziv = new Label(nazivProd);
		naziv.setFont(font);
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
		adresa.setFont(font);
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
		HBox h = new HBox();
		h.setPadding(new Insets(3,3,3,3));
		grid.setPrefHeight(80);
		Image im = new Image("file:" + path);
		ImageView iv = new ImageView(im);
		iv.setPreserveRatio(false);
		iv.setFitWidth(180);
		iv.setFitHeight(80);
		h.getChildren().add(iv);
		grid.add(h, 2, row);
	}
	
}
