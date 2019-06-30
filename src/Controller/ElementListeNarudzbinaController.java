package Controller;

import Model.*;
import View.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
            String obrada = "Obradjuje se";
            String poslata = "Poslata";
            String isporucena = "Isporucena";
            String vracena = "Vracena";
            stanja.getItems().addAll(obrada,poslata,isporucena,vracena);
            stanja.getSelectionModel().select(narudzbina.getTrenutnoStanje().redniBroj());

            stanja.valueProperty().addListener(new ChangeListener<String>() {
                @Override public void changed(ObservableValue ov, String t, String t1) {
                    if(t1.equals(obrada))
                        narudzbina.setTrenutnoStanje(new Obrada());
                    else if(t1.equals(poslata))
                        narudzbina.setTrenutnoStanje(new Poslata());
                    else if(t1.equals(isporucena))
                        narudzbina.setTrenutnoStanje(new Isporucena());
                    else if(t1.equals(vracena))
                        narudzbina.setTrenutnoStanje(new Vracena());
                    else
                        System.out.println("Greska kod promene stanja");

                    promeniStanje(narudzbina.getTrenutnoStanje().redniBroj());
                }
            });

            hbox.getChildren().add(stanja);
        }
    }


    /** Menja stanje narudzbine za kupca */
    void promeniStanje(int redniBroj){

        for(Kupac k : Main.webshop.getKupci()){
            for(Narudzbina n : k.getNarudzbine())
                if(n.getID() == narudzbina.getID()){
                    if(redniBroj == 0)
                        n.setTrenutnoStanje(new Obrada());
                    else if(redniBroj == 1)
                        n.setTrenutnoStanje(new Poslata());
                    else if(redniBroj == 2)
                        n.setTrenutnoStanje(new Isporucena());
                    else
                        n.setTrenutnoStanje(new Vracena());
                    return;
                }
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
