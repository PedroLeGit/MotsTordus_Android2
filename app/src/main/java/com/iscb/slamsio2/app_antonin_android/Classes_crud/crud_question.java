package com.iscb.slamsio2.app_antonin_android.Classes_crud;


import android.util.Log;

import com.iscb.slamsio2.app_antonin_android.modele.class_questions;
import com.iscb.slamsio2.app_antonin_android.modele.class_utilisateur;
import com.iscb.slamsio2.app_antonin_android.outils.AccesHTTP;
import com.iscb.slamsio2.app_antonin_android.outils.AsyncResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.TimeUnit;

public class crud_question implements AsyncResponse {

    //Constante de classe
    private static final String SERVERADDR = "http://192.168.43.13/crud_android/crud_questions.php";

    //Propriété
    private class_questions question_en_cours = null;

    /**
     * Retour du serveur distant
     * @param output
     */
    @Override
    public void processFinish(String output) {
        Log.d("serveur","******************************"+output);
        //découpage du message reçu avec %
        String[] message = output.split("%");

        if(message.length>1){
            if (message[0].equals("getQuestionByIdConcoursAndNbQuestion")){
                Log.d("getQuestionByIdConcours", "************************************"+message[1]);
                if(!message[1].equals("InvalidResearch")) {
                    try {
                        JSONArray info = new JSONArray(message[1]);
                        JSONObject data = info.getJSONObject(0);
                        int id_questions = data.getInt("id_questions");
                        String libelle_questions = data.getString("libelle_questions");
                        String choix1 = data.getString("choix1_questions");
                        String choix2 = data.getString("choix2_questions");
                        String choix3 = data.getString("choix3_questions");
                        String solution = data.getString("solution_questions");
                        String categorie = data.getString("libellecategorie_questions");
                        String indice = data.getString("indice_question");

                        class_questions q = new class_questions(id_questions, libelle_questions, choix1, choix2, choix3, solution, categorie, indice);
                        question_en_cours = q;

                    } catch (JSONException e) {
                        Log.d("Erreur JSON: ", "*************************************" + e);
                    }
                }
            }

        }
    }

    public void envoi(String operation, JSONArray lesDonnesJSON){
        AccesHTTP accesDonnes = new AccesHTTP();
        //lien de délegation
        accesDonnes.delegate = this;
        //ajout paramettre
        accesDonnes.addParam("operation", operation);
        accesDonnes.addParam("lesdonnes", lesDonnesJSON.toString());
        //appel au serveur
        accesDonnes.execute(SERVERADDR);
    }

    public void demande_question(String id_concours, String nb_question){
        AccesHTTP accesDonnes = new AccesHTTP();
        accesDonnes.delegate = this;
        accesDonnes.addParam("operation", "getQuestionByIdConcoursAndNbQuestion");
        accesDonnes.addParam("id_concours", id_concours);
        accesDonnes.addParam("nb_question", nb_question);
        accesDonnes.execute(SERVERADDR);
    }

    public void demande_indice(String nb_question){
        AccesHTTP accesDonnes = new AccesHTTP();
        accesDonnes.delegate = this;
        accesDonnes.addParam("operation", "getQuestionByIdConcoursAndNbQuestion");
        accesDonnes.addParam("nb_question", nb_question);
        accesDonnes.execute(SERVERADDR);
    }

    public class_questions getQuestion_en_cours(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        class_questions rep = question_en_cours;
        question_en_cours = null;
        return rep;
    }
}

