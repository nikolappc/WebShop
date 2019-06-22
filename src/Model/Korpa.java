/***********************************************************************
 * Module:  Korpa.java
 * Author:  Dusan
 * Purpose: Defines the Class Korpa
 ***********************************************************************/
package Model;
import java.util.*;

public class Korpa {
    private Narudzbina narudzbina;
    private Collection<StavkaNarudzbine> stavkaNarudzbine = new ArrayList<StavkaNarudzbine>();
    private Kupac kupac;
    
    
   
    
    public Korpa() {
		super();
	}

	public Korpa(Narudzbina narudzbina, Collection<StavkaNarudzbine> stavkaNarudzbine, Kupac kupac) {
		super();
		this.narudzbina = narudzbina;
		for (StavkaNarudzbine stavkaNarudzbine2 : stavkaNarudzbine) {
			this.stavkaNarudzbine.add(stavkaNarudzbine2);
		}
		this.kupac = kupac;
	}

	public Narudzbina getNarudzbina() {
		return narudzbina;
	}

	public void setNarudzbina(Narudzbina narudzbina) {
		this.narudzbina = narudzbina;
	}

	public Kupac getKupac() {
		return kupac;
	}

	public void setKupac(Kupac kupac) {
		this.kupac = kupac;
	}

	public boolean dodajProizvod() {
        // TODO: implement
        return false;
    }
    
    public boolean ukloniProizvod() {
        // TODO: implement
        return false;
    }
    
    public boolean izmeniKolicinuZaProizvod() {
        // TODO: implement
        return false;
    }
    
    public Collection<StavkaNarudzbine> getStavkaNarudzbine() {
         return stavkaNarudzbine;
    }
    
    public void setStavkaNarudzbine(Collection<StavkaNarudzbine> newStavkaNarudzbine) {
        this.stavkaNarudzbine.clear();;
        for (StavkaNarudzbine stavkaNarudzbine : newStavkaNarudzbine) {
			this.stavkaNarudzbine.add(stavkaNarudzbine);
		}
    }
    
    public void dodajStavkaNarudzbine(StavkaNarudzbine newStavkaNarudzbine) {
        if (newStavkaNarudzbine == null)
            return;
        if (!this.stavkaNarudzbine.contains(newStavkaNarudzbine))
            this.stavkaNarudzbine.add(newStavkaNarudzbine);
    }
    
    public void izbaciStavkaNarudzbine(StavkaNarudzbine oldStavkaNarudzbine) {
        if (oldStavkaNarudzbine == null)
            return;
        if (this.stavkaNarudzbine != null)
            if (this.stavkaNarudzbine.contains(oldStavkaNarudzbine))
                this.stavkaNarudzbine.remove(oldStavkaNarudzbine);
    }


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Korpa other = (Korpa) obj;
		if (kupac == null) {
			if (other.kupac != null)
				return false;
		} else if (!kupac.equals(other.kupac))
			return false;
		if (narudzbina == null) {
			if (other.narudzbina != null)
				return false;
		} else if (!narudzbina.equals(other.narudzbina))
			return false;
		if (stavkaNarudzbine == null) {
			if (other.stavkaNarudzbine != null)
				return false;
		} else if (!stavkaNarudzbine.equals(other.stavkaNarudzbine))
			return false;
		return true;
	}
    
    
    
    
}