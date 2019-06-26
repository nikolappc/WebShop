package Controller;

import Model.*;
import View.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTreeCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.*;

/**
 * Jedna stranica na kojoj se nalazi maksimalno 9 proizvoda
 * Ima referencu na prethodnu i sledecu
 */
class Stranica {

    public static final int proizvodPoStrani = 9;
    List<Proizvod> proizvodi;
    int start, end;

    Stranica prev, next;

    public Stranica(List<Proizvod> proizvodi, int start, int end) {
        this.proizvodi = proizvodi;
        this.start = start;
        this.end = end;
    }

    public Stranica getPrev() {
        return prev;
    }

    public void setPrev(Stranica prev) {
        this.prev = prev;
    }

    public Stranica getNext() {
        return next;
    }

    public void setNext(Stranica next) {
        this.next = next;
    }



    public GridPane ucitaj(){
        GridPane gp = new GridPane();
        gp.setVgap(30);
        gp.setHgap(20);

        int index = start;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (index >= proizvodi.size()) {
                    break;
                }

                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\ElementKataloga.fxml"));
                    VBox hb = (VBox) loader.load();
                    ElementKatalogaController ekc= loader.getController();
                    ekc.ucitaj(proizvodi.get(index));

                    gp.add(hb, j, i);
                    index++;

                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return gp;
    }
}

/**
 * Ova klasa se cuva u stablu na klik cvora koji sadrzi ovaj objekat
 * se obavlja pretraga proizvoda na putanji iz oobjekta ove klase
 */
class CvorDrveta {
    private String name;
    private String putanja;

    public CvorDrveta(String name, String putanja) {
        this.name = name;
        this.putanja = putanja;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }


    public String getPutanja() {
        return putanja;
    }
}

/**
 * Ovo koristim da znam na koju smo sliku kliknuli
 */
class ProizvodSlika {
    Proizvod proizvod;
    ImageView slika;
    StavkaNarudzbine stavka;

    public ProizvodSlika(Proizvod prz, ImageView sl) {
        proizvod = prz;
        slika = sl;
    }

    public ProizvodSlika(StavkaNarudzbine stv, ImageView sl) {
        stavka = stv;
        slika = sl;
    }

}

public class KatalogController implements Initializable {

    @FXML
    private VBox atributiLayout;

    @FXML
    private TreeView<CvorDrveta> stabloKategorija;

    @FXML
    private VBox vbox;

    @FXML
    public Label brojRezultata;

    @FXML
    public Label kategorijaLabela;

    @FXML
    private HeaderController someIdController;

    private List<MenuButton> atributMeniji = new LinkedList<>() ;

    private List<Proizvod> proizvodi;

    private Set<String> putanje = new TreeSet<>();


    private Stranica trenutnaStranica;

    Map<String, Set<String>> atributFilter = new HashMap<>();

    public void izvrsiPretragu() {
        /** Vrsi se pretraga po svim kriterijumima koje je korisnik izabrao i na kraju se rezultati pretraga spajaju i prikazuju*/


    }


    /**
     * Dodaje broj pronadjenih proizvoda, sve boje, brendove i velicine
     */
    public void sideBarOpcije(List<Proizvod> proizvodi) {

//        brojRezultata.setText(proizvodi.size() + "");
//        Map<String, Set<Atribut>> atributi = new HashMap<>();
//        for (Proizvod p : proizvodi) {
//            for (Map.Entry<String, Atribut> a : p.getAtributi().entrySet()) {
//                if (!atributi.containsKey(a.getKey())) {
//                    atributi.put(a.getKey(), new HashSet<>());
//                }
//                atributi.get(a.getKey()).add(a.getValue());
//            }
//        }
//        int index = 2;
//        for (Map.Entry<String, Set<Atribut>> entry : atributi.entrySet()) {
//            MenuButton atributMenu = new MenuButton(entry.getKey());
//            for (Atribut a : entry.getValue()) {
//                CustomMenuItem mitem = new CustomMenuItem();
//                CheckBox cb = new CheckBox(a.getVrednost());
//                mitem.setContent(cb);
//                atributMenu.getItems().add(mitem);
//            }
//            HBox hBox = new HBox();
//            hBox.getChildren().add(atributMenu);
//            atributiLayout.getChildren().add(index,hBox);
//            index++;
//        }

//        Set<String> setBoja = new TreeSet<String>();
//        Set<String> setBrendova = new TreeSet<String>();
//        Set<String> setVelicina = new TreeSet<String>();


        Map<String, Set<String>> atributiVrednosti = new HashMap<>();
        for (Proizvod p : proizvodi) {
            for (Atribut a:p.getAtributi().values()) {
                String naziv = a.getNaziv();
                if (!atributiVrednosti.containsKey(naziv)) {
                    atributiVrednosti.put(naziv, new HashSet<>());
                }

                Set<String> vrednosti = atributiVrednosti.get(naziv);
                vrednosti.addAll(a.getVrednosti());
            }

//            setBoja.add((String) p.getAtributi().get("Boja").getVrednost());
//
//            List<String> vel = (List<String>) p.getAtributi().get("Velicine").getVrednost();
//            for (String poj : vel)
//                setVelicina.add(poj);
//
//            setBrendova.add((String) p.getAtributi().get("Brend").getVrednost());
        }
        atributiLayout.getChildren().removeAll(atributMeniji);
        for (Map.Entry<String, Set<String>> e:atributiVrednosti.entrySet()){
            MenuButton atributMeni = new MenuButton(e.getKey());
            atributMeni.setPrefSize(200,25);
            atributMeni.setFont(new Font(15));
            for(String s: e.getValue()) {
                CustomMenuItem mitem = new CustomMenuItem();
                CheckBox cb = new CheckBox(s);
                cb.selectedProperty().addListener((observable, oldValue, newValue) -> {
                    if (newValue) {
                        dodajFilterAtributa(e.getKey(),cb.getText());
                    } else {
                        izbaciFilterAtributa(e.getKey(),cb.getText());
                    }

                });
                mitem.setContent(cb);
                atributMeni.getItems().add(mitem);

            }
            atributiLayout.getChildren().add(atributMeni);
            atributMeniji.add(atributMeni);
        }


//        for(String s: setBoja){
//            CustomMenuItem mitem = new CustomMenuItem();
//            CheckBox cb = new CheckBox(s);
//            cb.selectedProperty().addListener((observable, oldValue, newValue) -> {
//                if (newValue){
//
//                }else{
//
//                }
//            });
//            mitem.setContent(cb);
//            boje.getItems().add(mitem);
//        }
//
//        for(String s: setBrendova){
//            CustomMenuItem mitem = new CustomMenuItem();
//            CheckBox cb = new CheckBox(s);
//            mitem.setContent(cb);
//            brendovi.getItems().add(mitem);
//        }
//
//        for(String s: setVelicina){
//            CustomMenuItem mitem = new CustomMenuItem();
//            CheckBox cb = new CheckBox(s);
//            mitem.setContent(cb);
//            velicine.getItems().add(mitem);
//        }


    }

    public void pretraziPoAtributima(){
        List<Proizvod> proizvodiSaAtributima = new LinkedList<>();
        for (Proizvod p:proizvodi){
            boolean flag = true;
            for (String naziv:atributFilter.keySet()){
                Atribut atribut;
                if ((atribut = p.getAtribut(naziv))!=null){
                    if (!atribut.sadrziVrednosti(atributFilter.get(naziv))){
                        flag = false;
                        break;
                    }
                }
            }
            if (flag){
                proizvodiSaAtributima.add(p);
            }
        }
        prikazi(proizvodiSaAtributima);
    }


    public void pretraziPoKategoriji() {
        proizvodi = new LinkedList<>();
        atributFilter.clear();
        for (String putanja : putanje) {
            List<String> var = Arrays.asList(putanja.split("\\|"));
            proizvodi.addAll(Pretraga.pretraziKategorije(Main.webshop.getKategorije(), var));
        }

        if (proizvodi == null) {
            return;
        }
        prikazi(proizvodi);
        sideBarOpcije(proizvodi);
    }

    /**
     * Prikazuje date proizvode iz liste u katalogu
     *
     * @param proizvodi
     */
    public void prikazi(List<Proizvod> proizvodi) {
        brojRezultata.setText(String.valueOf(proizvodi.size()));
        if (proizvodi.isEmpty()) {
            Label label = new Label("Nijedan proizvod nije pronađen.");
            vbox.getChildren().set(1, label);
            return;
        }

        int end;
        Stranica prev = null;
        for (int i = 0; i < proizvodi.size(); i += Stranica.proizvodPoStrani) {
            end = i + Stranica.proizvodPoStrani;
            if (end >= proizvodi.size()) {
                end = proizvodi.size();
            }
            Stranica s = new Stranica(proizvodi, i, end);
            if (i == 0) {

                namestiNovuStranicu(s);
            }
            s.setPrev(prev);
            if (prev != null) {
                prev.setNext(s);
            }
            prev = s;
        }
    }

    private void namestiNovuStranicu(Stranica s) {
        if (s == null) {
            return;
        }
        trenutnaStranica = s;
        GridPane gp = trenutnaStranica.ucitaj();
        vbox.getChildren().set(1, gp);
    }


    public void dodajUPrikazKategorije(String putanja) {
        putanje.add(putanja);
        pretraziPoKategoriji();
    }


    private void izbaciIzPrikazaKategorije(String putanja) {
        putanje.remove(putanja);
        pretraziPoKategoriji();
    }

    private void dodajFilterAtributa(String naziv, String vrednost){
        if (!atributFilter.containsKey(naziv)){
            atributFilter.put(naziv,new HashSet<>());
        }
        atributFilter.get(naziv).add(vrednost);
        pretraziPoAtributima();
    }
    private void izbaciFilterAtributa(String naziv, String vrednost){
        if (atributFilter.containsKey(naziv)){
            atributFilter.get(naziv).remove(vrednost);
        }
        pretraziPoAtributima();
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //gp.getChildren().clear();
        HBox dugmad = new HBox();
        Button prev = new Button("Prethodna");
        Button next = new Button("Sledeca");
        prev.setOnAction(e -> {
            proslaStranica();
        });
        next.setOnAction(e -> {
            sledecaStranica();
        });
        dugmad.getChildren().addAll(prev, next);
        vbox.getChildren().add(2, dugmad);
        CheckBoxTreeItem<CvorDrveta> treeRoot = napraviCvor("Kategorije", "");
        stabloKategorija.setRoot(treeRoot);
        stabloKategorija.setStyle("-fx-background-color:lightsteelblue");
        stabloKategorija.setCellFactory(CheckBoxTreeCell.forTreeView());

        Collection<Kategorija> kategorije = Main.webshop.getKategorije();
        for (Kategorija k : kategorije) {
            rekurzivnoDodajKategorije(k, treeRoot, k.getNaziv());
        }

    }

    private void sledecaStranica() {
        namestiNovuStranicu(trenutnaStranica.getNext());
    }


    private void proslaStranica() {
        namestiNovuStranicu(trenutnaStranica.getPrev());
    }

    /**
     * Kreira cvor drveta i namesta Listener koji na osnovu stanja cvora dodaje ili izbacuje putanju do proizvoda
     * iz seta putranja preko kojih se dobavljaju proizvodi
     *
     * @param naziv
     * @param putanja
     * @return
     */
    private CheckBoxTreeItem<CvorDrveta> napraviCvor(String naziv, String putanja) {
        CheckBoxTreeItem<CvorDrveta> node = new CheckBoxTreeItem<>(new CvorDrveta(naziv, putanja));
        node.setExpanded(true);
        node.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                dodajUPrikazKategorije(node.getValue().getPutanja());
            } else {
                izbaciIzPrikazaKategorije(node.getValue().getPutanja());
            }
        });
        return node;
    }

    /**
     * Dodaje rekurzivno kategorije u stablo
     *
     * @param kategorija kategorija koja se trenutno unosi u stablo
     * @param parent     cvor u stablu koji ce biti roditelj novom dodatom
     * @param putanja    putanja do trenutne kategorije
     */
    private void rekurzivnoDodajKategorije(Kategorija kategorija, TreeItem<CvorDrveta> parent, String putanja) {

        CheckBoxTreeItem<CvorDrveta> node = napraviCvor(kategorija.getNaziv(), putanja);
        parent.getChildren().add(node);
        List<Kategorija> kategorije = kategorija.getPodKategorija();
        if (kategorije.isEmpty()) {
            return;
        }
        for (Kategorija k : kategorije) {
            rekurzivnoDodajKategorije(k, node, putanja + "|" + k.getNaziv());
        }
    }
}
