/***********************************************************************
 * Module:  Kupac.java
 * Author:  Dusan
 * Purpose: Defines the Class Kupac
 ***********************************************************************/
package Model;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.*;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Kupac extends UlogovaniKorisnik {
    private String adresa;
    private String email;
    private Korpa korpa;
    private ListaZelja listaZelja;
    private List<Narudzbina> narudzbine = new ArrayList<Narudzbina>();
    public Kupac() {

    	super();
		this.korpa = new Korpa();
		this.listaZelja = new ListaZelja();
	}

	public Kupac(String korIme, String lozinka, String ime, String prezime,
				 String adresa, String email) {
		super(korIme, lozinka, ime, prezime);
		this.adresa = adresa;
		this.email = email;
		this.korpa = new Korpa();
		this.listaZelja = new ListaZelja();
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Korpa getKorpa() {
		return korpa;
	}

	public void setKorpa(Korpa korpa) {
		this.korpa = korpa;
	}

	public ListaZelja getListaZelja() {
		return listaZelja;
	}

	public void setListaZelja(ListaZelja listaZelja) {
		this.listaZelja = listaZelja;
	}

	
	public void dodajNarudzbine(Narudzbina n) {
		this.narudzbine.add(n);
	}
	
	public List<Narudzbina> getNarudzbine() {
		return narudzbine;
	}

	public void setNarudzbine(List<Narudzbina> narudzbine) {
		this.narudzbine = narudzbine;
	}

}