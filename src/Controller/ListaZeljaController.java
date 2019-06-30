package Controller;


import java.net.URL;
import java.util.ResourceBundle;
import Model.Kupac;
import Model.StavkaNarudzbine;
import View.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ListaZeljaController implements Initializable {

    @FXML
    private VBox vBox;

    @FXML
    private Label listaZeljaLabela;


    /** prikaz svih stavki u listi zelja */
    public void prikazi(){

        vBox.setSpacing(20);
        Kupac kupac = (Kupac) Main.webshop.ulogovaniKorisnik;
        for(StavkaNarudzbine stavka :  kupac.getListaZelja().getProizvod()){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\ElementListeZelja.fxml"));
                HBox hb = (HBox) loader.load();
                ElementListeZeljaController ekc= loader.getController();
                ekc.postavi(stavka);

                vBox.getChildren().add(hb);
            }catch (Exception e) { e.printStackTrace(); }
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if(((Kupac) Main.webshop.ulogovaniKorisnik).getListaZelja().getProizvod().size() > 0)
            prikazi();
        else{
            vBox.getChildren().remove(1);
            listaZeljaLabela.setText("Lista zelja je trenutno prazna");
        }
    }
}
