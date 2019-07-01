package Controller;

import Model.Kupac;
import View.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.text.Font;

public class AdminKontroler {

    @FXML
    private Font x1;

    @FXML
    void dodajProdavnicu(ActionEvent event) {
    	try {
            Main.webshop.ulogovaniKorisnik = new Kupac();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\DodavanjeProdavnice.fxml"));
            Parent root = (Parent) loader.load();
            DodavanjeProdavniceController inc = loader.getController();
            Main.scene.setRoot(root);
        }
        catch (Exception e) { e.printStackTrace(); }
    }

    @FXML
    void izmeniProdavnicu(ActionEvent event) {

    }

    @FXML
    void logoutPritisnut(ActionEvent event) {
    	try {
            Main.webshop.ulogovaniKorisnik = new Kupac();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\glavni.fxml"));
            Parent root = (Parent) loader.load();
            MainController inc = loader.getController();
            Main.scene.setRoot(root);
        }
        catch (Exception e) { e.printStackTrace(); }
    }

    @FXML
    void izbrisiProdavnicu(ActionEvent event) {

    }
    
    @FXML
    void dodajMenadzera(ActionEvent event) {

    }

}
