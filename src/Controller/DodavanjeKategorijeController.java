package Controller;

import Model.Kategorija;
import Model.Proizvod;
import View.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTreeCell;

import java.net.URL;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
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

    void dodajKategorije(){
        TreeItem<CvorKategorija> koren = napraviCvor(null);
        stabloKategorija.setRoot(koren);
        stabloKategorija.setShowRoot(false);
        stabloKategorija.setStyle("-fx-background-color:lightsteelblue");
        stabloKategorija.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> nadKategorija = newValue.getValue().getKategorija());
        Collection<Kategorija> kategorije = Main.webshop.getKategorije();
        for (Kategorija k : kategorije) {
            rekurzivnoDodajKategorije(k, koren);
        }
    }

    private void rekurzivnoDodajKategorije(Kategorija kategorija, TreeItem<CvorKategorija> parent) {
        TreeItem<CvorKategorija> node = napraviCvor(kategorija);
        parent.getChildren().add(node);
        List<Kategorija> kategorije = kategorija.getPodKategorija();
        if (kategorije.isEmpty()) {
            return;
        }
        for (Kategorija k : kategorije) {
            rekurzivnoDodajKategorije(k, node);
        }
    }

    private TreeItem<CvorKategorija> napraviCvor(Kategorija kategorija) {
        TreeItem<CvorKategorija> cvor=new TreeItem<>(new CvorKategorija(kategorija));
        cvor.setExpanded(true);
        return cvor;
    }

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

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\glavni.fxml"));
            Parent root = (Parent) loader.load();

            Main.scene.setRoot(root);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dodajKategorije();
        dodajProizvode();
        dodavanjeDugme.setOnAction(e->dodaj());
        ponistavanjeDugme.setOnAction(e->ponisti());
    }
}
