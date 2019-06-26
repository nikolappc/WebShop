package Controller;

import Model.Kupac;
import Model.Proizvod;
import Model.StavkaNarudzbine;
import View.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ElementListeZeljaController {

    @FXML
    private ImageView slika;

    @FXML
    private Label boja;

    @FXML
    private Label sifra;

    @FXML
    private Label cena;

    @FXML
    private Label imeProizvoda;

    private Proizvod proizvod;


    public void postavi(Proizvod s){
        proizvod = s;

        slika.setImage(new Image(proizvod.getSlike().get(1)));
        cena.setText(proizvod.dajCenu() + " €");
        sifra.setText("Sifra: "+proizvod.getSifra());
        boja.setText("Boja: "+proizvod.getAtributVrednost("Boja"));
        imeProizvoda.setText(proizvod.getNaziv());
    }

    @FXML
    void proizvodKliknut() {

        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\Proizvod.fxml"));
            Parent root = (Parent) loader.load();

            ProizvodController mc = loader.getController();
            mc.postaviProizvod(proizvod);

            Main.scene.setRoot(root);

        } catch (Exception ex) {ex.printStackTrace();}
    }

    @FXML
    void ukloniPritisnut( ) {

        Kupac kupac = (Kupac) Main.webshop.ulogovaniKorisnik;

        kupac.getListaZelja().izbaciProizvod(proizvod);

        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\ListaZelja.fxml"));
            Parent root = (Parent) loader.load();

            ListaZeljaController mc = loader.getController();

            Main.scene.setRoot(root);

        } catch (Exception ex) {ex.printStackTrace();}

    }

    @FXML
    void dodaoUKorpu() {
        //TODO VELICINU DODATI
        StavkaNarudzbine stavka = new StavkaNarudzbine(1,proizvod.dajCenu(),proizvod, "M");
        ((Kupac) Main.webshop.ulogovaniKorisnik).getKorpa().dodajProizvod(stavka);

        ukloniPritisnut();

    }

}
