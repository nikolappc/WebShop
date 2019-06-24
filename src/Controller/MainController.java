package Controller;

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

    public void pritisnutLogo() {
        /** Korisnik pritisnuo LOGO*/

        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\glavni.fxml"));
            Parent root = (Parent) loader.load();

            MainController pc = loader.getController();

            Main.scene.setRoot(root);

        }catch (Exception ex){ ex.printStackTrace();}
    }


    public void traziPritisnut() {
        /** Korisnik pritisnuo pretragu za proizvode */

        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\Katalog.fxml"));
            Parent root = (Parent) loader.load();

            KatalogController pc = loader.getController();
            pc.prikaziSve();

            Main.scene.setRoot(root);
        }catch (Exception ex){}
    }

    public void nalogPritisnut() {
        /** Korisnik pritisnuo dugme za pregled svog naloga */

        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\Prijava.fxml"));
            Parent root = (Parent) loader.load();

            PrijavaController pc = loader.getController();

            Main.scene.setRoot(root);

        }catch (Exception ex){ ex.printStackTrace();}
    }

    public void listaZeljaPritisnuta() {
        /** Korisnik pritisnuo dugme za pregled svoje liste zelja */
    	
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

    
    public void korpaPritisnuta() {
        /** Korisnik pritisnuo dugme za pregled svoje korpe*/
    	
    	try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\Korpa.fxml"));
            Parent root = (Parent) loader.load();

            KorpaController pc = loader.getController();

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
        System.out.println("JAK");
    }

    @FXML
    void muskeDuksericePritisnut(ActionEvent event) {

    }

    @FXML
    void muskePantalonePritisnut(ActionEvent event) {

    }

    @FXML
    void muskePatikePritisnut(ActionEvent event) {

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
