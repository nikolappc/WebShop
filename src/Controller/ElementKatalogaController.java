package Controller;

import Model.Proizvod;
import View.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ElementKatalogaController implements Initializable {

    @FXML
    private Label naziv;

    @FXML
    private ImageView slikaProizvoda;

    @FXML
    private Label cena;

    public Proizvod proizvod;

    /** Ucitava jedan proizvod u matricu kataloga*/
    public void ucitaj(Proizvod p){

        proizvod = p;
        slikaProizvoda.setImage(new Image(proizvod.getSlike().get(1)));
        naziv.setText(proizvod.getNaziv());
        cena.setText(proizvod.dajCenu()+" €");
    }

    /** pritisnuta slika za detaljan pregled proizvoda*/
    @FXML
    void slikaPritisnuta() {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\Proizvod.fxml"));
            Parent root = (Parent) loader.load();

            ProizvodController pc = loader.getController();
            pc.postaviProizvod(proizvod);

            Main.scene.setRoot(root);
            Main.window.show();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    /** Korisnik postavio mis na sliku proizvoda u matrici kataloga*/
    @FXML
    void slikaHover() {
        slikaProizvoda.setImage(new Image(proizvod.getSlike().get(0)));
    }

    /** Pomerio mis sa slike */
    @FXML
    void slikaUnHover() {
        slikaProizvoda.setImage(new Image(proizvod.getSlike().get(1)));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}



