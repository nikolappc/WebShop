package Controller;

import Model.Kategorija;
import Model.Proizvod;
import Model.Webshop;
import View.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements  Initializable{

    @FXML
    private Button logo;

    @FXML
    private SplitPane splitPane1, splitPane2;

    @FXML
    private ImageView glavnaSlika, doleLevoSlika, doleDesnoSlika;

    @FXML
    private Pane glavniPane, leviPane, desniPane;

    @FXML
    private HeaderController someIdController;




    @Override
    public void initialize(URL location, ResourceBundle resources) {


        SplitPane.Divider divider = splitPane1.getDividers().get(0);
        divider.positionProperty().addListener(new ChangeListener<Number>()
        {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldvalue, Number newvalue )
            {
                divider.setPosition(0.6);
            }
        });

        SplitPane.Divider divider2 = splitPane2.getDividers().get(0);
        divider2.positionProperty().addListener(new ChangeListener<Number>()
        {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldvalue, Number newvalue )
            {
                divider2.setPosition(0.5);
            }
        });

        glavnaSlika.fitWidthProperty().bind(glavniPane.widthProperty());
        glavnaSlika.fitHeightProperty().bind(glavniPane.heightProperty());

        doleLevoSlika.fitWidthProperty().bind(leviPane.widthProperty());
        doleLevoSlika.fitHeightProperty().bind(leviPane.heightProperty());

        doleDesnoSlika.fitWidthProperty().bind(desniPane.widthProperty());
        doleDesnoSlika.fitHeightProperty().bind(desniPane.heightProperty());

    }

    public void glavnaSlikaPritisnuta() {
        prikaziProizvodeZaBrend("palm angels");
    }

    public void levaSlikaPritisnuta() {
        prikaziProizvodeZaBrend("saint laurent");
    }

    public void desnaSlikaPritisnuta() {
        prikaziProizvodeZaBrend("stone island");
    }

    /**
     * Pomocna metoda koja prikazuje proizvode za dati brend
     * @param brend
     */
    private void prikaziProizvodeZaBrend(String brend){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\Katalog.fxml"));
            Parent root = (Parent) loader.load();

            KatalogController pc = loader.getController();

            // uradi pretragu
            List<Proizvod> rezultat =
                    Main.webshop.pretraga.pretragaProizvodBrend(Main.webshop.proizvodi, brend);

            if (rezultat.size() == 0) {
                pc.brojRezultata.setText("0");
                pc.kategorijaLabela.setText("Nema rezultata za unesenu vredonst");
            }else {
                pc.prikazi(rezultat);
            }

            Main.scene.setRoot(root);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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

    /**
     * Prikazuje proizvode za izabranu kategoriju iz dropdown
     * menija
     * @param naziv naziv kategorije
     */
    private void prikazi(String naziv){
        List<Proizvod> proizvodi =
                Webshop.pretraga.pretragaProzvodaKategorija(Main.webshop.kategorije, naziv);
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\Katalog.fxml"));
            Parent root = (Parent) loader.load();

            KatalogController pc = loader.getController();
            pc.prikazi(proizvodi);

            Main.scene.setRoot(root);
        }catch (Exception ex){ ex.printStackTrace();}

    }


    public static Image loadImageFrom(String directory) {
        FileInputStream inputstream = null;
        try {
            inputstream = new FileInputStream(directory);
            return new Image(inputstream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
