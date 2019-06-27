package Controller;

import Model.Kategorija;
import View.Main;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.util.Collection;
import java.util.List;

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

    static private TreeItem<CvorKategorija> napraviCvor(Kategorija kategorija) {
        TreeItem<CvorKategorija> cvor=new TreeItem<>(new CvorKategorija(kategorija));
        cvor.setExpanded(true);
        return cvor;
    }
}
