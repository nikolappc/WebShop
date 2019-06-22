/***********************************************************************
 * Module:  Kupac.java
 * Author:  Dusan
 * Purpose: Defines the Class Kupac
 ***********************************************************************/
package Model;
import java.util.*;

public class Kupac extends UlogovaniKorisnik {
    private String adresa;
    private String email;
    private Korpa korpa;
    private ListaZelja listaZelja;
    
    
    
    
    public Kupac() {
		super();
	}




	public Kupac(String korIme, String lozinka, String ime, String prezime) {
		super(korIme, lozinka, ime, prezime);
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



}