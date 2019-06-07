package com.iscb.slamsio2.app_antonin_android.modele;

public class class_livre {
    //  Propriete
    private String ISBN;
    private String titre_livre;
    private String auteurprincipal_livre;
    private String tome_livre;
    private String genre_livre;
    private String codeimage_livre;

    //  Constructeur
    public class_livre(String unISBN, String unTitre, String unAuteurprincipale, String unTome, String unGenre, String unCodeimage){
        ISBN = unISBN;
        titre_livre = unTitre;
        auteurprincipal_livre = unAuteurprincipale;
        tome_livre = unTome;
        genre_livre = unGenre;
        codeimage_livre = unCodeimage;
    }


    //  Accesseur
    //      Getter

    public String getISBN() {
        return ISBN;
    }

    public String getTitre_livre() {
        return titre_livre;
    }

    public String getAuteurprincipal_livre() {
        return auteurprincipal_livre;
    }

    public String getTome_livre() {
        return tome_livre;
    }

    public String getGenre_livre() {
        return genre_livre;
    }

    public String getCodeimage_livre() {
        return codeimage_livre;
    }

    //      Setter


    public void setTitre_livre(String titre_livre) {
        this.titre_livre = titre_livre;
    }

    public void setAuteurprincipal_livre(String auteurprincipal_livre) {
        this.auteurprincipal_livre = auteurprincipal_livre;
    }

    public void setTome_livre(String tome_livre) {
        this.tome_livre = tome_livre;
    }

    public void setGenre_livre(String genre_livre) {
        this.genre_livre = genre_livre;
    }

    public void setCodeimage_livre(String codeimage_livre) {
        this.codeimage_livre = codeimage_livre;
    }

    //  Methodes utiles
}
