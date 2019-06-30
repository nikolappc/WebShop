/***********************************************************************
 * Module:  Korpa.java
 * Author:  Dusan
 * Purpose: Defines the Class Korpa
 ***********************************************************************/
package Model;
import javafx.beans.InvalidationListener;

import java.util.*;

public class Korpa extends Observable {
    private Narudzbina narudzbina;
    private List<StavkaNarudzbine> stavkeNarudzbine = new ArrayList<StavkaNarudzbine>();
    private Kupac kupac;
    

    public Korpa() {
		super();
		stavkeNarudzbine = new ArrayList<StavkaNarudzbine>();
	}

	public Korpa(Narudzbina narudzbina, List<StavkaNarudzbine> stavkaNarudzbine, Kupac kupac) {
		super();
		this.narudzbina = narudzbina;
		for (StavkaNarudzbine stavkaNarudzbine2 : stavkaNarudzbine) {
			this.stavkeNarudzbine.add(stavkaNarudzbine2);
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

	public void dodajProizvod(StavkaNarudzbine sn) {

    	for( StavkaNarudzbine stavka : stavkeNarudzbine){
    		if(stavka.getProizvod() == sn.getProizvod() && stavka.getVelicina().equals(sn.getVelicina())){
    			stavka.setKolicina(stavka.getKolicina()+1) ;
				setChanged();
				notifyObservers(ukupnaCena());
    			return;
			}
		}
    	stavkeNarudzbine.add(sn);
    }
    
    public boolean ukloniProizvod(StavkaNarudzbine sn) {

    	for(StavkaNarudzbine stavka : stavkeNarudzbine){
    		if(stavka == sn){
    			stavkeNarudzbine.remove(stavka);
				setChanged();
				notifyObservers(ukupnaCena());
    			return true;
			}
		}
        return false;
    }
    
    public void izmeniKolicinuZaProizvod(StavkaNarudzbine sn, int zaKoliko) {

		for(StavkaNarudzbine stavka : stavkeNarudzbine){
			if(stavka == sn){
				if(stavka.getKolicina() == 1 && zaKoliko < 0)
					stavkeNarudzbine.remove(stavka);
				else{
					stavka.setKolicina(stavka.getKolicina() + zaKoliko);
				}
				setChanged();
				notifyObservers(ukupnaCena());
				return;
			}
		}
    }
    
    public List<StavkaNarudzbine> getStavkaNarudzbine() {
         return stavkeNarudzbine;
    }
    
    public void setStavkaNarudzbine(List<StavkaNarudzbine> newStavkaNarudzbine) {
        this.stavkeNarudzbine.clear();;
        for (StavkaNarudzbine stavkaNarudzbine : newStavkaNarudzbine) {
			this.stavkeNarudzbine.add(stavkaNarudzbine);
		}
    }
    
    public void dodajStavkaNarudzbine(StavkaNarudzbine newStavkaNarudzbine) {
        if (newStavkaNarudzbine == null)
            return;
        if (!this.stavkeNarudzbine.contains(newStavkaNarudzbine))
            this.stavkeNarudzbine.add(newStavkaNarudzbine);
    }
    
    public void izbaciStavkaNarudzbine(StavkaNarudzbine oldStavkaNarudzbine) {
        if (oldStavkaNarudzbine == null)
            return;
        if (this.stavkeNarudzbine != null)
            if (this.stavkeNarudzbine.contains(oldStavkaNarudzbine))
                this.stavkeNarudzbine.remove(oldStavkaNarudzbine);
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
		if (stavkeNarudzbine == null) {
			if (other.stavkeNarudzbine != null)
				return false;
		} else if (!stavkeNarudzbine.equals(other.stavkeNarudzbine))
			return false;
		return true;
	}
    
    public int ukupnaCena(){
		int cena = 0;

		for(StavkaNarudzbine stavka: stavkeNarudzbine){
			cena += (stavka.getCena()*stavka.getKolicina());
		}

    	return cena;
	}

}