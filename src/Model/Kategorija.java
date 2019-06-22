/***********************************************************************
 * Module:  Kategorija.java
 * Author:  nklppc
 * Purpose: Defines the Class Kategorija
 ***********************************************************************/
package Model;
import java.util.*;

public class Kategorija {
    private String naziv;
    
    private Collection<AtributKategorije> atributKategorije = new ArrayList<AtributKategorije>();
    private Collection<Kategorija> podKategorija = new ArrayList<Kategorija>();
    private Kategorija nadKategorija;
    
    
    
    
    
    public Kategorija() {
    	super();
    }

    


	public Kategorija(String naziv, Collection<AtributKategorije> atributKategorije, Collection<Kategorija> podKategorija,
			Kategorija nadKategorija) {
		super();
		this.naziv = naziv;
		for (AtributKategorije a : atributKategorije) {
			this.atributKategorije.add(a);
		}
		
		for (Kategorija kategorija : podKategorija) {
			this.podKategorija.add(kategorija);
		}
		this.nadKategorija = nadKategorija;
	}




	public Collection<AtributKategorije> getAtributKategorije() {
		return atributKategorije;
	}
    
    

    public void setAtributKategorije(Collection<AtributKategorije> newAtributKategorije) {
    	this.atributKategorije.clear();
    	for (AtributKategorije atributKategorije : newAtributKategorije) {
    		this.atributKategorije.add(atributKategorije);
    	}
    }
    

    public void dodajAtributKategorije(AtributKategorije newAtributKategorije) {
        if (newAtributKategorije == null)
            return;
        if (!this.atributKategorije.contains(newAtributKategorije))
            this.atributKategorije.add(newAtributKategorije);
    }
    

    public void izbaciAtributKategorije(AtributKategorije oldAtributKategorije) {
        if (oldAtributKategorije == null)
            return;
        if (this.atributKategorije != null)
            if (this.atributKategorije.contains(oldAtributKategorije))
                this.atributKategorije.remove(oldAtributKategorije);
    }
    

    public Collection<Kategorija> getPodKategorija() {
        return podKategorija;
    }
    
    
    public void setPodKategorija(Collection<Kategorija> newPodKategorija) {
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
		if (atributKategorije == null) {
			if (other.atributKategorije != null)
				return false;
		} else if (!atributKategorije.equals(other.atributKategorije))
			return false;
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




	public String getNaziv() {
		return naziv;
	}




	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
    
    

}