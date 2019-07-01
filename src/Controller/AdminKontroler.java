package Controller;

import Model.Kupac;
import View.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.text.Font;

public class AdminKontroler {
    
    /**
     * Funkcija za dodavanje prodavnica
     */
    @FXML
    void dodajProdavnicu(ActionEvent event) {
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\DodavanjeProdavnice.fxml"));
            Parent root = (Parent) loader.load();
            DodavanjeProdavniceController inc = loader.getController();
            Main.scene.setRoot(root);
        }
        catch (Exception e) { e.printStackTrace(); }
    }

    /**
     * Funkcija za pregled prodavnica
     */
    @FXML
    void izmeniProdavnicu(ActionEvent event) {
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\prodavnice.fxml"));
            Parent root = (Parent) loader.load();
            Main.scene.setRoot(root);
        }
        catch (Exception e) { e.printStackTrace(); }
    }

    
    /**
     * funkcija za odjavu
     */
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
    
    
    /**
     * Funkcija za dodavanje menadzera
     */
    @FXML
    void dodajMenadzera(ActionEvent event) {
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\Reg.fxml"));
            Parent root = (Parent) loader.load();
            Main.scene.setRoot(root);
        }
        catch (Exception e) { e.printStackTrace(); }
    }

}
