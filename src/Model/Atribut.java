package Model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Atribut {
    private String naziv;
    private Object vrednost;

    public Atribut() {
    }

    public Atribut(String naziv, Object vrednost) {
        this.naziv = naziv;
        this.vrednost = vrednost;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Object getVrednost() {
        return vrednost;
    }

    public void setVrednost(Object vrednost) {
        this.vrednost = vrednost;
    }
}
