/***********************************************************************
 * Module:  Narudzbina.java
 * Author:  Stefan
 * Purpose: Defines the Class Narudzbina
 ***********************************************************************/
package Model;

public class Narudzbina {
    private Korpa korpa;
     
    private StanjeNarudzbine trenutnoStanje;
     
    public Narudzbina() {
		super();
		trenutnoStanje = new Obrada(this);
	}
     
    

	public Narudzbina(Korpa korpa) {
		super();
		this.korpa = korpa;
	}

	
	public void narudzbinaPrimljena() {
		
	}
	
    public String generisiFakturu() {
        // TODO: implement
        return null;
    }
    
    public void zavrsenaFaktura() {
        trenutnoStanje.zavrsenaFaktura();
    }
    
    public void poslataPosiljka() {
        // TODO: implement
    }
    
    public void otkazivanjeNarudzbine() {
        trenutnoStanje.otkazivanjeNarudzbine();
    }
    
    /** @param primljena **/
    public void porudzbinaStigla(boolean primljena) {
        trenutnoStanje.porudzbinaStigla(primljena);
    }
    
    public void odbijenaPosiljka() {
        // TODO: implement
    }
    
    public void uspesnaPosiljka() {
        // TODO: implement
    }
    
    public void vracanjeNarudzbine() {
        trenutnoStanje.vracanjeNarudzbine();
    }
    
    public void povecajStanjeProizvoda() {
        // TODO: implement
    }
    
    public void povratakNarudzbine() {
        // TODO: implement
    }
    
    /** @param novoStanje **/
    public void promeniStanje(StanjeNarudzbine novoStanje) {
        this.trenutnoStanje.exit();
        this.trenutnoStanje = novoStanje;
        this.trenutnoStanje.entry();
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