/***********************************************************************
 * Module:  Isporucena.java
 * Author:  Stefan
 * Purpose: Defines the Class Isporucena
 ***********************************************************************/
package Model;


public class Isporucena extends StanjeNarudzbine {

	

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
	
	
}