package Controller;

import Model.Kategorija;
import Model.Proizvod;
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

    /*
    public void pritisnutLogo() {


        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\glavni.fxml"));
            Parent root = (Parent) loader.load();

            MainController pc = loader.getController();

            Main.scene.setRoot(root);

        }catch (Exception ex){ ex.printStackTrace();}
    }



    public void traziPritisnut() {


        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\Katalog.fxml"));
            Parent root = (Parent) loader.load();

            KatalogController pc = loader.getController();
            //pc.prikaziSve();
            Main.scene.setRoot(root);
        }catch (Exception ex){ex.printStackTrace();}
    }

    public void nalogPritisnut() {

        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\Prijava.fxml"));
            Parent root = (Parent) loader.load();

            PrijavaController pc = loader.getController();

            Main.scene.setRoot(root);

        }catch (Exception ex){ ex.printStackTrace();}
    }

    public void listaZeljaPritisnuta() {

    	
    }

    public void korpaPritisnuta() {


    	try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\Korpa.fxml"));
            Parent root = (Parent) loader.load();

            KorpaController pc = loader.getController();

            Main.scene.setRoot(root);

        }catch (Exception ex){ ex.printStackTrace();}
    }

    */

    public void izmenaNaloga() {
        // SAMO DA PROBAM

        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\izmenaNaloga.fxml"));
            Parent root = (Parent) loader.load();

            IzmenaNalogaController pc = loader.getController();

            Main.scene.setRoot(root);

        }catch (Exception ex){ ex.printStackTrace();}
    }


    public void glavnaSlikaPritisnuta() {

    }

    public void levaSlikaPritisnuta() {

    }

    public void desnaSlikaPritisnuta() {


    }


    @FXML
    void muskeJaknePritisnut(ActionEvent event) {

        prikazi("muskarci|jakne");
    }

    @FXML
    void muskeDuksericePritisnut(ActionEvent event) {
        prikazi("muskarci|duksevi");
    }

    @FXML
    void muskeMajicePritisnut(ActionEvent event){
        prikazi("muskarci|majice");
    }

    @FXML
    void muskePantalonePritisnut(ActionEvent event) {
        prikazi("muskarci|pantalone");
    }

    @FXML
    void muskePatikePritisnut(ActionEvent event) {
        prikazi("muskarci|patike");
    }

    private void prikazi(String naziv){


        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\Katalog.fxml"));
            Parent root = (Parent) loader.load();

            KatalogController pc = loader.getController();
            pc.dodajUPrikaz(naziv);

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
