package Controller;

import Model.*;
import Model.Proizvod;
import View.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.swing.*;
import javax.xml.soap.Text;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HeaderController implements Initializable {

    @FXML
    private Button lupa;

    @FXML
    private Button logo;

    @FXML
    private TextField searchBar;


    /**
     * Korisnik pritisnuo LOGO
     */
    public void pritisnutLogo() {

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\glavni.fxml"));
            Parent root = (Parent) loader.load();

            MainController pc = loader.getController();

            Main.scene.setRoot(root);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Korisnik pritisnuo pretragu za proizvode
     */
    public void traziPritisnut() {

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\Katalog.fxml"));
            Parent root = (Parent) loader.load();

            KatalogController pc = loader.getController();

            // uradi pretragu
            String parametar = searchBar.getText();
            List<Proizvod> rezultat =
                    Main.webshop.pretraga.pretragaProizvoda(Main.webshop.proizvodi, parametar);


            pc.prikazi(rezultat);

            Main.scene.setRoot(root);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    /**
     * Korisnik pritisnuo dugme za pregled svog naloga
     */
    public void nalogPritisnut() {

        try {
            // proveri da li je ulogovan
            Parent root;
            if (Main.webshop.ulogovaniKorisnik == null) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\Prijava.fxml"));
                root = (Parent) loader.load();
                PrijavaController pc = loader.getController();
            } else {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\IzmenaNaloga.fxml"));
                root = (Parent) loader.load();
                IzmenaNalogaController inc = loader.getController();
            }
            Main.scene.setRoot(root);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    /**
     * Korisnik pritisnuo dugme za pregled svoje liste zelja
     */
    public void listaZeljaPritisnuta() {

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\ListaZelja.fxml"));
            Parent root = (Parent) loader.load();

            ListaZeljaController pc = loader.getController();

            Main.scene.setRoot(root);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


    public void izmenaNaloga() {
        // SAMO DA PROBAM

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\izmenaNaloga.fxml"));
            Parent root = (Parent) loader.load();

            IzmenaNalogaController pc = loader.getController();

            Main.scene.setRoot(root);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    /**
     * Korisnik pritisnuo dugme za pregled svoje korpe
     */
    public void korpaPritisnuta() {


        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\Korpa.fxml"));
            Parent root = (Parent) loader.load();

            KorpaController pc = loader.getController();

            Main.scene.setRoot(root);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    void muskeJaknePritisnut(ActionEvent event) {
        prikazi("muskarci|jakne");
    }
    void muskeJaknePritisnut(ActionEvent event) {
        List<Proizvod> proizvodi = Pretraga.
                pretragaProzvodaKategorija(Main.webshop.kategorije, "jakne");

        // pretrazi po trazenom polu
        proizvodi = Pretraga.pretragaProzvodaPol(proizvodi, Pol.M);
        prikazi(proizvodi);
    }

    @FXML
    void muskeDuksericePritisnut(ActionEvent event) {
        List<Proizvod> proizvodi = Pretraga.
                pretragaProzvodaKategorija(Main.webshop.kategorije, "duskevi");

        // pretrazi po trazenom polu
        proizvodi = Pretraga.pretragaProzvodaPol(proizvodi, Pol.M);
        prikazi(proizvodi);
        prikazi("muskarci|duksevi");
    }

    @FXML
    void muskeMajicePritisnut(ActionEvent event) {
        prikazi("muskarci|majice");
        List<Proizvod> proizvodi = Pretraga.
                pretragaProzvodaKategorija(Main.webshop.kategorije, "majce");

        // pretrazi po trazenom polu
        proizvodi = Pretraga.pretragaProzvodaPol(proizvodi, Pol.M);
        prikazi(proizvodi);
    }

    @FXML
    void muskePantalonePritisnut(ActionEvent event) {
        prikazi("muskarci|pantalone");
        List<Proizvod> proizvodi = Pretraga.
                pretragaProzvodaKategorija(Main.webshop.kategorije, "pantalone");

        // pretrazi po trazenom polu
        proizvodi = Pretraga.pretragaProzvodaPol(proizvodi, Pol.M);
        prikazi(proizvodi);
    }

    @FXML
    void muskePatikePritisnut(ActionEvent event) {
        prikazi("muskarci|patike");
        List<Proizvod> proizvodi = Pretraga.
                pretragaProzvodaKategorija(Main.webshop.kategorije, "pantalone");

        // pretrazi po trazenom polu
        proizvodi = Pretraga.pretragaProzvodaPol(proizvodi, Pol.M);
        prikazi(proizvodi);
    }

    @FXML
    void stisnuoStone(ActionEvent event) {
        List<Proizvod> proizvodi = Pretraga.
                pretragaProizvodBrend(Main.webshop.proizvodi, "Stone Island");
        prikazi(proizvodi);
    }

    @FXML
    void stisnuoStussy(ActionEvent event){
        List<Proizvod> proizvodi = Pretraga.
                pretragaProizvodBrend(Main.webshop.proizvodi, "Stussy");
        prikazi(proizvodi);
    }

    @FXML
    void stisnuoPalm(ActionEvent event){
        List<Proizvod> proizvodi = Pretraga.
                pretragaProizvodBrend(Main.webshop.proizvodi, "Palm Angels");
        prikazi(proizvodi);
    }

    @FXML
    void stisnuoSaint(ActionEvent event){
        List<Proizvod> proizvodi = Pretraga.
                pretragaProizvodBrend(Main.webshop.proizvodi, "Saint Laurent");
        prikazi(proizvodi);
    }

    @FXML
    void stisnuoMaison(ActionEvent event){
        List<Proizvod> proizvodi = Pretraga.
                pretragaProizvodBrend(Main.webshop.proizvodi, "Maison Margiela");
        prikazi(proizvodi);
    }

    @FXML
    void stisnuoNike(ActionEvent event){
        List<Proizvod> proizvodi = Pretraga.
                pretragaProizvodBrend(Main.webshop.proizvodi, "Nike");
        prikazi(proizvodi);
    }


    /**
     * Prikazuje proizvode za izabranu kategoriju iz dropdown
     * menija
     * @param naziv naziv kategorije
     */
    private void prikazi(String naziv) {
//
//        List<Proizvod> proizvodi = new ArrayList<Proizvod>();
//
//        for (Kategorija k1 : Main.webshop.getKategorije()) {
//
//            for (Kategorija k2 : k1.getPodKategorija()) {
//                if (k2.getNaziv().equals(naziv)) {
//                    proizvodi = k2.getProizvodi();
//                }
//            }
//
//        }

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\Katalog.fxml"));
            Parent root = (Parent) loader.load();

            KatalogController pc = loader.getController();
            pc.dodajUPrikazKategorije(naziv);

            Main.scene.setRoot(root);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
