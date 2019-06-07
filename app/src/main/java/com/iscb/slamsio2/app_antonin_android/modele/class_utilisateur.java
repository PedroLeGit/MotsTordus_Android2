package com.iscb.slamsio2.app_antonin_android.modele;

import android.os.Parcel;
import android.os.Parcelable;

import com.iscb.slamsio2.app_antonin_android.R;

import java.lang.reflect.Field;

public class class_utilisateur implements Parcelable {
    //Propriétés de la classe
    private int id_utilisateur;
    private String nom_utilisateur;
    private String prenom_utilisateur;
    private String pseudo_utilisateur;
    private String email_utilisateur;
    private String motdepasse_utilisateur;
    private int niveau_utilisateur;
    private String codeavatar_utilisateur;

    //Constructeur
    public class_utilisateur(int unId_utilisateur, String unNom_utilisateur, String unPrenom_utilisateur, String unPseudo_utlisateur, String unEmail_utilisateur, String unMotdepasse_utilisateur, int unNiveau_utilisateur, String unCodeavatar_utilisateur){
        id_utilisateur = unId_utilisateur;
        nom_utilisateur = unNom_utilisateur;
        prenom_utilisateur = unPrenom_utilisateur;
        pseudo_utilisateur = unPseudo_utlisateur;
        email_utilisateur = unEmail_utilisateur;
        motdepasse_utilisateur = unMotdepasse_utilisateur;
        niveau_utilisateur = unNiveau_utilisateur;
        codeavatar_utilisateur = unCodeavatar_utilisateur;
    }

    protected class_utilisateur(Parcel in) {
        id_utilisateur = in.readInt();
        nom_utilisateur = in.readString();
        prenom_utilisateur = in.readString();
        pseudo_utilisateur = in.readString();
        email_utilisateur = in.readString();
        motdepasse_utilisateur = in.readString();
        niveau_utilisateur = in.readInt();
        codeavatar_utilisateur = in.readString();
    }

    public static final Creator<class_utilisateur> CREATOR = new Creator<class_utilisateur>() {
        @Override
        public class_utilisateur createFromParcel(Parcel in) {
            return new class_utilisateur(in);
        }

        @Override
        public class_utilisateur[] newArray(int size) {
            return new class_utilisateur[size];
        }
    };

    //  Accesseur
    //      Getter
    public int getId_utilisateur(){return id_utilisateur;}
    public String getNom_utilisateur(){return nom_utilisateur;}
    public String getPrenom_utilisateur(){return prenom_utilisateur;}
    public String getPseudo_utilisateur(){return pseudo_utilisateur;}
    public String getEmail_utilisateur(){return email_utilisateur;}
    public String getMotdepasse_utilisateur(){return motdepasse_utilisateur;}
    public int getNiveau_utilisateur(){return niveau_utilisateur;}
    public String getCodeavatar_utilisateur(){return codeavatar_utilisateur;}

    //      Setter
    // public void setNom_utilisateur(String data){nom_utilisateur = data;}
    // public void setPrenom_utilisateur(String data){prenom_utilisateur = data;}
    // public void setPseudo_utilisateur(String data){pseudo_utilisateur = data;}
    // public void setEmail_utilisateur(String data){email_utilisateur = data;}
    // public void setMotdepasse_utilisateur(String data){motdepasse_utilisateur = data;}
    // public void setNiveau_utilisateur(Integer data){niveau_utilisateur = data;}
    // public void setCodeavatar_utilisateur(String data){codeavatar_utilisateur = data;}



    //Methodes utiles

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id_utilisateur);
        dest.writeString(nom_utilisateur);
        dest.writeString(prenom_utilisateur);
        dest.writeString(pseudo_utilisateur);
        dest.writeString(email_utilisateur);
        dest.writeString(motdepasse_utilisateur);
        dest.writeInt(niveau_utilisateur);
        dest.writeString(codeavatar_utilisateur);
    }
}

