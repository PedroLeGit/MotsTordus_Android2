package com.iscb.slamsio2.app_antonin_android.modele;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.iscb.slamsio2.app_antonin_android.outils.MySQLiteOpenHelper;

public class AccesLocal {

    //propriétes
    private String nomBase = "MotsTordus.sqlite";
    private Integer versionBase = 1;
    private MySQLiteOpenHelper accesBD;
    private SQLiteDatabase bd;

    public AccesLocal(Context contexte){
        accesBD = new MySQLiteOpenHelper(contexte,nomBase,null,versionBase);
        // il faut créer la base si n'existe pas
        bd = accesBD.getWritableDatabase();
        accesBD.onCreate(bd);
        tempInitData();
    }

    public void ajoutUtilisateur(class_utilisateur utilisateur){
        bd = accesBD.getWritableDatabase();
        String req = "INSERT INTO utilisateur (nom_utilisateur, prenom_utilisateur,pseudo_utilisateur,email_utilisateur,motdepasse_utilisateur,niveau_utilisateur,codeavatar_utilisateur) VALUES ";
        req += "(\""+ utilisateur.getNom_utilisateur() +"\",\""+utilisateur.getPrenom_utilisateur()+"\",\""+utilisateur.getPseudo_utilisateur()+"\",\""+utilisateur.getEmail_utilisateur()+"\",\""+utilisateur.getMotdepasse_utilisateur()+"\",\""+utilisateur.getNiveau_utilisateur()+"\",\""+utilisateur.getCodeavatar_utilisateur()+"\");";
        bd.execSQL(req);
    }

    public class_utilisateur recupUtilisateurByID(int id){
        class_utilisateur user = null;
        bd = accesBD.getReadableDatabase();
        String req = "";
        // intérêt de faire une requête vide ?
        req = "SELECT nom_utilisateur, prenom_utilisateur, pseudo_utilisateur,email_utilisateur,motdepasse_utilisateur,niveau_utilisateur,codeavatar_utilisateur" +
                " FROM utilisateur WHERE id_utilisateur = "+ id +";";
        Cursor curseur = bd.rawQuery(req,null);
        //if (curseur.getCount()==1){
         //si votre programme est bien fait il y a OBLIGATOIREMENT un enregistrement !
        if (curseur.moveToFirst()){
           // curseur.moveToFirst();
            /* faites PROPREMENT ....
            String nom = curseur.getString(1);
            String prenom = curseur.getString(2);
            String pseudo = curseur.getString(3);
            String email = curseur.getString(4);
            String motdepasse = curseur.getString(5);
            Integer niveau = curseur.getInt(6);
            String codeavatar = curseur.getString(7);
            */
            String nom = curseur.getString(curseur.getColumnIndex("nom_utilisateur"));
            String prenom = curseur.getString(curseur.getColumnIndex("prenom_utilisateur"));
            String pseudo = curseur.getString(curseur.getColumnIndex("pseudo_utilisateur"));
            String email = curseur.getString(curseur.getColumnIndex("email_utilisateur"));
            String motdepasse = curseur.getString(curseur.getColumnIndex("motdepasse_utilisateur"));
            Integer niveau = curseur.getInt(curseur.getColumnIndex("niveau_utilisateur"));
            String codeavatar = curseur.getString(curseur.getColumnIndex("codeavatar_utilisateur"));

            user = new class_utilisateur(id,nom,prenom,pseudo,email,motdepasse,niveau,codeavatar);
        }
        return user;
    }

    public String verifConnexion(String username, String motdepasse) {
        String loginOK = "false";
        bd = accesBD.getReadableDatabase();
        String req;
        if (username.contains("@")) {
            req = "SELECT id_utilisateur FROM utilisateur WHERE email_utilisateur LIKE \"" + username + "\" AND motdepasse_utilisateur LIKE \"" + motdepasse + "\";";
        } else {
            req = "SELECT id_utilisateur FROM utilisateur WHERE pseudo_utilisateur LIKE \"" + username + "\" AND motdepasse_utilisateur LIKE \"" + motdepasse + "\";";
        }
        Cursor curseur = bd.rawQuery(req, null);
        if (curseur.getCount() == 1) {
            //loginOK = curseur.getString(0);
            // vous ne lisez même pas me curseur !
            curseur.moveToFirst();
            //essayez proprement ....sachant que votre logique est peu juste car vous récupérer un Id de type entier pour
            // le convertir en chaine qui ressemeble franchement à une utilisation de booléen !!!
            loginOK = String.valueOf(curseur.getInt(curseur.getColumnIndex("id_utilisateur")));
        }
        return loginOK;
    }
    public void tempInitData(){
        class_utilisateur Antonin = new class_utilisateur(1,"RICHARD","Antonin","arichard","richard.antonin@outlook.fr","test37", 1,"man");
        class_utilisateur Pierre = new class_utilisateur(2,"PLAUD","Pierre-Amaury","pedro","pedro@gmail.com","37test",2,"boy.jpg");
        this.ajoutUtilisateur(Antonin);
        this.ajoutUtilisateur(Pierre);
    }
}
