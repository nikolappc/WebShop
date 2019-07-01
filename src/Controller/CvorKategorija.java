package Controller;

import Model.Kategorija;
import View.Main;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.util.Collection;
import java.util.List;


/**
 * Ova klasa sluzi kao omotac za kategoriju pri odabiru kategorija iz stabla klase TreeView
 */
public class CvorKategorija {
    private Kategorija kategorija;

    public CvorKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }

    public Kategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }

    @Override
    public String toString() {
        return kategorija.getNaziv();
    }


    /**
     * Dodaje sve kategorije u prosledjeno stablo
     * @param stabloKategorija
     */
    static void dodajKategorije(TreeView<CvorKategorija> stabloKategorija){
        TreeItem<CvorKategorija> koren = napraviCvor(null);
        stabloKategorija.setRoot(koren);
        stabloKategorija.setShowRoot(false);
        stabloKategorija.setStyle("-fx-background-color:lightsteelblue");
        Collection<Kategorija> kategorije = Main.webshop.getKategorije();
        for (Kategorija k : kategorije) {
            rekurzivnoDodajKategorije(k, koren);
        }
    }


    /**
     * Prvo dodaje prosledjenu kategoriju na prosledjenog roditelja zatim sve to isto radi za podkategorije prosledjene kategorije
     */
    static private void rekurzivnoDodajKategorije(Kategorija kategorija, TreeItem<CvorKategorija> parent) {
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


    /**
     * Kreira cvor u stablu i namesta ga da izgleda otvoreno
     * @param kategorija
     * @return
     */
    static private TreeItem<CvorKategorija> napraviCvor(Kategorija kategorija) {
        TreeItem<CvorKategorija> cvor=new TreeItem<>(new CvorKategorija(kategorija));
        cvor.setExpanded(true);
        return cvor;
    }
}
