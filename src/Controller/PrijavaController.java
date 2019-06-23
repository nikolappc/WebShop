package Controller;

import Model.Kupac;
import Model.UlogovaniKorisnik;
import View.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javax.xml.soap.Text;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ResourceBundle;

import static View.Main.webshop;

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

        if(Main.webshop.prijava(korisnickoPrijava.getText(), lozinkaPrijava.getText())){
            // TODO: dodaj da se prikazuje glavna strana
            System.out.println("Bravo care");
        } else {
            porukaPrijava.setText("Pogresno korisnicko ili lozinka");
        }
    }

    @FXML
    void stisnuoZabroavljenaSifra(ActionEvent event) {

    }

    /**
     * Poziva se kada korisnik klikne na dugme Registracija
     * Validuje korisnicki unos i kreira novi nalog ako je
     * unos validan.
     * @param event
     */
    @FXML
    void stisnuoRegistracija(ActionEvent event) {
        ArrayList<TextField> polja = new ArrayList(
                Arrays.asList(imeReg, prezimeReg, emailReg, korisnickoReg,
                              pLoznikaReg, lozinkaReg));
        porukaReg.setText("");
        resetujBojePolja(polja);
        proveraPraznine(polja);
        oznaciPolja(polja);

        // ovo znaci da nije popunio sva polja
        if(polja.size() > 0){
            return;
        }

        // validacija polja
        boolean ok = true;
        ok = proveraEmail();
        ok = proveraKorisnickog();
        ok = proveraLoznike();
        ok = proveraBrTelefona();

        // proveri da li je izabro pol
        if(polComboBox.getValue()==null){
            porukaReg.setText(String.format("%s %s", porukaReg.getText(), "Izaberite pol."));
            ok = false;
        }

        if(ok){
            Main.webshop.addKupac(new Kupac(korisnickoReg.getText(),
                                            lozinkaReg.getText(),
                                            imeReg.getText(),
                                            prezimeReg.getText(),
                                            adresaReg.getText(),
                                            emailReg.getText()));

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Nalog uspesno kreiran.");
            alert.setContentText("Sada probajte da se prijavite.");
            alert.setHeaderText("Uspesno ste se registrovali.");
            alert.showAndWait();
        }
    }

    /**
     * Proverava validnost i jednistvenost maila
     * i prikazuje odgovarajuce poruke u slucaju da
     * nesto nije u redu.
     * @return true ako je sve ok, false u suprotnom
     */
    private boolean proveraEmail(){
        boolean ok = true;
        // provera validnosti maila
        if(!emailReg.getText().matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")){
            porukaReg.setText("Email nije dobar.");
            emailReg.setStyle("-fx-text-box-border: red;");
            ok = false;
        }

        // proveri jednistvenost maila.
        Kupac kupac = Main.webshop.pretraga.pretragaKupacaEmail(Main.webshop.kupci, emailReg.getText());
        if(kupac != null){
            porukaReg.setText("Email je zauzet.");
            emailReg.setStyle("-fx-text-box-border: red;");
            ok = false;
        }

        return ok;
    }

    /**
     * Proverava jedinstvenost korisnickog
     * @return true ako je ne postoji vec, false  u suprotnom
     */
    private boolean proveraKorisnickog(){
        UlogovaniKorisnik korisnik = Main.webshop.pretraga.pretragaKupacaKorisnicko(
                Main.webshop.kupci, webshop.contentMenadzeri, korisnickoReg.getText());

        if(korisnik != null){
            porukaReg.setText(String.format("%s %s", porukaReg.getText(),"Korisnicko vec postoji."));
            korisnickoReg.setStyle("-fx-text-box-border: red;");
            return false;
        }

        return true;
    }

    /**
     * Uporedjuje loznike
     * @return true ako se poklapaju, false u suprotnom
     */
    private boolean proveraLoznike(){
        if(!lozinkaReg.getText().equals(pLoznikaReg.getText())){
            porukaReg.setText(String.format("%s %s", porukaReg.getText(), "Lozinke se ne poklapaju"));
            lozinkaReg.setStyle("-fx-text-box-border: red;");
            pLoznikaReg.setStyle("-fx-text-box-border: red;");
            return false;
        }
        return true;
    }

    /**
     * Proverava validnost broja telefona
     * @return
     */
    private boolean proveraBrTelefona(){
        if(!brTelefonaReg.getText().matches("^[+]*[0-9]*$")){
            porukaReg.setText(String.format("%s %s", porukaReg.getText(), "Pogresan br tel."));
            brTelefonaReg.setStyle("-fx-text-box-border: red;");
            return false;
        }

        return true;
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
