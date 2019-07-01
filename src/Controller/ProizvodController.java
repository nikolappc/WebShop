package Controller;

import Model.*;
import View.Main;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class ProizvodController implements Initializable {

    public ImageView trenutnaSlika;
    public ImageView slikaProizvoda1, slikaProizvoda2, slikaProizvoda3;
    @FXML
    public ImageView preporucenSlika1,preporucenSlika2,preporucenSlika3;

    public Proizvod trenutniProizvod;

    public List<Proizvod> preporuceniProizvodi;
    @FXML
    public Label opisProizvoda, cenaProizvoda, bojaProizvoda, nazivProizvoda;
    @FXML
    public ComboBox<String> moguceVelicine;

    @FXML
    public Button prethodna,sledeca, korpaDugme, listaDugme;

    @FXML
    private VBox vBox;


    /** Postavlja proizvod na scenu za prikaz izabranog*/
    public void postaviProizvod(Proizvod p){

        for (String putanja:p.getSlike()){
            System.out.println(putanja);
        }


        trenutniProizvod = p;
        Image image = new Image(p.getSlike().get(1));
        trenutnaSlika.setImage(image);
        slikaProizvoda1.setImage(image);

        Image image2 = new Image(p.getSlike().get(0));
        slikaProizvoda2.setImage(image2);

        Image image3 = new Image(p.getSlike().get(2));
        slikaProizvoda3.setImage(image3);
        cenaProizvoda.setText(p.dajCenu()+" €");
        opisProizvoda.setText(p.getOpis());
        bojaProizvoda.setText((String)p.getAtributi().get("Boja").getVrednost());

        List<String> velicine = p.getAtributi().get("Velicine").getVrednosti();

        for(String s : velicine){
            moguceVelicine.getItems().add(s);
        }

        if(p.getNaziv().length() <= 21){

            nazivProizvoda.setText(p.getNaziv());
        }
        else if(p.getNaziv().length() > 21 && p.getNaziv().length() < 30){
            nazivProizvoda.setFont(new Font("System", 24));
            nazivProizvoda.setText(p.getNaziv());
        }
        else{
            nazivProizvoda.setFont(new Font("System", 24));
            nazivProizvoda.setText(p.getNaziv());
        }

        //postavi preporucene proizvode
        preporuceniProizvodi = nadjiPreporucene(p);

        if(preporuceniProizvodi.isEmpty()){
            vBox.getChildren().remove(7,9);
        }

        if(preporuceniProizvodi.size() >0 ){
            preporucenSlika1.setImage(new Image(preporuceniProizvodi.get(0).getSlike().get(1)));
            preporucenSlika1.setOnMouseClicked(e-> prikaziPreporuceni(preporuceniProizvodi.get(0)));
        }

        if(preporuceniProizvodi.size() > 1){

            preporucenSlika2.setImage(new Image(preporuceniProizvodi.get(1).getSlike().get(1)));
            preporucenSlika2.setOnMouseClicked(e-> prikaziPreporuceni(preporuceniProizvodi.get(1)));
        }

        if(preporuceniProizvodi.size() > 2){

            preporucenSlika3.setImage(new Image(preporuceniProizvodi.get(2).getSlike().get(1)));
            preporucenSlika3.setOnMouseClicked(e-> prikaziPreporuceni(preporuceniProizvodi.get(2)));
        }

        if(!(Main.webshop.ulogovaniKorisnik instanceof Kupac)){
            listaDugme.setDisable(true);
            korpaDugme.setDisable(true);
        }
    }


    /** Prikazivanje preporucenog proizvoda*/
    public void prikaziPreporuceni(Proizvod proizvod){

        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\Proizvod.fxml"));
            Parent root = (Parent) loader.load();

            ProizvodController pc = loader.getController();
            pc.postaviProizvod(proizvod);

            Main.scene.setRoot(root);
            Main.window.show();
        }
        catch(Exception ex) {ex.printStackTrace();}
    }


    /** Korisnik pritisnuo kategoriju u putanji do proizvoda*/
    public void pritisnutaKategorija(){


    }


    /** Prva slika zauzima centralni deo*/
    public void izabranaSlika1(){

        String path = trenutnaSlika.getImage().impl_getUrl();
        Image img = new Image(path.substring(0,path.length()-5) + "2.jpg");
        trenutnaSlika.setImage(img);

    }


    /** Druga slika zauzima centralni deo*/
    public void izabranaSlika2(){

        String path = trenutnaSlika.getImage().impl_getUrl();
        Image img = new Image(path.substring(0,path.length()-5) + "1.jpg");
        trenutnaSlika.setImage(img);
    }


    /** Treca slika zauzima centralni deo*/
    public void izabranaSlika3(){


        String path = trenutnaSlika.getImage().impl_getUrl();
        Image img = new Image(path.substring(0,path.length()-5) + "3.jpg");
        trenutnaSlika.setImage(img);
    }


    /** Centralna slika se menja na prethodnu sliku proizvoda*/
    public void prethodnaSlika(){

        String path = trenutnaSlika.getImage().impl_getUrl();
        if( path.charAt(path.length()-5) == '1') {
            Image img2 = new Image(path.substring(0,path.length()-5) + "2.jpg");
            trenutnaSlika.setImage(img2);
        }
        else if(path.charAt(path.length()-5) == '2') {
            Image img2 = new Image(path.substring(0,path.length()-5) + "3.jpg");
            trenutnaSlika.setImage(img2);
        }
        else{
            Image img2 = new Image(path.substring(0,path.length()-5) + "1.jpg");
            trenutnaSlika.setImage(img2);
        }
    }


    /** Centralna slika se menja na sledecu sliku proizvoda*/
    public void sledecaSlika(){


        String path = trenutnaSlika.getImage().impl_getUrl();
        if( path.charAt(path.length()-5) == '1') {
            Image img2 = new Image(path.substring(0,path.length()-5) + "3.jpg");
            trenutnaSlika.setImage(img2);
        }
        else if(path.charAt(path.length()-5) == '2') {
            Image img2 = new Image(path.substring(0,path.length()-5) + "1.jpg");
            trenutnaSlika.setImage(img2);
        }
        else{
            Image img2 = new Image(path.substring(0,path.length()-5) + "2.jpg");
            trenutnaSlika.setImage(img2);
        }
    }


    public void sledecaHover(){
        sledeca.setStyle("-fx-border-color: #ffa500; -fx-background-color: #ffa500; -fx-padding: 0 ");
    }

    public void sledecaUnhover(){
        sledeca.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; -fx-padding: 0 ");
    }

    public void prethodnaHover(){
        prethodna.setStyle("-fx-border-color: #ffa500; -fx-background-color: #ffa500; -fx-padding: 0");
    }

    public void prethodnaUnhover(){
        prethodna.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; -fx-padding: 0");
    }


    public void izabranaVelicina(){
        moguceVelicine.setStyle("");
    }


    /** Dodavanje proizvoda u korpu*/
    public void dodatoUKorpu(){

        if(moguceVelicine.getSelectionModel().isEmpty()){
            moguceVelicine.setStyle("-fx-border-color: red;-fx-border-width: 2;");
            moguceVelicine.setPromptText("Morate izabrati velicinu");
            return;
        }

        StavkaNarudzbine stavka = new StavkaNarudzbine(1,trenutniProizvod.dajCenu(),trenutniProizvod, moguceVelicine.getValue());
        ((Kupac) Main.webshop.ulogovaniKorisnik).getKorpa().dodajProizvod(stavka);
    }


    /** Dodavanje proizvoda u listu zelja */
    public void dodatoUListuZelja(){

        if(moguceVelicine.getSelectionModel().isEmpty()){
            moguceVelicine.setStyle("-fx-border-color: red;-fx-border-width: 2;");
            moguceVelicine.setPromptText("Morate izabrati velicinu");
            return;
        }

        StavkaNarudzbine stavka = new StavkaNarudzbine(1,trenutniProizvod.dajCenu(),trenutniProizvod, moguceVelicine.getValue());
        ((Kupac) Main.webshop.ulogovaniKorisnik).getListaZelja().dodajProizvod(stavka);
    }
    

    /** vraca tri slicna proizvoda za dati proizvod*/
    public ArrayList<Proizvod> nadjiPreporucene(Proizvod p) {

        ArrayList<Proizvod> listaP = new ArrayList<Proizvod>();
        ArrayList<Proizvod> retVal = new ArrayList<Proizvod>();

        for(Proizvod proizvod : Main.webshop.getProizvodi()){
            if(proizvod.getAtributVrednost("Brend").equals(p.getAtributVrednost("Brend")) && !p.getSifra().equals(proizvod.getSifra())){
                listaP.add(proizvod);
            }
        }

        Random rand = new Random();

        for(int i =0; i < 3 && listaP.size() > 0; i++){
            int randomIndex = rand.nextInt(listaP.size());
            retVal.add(listaP.get(randomIndex));
            listaP.remove(randomIndex);
        }
        return retVal;
    }
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

}
