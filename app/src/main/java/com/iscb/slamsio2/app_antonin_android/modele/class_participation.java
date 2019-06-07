package com.iscb.slamsio2.app_antonin_android.modele;

public class class_participation {

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



}
