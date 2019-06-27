package Controller;

import Model.*;
import View.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

import javax.xml.soap.Text;
import java.io.File;
import java.net.URL;
import java.util.*;

public class DodajProizvodController implements Initializable {

    private List<String> putanjeDoSlika;

    @FXML
    private ComboBox<String> pol;
    @FXML
    private TextField naziv;
    @FXML
    private TextArea opis;
    @FXML
    private Label poruka;
    @FXML
    private TextField cena;
    @FXML
    private TextField boja;
    @FXML
    private ComboBox<String> kategorija;

    @FXML
    private void dodavanjeSlikePritisnuo(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(String.format(System.getProperty("user.dir") + "\\src\\slike\\slikeProizvoda")));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Jpg files", "*.jpg"),
                                                 new FileChooser.ExtensionFilter("Png files", "*.png"));
        fileChooser.setTitle("Izaberi slike");
        List<File> slike = fileChooser.showOpenMultipleDialog(Main.window);
        putanjeDoSlika = new ArrayList<String>();
        if(slike != null){
            for(File slika : slike){
                putanjeDoSlika.add(String.format("./slike/slikeproizvoda/" + slika.getName()));
            }
        }
    }

    @FXML
    private void dodajPritisnut(ActionEvent event){

        if(putanjeDoSlika.size() != 3){
            poruka.setText("Morate da izaberete tacno tri slika.");
            return;
        }

        if(!cena.getText().matches("^[0-9]+$")){
            cena.setPromptText("Morate uneti broj.");
            cena.setStyle("-fx-text-box-border: red;");
            return;
        }

        if(kategorija.getValue().equals("")){
            poruka.setText("Morate da izaberete kategoriju.");
            return;
        }

        Pol p;
        if(pol.getValue().equals("M")){
            p = Pol.M;
        }else if(pol.getValue().equals("Z")){
            p = Pol.Z;
        }else{
            pol.setPromptText("Morate izabrati pol");
            pol.setStyle("-fx-border-color: red;");
            return;
        }

        Proizvod proizvod = new Proizvod(naziv.getText(), opis.getText(), new Date(), generisiSifru(), p, putanjeDoSlika );
        Kategorija kat = Pretraga.traziKategoriju(Main.webshop.kategorije, kategorija.getValue());
        kat.dodajProizvod(proizvod);
        StavkaCenovnika sc = new StavkaCenovnika(new Date(), null, Integer.valueOf(cena.getText()), 0, proizvod);
        Main.webshop.addStavkaCenovnika(sc);
        Main.webshop.addProizvod(proizvod);

        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\MenadzerMain.fxml"));
            Parent root = (Parent) loader.load();
            MenadzerKontroler pc = loader.getController();
            Main.scene.setRoot(root);
        } catch (Exception e){ e.printStackTrace(); }
    }

    private String generisiSifru(){
        int brojProizvoda = Main.webshop.proizvodi.size() + 2;
        if(brojProizvoda < 10){
            return String.format("00" + brojProizvoda);
        }else if(brojProizvoda >= 10 && brojProizvoda < 100){
            return String.format("0" + brojProizvoda);
        }else{
            return String.valueOf(brojProizvoda);
        }
    }

    /**
     * Inicijalizuje comboboxove
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        putanjeDoSlika = new LinkedList<>();
        pol.getItems().clear();
        pol.getItems().addAll("M", "Z");
        kategorija.getItems().clear();

        for(Kategorija k1: Main.webshop.kategorije){
            for(Kategorija k2: k1.getPodKategorija()){
                kategorija.getItems().add(k2.getNaziv());
            }
        }

    }
}
