package Controller;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;

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


    /** Za sada pravi staticku korpu */
    public void dodaj(){

        vBox.setSpacing(20);
        for(int i =0 ; i < 5;i++){

            HBox hg = new HBox();
            hg.setPadding(new Insets(0,0,0,10));
            VBox v1= new VBox();
            v1.setPrefWidth(269);

            Label image = new Label("Stone Island Rgoue Trehscn");
            Label l2 = new Label("Boja : Crvena");
            Label l3 = new Label("Velicina XS");
            Label l4 = new Label("SIFRA XD");

            v1.getChildren().addAll(image,l2,l3,l4);

            HBox ukloni = new HBox();
            ukloni.setAlignment(Pos.CENTER);
            ukloni.setPrefWidth(135);
            Label l1 = new Label("DUGME");
            ukloni.getChildren().add(l1);



            HBox cena = new HBox();
            cena.setAlignment(Pos.CENTER);
            cena.setPrefWidth(125);
            Label labelace = new Label("76 000");
            cena.getChildren().add(labelace);

            HBox dodaj = new HBox();
            dodaj.setAlignment(Pos.CENTER);
            dodaj.setPrefWidth(194);
            Button dodajDugme = new Button("DODAJ U KORPU");
            dodaj.getChildren().add(dodajDugme);

            hg.getChildren().addAll(v1,ukloni,cena, dodaj);
            vBox.getChildren().addAll(hg);

        }

        HBox space = new HBox();
        space.setPrefHeight(15);

        VBox total = new VBox();
        total.setPadding(new Insets(0, 45, 0, 0));
        total.setSpacing(20);
        total.setAlignment(Pos.BOTTOM_RIGHT);

        Button b = new Button("DODAJ SVE U KORPU");
        total.getChildren().addAll(space,b);
        vBox.getChildren().add(total);



    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dodaj();
    }
}
