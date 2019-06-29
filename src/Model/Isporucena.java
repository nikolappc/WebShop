/***********************************************************************
 * Module:  Isporucena.java
 * Author:  Stefan
 * Purpose: Defines the Class Isporucena
 ***********************************************************************/
package Model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

public class Isporucena extends StanjeNarudzbine {

	

	public Isporucena() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Isporucena(Narudzbina narudzbina) {
		super(narudzbina);
	}

	@Override
	public void entry() {
		
	}

	@Override
	public void exit() {
		
	}

	@Override
	public void zavrsenaFaktura() {
		
	}

	@Override
	public void otkazivanjeNarudzbine() {
		
	}

	@Override
	public void porudzbinaStigla(boolean primljena) {
		
	}

	@Override
	public void vracanjeNarudzbine() {
		narudzbina.povratakNarudzbine();
		StanjeNarudzbine p = new Vracena(narudzbina);
		narudzbina.promeniStanje(p);
	}

	@JsonIgnore
	public String nazivStanja() {
		return "Isporucena";
	}

	@JsonIgnore
	public int redniBroj(){return 2;}


}