package Controller;

import Model.Proizvod;

public class CvorProizvod {
    Proizvod proizvod;

    public CvorProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }

    public Proizvod getProizvod() {
        return proizvod;
    }

    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }

    @Override
    public String toString() {
        return proizvod.getNaziv();
    }
}
