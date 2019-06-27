package Controller;

import Model.Narudzbina;
import View.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

public class ElementListeNarudzbinaController implements Initializable {

    @FXML
    private Label datum;

    @FXML
    private Label iznos;

    @FXML
    private Label broj;

    @FXML
    private Label primalac;

    @FXML
    private Label status;

    public Narudzbina narudzbina;

    public void ucitaj(Narudzbina nar){

        narudzbina = nar;
        broj.setText("ORD " +nar.getID());
        primalac.setText(narudzbina.getIme()+" "+narudzbina.getPrezime());
        status.setText(narudzbina.getTrenutnoStanje().nazivStanja());
        iznos.setText(narudzbina.getKorpa().ukupnaCena()+" €");
        datum.setText(new SimpleDateFormat("dd.MM.yyyy").format(narudzbina.getDatum()));

    }

    /** Pregled posebne narudzbine */
    @FXML
    void pregledajPorudzbinu() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\PojedinacnaNarudzbina.fxml"));
            Parent root = (Parent) loader.load();
            PojedinacnaNarudzbinaController elem = loader.getController();
            elem.ucitaj(narudzbina);

            Main.scene.setRoot(root);


        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
