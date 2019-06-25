package Controller;

import Model.Kategorija;
import Model.Proizvod;
import View.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.*;


/**
 *  Ovo koristim da znam na koju smo sliku kliknuli
 */
class ProizvodSlika{
    Proizvod proizvod;
    ImageView slika;

    public ProizvodSlika(Proizvod prz, ImageView sl){ proizvod = prz; slika = sl;}

}

public class KatalogController implements Initializable {

    @FXML
    private VBox vbox;

    @FXML
    public Label brojRezultata;

    @FXML
    private MenuButton boje,brendovi, velicine;

    @FXML
    private HeaderController someIdController;

    @FXML
    public Label kategorijaLabela;

    private GridPane gp;

    private List<Proizvod> proizvodi;



    /** Vrsi se pretraga po svim kriterijumima koje je korisnik izabrao i na kraju se rezultati pretraga spajaju i prikazuju*/
    public void izvrsiPretragu(){



    }


    /** Dodaje broj pronadjenih proizvoda, sve boje, brendove i velicine*/
    public void sideBarOpcije(){

        brojRezultata.setText(proizvodi.size()+"");

        Set<String> setBoja = new TreeSet<String>();
        Set<String> setBrendova = new TreeSet<String>();
        Set<String> setVelicina = new TreeSet<String>();


        for(Proizvod p : proizvodi){
            setBoja.add((String)p.getAtributi().get("Boja").getVrednost());

            String[] vel = ((String) p.getAtributi().get("Velicine").getVrednost()).trim().split(" ");
            for(String poj : vel)
                setVelicina.add(poj);

            setBrendova.add((String)p.getAtributi().get("Brend").getVrednost());
        }



        // TODO: DODATI EVENTOVE ZA SVE OVE DJAVOLE
        for(String s: setBoja){
            CustomMenuItem mitem = new CustomMenuItem();
            CheckBox cb = new CheckBox(s);
            mitem.setContent(cb);
            boje.getItems().add(mitem);
        }

        for(String s: setBrendova){
            CustomMenuItem mitem = new CustomMenuItem();
            CheckBox cb = new CheckBox(s);
            mitem.setContent(cb);
            brendovi.getItems().add(mitem);
        }

        for(String s: setVelicina){
            CustomMenuItem mitem = new CustomMenuItem();
            CheckBox cb = new CheckBox(s);
            mitem.setContent(cb);
            velicine.getItems().add(mitem);
        }


    }


    /** Prikazuje datu listu proizvoda kao Katalog */
    public void prikazi(List<Proizvod> lista){

        proizvodi = lista;
        sideBarOpcije();

        gp = new GridPane();
        gp.setVgap(30);
        gp.setHgap(20);

        int index = -1;
        for(int i = 0; i < 30; i++){
            for(int j = 0; j < 3; j++){

                index++;
                if (index >= proizvodi.size()) {
                    break;
                }

                VBox layout = new VBox();
                layout.setSpacing(5);

                layout.prefWidth(266);
                layout.prefHeight(323);

                ImageView slika = new ImageView(Main.mojaPutanja+proizvodi.get(index).getSlike().get(1));

                ProizvodSlika ps = new ProizvodSlika(proizvodi.get(index), slika);

                ps.slika.setOnMouseClicked(e->
                {
                    try{

                        FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\Proizvod.fxml"));
                        Parent root = (Parent) loader.load();

                        ProizvodController pc = loader.getController();
                        pc.postaviProizvod(ps.proizvod);

                        Main.scene.setRoot(root);
                        Main.window.show();
                    }
                    catch(Exception ex) {ex.printStackTrace();}

                });
                slika.setFitHeight(276);
                slika.setFitWidth(240);
                slika.setCursor(Cursor.HAND);
                layout.getChildren().add(slika);


                HBox hb1 = new HBox();
                hb1.setAlignment(Pos.CENTER);
                Label labela = new Label(proizvodi.get(index).getNaziv());
                //font size
                hb1.getChildren().add(labela);
                layout.getChildren().add(hb1);

                HBox hb2 = new HBox();
                hb2.setAlignment(Pos.CENTER);
                Label labela2 = new Label(proizvodi.get(index).dajCenu());
                //font size
                hb2.getChildren().add(labela2);
                layout.getChildren().add(hb2);

                gp.add(layout,j,i);
            }
        }
        vbox.getChildren().add(gp);
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

        //gp.getChildren().clear();
        vbox.getChildren().removeAll(gp);
    }
}
