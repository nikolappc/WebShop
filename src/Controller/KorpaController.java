package Controller;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;

import Model.Kupac;
import Model.StavkaNarudzbine;
import View.Main;
import com.sun.deploy.Environment;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class KorpaController implements Initializable {

	@FXML
	private VBox vBox;

	@FXML
	private Label korpaLabela;

	@FXML
	private GridPane gridPane;

	/** Prikazi sve artikle iz kupceve korpe */
	public void prikazi(){

		vBox.setSpacing(10);
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

		Button b = new Button("NARUCI NARUDZBINU");
		total.getChildren().addAll(space,l,b);
		vBox.getChildren().add(total);
	}




	@Override
	public void initialize(URL location, ResourceBundle resources) {

		if(((Kupac) Main.webshop.ulogovaniKorisnik).getKorpa().getStavkaNarudzbine().size() > 0)
			prikazi();
		else{
			vBox.getChildren().remove(1);
			korpaLabela.setText("NEMA NISTA JEBO TE DAN");


		}
	}
}
