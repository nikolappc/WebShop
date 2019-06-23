package Controller;

import View.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;

import javax.xml.soap.Text;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class PrijavaController implements Initializable {


    // za registraciju
    @FXML
    private TextField imeReg;
    @FXML
    private TextField prezimeReg;
    @FXML
    private TextField emailReg;
    @FXML
    private TextField korisnickoReg;
    @FXML
    private TextField lozinkaReg;
    @FXML
    private TextField pLoznikaReg;
    @FXML
    private TextField adresaReg;
    @FXML
    private TextField brTelefonaReg;
    @FXML
    private ComboBox<String> polComboBox;
    @FXML
    private Label porukaReg;


    // za prijavu
    @FXML
    private TextField korisnickoPrijava;
    @FXML
    private TextField lozinkaPrijava;
    @FXML
    private Label porukaPrijava;


    @FXML
    private SplitPane splitPane;





    @Override
    public void initialize(URL location, ResourceBundle resources) {

        SplitPane.Divider divider = splitPane.getDividers().get(0);
        divider.positionProperty().addListener(new ChangeListener<Number>()
        {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldvalue, Number newvalue )
            {
                divider.setPosition(0.5);
            }
        });

        polComboBox.getItems().clear();
        polComboBox.getItems().addAll("Muski","Zenski");

    }

    @FXML
    void stistuoPrijava(ActionEvent event) {
        ArrayList<TextField> polja = new ArrayList(
                Arrays.asList(korisnickoPrijava, lozinkaPrijava));
        porukaPrijava.setText("");

        resetujBojePolja(polja);
        proveraPraznine(polja);
        oznaciPolja(polja);
        // ovo znaci da nije uneo sva polja
        if(polja.size() > 0){
            return;
        }


        // ove uradi pretragu korisnika
        if(/* pretraga korisnika je uspela*/ false){

        } else {
            porukaPrijava.setText("Pogresno korisnicko ili lozinka");
        }
    }

    @FXML
    void stisnuoZabroavljenaSifra(ActionEvent event) {

    }

    @FXML
    void stisnuoRegistracija(ActionEvent event) {
        ArrayList<TextField> polja = new ArrayList(
                Arrays.asList(imeReg, prezimeReg, emailReg, korisnickoReg,
                              pLoznikaReg, lozinkaReg, adresaReg, brTelefonaReg));
        porukaReg.setText("");
        resetujBojePolja(polja);
        proveraPraznine(polja);
        oznaciPolja(polja);

        if(polja.size() > 0){
            return;
        }

        // proveri jedinstvenost korisnickog

        // poredi loznike
        if(!lozinkaReg.getText().equals(pLoznikaReg.getText())){
            porukaReg.setText(String.format("%s %s", porukaReg.getText(), "Lozinke se ne poklapaju"));
            lozinkaReg.setStyle("-fx-text-box-border: red;");
            pLoznikaReg.setStyle("-fx-text-box-border: red;");
        }

        //proveri broj telefona
        if(!brTelefonaReg.getText().matches("^[+]*[0-9]$")){
            porukaReg.setText(String.format("%s %s", porukaReg.getText(), "Pogresan br tel."));
            brTelefonaReg.setStyle("-fx-text-box-border: red;");
        }

        // proveri da li je izabro pol
        if(polComboBox.getValue()==null){
            porukaReg.setText(String.format("%s %s", porukaReg.getText(), "Izaberite pol."));
        }
    }

    @FXML
    void traziPritisnut(ActionEvent event) {

    }

    @FXML
    void pritisnutLogo(ActionEvent event) {

        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\glavni.fxml"));
            Parent root = (Parent) loader.load();

            MainController pc = loader.getController();

            Main.scene.setRoot(root);

        }catch (Exception ex){ ex.printStackTrace();}

    }

    @FXML
    void nalogPritisnut(ActionEvent event){

    }


    /**
     * Proverava da li je uneo text u polja.
     * @param polja - polja koja treba da proveri
     * @return ne vraca nista, radi na prosledjenoj
     * listi
     */
    private void proveraPraznine(ArrayList<TextField> polja){
        for(int i = 0; i < polja.size(); i++){
            if(!polja.get(i).getText().isEmpty()) {
                polja.remove(i);
                i--;
            }
        }
    }

    /**
     * Oznacava zadata polja da su obavezna
     * @param polja lista polja
     */
    private void oznaciPolja(ArrayList<TextField> polja){
        for(TextField polje : polja){
            polje.setStyle("-fx-text-box-border: red;");
            polje.setPromptText("Polje je obavezno.");
        }
    }

    /**
     * Resetuje boje zadatim poljima
     * @param polja - lista polja
     */
    private void resetujBojePolja(ArrayList<TextField> polja){
        for(TextField polje: polja){
            polje.setStyle("");
        }
    }

}
