package Controller;

import Model.Narudzbina;
import Model.StavkaNarudzbine;
import View.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PojedinacnaNarudzbinaController implements Initializable {

    @FXML
    private Label brojNarudzbine;

    @FXML
    private VBox vBox;

    private Narudzbina narudzbina;


    public void ucitaj(Narudzbina n){

        narudzbina = n;
        brojNarudzbine.setText(narudzbina.getID()+" - "+n.getTrenutnoStanje().nazivStanja());

        vBox.setSpacing(10);
        for(StavkaNarudzbine stavka : narudzbina.getKorpa().getStavkaNarudzbine()){

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\ElementNarudzbine.fxml"));
                HBox hb = (HBox) loader.load();
                ElementNarudzbineController elem = loader.getController();
                elem.postavi(stavka);

                Separator separator = new Separator();
                vBox.getChildren().addAll(hb,separator);
            }catch (Exception e) { e.printStackTrace(); }
        }


        HBox space = new HBox();
        space.setPrefHeight(15);

        VBox total = new VBox();
        total.setPadding(new Insets(0, 35, 0, 0));
        total.setSpacing(20);
        total.setAlignment(Pos.BOTTOM_RIGHT);
        Label cenaKorpe = new Label(" Ukupna cena:      "+narudzbina.getKorpa().ukupnaCena() + " €");
        cenaKorpe.setFont(new Font("System Bold", 18));

        total.getChildren().addAll(space,cenaKorpe);
        vBox.getChildren().add(total);
    }

    /** Povratak iz pregleda pojedinacne
     * na pregled svih narudzbina
     */
    public void natragStisnuto(){

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\NarudzbineStefan.fxml"));
            Parent root = (Parent) loader.load();
            NarudzbineControllerStefan nc = loader.getController();
            nc.ucitaj();

            Main.scene.setRoot(root);
        }
        catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
