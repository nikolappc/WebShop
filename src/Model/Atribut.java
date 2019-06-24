package Model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Atribut {
    private String naziv;
    private String vrednost;

    public Atribut() {
    }

    public Atribut(String naziv, String vrednost) {
        this.naziv = naziv;
        this.vrednost = vrednost;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getVrednost() {
        return vrednost;
    }

    public void setVrednost(String vrednost) {
        this.vrednost = vrednost;
    }
}
