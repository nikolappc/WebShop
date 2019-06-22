package Controller;

import View.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

public class MainController  {

    public Button logo;


    public void pritisnutLogo(){
        /** Korisnik pritisnuo LOGO*/

        try{

            Parent root = FXMLLoader.load(getClass().getResource("..\\FXML\\new.fxml"));

            Main.scene.setRoot(root);

        }catch (Exception e){

        }
    }


    public void muskarciIzabran(){
        /** Korisnik pritisnuo drop down za muskarce*/
    }

    public void zeneIzabran(){
        /** Korisnik pritisnuo drop down za zene*/

    }

    public void popustIzabran(){
        /** Korisnik pritisnuo drop down za popuste*/

    }

    public void traziPritisnut(){
        /** Korisnik pritisnuo pretragu za proizvode */
    }

    public void nalogPritisnut(){
        /** Korisnik pritisnuo dugme za pregled svog naloga */
    }
    public void listaZeljaPritisnuta(){
        /** Korisnik pritisnuo dugme za pregled svoje liste zelja */
    }
    public void korpaPritisnuta(){
        /** Korisnik pritisnuo dugme za pregled svoje korpe*/
    }

}
