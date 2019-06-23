package Controller;

import View.Main;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Random;

public class KatalogController {

    public VBox vbox;

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

    public class Nesto{

        ImageView slika;
        String ime;

        Nesto(ImageView slika, String ime){
            slika = slika; ime = ime;
        }
    }

    public void pritisnutLogo(){



        GridPane gp = new GridPane();
        gp.setVgap(30);
        gp.setHgap(20);

        int n = 1;
        for(int i = 0; i < 30; i++){
            for(int j = 0; j < 3; j++){
                //Label cena = new Label("13 990 RSD");

                VBox layout = new VBox();
                layout.setSpacing(5);

                layout.prefWidth(266);
                layout.prefHeight(323);

                Random rand = new Random();

                //int n = rand.nextInt(50) + 1;
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
}