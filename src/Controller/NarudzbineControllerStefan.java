package Controller;

import Model.ContentMenadzer;
import Model.Kupac;
import Model.Narudzbina;
import View.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

enum Kriterijum {brojNarudzbine, datum, iznosNarudzbine, imePrimaoca, statusNarudzbine }

public class NarudzbineControllerStefan implements Initializable {


    @FXML
    private VBox vBox;

    private List<Narudzbina> narudzbine;

    public void ucitaj(){
        List<Narudzbina> lista = new ArrayList<>();
        ucitaj(lista);
    }

    public void ucitaj(List<Narudzbina> n){

        narudzbine = n;
        vBox.setSpacing(10);
        if(Main.webshop.ulogovaniKorisnik instanceof Kupac){

            Kupac k = (Kupac) Main.webshop.ulogovaniKorisnik;
            narudzbine = k.getNarudzbine();
        }
        else{
            ContentMenadzer m  = (ContentMenadzer) Main.webshop.ulogovaniKorisnik;
            narudzbine = Main.webshop.getNarudzbine();
        }

        for(Narudzbina nar : narudzbine){

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\ElementListeNarudzbina.fxml"));
                GridPane hb = (GridPane) loader.load();
                ElementListeNarudzbinaController elem = loader.getController();
                elem.ucitaj(nar);

                Separator separator = new Separator();
                vBox.getChildren().addAll(hb,separator);

            }catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    /** metode za sortiranje narudzbina */
    public void sortirajBroj(){ sortiraj(Kriterijum.brojNarudzbine); osvezi();}

    public void sortirajDatum(){ sortiraj(Kriterijum.datum); osvezi();}

    public void sortirajIznos(){ sortiraj(Kriterijum.iznosNarudzbine); osvezi();}

    public void sortirajIme() { sortiraj(Kriterijum.imePrimaoca); osvezi();}

    public void sortirajStatus(){ sortiraj(Kriterijum.statusNarudzbine); osvezi();}

    private void sortiraj(Kriterijum krit){
        //TODO IMPLEMENTIRAJ

    }

    /** osvezava stranicu zbog moguce promene redosleda narudzbina */
    private void osvezi(){
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
