package com.iscb.slamsio2.app_antonin_android.modele;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

public class class_participation implements Parcelable {

    //Propriétés
    private int concours_participation;
    private int utilisateur_participation;
    private int score_participation;

    /**
     * Constructeur de la classe participation
     * @param concours_id
     * @param utilisateur_id
     * @param score
     */
    public class_participation(int concours_id, int utilisateur_id, int score){
        concours_participation = concours_id;
        utilisateur_participation = utilisateur_id;
        score_participation = score;
    }


    //Getter et Setter

    protected class_participation(Parcel in) {
        concours_participation = in.readInt();
        utilisateur_participation = in.readInt();
        score_participation = in.readInt();
    }

    public static final Creator<class_participation> CREATOR = new Creator<class_participation>() {
        @Override
        public class_participation createFromParcel(Parcel in) {
            return new class_participation(in);
        }

        @Override
        public class_participation[] newArray(int size) {
            return new class_participation[size];
        }
    };

    public int getConcours_participation() {
        return concours_participation;
    }

    public void setConcours_participation(int concours_participation) {
        this.concours_participation = concours_participation;
    }

    public int getUtilisateur_participation() {
        return utilisateur_participation;
    }

    public void setUtilisateur_participation(int utilisateur_participation) {
        this.utilisateur_participation = utilisateur_participation;
    }

    public int getScore_participation() {
        return score_participation;
    }

    public void setScore_participation(int score_participation) {
        this.score_participation = score_participation;
    }

    //Methodes utiles
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(concours_participation);
        dest.writeInt(utilisateur_participation);
        dest.writeInt(score_participation);
    }



}
