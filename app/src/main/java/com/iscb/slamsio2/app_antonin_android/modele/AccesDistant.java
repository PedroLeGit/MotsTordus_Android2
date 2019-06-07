package com.iscb.slamsio2.app_antonin_android.modele;


import android.util.Log;

import com.iscb.slamsio2.app_antonin_android.outils.AccesHTTP;
import com.iscb.slamsio2.app_antonin_android.outils.AsyncResponse;

import org.json.JSONArray;
import org.json.JSONException;
import java.util.concurrent.TimeUnit;

public class AccesDistant implements AsyncResponse {

    //Constante de classe
    private static final String SERVERADDR = "http://192.168.43.13/crud_android/crud_utilisateur.php";

    //Propriété
    class_utilisateur utilisateur_verifie = null;

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
            if (message[0].equals("verificationLogin")){
                Log.d("verificationLogin", "************************************"+message[1]);
                if(!message[1].equals("InvalidLogin")) {
                    try {
                        Log.d("CHECKPOINT", "**********************************************************Traitement de l'entree");
                        JSONArray info = new JSONArray(message[1]);
                        Integer id = info.getJSONObject(0).getInt("id_utilisateur");
                        String nom = info.getJSONObject(0).getString("nom_utilisateur");
                        String prenom = info.getJSONObject(0).getString("prenom_utilisateur");
                        String pseudo = info.getJSONObject(0).getString("pseudo_utilisateur");
                        String email = info.getJSONObject(0).getString("nom_utilisateur");
                        String mdp = info.getJSONObject(0).getString("nom_utilisateur");
                        Integer niveau = info.getJSONObject(0).getInt("niveau_utilisateur");
                        String avatar = info.getJSONObject(0).getString("codeavatar_utilisateur");
                        class_utilisateur utilisateur = new class_utilisateur(id, nom, prenom, pseudo, email, mdp, niveau, avatar);
                        Log.d("CHECKPOINT", "**********************************************************UTILISATEUR CREER");
                        utilisateur_verifie = utilisateur;
                        Log.d("CHECKPOINT", "**********************************************************UTILISATEUR AFFECTER");

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

    public void demande_verifConnexion(String Login, String mdp){
            AccesHTTP accesDonnes = new AccesHTTP();
            accesDonnes.delegate = this;
            accesDonnes.addParam("operation", "verificationLogin");
            accesDonnes.addParam("login", Login);
            accesDonnes.addParam("mdp", mdp);
            accesDonnes.execute(SERVERADDR);
    }

    public class_utilisateur getUtilisateur_verifie(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            Log.d("SLEEP","************************************************************************"+e.getMessage());
        }
        class_utilisateur user = utilisateur_verifie;
        utilisateur_verifie=null;
        return user;
    }
}

