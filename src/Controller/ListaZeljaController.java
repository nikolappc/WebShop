package Controller;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;

import Model.Kupac;
import Model.Proizvod;
import Model.StavkaNarudzbine;
import View.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ListaZeljaController implements Initializable {

    @FXML
    private VBox vBox;

    @FXML
    private Label listaZeljaLabela;

    public void prikazi(){

        vBox.setSpacing(20);
        Kupac kupac = (Kupac) Main.webshop.ulogovaniKorisnik;
        for(Proizvod proizvod :  kupac.getListaZelja().getProizvod()){

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\ElementListeZelja.fxml"));
                HBox hb = (HBox) loader.load();
                ElementListeZeljaController ekc= loader.getController();
                ekc.postavi(proizvod);

                vBox.getChildren().add(hb);

            }catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if(((Kupac) Main.webshop.ulogovaniKorisnik).getListaZelja().getProizvod().size() > 0)
            prikazi();
        else{
            vBox.getChildren().remove(1);
            listaZeljaLabela.setText("NEMA NISTA JEBO TE DAN");
        }
    }
}
