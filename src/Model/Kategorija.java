/***********************************************************************
 * Module:  Kategorija.java
 * Author:  nklppc
 * Purpose: Defines the Class Kategorija
 ***********************************************************************/
package Model;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.*;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Kategorija {
    private String naziv;
    
    @JsonManagedReference
    private List<Kategorija> podKategorija = new ArrayList<>();
    @JsonBackReference
    private Kategorija nadKategorija;
    @JsonManagedReference
    private List<Proizvod> proizvodi = new ArrayList<>();

    private Map<String,Atribut> atributi = new HashMap<>();




    public Kategorija() {
    	super();
    }


    public Kategorija(String naziv) {
        super();
        this.naziv = naziv;
    }

    public Kategorija(String naziv, List<Kategorija> podKategorija, Kategorija nadKategorija, List<Proizvod> proizvodi) {
        this.naziv = naziv;
        this.podKategorija = podKategorija;
        this.nadKategorija = nadKategorija;
        this.proizvodi = proizvodi;
    }




    public List<Kategorija> getPodKategorija() {
        return podKategorija;
    }
    
    
    public void setPodKategorija(List<Kategorija> newPodKategorija) {
        this.podKategorija.clear();
        for (Kategorija kategorija : newPodKategorija) {
			this.podKategorija.add(kategorija);
		}
    }
    

    public void dodajPodKategorija(Kategorija newKategorija) {
        if (newKategorija == null)
            return;
        if (!this.podKategorija.contains(newKategorija))
        {
            this.podKategorija.add(newKategorija);
            newKategorija.setNadKategorija(this);        
        }
    }
    

    public void izbaciPodKategorija(Kategorija oldKategorija) {
        if (oldKategorija == null)
            return;
        if (this.podKategorija != null)
            if (this.podKategorija.contains(oldKategorija))
            {
                this.podKategorija.remove(oldKategorija);
                oldKategorija.setNadKategorija((Kategorija)null);
            }
    }
    
    
    public Kategorija getNadKategorija() {
        return nadKategorija;
    }
    

    public void setNadKategorija(Kategorija newKategorija) {
        if (this.nadKategorija == null || !this.nadKategorija.equals(newKategorija))
        {
            if (this.nadKategorija != null)
            {
                Kategorija oldKategorija = this.nadKategorija;
                this.nadKategorija = null;
                oldKategorija.izbaciPodKategorija(this);
            }
            if (newKategorija != null)
            {
                this.nadKategorija = newKategorija;
                this.nadKategorija.dodajPodKategorija(this);
            }
        }
    }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kategorija other = (Kategorija) obj;
		if (nadKategorija == null) {
			if (other.nadKategorija != null)
				return false;
		} else if (!nadKategorija.equals(other.nadKategorija))
			return false;
		if (naziv == null) {
			if (other.naziv != null)
				return false;
		} else if (!naziv.equals(other.naziv))
			return false;
		if (podKategorija == null) {
			if (other.podKategorija != null)
				return false;
		} else if (!podKategorija.equals(other.podKategorija))
			return false;
		return true;
	}



	public void dodajProizvod(Proizvod p){
        proizvodi.add(p);
    }

	public String getNaziv() {
		return naziv;
	}




	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

    public List<Proizvod> getProizvodi() {
        return proizvodi;
    }

    public void setProizvodi(List<Proizvod> proizvodi) {
        this.proizvodi = proizvodi;
    }


    public Map<String, Atribut> getAtributi() {
        return atributi;
    }

    public void setAtributi(Map<String, Atribut> atributi) {
        this.atributi = atributi;
    }


    public Atribut napraviAtribut(String naziv, List<String> vrednosti,TipAtributa tipAtributa) {
        String key = naziv+vrednosti;
        if (!atributi.containsKey(key)){
            atributi.put(key,new Atribut(naziv,vrednosti,tipAtributa));
        }
        return atributi.get(key);
    }
}