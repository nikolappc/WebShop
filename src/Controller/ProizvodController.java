package Controller;

import Model.Kategorija;
import Model.Proizvod;
import Model.StavkaCenovnika;
import View.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ProizvodController implements Initializable {

    public ImageView trenutnaSlika;
    public ImageView slikaProizvoda1, slikaProizvoda2, slikaProizvoda3;

    public ImageView preporucenSlika1,preporucenSlika2,preporucenSlika3;

    public Label opisProizvoda, cenaProizvoda, bojaProizvoda, nazivProizvoda;

    public ComboBox<String> moguceVelicine;

    public Button logo;

    @FXML
    private LogoController someIdController;


    public void postaviSliku(String url){

        Image image = new Image(url);
        trenutnaSlika.setImage(image);

        slikaProizvoda1.setImage(image);

        Image img2 = new Image(url.substring(0,url.length()-5) + "1.jpg");
        slikaProizvoda2.setImage(img2);

        Image img3 = new Image(url.substring(0,url.length()-5) + "3.jpg");
        slikaProizvoda3.setImage(img3);
    }

    /** Postavlja proizvod na scenu za prikaz izabranog*/
    public void postaviProizvod(Proizvod p){


        Image image = new Image(Main.mojaPutanja+p.getSlike().get(1));
        trenutnaSlika.setImage(image);
        slikaProizvoda1.setImage(image);

        Image image2 = new Image(Main.mojaPutanja+p.getSlike().get(0));
        slikaProizvoda2.setImage(image2);

        Image image3 = new Image(Main.mojaPutanja+p.getSlike().get(2));
        slikaProizvoda3.setImage(image3);

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

    }


    public void pritisnutaKategorija(){
        /** Korisnik pritisnuo kategoriju u putanji do proizvoda*/


    }

    public void izabranaSlika1(){
        /** Korisnik izabrao prvu sliku proizvoda koja sad treba da zauzme centralni deo prozora*/
        String path = trenutnaSlika.getImage().impl_getUrl();
        Image img = new Image(path.substring(0,path.length()-5) + "2.jpg");
        trenutnaSlika.setImage(img);

    }

    public void izabranaSlika2(){
        /** Korisnik izabrao drugu sliku proizvoda koja sad treba da zauzme centralni deo prozora*/
        String path = trenutnaSlika.getImage().impl_getUrl();
        Image img = new Image(path.substring(0,path.length()-5) + "1.jpg");
        trenutnaSlika.setImage(img);
    }

    public void izabranaSlika3(){
        /** Korisnik izabrao trecu sliku proizvoda koja sad treba da zauzme centralni deo prozora*/

        String path = trenutnaSlika.getImage().impl_getUrl();
        Image img = new Image(path.substring(0,path.length()-5) + "3.jpg");
        trenutnaSlika.setImage(img);
    }


    public void prethodnaSlika(){
        /** Korisnik izabrao prethodnu sliku proizvoda koja sad treba da zauzme centralni deo prozora*/

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

    public void sledecaSlika(){
        /** Korisnik izabrao sledecu sliku proizvoda koja sad treba da zauzme centralni deo prozora*/

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

    public void dodatoUKorpu(){
        /** Korisnik dodao proizvod u korpu*/



    }

    public void dodatoUListuZelja(){
        /** Korisnik dodao proizvod u list uzelja */

    }

    public void izabranPreporucen1(){
        /** Korisnik zeli da vidi prvi preporuceni proizvod */

    }

    public void izabranPreporucen2(){
        /** Korisnik zeli da vidi drugi preporuceni proizvod */

    }

    public void izabranPreporucen3(){
        /** Korisnik zeli da vidi treci preporuceni proizvod */

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        opisProizvoda.setText("This classic black parka from Italian brand Stone Island pays heed to the label’s ethos of technologically advanced design and simple cuts with a militaristic twist");

    }

}
