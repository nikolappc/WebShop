package Controller;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class ProizvodController {

    public ImageView trenutnaSlika;
    public ImageView slikaProizvoda1, slikaProizvoda2, slikaProizvoda3;

    public ImageView preporucenSlika1,preporucenSlika2,preporucenSlika3;

    public Button logo;

    public void logopressed(){
        /** Korisnik pritisnuo LOGO u gornjem delu ekrana */

        logo.setText("SUKURAC");
    }

    public void traziPritisnut(){

    }

    public void pritisnutLogo(){

    }

    public void pritisnutaKategorija(){
        /** Korisnik pritisnuo kategoriju u putanji do proizvoda*/

        logo.setText("Ne DIRAJ");
    }

    public void izabranaSlika1(){
        /** Korisnik izabrao prvu sliku proizvoda koja sad treba da zauzme centralni deo prozora*/

        logo.setText("Ne DIRAJ");
    }

    public void izabranaSlika2(){
        /** Korisnik izabrao drugu sliku proizvoda koja sad treba da zauzme centralni deo prozora*/

        logo.setText("Ne DIRAJ");
    }

    public void izabranaSlika3(){
        /** Korisnik izabrao trecu sliku proizvoda koja sad treba da zauzme centralni deo prozora*/

        logo.setText("Ne DIRAJ");
    }


    public void prethodnaSlika(){
        /** Korisnik izabrao prethodnu sliku proizvoda koja sad treba da zauzme centralni deo prozora*/

    }

    public void sledecaSlika(){
        /** Korisnik izabrao sledecu sliku proizvoda koja sad treba da zauzme centralni deo prozora*/

    }

    public void dodatoUKorpu(){
        /** Korisnik dodao proizvod u korpu*/

    }

    public void dodatoUListuZelja(){
        /** Korisnik dodao proizvod u list uzelja */

    }

    public void izabranPreporucen1(){
        /** Korisnik zeli da vidi prvi preporuceni proizvod */

    }

    public void izabranPreporucen2(){
        /** Korisnik zeli da vidi drugi preporuceni proizvod */

    }

    public void izabranPreporucen3(){
        /** Korisnik zeli da vidi treci preporuceni proizvod */

    }

}
