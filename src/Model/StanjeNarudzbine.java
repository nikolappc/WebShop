/***********************************************************************
 * Module:  StanjeNarudzbine.java
 * Author:  Dusan
 * Purpose: Defines the Class StanjeNarudzbine
 ***********************************************************************/
package Model;

public abstract class StanjeNarudzbine {
	
	protected Narudzbina narudzbina;
	
	

	public StanjeNarudzbine(Narudzbina narudzbina) {
		super();
		this.narudzbina = narudzbina;
	}

	abstract public void entry();
	
	abstract public void exit();
	
	abstract public void zavrsenaFaktura();
    
	abstract public void otkazivanjeNarudzbine();
    
    /** @param primljena **/
	abstract public void porudzbinaStigla(boolean primljena);
    
	abstract public void vracanjeNarudzbine();
}