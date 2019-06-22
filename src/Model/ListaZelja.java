/***********************************************************************
 * Module:  ListaZelja.java
 * Author:  Stefan
 * Purpose: Defines the Class ListaZelja
 ***********************************************************************/
package Model;
import java.util.*;

public class ListaZelja {
	private Collection<Proizvod> proizvod = new ArrayList<Proizvod>();
    
	
	
	
    public ListaZelja() {
		super();
	}
    
    

	public ListaZelja(Collection<Proizvod> proizvod) {
		super();
		for (Proizvod proizvod2 : proizvod) {
			this.proizvod.add(proizvod2);
		}
	}



    public void obavestiOPopustu() {
        // TODO: implement
    }


    public Collection<Proizvod> getProizvod() {
        return proizvod;
    }


    public void setProizvod(Collection<Proizvod> newProizvod) {
        this.proizvod.clear();
        for (Proizvod proizvod : newProizvod) {
			this.proizvod.add(proizvod);
		}
    }
    

    public void dodajProizvod(Proizvod newProizvod) {
        if (newProizvod == null)
            return;
        if (!this.proizvod.contains(newProizvod))
            this.proizvod.add(newProizvod);
    }

    public void izbaciProizvod(Proizvod oldProizvod) {
        if (oldProizvod == null)
            return;
        if (this.proizvod != null)
            if (this.proizvod.contains(oldProizvod))
                this.proizvod.remove(oldProizvod);
    }






	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListaZelja other = (ListaZelja) obj;
		if (proizvod == null) {
			if (other.proizvod != null)
				return false;
		} else if (!proizvod.equals(other.proizvod))
			return false;
		return true;
	}
    
    

}