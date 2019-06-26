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


	/** Za sada pravi staticku korpu */
	public void dodaj(){

		//TODO KAD JE KORPA PRAZNA

		vBox.setSpacing(20);
		int ukupnaCena = 0;
		Kupac kupac = (Kupac) Main.webshop.ulogovaniKorisnik;
		for(StavkaNarudzbine stavka : kupac.getKorpa().getStavkaNarudzbine()){

			HBox hg = new HBox();
			hg.setPadding(new Insets(0,0,0,10));
			VBox v1= new VBox();
			v1.setPrefWidth(218);

			Label image = new Label(stavka.getProizvod().getNaziv());
			Label l2 = new Label("Boja : "+ stavka.getProizvod().getAtribut("Boja").getVrednost());
			Label l3 = new Label("Velicina: "+ stavka.getVelicina());
			Label l4 = new Label("Sifra: "+ stavka.getProizvod().getSifra() );

			v1.getChildren().addAll(image,l2,l3,l4);

			HBox ukloni = new HBox();
			ukloni.setAlignment(Pos.CENTER);
			ukloni.setPrefWidth(129);

			HBox zaSliku = new HBox();
			zaSliku.setAlignment(Pos.CENTER);
			zaSliku.setPrefWidth(36);
			zaSliku.setPrefHeight(36);
			ImageView X = new ImageView(Main.mojaPutanja+"Ikonice/X.png");
			X.setPreserveRatio(false);
			zaSliku.getChildren().addAll(X);
			//Label l1 = new Label("DUGME");
			ukloni.getChildren().add(zaSliku);

			HBox kolicina = new HBox();
			kolicina.setAlignment(Pos.CENTER);
			kolicina.setPrefWidth(119);
			ImageView plus = new ImageView(Main.mojaPutanja+"Ikonice/plus.png");
			ImageView minus = new ImageView(Main.mojaPutanja+"Ikonice/minus.png");
			plus.setPreserveRatio(false);	minus.setPreserveRatio(false);
			Label labela2 = new Label(stavka.getKolicina()+"");
			kolicina.getChildren().addAll(minus,labela2,plus);

			HBox jcena = new HBox();
			jcena.setAlignment(Pos.CENTER);
			jcena.setPrefWidth(140);
			Label labelac = new Label(stavka.getCena()+" €");
			jcena.getChildren().add(labelac);

			HBox cena = new HBox();
			cena.setAlignment(Pos.CENTER);
			cena.setPrefWidth(108);
			Label labelace = new Label((stavka.getKolicina()*stavka.getCena())+" €");
			cena.getChildren().add(labelace);
			ukupnaCena+=stavka.getKolicina()*stavka.getCena();

			hg.getChildren().addAll(v1,ukloni,kolicina, jcena,cena);
			vBox.getChildren().addAll(hg);

		}

		HBox space = new HBox();
		space.setPrefHeight(15);

		VBox total = new VBox();
		total.setPadding(new Insets(0, 45, 0, 0));
		total.setSpacing(20);
		total.setAlignment(Pos.BOTTOM_RIGHT);
		Label l = new Label(" Ukupna cena:     "+ukupnaCena + " €");

		Button b = new Button("NARUCI NARUDZBINU");
		total.getChildren().addAll(space,l,b);
		vBox.getChildren().add(total);



	}


	public void dodaj2(){

		vBox.setSpacing(10);
		int ukupnaCena = 0;
		Kupac kupac = (Kupac) Main.webshop.ulogovaniKorisnik;
		for(StavkaNarudzbine stavka : kupac.getKorpa().getStavkaNarudzbine()){
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\ElementKorpe.fxml"));
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
		dodaj2();
	}
}
