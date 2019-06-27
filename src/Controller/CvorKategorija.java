package Controller;

import Model.Kategorija;

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
}
