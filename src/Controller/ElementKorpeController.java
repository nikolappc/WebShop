package Controller;

import Model.Kupac;
import Model.Proizvod;
import Model.StavkaNarudzbine;
import View.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ElementKorpeController implements Initializable {

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

    private StavkaNarudzbine stavka;

    /** Ucitava proizvod koji se nalazi u korpi */
    public void postavi(StavkaNarudzbine s){
        stavka = s;

        slika.setImage(new Image(stavka.getProizvod().getSlike().get(1)));
        jedinicna.setText(stavka.getProizvod().dajCenu()+" €");
        ukupnaCena.setText((stavka.getKolicina()*stavka.getCena())+" €");
        kolicina.setText(stavka.getKolicina()+"");
        velicina.setText("Velicina: "+stavka.getVelicina());
        sifra.setText("Sifra: "+stavka.getProizvod().getSifra());
        boja.setText("Boja: "+stavka.getProizvod().getAtributVrednost("Boja"));
        imeProizvoda.setText(stavka.getProizvod().getNaziv());


    }

    /** pritisnuto digme za uklanjane proizvoda iz korpe*/
    @FXML
    void ukloniPritisnut() {
        Kupac kupac = (Kupac) Main.webshop.ulogovaniKorisnik;

        kupac.getKorpa().ukloniProizvod(stavka);

        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\Korpa.fxml"));
            Parent root = (Parent) loader.load();

            KorpaController mc = loader.getController();

            Main.scene.setRoot(root);

        } catch (Exception ex) {ex.printStackTrace();}
    }


    /**
     * korisnik zeli da smanji kolicinu za dati proizvod u korpi
     * ako je kolicina 1 proizvod se brise
     */
    @FXML
    void minusPritisnut() {

        if(stavka.getKolicina() == 1)
            ukloniPritisnut();
        else{
            ((Kupac) Main.webshop.ulogovaniKorisnik).getKorpa().izmeniKolicinuZaProizvod(stavka,-1);
            kolicina.setText(stavka.getKolicina()+"");
            ukupnaCena.setText((stavka.getKolicina()*stavka.getCena())+" €");
        }

    }


    /** korisnik zeli da poveca kolicinu proizvoda u korpi*/
    @FXML
    void plusPritisnut() {
        ((Kupac) Main.webshop.ulogovaniKorisnik).getKorpa().izmeniKolicinuZaProizvod(stavka,1);
        kolicina.setText(stavka.getKolicina()+"");
        ukupnaCena.setText((stavka.getKolicina()*stavka.getCena())+" €");
    }


    /**
     * klikom na sliku proizvoda u korpi,
     * dolazi do detaljnog prikaza proizvoda
     */
    @FXML
    void proizvodKliknut() {

        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\Proizvod.fxml"));
            Parent root = (Parent) loader.load();

            ProizvodController mc = loader.getController();
            mc.postaviProizvod(stavka.getProizvod());

            Main.scene.setRoot(root);

        } catch (Exception ex) {ex.printStackTrace();}
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
