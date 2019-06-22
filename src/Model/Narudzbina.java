/***********************************************************************
 * Module:  Narudzbina.java
 * Author:  Stefan
 * Purpose: Defines the Class Narudzbina
 ***********************************************************************/
package Model;
import java.util.*;

public class Narudzbina {
    private Korpa korpa;
    
    
    
    
    
    public Narudzbina() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Narudzbina(Korpa korpa) {
		super();
		this.korpa = korpa;
	}

	public String generisiFakturu() {
        // TODO: implement
        return null;
    }
    
    public void povecajStanjeProizvoda() {
        // TODO: implement
    }
    
    public void poslataPosiljka() {
        // TODO: implement
    }
    
    public void uspesnaIsporuka() {
        // TODO: implement
    }
    
    public void neuspesnaIsporuka() {
        // TODO: implement
    }
    
    public void kupacPoslaoNatrag() {
        // TODO: implement
    }
    
    public void uspesnoVracena() {
        // TODO: implement
    }
    
    public void neuspesnoVracena() {
        // TODO: implement
    }
    
    public void promeniStanje() {
        // TODO: implement
    }



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Narudzbina other = (Narudzbina) obj;
		if (korpa == null) {
			if (other.korpa != null)
				return false;
		} else if (!korpa.equals(other.korpa))
			return false;
		return true;
	}

	public Korpa getKorpa() {
		return korpa;
	}

	public void setKorpa(Korpa korpa) {
		this.korpa = korpa;
	}

    
    
}