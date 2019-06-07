package com.iscb.slamsio2.app_antonin_android.modele;

import android.os.Parcel;
import android.os.Parcelable;

public class class_questions implements Parcelable {
    //  Propriété
    private int id_question;
    private String libelle_question;
    private String choix1_question;
    private String choix2_question;
    private String choix3_question;
    private String solution_question;

    //  Construction
    public class_questions(int unId, String unLibelle, String choix1, String choix2, String choix3,String bonne_rep){
        id_question = unId;
        libelle_question = unLibelle;
        choix1_question = choix1;
        choix2_question = choix2;
        choix3_question = choix3;
        solution_question = bonne_rep;
    }
    //  Accesseurs
    //      Getter

    protected class_questions(Parcel in) {
        id_question = in.readInt();
        libelle_question = in.readString();
        choix1_question = in.readString();
        choix2_question = in.readString();
        choix3_question = in.readString();
        solution_question = in.readString();
    }

    public static final Creator<class_questions> CREATOR = new Creator<class_questions>() {
        @Override
        public class_questions createFromParcel(Parcel in) {
            return new class_questions(in);
        }

        @Override
        public class_questions[] newArray(int size) {
            return new class_questions[size];
        }
    };

    public int getId_question() {
        return id_question;
    }

    public String getLibelle_question() {
        return libelle_question;
    }

    public String getChoix1_question() {
        return choix1_question;
    }

    public String getChoix2_question() {
        return choix2_question;
    }

    public String getChoix3_question() {
        return choix3_question;
    }

    public String getSolution_question() {
        return solution_question;
    }

    //      Setter

    public void setLibelle_question(String libelle_question) {
        this.libelle_question = libelle_question;
    }

    public void setChoix1_question(String choix1_question) {
        this.choix1_question = choix1_question;
    }

    public void setChoix2_question(String choix2_question) {
        this.choix2_question = choix2_question;
    }

    public void setChoix3_question(String choix3_question) {
        this.choix3_question = choix3_question;
    }

    public void setSolution_question(String solution_question) {
        this.solution_question = solution_question;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id_question);
        dest.writeString(libelle_question);
        dest.writeString(choix1_question);
        dest.writeString(choix2_question);
        dest.writeString(choix3_question);
        dest.writeString(solution_question);
    }
}
