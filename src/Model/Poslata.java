/***********************************************************************
 * Module:  Poslata.java
 * Author:  Stefan
 * Purpose: Defines the Class Poslata
 ***********************************************************************/
package Model;

public class Poslata extends StanjeNarudzbine {



	public Poslata(Narudzbina narudzbina) {
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
		if(primljena) {
			narudzbina.uspesnaPosiljka();
			StanjeNarudzbine p = new Isporucena(narudzbina);
			narudzbina.promeniStanje(p);
			
		}
		else {
			narudzbina.odbijenaPosiljka();
			StanjeNarudzbine p = new Vracena(narudzbina);
			narudzbina.promeniStanje(p);
		}
	}

	@Override
	public void vracanjeNarudzbine() {
		
	}
	
	
}