/***********************************************************************
 * Module:  Narudzbina.java
 * Author:  Stefan
 * Purpose: Defines the Class Narudzbina
 ***********************************************************************/
package Model;

public class Narudzbina {
	private int ID;
    private Korpa korpa;
    
    private String ime;
    private String prezime;
    private String adresa;
     
    private StanjeNarudzbine trenutnoStanje;
     
    public Narudzbina() {
		super();
		trenutnoStanje = new Obrada(this);
	}
     
    

	public Narudzbina(Korpa korpa,String ime, String prezime, String adresa) {
		super();
		this.korpa = korpa;
		trenutnoStanje = new Obrada(this);
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



	public int getID() {
		return ID;
	}



	public void setID(int iD) {
		ID = iD;
	}



	public StanjeNarudzbine getTrenutnoStanje() {
		return trenutnoStanje;
	}



	public void setTrenutnoStanje(StanjeNarudzbine trenutnoStanje) {
		this.trenutnoStanje = trenutnoStanje;
	}

	
	
     
     
}