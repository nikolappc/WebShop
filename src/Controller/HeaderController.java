package Controller;

import Model.Kategorija;
import Model.Proizvod;
import View.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HeaderController implements Initializable {

    @FXML
    private Button lupa;

    @FXML
    private Button logo;



    public void pritisnutLogo() {
        /** Korisnik pritisnuo LOGO*/

        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\glavni.fxml"));
            Parent root = (Parent) loader.load();

            MainController pc = loader.getController();

            Main.scene.setRoot(root);

        }catch (Exception ex){ ex.printStackTrace();}
    }


    public void traziPritisnut() {
        /** Korisnik pritisnuo pretragu za proizvode */

        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\Katalog.fxml"));
            Parent root = (Parent) loader.load();

            KatalogController pc = loader.getController();
            //pc.prikaziSve();

            Main.scene.setRoot(root);
        }catch (Exception ex){ex.printStackTrace();}
    }

    public void nalogPritisnut() {
        /** Korisnik pritisnuo dugme za pregled svog naloga */

        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\Prijava.fxml"));
            Parent root = (Parent) loader.load();

            PrijavaController pc = loader.getController();

            Main.scene.setRoot(root);

        }catch (Exception ex){ ex.printStackTrace();}
    }

    public void listaZeljaPritisnuta() {
        /** Korisnik pritisnuo dugme za pregled svoje liste zelja */

    }


    public void izmenaNaloga() {
        // SAMO DA PROBAM

        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\izmenaNaloga.fxml"));
            Parent root = (Parent) loader.load();

            IzmenaNalogaController pc = loader.getController();

            Main.scene.setRoot(root);

        }catch (Exception ex){ ex.printStackTrace();}
    }

    public void korpaPritisnuta() {
        /** Korisnik pritisnuo dugme za pregled svoje korpe*/

        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\Korpa.fxml"));
            Parent root = (Parent) loader.load();

            KorpaController pc = loader.getController();

            Main.scene.setRoot(root);

        }catch (Exception ex){ ex.printStackTrace();}
    }

    @FXML
    void muskeJaknePritisnut(ActionEvent event) {

        prikazi("jakne");
    }

    @FXML
    void muskeDuksericePritisnut(ActionEvent event) {
        prikazi("duksevi");
    }

    @FXML
    void muskeMajicePritisnut(ActionEvent event){
        prikazi("majice");
    }

    @FXML
    void muskePantalonePritisnut(ActionEvent event) {
        prikazi("pantalone");
    }

    @FXML
    void muskePatikePritisnut(ActionEvent event) {
        prikazi("patike");
    }

    private void prikazi(String naziv){

        List<Proizvod> proizvodi = new ArrayList<Proizvod>();

        for(Kategorija k1: Main.webshop.getKategorije()){

            for(Kategorija k2 : k1.getPodKategorija()){
                if(k2.getNaziv().equals(naziv)){
                    proizvodi = k2.getProizvodi();
                }
            }

        }

        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\Katalog.fxml"));
            Parent root = (Parent) loader.load();

            KatalogController pc = loader.getController();
            pc.prikazi(proizvodi);

            Main.scene.setRoot(root);
        }catch (Exception ex){ ex.printStackTrace();}

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
