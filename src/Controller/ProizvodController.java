package Controller;

import Model.Kategorija;
import Model.Proizvod;
import View.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class ProizvodController implements Initializable {

    public ImageView trenutnaSlika;
    public ImageView slikaProizvoda1, slikaProizvoda2, slikaProizvoda3;

    public ImageView preporucenSlika1,preporucenSlika2,preporucenSlika3;

    public List<Proizvod> preporuceniProizvodi;

    public Label opisProizvoda, cenaProizvoda, bojaProizvoda, nazivProizvoda;

    public ComboBox<String> moguceVelicine;

    public Button logo;

    @FXML
    private HeaderController someIdController;



    /** Postavlja proizvod na scenu za prikaz izabranog*/
    public void postaviProizvod(Proizvod p){


        Image image = new Image(Main.mojaPutanja+p.getSlike().get(1));
        trenutnaSlika.setImage(image);
        slikaProizvoda1.setImage(image);

        Image image2 = new Image(Main.mojaPutanja+p.getSlike().get(0));
        slikaProizvoda2.setImage(image2);

        Image image3 = new Image(Main.mojaPutanja+p.getSlike().get(2));
        slikaProizvoda3.setImage(image3);

        cenaProizvoda.setText(p.dajCenu());

        opisProizvoda.setText(p.getOpis());

        bojaProizvoda.setText((String)p.getAtributi().get("Boja").getVrednost());

        String[] velicine = ((String)p.getAtributi().get("Velicine").getVrednost()).trim().split(" ");


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


        preporuceniProizvodi = nadjiPreporucene(p);

        if(preporuceniProizvodi.size() >0 ){
            preporucenSlika1.setImage(new Image(Main.mojaPutanja + preporuceniProizvodi.get(0).getSlike().get(1)));
            preporucenSlika1.setOnMouseClicked(e-> prikaziPreporuceni(preporuceniProizvodi.get(0)));
        }

        if(preporuceniProizvodi.size() > 1){

            preporucenSlika2.setImage(new Image(Main.mojaPutanja +preporuceniProizvodi.get(1).getSlike().get(1)));
            preporucenSlika2.setOnMouseClicked(e-> prikaziPreporuceni(preporuceniProizvodi.get(1)));
        }

        if(preporuceniProizvodi.size() > 2){

            preporucenSlika3.setImage(new Image(Main.mojaPutanja +preporuceniProizvodi.get(2).getSlike().get(1)));
            preporucenSlika3.setOnMouseClicked(e-> prikaziPreporuceni(preporuceniProizvodi.get(2)));
        }

    }


    /** Kada se klikne na preporuceni otvara se novi prozor*/
    public void prikaziPreporuceni(Proizvod proizvod){

        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\Proizvod.fxml"));
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


    /** Korisnik izabrao prvu sliku proizvoda koja sad treba da zauzme centralni deo prozora*/
    public void izabranaSlika1(){

        String path = trenutnaSlika.getImage().impl_getUrl();
        Image img = new Image(path.substring(0,path.length()-5) + "2.jpg");
        trenutnaSlika.setImage(img);

    }


    /** Korisnik izabrao drugu sliku proizvoda koja sad treba da zauzme centralni deo prozora*/
    public void izabranaSlika2(){

        String path = trenutnaSlika.getImage().impl_getUrl();
        Image img = new Image(path.substring(0,path.length()-5) + "1.jpg");
        trenutnaSlika.setImage(img);
    }


    /** Korisnik izabrao trecu sliku proizvoda koja sad treba da zauzme centralni deo prozora*/
    public void izabranaSlika3(){


        String path = trenutnaSlika.getImage().impl_getUrl();
        Image img = new Image(path.substring(0,path.length()-5) + "3.jpg");
        trenutnaSlika.setImage(img);
    }


    /** Korisnik izabrao prethodnu sliku proizvoda koja sad treba da zauzme centralni deo prozora*/
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


    /** Korisnik izabrao sledecu sliku proizvoda koja sad treba da zauzme centralni deo prozora*/
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


    /** Korisnik dodao proizvod u korpu*/
    public void dodatoUKorpu(){


    }


    /** Korisnik dodao proizvod u list uzelja */
    public void dodatoUListuZelja(){


    }
    
    

    /** vraca tri slicna proizvoda za dati proizvod*/
    public ArrayList<Proizvod> nadjiPreporucene(Proizvod p) {

        ArrayList<Proizvod> listaP = new ArrayList<Proizvod>();
        ArrayList<Proizvod> retVal = new ArrayList<Proizvod>();

        for(Proizvod proizvod : Main.webshop.getProizvodi()){
            if(proizvod.getAtribut("Brend").equals(p.getAtribut("Brend")) && !p.getSifra().equals(proizvod.getSifra())){
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
