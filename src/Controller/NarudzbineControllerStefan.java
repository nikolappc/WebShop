package Controller;

import Model.ContentMenadzer;
import Model.Kupac;
import Model.Narudzbina;
import Model.StavkaNarudzbine;
import View.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.util.*;


enum Kriterijum {brojNarudzbine, datum, iznosNarudzbine, imePrimaoca, statusNarudzbine }


public class NarudzbineControllerStefan implements Initializable {

    @FXML
    private VBox vBox;

    private List<Narudzbina> narudzbine;

    /** poslednji primenjen kriterijum sortiranja */
    private Kriterijum currentSort;


    /** Ucitava sve narudzbine za korisnika/menadzera u tabelarnom obliku */
    public void ucitaj(){

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

            }catch (Exception e) { e.printStackTrace(); }
        }
    }

    /** metode za sortiranje narudzbina */
    public void sortirajBroj(){ sortiraj(Kriterijum.brojNarudzbine); osvezi();}

    public void sortirajDatum(){ sortiraj(Kriterijum.datum); osvezi();}

    public void sortirajIznos(){ sortiraj(Kriterijum.iznosNarudzbine); osvezi();}

    public void sortirajIme() { sortiraj(Kriterijum.imePrimaoca); osvezi();}

    public void sortirajStatus(){ sortiraj(Kriterijum.statusNarudzbine); osvezi();}


    /** sortira listu narudzbina po zadatom kriterijumu */
    private void sortiraj(Kriterijum krit){

        if(currentSort == krit){
            Collections.reverse(narudzbine);
            return;
        }

        currentSort = krit;
        for (int i = 0; i < narudzbine.size() - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < narudzbine.size(); j++){
                if( compare(narudzbine.get(j), narudzbine.get(index), krit)){
                    index = j;//searching for lowest index
                }
            }
            Collections.swap(narudzbine, index, i);
        }
    }


    /**
     * poredi narudzbine po zadatom kriterijumu
     * @param n1 - prva narudzbina
     * @param n2 - druga narudzbina
     * @param kriterijum - kriterijum poredjenja
     * @return 1. true  ako n1 < n2
     *         2. false ako n1 >= n2
     */
    public boolean compare(Narudzbina n1, Narudzbina n2, Kriterijum kriterijum){

        switch (kriterijum){

            case brojNarudzbine:
                return n1.getID() < n2.getID();
            case datum:
                return n1.getDatum().before(n2.getDatum());
            case iznosNarudzbine:
                return n1.getKorpa().ukupnaCena() < n2.getKorpa().ukupnaCena();
            case imePrimaoca:
                String primalac1 = n1.getIme() + n1.getPrezime();
                String primalac2 = n2.getIme() + n2.getPrezime();
                return primalac1.trim().compareTo(primalac2.trim()) < 0;
            case statusNarudzbine:
                return n1.getTrenutnoStanje().nazivStanja().compareTo(n2.getTrenutnoStanje().nazivStanja()) < 0;
            default:
                return false;
        }
    }

    /** osvezava stranicu zbog moguce promene redosleda narudzbina */
    private void osvezi(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\NarudzbineStefan.fxml"));
            Parent root = (Parent) loader.load();
            NarudzbineControllerStefan nc = loader.getController();
            nc.ucitaj();
            nc.currentSort = currentSort;

            Main.scene.setRoot(root);
        }
        catch (Exception e) { e.printStackTrace(); }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
