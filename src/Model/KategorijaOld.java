/***********************************************************************
 * Module:  Kategorija.java
 * Author:  nklppc
 * Purpose: Defines the Class Kategorija
 ***********************************************************************/
package Model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class KategorijaOld {
    private String naziv;

    private Map<String,AtributKategorije> atributKategorije = new HashMap<>();
    @JsonManagedReference
    private Collection<KategorijaOld> podKategorija = new ArrayList<>();
    @JsonBackReference
    private KategorijaOld nadKategorija;

    private Collection<Proizvod> proizvodi = new ArrayList<>();




    public KategorijaOld() {
    	super();
    }


    public KategorijaOld(String naziv) {
        super();
        this.naziv = naziv;
    }

	public KategorijaOld(String naziv, Map<String,AtributKategorije> atributKategorije, Collection<KategorijaOld> podKategorija,
                         KategorijaOld nadKategorija) {
		super();
		this.naziv = naziv;
		for (Map.Entry<String, AtributKategorije> a : atributKategorije.entrySet()) {
			this.atributKategorije.put(a.getKey(),a.getValue());
		}
		
		for (KategorijaOld kategorija : podKategorija) {
			this.podKategorija.add(kategorija);
		}
		this.nadKategorija = nadKategorija;
	}




	public Map<String,AtributKategorije> getAtributKategorije() {
		return atributKategorije;
	}
    
    

    public void setAtributKategorije(Map<String,AtributKategorije> newAtributKategorije) {
    	this.atributKategorije.clear();
    	for (Map.Entry<String, AtributKategorije> atributKategorije : newAtributKategorije.entrySet()) {
    		this.atributKategorije.put(atributKategorije.getKey(),atributKategorije.getValue());
    	}
    }

    public void dodajAtributKategorije(AtributKategorije newAtributKategorije) {
        if (newAtributKategorije == null)
            return;
        if (!this.atributKategorije.containsKey(newAtributKategorije.getNaziv()))
            this.atributKategorije.put(newAtributKategorije .getNaziv(),newAtributKategorije);
    }
    

    public void izbaciAtributKategorije(AtributKategorije oldAtributKategorije) {
        if (oldAtributKategorije == null)
            return;
        if (this.atributKategorije != null)
            this.atributKategorije.remove(oldAtributKategorije.getNaziv());
    }
    

    public Collection<KategorijaOld> getPodKategorija() {
        return podKategorija;
    }
    
    
    public void setPodKategorija(Collection<KategorijaOld> newPodKategorija) {
        this.podKategorija.clear();
        for (KategorijaOld kategorija : newPodKategorija) {
			this.podKategorija.add(kategorija);
		}
    }
    

    public void dodajPodKategorija(KategorijaOld newKategorija) {
        if (newKategorija == null)
            return;
        if (!this.podKategorija.contains(newKategorija))
        {
            this.podKategorija.add(newKategorija);
            newKategorija.setNadKategorija(this);        
        }
    }
    

    public void izbaciPodKategorija(KategorijaOld oldKategorija) {
        if (oldKategorija == null)
            return;
        if (this.podKategorija != null)
            if (this.podKategorija.contains(oldKategorija))
            {
                this.podKategorija.remove(oldKategorija);
                oldKategorija.setNadKategorija((KategorijaOld)null);
            }
    }
    
    
    public KategorijaOld getNadKategorija() {
        return nadKategorija;
    }
    

    public void setNadKategorija(KategorijaOld newKategorija) {
        if (this.nadKategorija == null || !this.nadKategorija.equals(newKategorija))
        {
            if (this.nadKategorija != null)
            {
                KategorijaOld oldKategorija = this.nadKategorija;
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
		KategorijaOld other = (KategorijaOld) obj;
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


    public AtributKategorije getAtributKategorije(String naziv) {
        if (atributKategorije.containsKey(naziv))
        return atributKategorije.get(naziv);
        return null;
    }

    public AtributKategorije napraviAtributKategorije(String naziv) {

        if (!atributKategorije.containsKey(naziv)){
            atributKategorije.put(naziv, new AtributKategorije(naziv));
        }
        return atributKategorije.get(naziv);
    }
}