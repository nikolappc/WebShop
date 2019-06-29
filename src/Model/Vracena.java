/***********************************************************************
 * Module:  Vracena.java
 * Author:  Stefan
 * Purpose: Defines the Class Vracena
 ***********************************************************************/
package Model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Vracena extends StanjeNarudzbine {

	
	public Vracena() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vracena(Narudzbina narudzbina) {
		super(narudzbina);
	}

	@Override
	public void entry() {
		narudzbina.povecajStanjeProizvoda();
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
	}

	@JsonIgnore
	public String nazivStanja() {
		return "Vracena";
	}

	@JsonIgnore
	public int redniBroj(){return 3;}
}