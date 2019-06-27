package Controller;

import Model.Korpa;
import Model.Kupac;
import Model.Narudzbina;
import Model.StavkaNarudzbine;
import View.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class PojedinacnaNarudzbinaController implements Initializable {

    @FXML
    private Label brojNarudzbine;

    @FXML
    private VBox vBox;

    private Narudzbina narudzbina;

    public void ucitaj(Narudzbina n){

        narudzbina = n;
        brojNarudzbine.setText(narudzbina.getID()+"");

        vBox.setSpacing(10);
        Kupac k = (Kupac) Main.webshop.ulogovaniKorisnik;
        for(StavkaNarudzbine stavka : narudzbina.getKorpa().getStavkaNarudzbine()){

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\ElementNarudzbine.fxml"));
                HBox hb = (HBox) loader.load();
                ElementNarudzbineController elem = loader.getController();
                elem.postavi(stavka);

                Separator separator = new Separator();
                vBox.getChildren().addAll(hb,separator);

            }catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    /** Povratak iz pregleda pojedinacne
     * na pregled svih narudzbina
     */
    public void natragStisnuto(){

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\NarudzbineStefan.fxml"));
            Parent root = (Parent) loader.load();
            NarudzbineControllerStefan nc = loader.getController();
            Kupac k = (Kupac) Main.webshop.ulogovaniKorisnik;
            nc.ucitaj(k.getNarudzbine());

            Main.scene.setRoot(root);
        }
        catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
