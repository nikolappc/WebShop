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
import java.io.File;
import java.net.URL;
import java.util.*;

public class DodajProizvodController implements Initializable {

    private List<String> putanjeDoSlika;
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
    private TextField brend;
    @FXML
    private TextField velicinePolje;
    @FXML
    private TreeView<CvorKategorija> stabloKategorija;
    private Kategorija nadKategorija = null;

    @FXML
    private void dodavanjeSlikePritisnuo(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(String.format(System.getProperty("user.dir") + "\\src\\slike\\slikeProizvoda")));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Jpg files", "*.jpg"),
                new FileChooser.ExtensionFilter("Png files", "*.png"));
        fileChooser.setTitle("Izaberi slike");
        List<File> slike = fileChooser.showOpenMultipleDialog(Main.window);
        putanjeDoSlika = new ArrayList<String>();
        if (slike != null) {
            for (File slika : slike) {
                putanjeDoSlika.add(String.format("./slike/slikeproizvoda/" + slika.getName()));
            }
        }
    }

    @FXML
    private void dodajPritisnut(ActionEvent event) {
        ArrayList<TextField> polja = new ArrayList(
                Arrays.asList(naziv, cena, boja, brend, velicinePolje));

        // proverava da li uneo text u sva polja
        poruka.setText("");
        resetujBojePolja(polja);
        proveraPraznine(polja);
        oznaciPolja(polja);

        // ako je izostavio neko polje
        if (polja.size() > 0) {
            return;
        }

        // mora da izabere tri slika inace program puca
        if (putanjeDoSlika.size() != 3) {
            poruka.setText("Morate da izaberete tacno tri slika.");
            return;
        }

        // proverava da li je uneo broj
        if (!cena.getText().matches("^[0-9]+$")) {
            poruka.setText("Morate uneti broj za cenu");
            return;
        }

        if (nadKategorija == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING,"Morate izabrati kategoriju");
            alert.showAndWait();
            stabloKategorija.setStyle("-fx-border-color: red;");
            return;
        }

        ArrayList<String> velicine = new ArrayList<String>();
        if (!proveriVelicine(velicine)) {
            poruka.setText("Niste dobro uneli velicine");
            return;
        }

        Proizvod proizvod = new Proizvod(naziv.getText(), opis.getText(), new Date(), generisiSifru(),  putanjeDoSlika);
        nadKategorija.dodajProizvod(proizvod);
        StavkaCenovnika sc = new StavkaCenovnika(new Date(), null, Integer.valueOf(cena.getText()), 0, proizvod);

        // dodaje atribute proizvodu
        proizvod.dodajAtribut(nadKategorija.napraviAtribut("Boja", Arrays.asList(boja.getText()), TipAtributa.STRING));
        proizvod.dodajAtribut(nadKategorija.napraviAtribut("Velicine", velicine, TipAtributa.LIST));
        proizvod.dodajAtribut(nadKategorija.napraviAtribut("Brend", Arrays.asList(brend.getText()), TipAtributa.STRING));

        Main.webshop.addStavkaCenovnika(sc);
        Main.webshop.addProizvod(proizvod);

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\MenadzerMain.fxml"));
            Parent root = (Parent) loader.load();
            MenadzerKontroler pc = loader.getController();
            Main.scene.setRoot(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private String generisiSifru() {
        int brojProizvoda = Main.webshop.proizvodi.size() + 2;
        if (brojProizvoda < 10) {
            return String.format("00" + brojProizvoda);
        } else if (brojProizvoda >= 10 && brojProizvoda < 100) {
            return String.format("0" + brojProizvoda);
        } else {
            return String.valueOf(brojProizvoda);
        }
    }

    private boolean proveriVelicine(ArrayList<String> listaVelicina) {
        String[] nizVelizina = velicinePolje.getText().split(" ");

        for (String velicina : nizVelizina) {
            switch (velicina) {
                case "S":
                case "M":
                case "L":
                case "XL":
                case "s":
                case "m":
                case "l":
                case "xl":
                    listaVelicina.add(velicina);
                    break;
                default:
                    try {
                        Integer.valueOf(velicina);
                        listaVelicina.add(velicina);
                    } catch (NumberFormatException e) {
                        return false;
                    }
            }
        }

        return true;
    }

    /**
     * Inicijalizuje comboboxove
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CvorKategorija.dodajKategorije(stabloKategorija);
        stabloKategorija.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> nadKategorija = newValue.getValue().getKategorija());
        putanjeDoSlika = new LinkedList<>();

    }


    /**
     * Proverava da li je uneo text u polja.
     *
     * @param polja - polja koja treba da proveri
     * @return ne vraca nista, radi na prosledjenoj
     * listi
     */
    private void proveraPraznine(ArrayList<TextField> polja) {
        for (int i = 0; i < polja.size(); i++) {
            if (!polja.get(i).getText().isEmpty()) {
                polja.remove(i);
                i--;
            }
        }
    }

    /**
     * Oznacava zadata polja da su obavezna
     *
     * @param polja lista polja
     */
    private void oznaciPolja(ArrayList<TextField> polja) {
        for (TextField polje : polja) {
            polje.setStyle("-fx-text-box-border: red;");
            polje.setPromptText("Polje je obavezno.");
        }
    }

    /**
     * Resetuje boje zadatim poljima
     *
     * @param polja - lista polja
     */
    private void resetujBojePolja(ArrayList<TextField> polja) {
        for (TextField polje : polja) {
            polje.setStyle("");
        }
    }

}
