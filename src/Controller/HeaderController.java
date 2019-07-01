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
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HeaderController implements Initializable {

    @FXML
    private TextField searchBar;

    /** Korisnik pritisnuo LOGO*/
    public void pritisnutLogo() {

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\glavni.fxml"));
            Parent root = (Parent) loader.load();

            MainController pc = loader.getController();

            Main.scene.setRoot(root);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    /** Korisnik pritisnuo pretragu za proizvode */
    public void traziPritisnut() {

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\Katalog.fxml"));
            Parent root = (Parent) loader.load();

            KatalogController pc = loader.getController();

            // uradi pretragu
            String parametar = searchBar.getText();
            List<Proizvod> rezultat =
                    Pretraga.pretragaProizvoda(Main.webshop.proizvodi, parametar);


            pc.prikaziIOsveziSidebar(rezultat);

            Main.scene.setRoot(root);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    /** Korisnik pritisnuo dugme za pregled svog naloga*/
    public void nalogPritisnut() {

        try {
            // proveri da li je ulogovan
            Parent root;
            if("admin".equals(Main.webshop.ulogovaniKorisnik.getKorIme())) {
        		FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\AdminMain.fxml"));
            	root = (Parent) loader.load();
                AdminKontroler pc = loader.getController();
                Main.scene.setRoot(root);
            }
            else if (Main.webshop.ulogovaniKorisnik.getKorIme() == null) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\Prijava.fxml"));
                root = (Parent) loader.load();
                PrijavaController pc = loader.getController();
            } else if(Main.webshop.ulogovaniKorisnik instanceof Kupac){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\KorisnickiNalog.fxml"));
                root = (Parent) loader.load();
                KorisnickiNalogController inc = loader.getController();
            } else{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\MenadzerMain.fxml"));
                root = (Parent) loader.load();
                MenadzerKontroler inc = loader.getController();
            }
            Main.scene.setRoot(root);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    /** Korisnik pritisnuo dugme za pregled svoje liste zelja */
    public void listaZeljaPritisnuta() {

        try {
            // menadzer nema listu zelja
            if(Main.webshop.ulogovaniKorisnik instanceof ContentMenadzer){
                return;
            }

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\ListaZelja.fxml"));
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\IzmenaNaloga.fxml"));
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
            // menadzer nema korpu
            if(Main.webshop.ulogovaniKorisnik instanceof ContentMenadzer){
                return;
            }
            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\Korpa.fxml"));
            Parent root = (Parent) loader.load();
            KorpaController pc = loader.getController();

            Main.scene.setRoot(root);

        } catch (Exception ex) { ex.printStackTrace(); }
    }

    @FXML
    void muskeJaknePritisnut(ActionEvent event) {
        prikazi("muskarci|jakne");
    }

    @FXML
    void muskeDuksericePritisnut(ActionEvent event) {
        prikazi("muskarci|duksevi");
    }

    @FXML
    void muskeMajicePritisnut(ActionEvent event) {
        prikazi("muskarci|majice");
    }

    @FXML
    void muskePantalonePritisnut(ActionEvent event) {
        prikazi("muskarci|pantalone");
    }

    @FXML
    void muskePatikePritisnut(ActionEvent event) {
        prikazi("muskarci|patike");
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
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\Katalog.fxml"));
            Parent root = (Parent) loader.load();

            KatalogController pc = loader.getController();
            pc.dodajUPrikazKategorije(naziv);

            Main.scene.setRoot(root);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void prikazi(List<Proizvod> proizvodi){
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\Katalog.fxml"));
            Parent root = (Parent) loader.load();

            KatalogController pc = loader.getController();
            pc.prikaziIOsveziSidebar(proizvodi);

            Main.scene.setRoot(root);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
