/***********************************************************************
 * Module:  Narudzbina.java
 * Author:  Stefan
 * Purpose: Defines the Class Narudzbina
 ***********************************************************************/
package Model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Date;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Narudzbina {
	
	private int ID;
    private Korpa korpa;
    
    private String ime;
    private String prezime;
    private String adresa;

    private Date datum;

    
    @JsonManagedReference
    private StanjeNarudzbine trenutnoStanje;
     
    public Narudzbina() {
		super();
		trenutnoStanje = new Obrada(this);
		datum = new Date();
	}
     
    

	public Narudzbina(Korpa korpa,String ime, String prezime, String adresa) {
		super();
		this.korpa = korpa;
		this.ime = ime;
		this.prezime = prezime;
		this.adresa = adresa;
		datum = new Date();
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

	
	public String getIme() {return ime;}

	public void setIme(String novo) {ime = novo;}

	public String getPrezime() {return prezime;}

	public void setPrezime(String novo) {prezime = novo;}

	public String getAdresa() {return adresa;}

	public void setAdresa(String novo) {adresa = novo;}

	public Date getDatum() {return datum;}

	public void setDatum(Date novo) {datum = novo;}
     
}