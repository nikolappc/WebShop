package Controller;

import Model.StavkaNarudzbine;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ElementNarudzbineController implements Initializable {

    @FXML
    private ImageView slika;

    @FXML
    private Label ukupnaCena;

    @FXML
    private Label velicina;

    @FXML
    private Label kolicina;

    @FXML
    private Label boja;

    @FXML
    private Label sifra;

    @FXML
    private Label jedinicna;

    @FXML
    private Label imeProizvoda;

    @FXML
    void proizvodKliknut() {

    }

    public void postavi(StavkaNarudzbine stavka){

        slika.setImage(new Image(stavka.getProizvod().getSlike().get(1)));
        velicina.setText("Velicina: "+stavka.getVelicina());
        kolicina.setText(stavka.getKolicina()+"");
        boja.setText("Boja: "+stavka.getProizvod().getAtributVrednost("Boja"));
        sifra.setText("Sifra: "+ stavka.getProizvod().getSifra());
        jedinicna.setText(stavka.getCena()+" €");
        ukupnaCena.setText((stavka.getKolicina()*stavka.getCena())+" €");
        imeProizvoda.setText(stavka.getProizvod().getNaziv());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}