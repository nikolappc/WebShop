package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;

import Dialog.DialogInfo;
import Model.Korpa;
import Model.Kupac;
import Model.Narudzbina;
import Model.Pretraga;
import Model.StavkaNarudzbine;
import View.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import static java.lang.Math.abs;

public class KorpaController implements Initializable {

	@FXML
	private VBox vBox;

	@FXML
	private Label korpaLabela;

	@FXML
	private GridPane gridPane;
	
	/** Prikazi sve artikle iz kupceve korpe */
	public void prikazi(){

		vBox.setSpacing(20);
		int ukupnaCena = 0;
		Kupac kupac = (Kupac) Main.webshop.ulogovaniKorisnik;
		for(StavkaNarudzbine stavka : kupac.getKorpa().getStavkaNarudzbine()){
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\ElementKorpe.fxml"));
				HBox hb = (HBox) loader.load();
				ElementKorpeController ekc= loader.getController();
				ekc.postavi(stavka);
				ukupnaCena+= stavka.getKolicina()*stavka.getCena();

				//TODO DODATI NEKAKO LISTENER NA UKUPNU CENU

				vBox.getChildren().add(hb);

			}catch (Exception e) {
				e.printStackTrace();
			}
		}

		HBox space = new HBox();
		space.setPrefHeight(15);

		VBox total = new VBox();
		total.setPadding(new Insets(0, 20, 0, 0));
		total.setSpacing(20);
		total.setAlignment(Pos.BOTTOM_RIGHT);
		Label l = new Label(" Ukupna cena:     "+ukupnaCena + " €");

		Button b = new Button("NARUCI");
		b.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	infoKorisnika();
		    }
		});
		
		
		total.getChildren().addAll(space,l,b);
		vBox.getChildren().add(total);
	}


	private void infoKorisnika(){
		// Create the custom dialog.
		DialogInfo d = new DialogInfo();
		if(d.start()) {
			napraviNarudzbinu(d.ime,d.prezime,d.adresa);
		}
	}
	

	/**
	 * Funkcija koja pravi narudzbinu
	 */
	private void napraviNarudzbinu(String ime,String prezime,String adresa) {
		Kupac k = (Kupac) Main.webshop.ulogovaniKorisnik;
		Narudzbina n = new Narudzbina(k.getKorpa(), ime,prezime,adresa);
		Random r = new Random();
		while(true) {			
			int ID = abs(1000 + r.nextInt()%98999);
			Narudzbina n1 = Pretraga.pretragaNarudzbine(ID,
					(List<Narudzbina>) Main.webshop.getNarudzbine());
			if(n1 == null) {
				n.setID(ID);
				break;
			}
		}
		
		k.dodajNarudzbine(n);
		Main.webshop.addNarudzbina(n);
		k.setKorpa(new Korpa());
		promeniIzgled();
		
	}

	/**
	 * Funkcija za promenu trenutnog izgleda korpe
	 * 
	 */
	private void promeniIzgled(){
		vBox.getChildren().clear();
		korpaLabela.setText("Uspesno ste porucili proizvod");
		Button dugme = new Button("Nazad Bog te");
		dugme.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	try {

		            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\glavni.fxml"));
		            Parent root = (Parent) loader.load();

		            MainController pc = loader.getController();

		            Main.scene.setRoot(root);

		        } catch (Exception ex) {
		            ex.printStackTrace();
		        };
		    }
		});
		vBox.getChildren().addAll(korpaLabela,dugme);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		if(((Kupac) Main.webshop.ulogovaniKorisnik).getKorpa().getStavkaNarudzbine().size() > 0)
			prikazi();
		else{
			vBox.getChildren().remove(1);
			korpaLabela.setText("Korpa je trenutno prazna :'-( ");


		}
	}
}
