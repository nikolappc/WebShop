/***********************************************************************
 * Module:  AtributKategorije.java
 * Author:  nklppc
 * Purpose: Defines the Class AtributKategorije
 ***********************************************************************/

package Model;

import java.util.*;


public class AtributKategorije {
    
	private Collection<VrednostAtributa> vrednostAtributa = new ArrayList<VrednostAtributa>();
    
    
    
    
    public AtributKategorije() {}
    
    
    
    
    public AtributKategorije(Collection<VrednostAtributa> vrednostAtributa) {
	    
	    for (VrednostAtributa vr : vrednostAtributa) {
			  this.vrednostAtributa.add(vr);
		}
    }

    
    public Collection<VrednostAtributa> getVrednostAtributa() {
	    return vrednostAtributa;
    }
    
    public void setVrednostAtributa(Collection<VrednostAtributa> newVrednostAtributa) {
	  this.vrednostAtributa.clear();
	  for (VrednostAtributa vrednostAtributa : newVrednostAtributa) {
		  this.vrednostAtributa.add(vrednostAtributa);
	}
    }
    
    public void dodajVrednostAtributa(VrednostAtributa newVrednostAtributa) {
        if (newVrednostAtributa == null)
            return;
        if (!this.vrednostAtributa.contains(newVrednostAtributa))
        {
            this.vrednostAtributa.add(newVrednostAtributa);
            newVrednostAtributa.setAtributKategorije(this);        
        }
    }

    public void izbaciVrednostAtributa(VrednostAtributa oldVrednostAtributa) {
        if (oldVrednostAtributa == null)
            return;
        if (this.vrednostAtributa != null)
            if (this.vrednostAtributa.contains(oldVrednostAtributa))
                this.vrednostAtributa.remove(oldVrednostAtributa);
    }


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AtributKategorije other = (AtributKategorije) obj;
		if (vrednostAtributa == null) {
			if (other.vrednostAtributa != null)
				return false;
		} else if (!vrednostAtributa.equals(other.vrednostAtributa))
			return false;
		return true;
}
    
    
    
  
    
    
    
    
}