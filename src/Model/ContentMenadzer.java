/***********************************************************************
 * Module:  ContentMenadzer.java
 * Author:  Stefan
 * Purpose: Defines the Class ContentMenadzer
 ***********************************************************************/
package Model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

public class ContentMenadzer extends UlogovaniKorisnik {

	public ContentMenadzer() {
		super();
	}

	public ContentMenadzer(String korIme, String lozinka, String ime, String prezime) {
		super(korIme, lozinka, ime, prezime);
	}
	
	
}