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

    public static final int proizvodPoStrani = 18;
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


    /**
     * Učitava 9 proizvoda iz liste proizvoda
     * @return
     */
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
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\ElementKataloga.fxml"));
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
    private HeaderController someIdController;

    private List<MenuButton> atributMeniji = new LinkedList<>() ;

    private List<Proizvod> proizvodi;

    private Set<String> putanje = new TreeSet<>();

    private Map<String,CheckBoxTreeItem<CvorDrveta>> cvorovi = new HashMap<>();

    private Stranica trenutnaStranica;

    private Map<String, Set<String>> atributFilter = new HashMap<>();
    private Button prev;
    private Button next;

    private Label brStrane;

    public void izvrsiPretragu() {
        /** Vrsi se pretraga po svim kriterijumima koje je korisnik izabrao i na kraju se rezultati pretraga spajaju i prikazuju*/

    }


    /**
     * Dodaje broj pronadjenih proizvoda, sve boje, brendove i velicine
     */
    public void sideBarOpcije(List<Proizvod> proizvodi) {
        stvoriStablo();

        Map<String, Set<String>> atributiVrednosti = new HashMap<>();
        for (Proizvod p : proizvodi) {
            for (Atribut a:p.getAtributi().values()) {
                String naziv = a.getNaziv();
                if (!atributiVrednosti.containsKey(naziv)) {
                    atributiVrednosti.put(naziv, new TreeSet<>());
                }

                Set<String> vrednosti = atributiVrednosti.get(naziv);
                vrednosti.addAll(a.getVrednosti());
            }
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

    }

    /**
     * Pretrazuje proizvode unapred pretrazene preko kategorija koristeci filter atributa
     * i prikazuje samo one ciji se atributi slazu sa svim filterima
     */
    public void pretraziPoAtributima(){
        List<Proizvod> proizvodiSaAtributima = new LinkedList<>();
        for (Proizvod p:proizvodi){
            boolean flag = true;
            for (String naziv:atributFilter.keySet()){
                Atribut atribut;
                if ((atribut = p.getAtribut(naziv))!=null){
                    if (!atribut.sadrziVrednost(atributFilter.get(naziv))){
                        flag = false;
                        break;
                    }
                }
            }
            if (flag){
                proizvodiSaAtributima.add(p);
            }
        }
        prikaziProizvode(proizvodiSaAtributima);
    }


    /**
     * Dodaje u listu proizvoda one proizvode koji se nalaze u
     * kategorijama koje su dodate u polje putanje
     */
    public void pretraziPoKategoriji() {
        proizvodi = new LinkedList<>();
        atributFilter.clear();
        for (String putanja : putanje) {
            List<String> var = Arrays.asList(putanja.split("\\|"));
            proizvodi.addAll(Pretraga.pretraziKategorije(var));
        }

        if (proizvodi == null) {
            return;
        }
        prikaziIOsveziSidebar(proizvodi);
    }


    /**
     * Puni stablo pretrage sa kategorijama
     */
    private void stvoriStablo() {
        CheckBoxTreeItem<CvorDrveta> treeRoot = napraviCvor("Kategorije", "");
        stabloKategorija.setRoot(treeRoot);
        stabloKategorija.setCellFactory(CheckBoxTreeCell.forTreeView());
        stabloKategorija.setStyle("-fx-background-color:lightsteelblue");
        Collection<Kategorija> kategorije = Main.webshop.getKategorije();
        for (Kategorija k : kategorije) {
            rekurzivnoDodajKategorije(k, treeRoot, k.getNaziv());
        }
    }


    /**
     * Prikazuje date proizvode iz liste u katalogu
     *
     * @param proizvodi
     */
    private void prikaziProizvode(List<Proizvod> proizvodi) {
        brojRezultata.setText(String.valueOf(proizvodi.size()));
        if (proizvodi.isEmpty()) {
            Label label = new Label("Nijedan proizvod nije pronađen.");
            vbox.getChildren().set(1, label);
            trenutnaStranica = null;
            next.setDisable(true);
            prev.setDisable(true);
            return;
        }
        int end;
        Stranica prev = null, prva = null;

        for (int i = 0; i < proizvodi.size(); i += Stranica.proizvodPoStrani) {
            end = i + Stranica.proizvodPoStrani;
            if (end >= proizvodi.size()) {
                end = proizvodi.size();
            }
            Stranica s = new Stranica(proizvodi, i, end);
            if (i == 0) {

                prva = s;
            }
            s.setPrev(prev);
            if (prev != null) {
                prev.setNext(s);
            }
            prev = s;
        }
        if (prva!=null)
        {
            namestiNovuStranicu(prva);
        }
    }


    /**
     * Prikazuje date proizvode iz liste u katalogu i osvezava sidebar
     *
     * @param proizvodi
     */
    public void prikaziIOsveziSidebar(List<Proizvod> proizvodi) {
        this.proizvodi = proizvodi;
        prikaziProizvode(proizvodi);
        sideBarOpcije(proizvodi);
    }


    /**
     * Namesta novu stranicu za prikaz
     * @param s
     */
    private void namestiNovuStranicu(Stranica s) {
        if (s == null) {
            return;
        }
        trenutnaStranica = s;
        GridPane gp = trenutnaStranica.ucitaj();
        vbox.getChildren().set(1, gp);
        if (trenutnaStranica.getNext()!=null){
            next.setDisable(false);
        }else{
            next.setDisable(true);
        }
        if (trenutnaStranica.getPrev()!=null){
            prev.setDisable(false);
        }else{
            prev.setDisable(true);
        }
    }


    /**
     * Dodaje putanju do kategorije u skup putanja
     * @param putanja
     */
    public void dodajUPrikazKategorije(String putanja) {
        putanje.add(putanja);
        pretraziPoKategoriji();
    }


    /**
     * Izbacuje putanju do kategorije iz skupa putanja
     * @param putanja
     */
    private void izbaciIzPrikazaKategorije(String putanja) {
        putanje.remove(putanja);
        pretraziPoKategoriji();
    }


    /**
     * Dodaje filter vrednosti za zadati atribut u mapu filtera atributa
     * @param naziv
     * @param vrednost
     */
    private void dodajFilterAtributa(String naziv, String vrednost){
        if (!atributFilter.containsKey(naziv)){
            atributFilter.put(naziv,new HashSet<>());
        }
        atributFilter.get(naziv).add(vrednost);
        pretraziPoAtributima();
    }


    /**
     * Izbacuje filter vrednosti za zadati atribut u mapu filtera atributa
     * @param naziv
     * @param vrednost
     */
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
        dugmad.setSpacing(10);
        dugmad.setAlignment(Pos.CENTER);
        prev = new Button("\uD83E\uDC44");
        brStrane = new Label("1");
        next = new Button("\uD83E\uDC46");
        prev.setOnAction(e -> {
            proslaStranica();
        });
        next.setOnAction(e -> {
            sledecaStranica();
        });
        dugmad.getChildren().addAll(prev,brStrane,next);
        vbox.getChildren().add(2, dugmad);
    }


    /** Prelazak na sledecu stranicu kataloga*/
    private void sledecaStranica() {
        if (trenutnaStranica==null){
            return;
        }
        namestiNovuStranicu(trenutnaStranica.getNext());
        brStrane.setText((Integer.valueOf(brStrane.getText()) + 1) + "");
    }


    /** Povratak na prethodnu stranicu kataloga*/
    private void proslaStranica() {
        if (trenutnaStranica==null){
            return;
        }
        namestiNovuStranicu(trenutnaStranica.getPrev());
        brStrane.setText((Integer.valueOf(brStrane.getText()) -1) + "");
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
        if (putanje.contains(putanja)){
            node.setSelected(true);
        }
        node.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                dodajUPrikazKategorije(node.getValue().getPutanja());
            } else {
                izbaciIzPrikazaKategorije(node.getValue().getPutanja());
            }
        });
        cvorovi.put(putanja,node);
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
