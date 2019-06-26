package Model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;


@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Atribut {
    private String naziv;
    private List<String> vrednosti;

    private TipAtributa tipAtributa;

    public Atribut() {
    }

    public Atribut(String naziv, List<String> vrednost, TipAtributa tipAtributa) {
        this.naziv = naziv;
        this.vrednosti = vrednost;
        this.tipAtributa = tipAtributa;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getVrednost() {
        return vrednosti.get(0);
    }

    public void setVrednost(String vrednost) {
        if (vrednosti.isEmpty()) {
            return;
        }
        this.vrednosti.set(0, vrednost);
    }

    public List<String> getVrednosti() {
        return vrednosti;
    }

    public void setVrednosti(List<String> vrednosti) {
        this.vrednosti = vrednosti;
    }

    public TipAtributa getTipAtributa() {
        return tipAtributa;
    }

    public void setTipAtributa(TipAtributa tipAtributa) {
        this.tipAtributa = tipAtributa;
    }

    /**
     * Proverava da li atribut sadrzi vrednost datu parametrom
     * @param parametar
     * @return
     */
    public boolean sadrziVrednost(String parametar) {
        for (String vrednost : vrednosti) {
            if (vrednost.contains(parametar)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Proverava da li atribut sadrzi bar jednu od vrednosti u listi
     * @param strings
     * @return
     */
    public boolean sadrziVrednost(Collection<String> strings) {
        if (strings.isEmpty()){
            return true;
        }
        for (String vrednost : strings) {
            if (vrednosti.contains(vrednost)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {

        Collections.sort(vrednosti);
        StringBuilder kod = new StringBuilder();
        for (String vrednost : vrednosti) {
            kod.append(vrednost);
        }
        return kod.toString().hashCode();
    }
}
