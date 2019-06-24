/***********************************************************************
 * Module:  ContentMenadzer.java
 * Author:  Stefan
 * Purpose: Defines the Class ContentMenadzer
 ***********************************************************************/
package Model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

public class ContentMenadzer extends UlogovaniKorisnik {
	private String adresa;
    private String email;
	
	public ContentMenadzer() {
		super();
	}

	public ContentMenadzer(String korIme, String lozinka, String ime, String prezime,String email, String adresa) {
		super(korIme, lozinka, ime, prezime);
		this.adresa = adresa;
		this.email = email;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
	
}