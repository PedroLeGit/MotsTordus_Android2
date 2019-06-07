package com.iscb.slamsio2.app_antonin_android.modele;

import java.util.Date;

public class class_concours {
    //  Propriétés
    private int id_concours;
    private String libelle_concours;
    private Date datedebut_concours;
    private Date datefin_concours;
    private class_utilisateur gagnant_concours;
    private String codebanniere_concours;

    //  Constructeur
    public class_concours(int unId, String unLibelle, Date debut, Date fin, String Codebanniere){
        id_concours = unId;
        libelle_concours = unLibelle;
        datedebut_concours = debut;
        datefin_concours = fin;
        codebanniere_concours = Codebanniere;
    }

    //  Accesseur
    //      Getter
    public int getId_concours(){return id_concours;}
    public String getLibelle_concours(){return libelle_concours;}
    public Date getDatedebut_concours(){return datedebut_concours;}
    public Date getDatefin_concours(){return datefin_concours;}
    public class_utilisateur getGagnant_concours(){return gagnant_concours;}
    public String getCodebanniere_encours(){return codebanniere_concours;}

    //      Setter
    public void setLibelle_concours(String data){libelle_concours = data; }
    public void setDatedebut_concours(Date data){datedebut_concours = data;}
    public void setDatefin_concours(Date data){datefin_concours = data;}
    public void setGagnant_concours(class_utilisateur data){gagnant_concours = data;}
    public void setCodebanniere_encours(String data){codebanniere_concours = data;}

    //  Methodes utiles
}
