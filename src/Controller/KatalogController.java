package Controller;

import View.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class KatalogController implements Initializable {

    @FXML
    private VBox vbox;

    private GridPane gp;

    ArrayList<String> brendovi; //da prikaze sve brendove

    int brojRedova = 3; // na pocetku je 3, ali se moze menjati kasnije



    public void izvrsiPretragu(){
        /** Vrsi se pretraga po svim kriterijumima koje je korisnik izabrao i na kraju se rezultati pretraga spajaju i prikazuju*/


    }


    public void traziPritisnut(){


    }

    public void nalogPritisnut(){


    }

    public void listaZeljaPritisnuta(){


    }


    public void korpaPritisnuta(){


    }


    public void pritisnutLogo(){


        gp = new GridPane();
        gp.setVgap(30);
        gp.setHgap(20);

        int n = 1;
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 3; j++){

                VBox layout = new VBox();
                layout.setSpacing(5);

                layout.prefWidth(266);
                layout.prefHeight(323);

                Random rand = new Random();

                String s = n+"";
                if (n<10)
                    s = "0"+n;
                if(n>77)
                    break;
                ImageView slika = new ImageView("file:/C:/Users/Stefan/Desktop/WebShop/Proizvodi/Slike/0"+s+"-2.jpg");
                n++;
                // NE RADI   slika.fitWidthProperty().bind(View.Main.window.widthProperty());

                slika.setOnMouseClicked(e->
                {
                    try{

                        FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\new.fxml"));
                        Parent root = (Parent) loader.load();

                        ProizvodController pc = loader.getController();
                        pc.postaviSliku(slika.getImage().impl_getUrl());

                        Main.scene.setRoot(root);
                        Main.window.show();

                        System.out.println(slika.getImage().impl_getUrl());
                    }
                    catch(Exception ex) {}

                });
                slika.setFitHeight(276);
                slika.setFitWidth(240);
                slika.setCursor(Cursor.HAND);
                layout.getChildren().add(slika);

                /*
                BorderPane pejn = new BorderPane();
                pejn.setCenter(slika);


                slika.fitWidthProperty().bind(pejn.widthProperty());
                slika.fitHeightProperty().bind(pejn.heightProperty());
                layout.getChildren().add(pejn);
                */

                HBox hb1 = new HBox();
                hb1.setAlignment(Pos.CENTER);
                Label labela = new Label("Ovde ce pisati neki malo poduzi tekst");
                //font size
                hb1.getChildren().add(labela);
                layout.getChildren().add(hb1);

                HBox hb2 = new HBox();
                hb2.setAlignment(Pos.CENTER);
                Label labela2 = new Label("13 990 RSD");
                //font size
                hb2.getChildren().add(labela2);
                layout.getChildren().add(hb2);

                //cena.setPrefSize(100,100);
                gp.add(layout,j,i);
            }
        }


        vbox.getChildren().add(gp);


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //gp.getChildren().clear();
        vbox.getChildren().removeAll(gp);
    }
}
