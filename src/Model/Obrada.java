/***********************************************************************
 * Module:  Obrada.java
 * Author:  Stefan
 * Purpose: Defines the Class Obrada
 ***********************************************************************/
package Model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Obrada extends StanjeNarudzbine {

	

	public Obrada() {
		super();
	}

	public Obrada(Narudzbina narudzbina) {
		super(narudzbina);
	}

	@Override
	public void entry() {
		narudzbina.generisiFakturu();
	}

	@Override
	public void exit() {
		
	}

	@Override
	public void zavrsenaFaktura() {
		narudzbina.poslataPosiljka();
		StanjeNarudzbine p = new Poslata(narudzbina);
		narudzbina.promeniStanje(p);
	}

	@Override
	public void otkazivanjeNarudzbine() {
		StanjeNarudzbine p = new Vracena(narudzbina);
		narudzbina.promeniStanje(p);
	}

	@Override
	public void porudzbinaStigla(boolean primljena) {
		
	}

	@Override
	public void vracanjeNarudzbine() {
		
	}

	@JsonIgnore
	public String nazivStanja() {
		return "Obradjuje se";
	}

	@JsonIgnore
	public int redniBroj(){return 0;}


}