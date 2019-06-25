/***********************************************************************
 * Module:  Vracena.java
 * Author:  Stefan
 * Purpose: Defines the Class Vracena
 ***********************************************************************/
package Model;

/** @pdOid 51d8e964-9974-433c-8ff7-94cc00c19d19 */
public class Vracena extends StanjeNarudzbine {

	
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

}