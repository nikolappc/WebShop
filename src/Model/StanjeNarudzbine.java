/***********************************************************************
 * Module:  StanjeNarudzbine.java
 * Author:  Dusan
 * Purpose: Defines the Class StanjeNarudzbine
 ***********************************************************************/
package Model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonTypeInfo(
		  use = JsonTypeInfo.Id.NAME, 
		  include = JsonTypeInfo.As.PROPERTY, 
		  property = "type")
@JsonSubTypes({ 
  @Type(value = Obrada.class, name = "obrada"), 
  @Type(value = Poslata.class, name = "poslata"),
  @Type(value = Vracena.class, name = "vracena"),
  @Type(value = Isporucena.class, name = "isporucena") 
})
public abstract class StanjeNarudzbine {
	
	@JsonBackReference
	protected Narudzbina narudzbina;
	
	public StanjeNarudzbine() {
		super();
		this.narudzbina = null;
	}

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

	public Narudzbina getNarudzbina() {
		return narudzbina;
	}

	public void setNarudzbina(Narudzbina narudzbina) {
		this.narudzbina = narudzbina;
	}

	@JsonIgnore
	public String nazivStanja() { return "";}

	@JsonIgnore
	public int redniBroj() {return -1;}

	
}