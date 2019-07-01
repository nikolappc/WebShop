package Model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Prodavnica {
   private String naziv;
   private String adresa;
   private String slika;

   
   
   public Prodavnica() {
	super();
   }



	public Prodavnica(String naziv, String adresa, String slika) {
		super();
		this.naziv = naziv;
		this.adresa = adresa;
		this.slika = slika;
	}



	public String getNaziv() {
		return naziv;
	}



	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}



	public String getAdresa() {
		return adresa;
	}



	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}



	public String getSlika() {
		return slika;
	}



	public void setSlika(String slika) {
		this.slika = slika;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prodavnica other = (Prodavnica) obj;
		if (adresa == null) {
			if (other.adresa != null)
				return false;
		} else if (!adresa.equals(other.adresa))
			return false;
		if (naziv == null) {
			if (other.naziv != null)
				return false;
		} else if (!naziv.equals(other.naziv))
			return false;
		if (slika == null) {
			if (other.slika != null)
				return false;
		} else if (!slika.equals(other.slika))
			return false;
		return true;
	}

	
   
   
}



