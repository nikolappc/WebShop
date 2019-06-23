/***********************************************************************
 * Module:  AtributKategorije.java
 * Author:  nklppc
 * Purpose: Defines the Class AtributKategorije
 ***********************************************************************/

package Model;

import java.util.*;


public class AtributKategorije {

	private String naziv;

	private Map<Object, VrednostAtributa> vrednostAtributa = new HashMap<>();

    
    public AtributKategorije() {}

	public AtributKategorije(String naziv) {
		this.naziv = naziv;
	}


    public Map<Object, VrednostAtributa> getVrednostAtributa() {
	    return vrednostAtributa;
    }
    

    public void dodajVrednostAtributa(VrednostAtributa newVrednostAtributa) {
        if (newVrednostAtributa == null)
            return;
        if (!this.vrednostAtributa.containsKey(newVrednostAtributa.getVrednost()))
        {
            this.vrednostAtributa.put(newVrednostAtributa.getVrednost(),newVrednostAtributa);
            newVrednostAtributa.setAtributKategorije(this);        
        }
    }

    public void izbaciVrednostAtributa(VrednostAtributa oldVrednostAtributa) {
        if (oldVrednostAtributa == null)
            return;
        if (this.vrednostAtributa != null)
            if (this.vrednostAtributa.containsKey(oldVrednostAtributa.getVrednost()))
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


	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	/*
	    Vraca vrednost atributa ako postoji sa ovakvom vrednoscu,inace pravi novu za zadatu vrednost
	 */
    public VrednostAtributa napraviVrednostAtributa(Object vrednost) {
        if (vrednostAtributa.containsKey(vrednost))
        return vrednostAtributa.get(vrednost);
        VrednostAtributa va = new VrednostAtributa(vrednost);
        vrednostAtributa.put(vrednost, va);
        return va;
    }
}