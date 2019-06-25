/***********************************************************************
 * Module:  Obrada.java
 * Author:  Stefan
 * Purpose: Defines the Class Obrada
 ***********************************************************************/
package Model;

public class Obrada extends StanjeNarudzbine {

	

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
	
	
	
}