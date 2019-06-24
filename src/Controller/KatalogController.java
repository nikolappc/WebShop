package Controller;

import Model.Kategorija;
import Model.Proizvod;
import View.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.*;


/** Ovo koristim da znam na koju smo sliku kliknuli*/
class ProizvodSlika{
    Proizvod proizvod;
    ImageView slika;

    public ProizvodSlika(Proizvod prz, ImageView sl){ proizvod = prz; slika = sl;}

}

public class KatalogController implements Initializable {

    @FXML
    private VBox vbox;

    @FXML
    private Label brojRezultata;

    @FXML
    private MenuButton boje,brendovi, velicine;

    private GridPane gp;

    private List<Proizvod> proizvodi;



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

        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\glavni.fxml"));
            Parent root = (Parent) loader.load();

            MainController pc = loader.getController();

            Main.scene.setRoot(root);

        }catch (Exception ex){ ex.printStackTrace();}

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



        //TODO DODATI EVENTOVE ZA SVE OVE DJAVOLE
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


    //ovde bi trebao da prima listu Proizvoda
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

                        FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\new.fxml"));
                        Parent root = (Parent) loader.load();

                        ProizvodController pc = loader.getController();


                        //for(Proizvod p :proizvodi){
                            //jako volim javu i strlen
                            //if(p.getSlike().get(1).substring(p.getSlike().get(0).length() - 8).equals(slika.getImage().impl_getUrl().substring(slika.getImage().impl_getUrl().length() -8)))
                              //  pc.postaviProizvod(p);
                        //}

                        pc.postaviProizvod(ps.proizvod);

                        Main.scene.setRoot(root);
                        Main.window.show();

                        //System.out.println(slika.getImage().impl_getUrl());
                    }
                    catch(Exception ex) {}

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
                    System.out.println("YYYEESS");
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


    public void izmenaNaloga() {
        // SAMO DA PROBAM

        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\izmenaNaloga.fxml"));
            Parent root = (Parent) loader.load();

            IzmenaNalogaController pc = loader.getController();

            Main.scene.setRoot(root);

        }catch (Exception ex){ ex.printStackTrace();}
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //gp.getChildren().clear();
        vbox.getChildren().removeAll(gp);
    }
}
