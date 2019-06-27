package Controller;

import Model.ContentMenadzer;
import Model.Kupac;
import Model.Narudzbina;
import View.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

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

    @FXML
    private HBox hbox;

    public Narudzbina narudzbina;

    public void ucitaj(Narudzbina nar){

        narudzbina = nar;
        broj.setText("ORD " +nar.getID());
        primalac.setText(narudzbina.getIme()+" "+narudzbina.getPrezime());
        iznos.setText(narudzbina.getKorpa().ukupnaCena()+" €");
        datum.setText(new SimpleDateFormat("dd.MM.yyyy").format(narudzbina.getDatum()));

        if(Main.webshop.ulogovaniKorisnik instanceof Kupac)
            status.setText(narudzbina.getTrenutnoStanje().nazivStanja());
        else{
            hbox.getChildren().remove(0);

            ComboBox<String> stanja = new ComboBox<>();
            stanja.getItems().addAll("Obradjuje se", "Poslata", "Isporucena", "Vracena");
            stanja.getSelectionModel().select(1);
            hbox.getChildren().add(stanja);

        }

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
