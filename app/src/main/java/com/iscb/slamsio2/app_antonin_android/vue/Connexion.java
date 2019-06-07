package com.iscb.slamsio2.app_antonin_android.vue;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.iscb.slamsio2.app_antonin_android.Classes_crud.crud_utilisateur;
import com.iscb.slamsio2.app_antonin_android.R;
import com.iscb.slamsio2.app_antonin_android.modele.class_utilisateur;

import java.util.concurrent.TimeUnit;

public class Connexion extends AppCompatActivity implements View.OnClickListener {


    //Propriétés
    private Button LeBouton;
    private EditText pseudo;
    private EditText mdp;
    private Button mentionslegales;
    private crud_utilisateur crudUtilisateur;
    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
        crudUtilisateur = new crud_utilisateur();
        init();
    }

    /**
     * La procédure 'init" permet d'effectuer les tâches nécéssaire au bon lancement de l'activitée
     * ****** Elle sera appeler dans la méthode surcharger "OnCreate"
     */
    private void init(){
        //Connexion Logique -> Physique
        LeBouton = (Button)this.findViewById(R.id.btn_seconnecter);
        pseudo = (EditText)this.findViewById(R.id.tbx_user);
        mdp = (EditText)this.findViewById(R.id.tbx_password);
        mentionslegales = (Button)this.findViewById(R.id.btn_mentionslegales);
        //Mise en écoute des boutons
        LeBouton.setOnClickListener(this);
        mentionslegales.setOnClickListener(this);
        //Connexion ?
        isSetNetwork();
    }

    /**
     * Permet de gerer les actions au clique bouton
     * @param v = l'objet bouton cliqué
     */
    @Override
    public void onClick(View v) {
        Button b=(Button)v;
        if (b.getText().equals(LeBouton.getText())){
            isSetNetwork();
            class_utilisateur utilisateur;
            crudUtilisateur.demande_verifConnexion(pseudo.getText().toString(), mdp.getText().toString());
            utilisateur = crudUtilisateur.getUtilisateur_verifie();
            if (utilisateur==null){
                Toast.makeText(Connexion.this,"Identifiants incorrectes", Toast.LENGTH_LONG).show();
            }else{
                Intent PageMainActivity = new Intent(this,MainActivity.class);
                PageMainActivity.putExtra("Utilisateur",utilisateur);
                this.startActivity(PageMainActivity);
            }
        }
        if (b.getText().equals(mentionslegales.getText())){
            Intent PageMentionsLegales = new Intent(this, mentions_legales.class);
            this.startActivity(PageMentionsLegales);
        }
    }

    /**
     * Permet de connaitre si l'acces réseau est disponible
     * @return vrai si dispo ou faux si pas dispo
     */
    private boolean isNetworkAvailable(){
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /**
     * Procédure qui permet de gerer les actions en fonction du statut de la connexion internet via 'isNetworkAvailabe()'
     */
    private void isSetNetwork(){
        //Verification de la connexion
        boolean NetworkStatut = isNetworkAvailable();
        //si la connexion n'est pas possible
        if(!NetworkStatut){
            //informer l'utilisateur via un toast
            Toast.makeText(Connexion.this,"Impossible de récuperer les informations ! Mode dégradé", Toast.LENGTH_LONG).show();
            //lancer l'activité 'fatal error internet'
            Intent intent = new Intent(this, erreurinternet.class);
            this.startActivity(intent);
        }
    }
}
