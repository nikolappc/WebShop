package Controller;

import Model.Kategorija;
import Model.Proizvod;
import View.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;

public class DodavanjeKategorijeController implements Initializable {
    @FXML
    private TreeView<CvorKategorija> stabloKategorija;
    @FXML
    private ListView<CvorProizvod> listaProizvoda;

    @FXML
    private TextField nazivTextField;

    @FXML
    private Button dodavanjeDugme;

    @FXML
    private Button ponistavanjeDugme;

    Kategorija nadKategorija = null;


    private void dodajProizvode() {
        for(Proizvod p:Main.webshop.getProizvodi()){
            listaProizvoda.getItems().add(new CvorProizvod(p));
        }
    }

    void dodaj(){
        if (nazivTextField.getText().trim().isEmpty()){
            nazivTextField.setStyle("-fx-border-color: red");
            nazivTextField.setPromptText("Naziv kategorije ne sme biti prazan!");
        }
        else{
            Kategorija kategorija = new Kategorija(nazivTextField.getText().trim());
            if (nadKategorija!=null){
                nadKategorija.dodajPodKategorija(kategorija);
            }else{
                Main.webshop.addKategorija(kategorija);
            }
            for (CvorProizvod cvorProizvod:listaProizvoda.getSelectionModel().getSelectedItems()){
                kategorija.dodajProizvod(cvorProizvod.getProizvod());
            }
            prebaciPrikazNaGlavni();
        }
    }

    private void ponisti() {
        prebaciPrikazNaGlavni();
    }

    private void prebaciPrikazNaGlavni(){
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\MenadzerMain.fxml"));
            Parent root = (Parent) loader.load();

            Main.scene.setRoot(root);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CvorKategorija.dodajKategorije(stabloKategorija);
        dodajProizvode();
        stabloKategorija.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> nadKategorija = newValue.getValue().getKategorija());
        dodavanjeDugme.setOnAction(e->dodaj());
        ponistavanjeDugme.setOnAction(e->ponisti());
    }
}
