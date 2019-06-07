package com.iscb.slamsio2.app_antonin_android.vue;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.iscb.slamsio2.app_antonin_android.R;
import com.iscb.slamsio2.app_antonin_android.modele.class_utilisateur;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Propriétés
    private Button btn_deconnexion;
    private Button btn_moncompte;
    private Button btn_participer;
    private Button btn_concoursvenir;
    private ImageView img_avatar;
    private TextView lbl_pseudo;
    private class_utilisateur utilisateur;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        //Connexion logique -> physique
        btn_deconnexion = (Button)findViewById(R.id.btn_gotodeconnexion);
        btn_moncompte = (Button)findViewById(R.id.btn_gotomoncompte);
        btn_participer = (Button)findViewById(R.id.btn_gotoquizz);
        btn_concoursvenir = (Button)findViewById(R.id.btn_concoursavenir);
        img_avatar = (ImageView)findViewById(R.id.img_avatar);
        lbl_pseudo = (TextView)findViewById(R.id.lbl_pseudo);
        //Ecoute bouton
        btn_deconnexion.setOnClickListener(this);
        btn_moncompte.setOnClickListener(this);
        btn_participer.setOnClickListener(this);
        btn_concoursvenir.setOnClickListener(this);
        //Recuperation du profil en extra
        utilisateur = getIntent().getParcelableExtra("Utilisateur");
        //Affectation aux view des données utilisateurs
        lbl_pseudo.setText(utilisateur.getPseudo_utilisateur());
        Log.d("getter parcelable:", "******************************"+utilisateur.getId_utilisateur());
        Log.d("getter parcelable:", "******************************"+utilisateur.getPrenom_utilisateur());
        Log.d("getter parcelable:", "******************************"+utilisateur.getNom_utilisateur());
        Log.d("getter parcelable:", "******************************"+utilisateur.getPseudo_utilisateur());
        Log.d("getter parcelable:", "******************************"+utilisateur.getEmail_utilisateur());
        Log.d("getter parcelable:", "******************************"+utilisateur.getMotdepasse_utilisateur());
        Log.d("getter parcelable:", "******************************"+utilisateur.getNiveau_utilisateur());
        Log.d("getter parcelable:", "******************************"+utilisateur.getCodeavatar_utilisateur());
        imgSetter(utilisateur.getCodeavatar_utilisateur());

    }

    private void imgSetter(String input){
        switch (input){
            case("boy"):
                img_avatar.setImageResource(R.drawable.boy);
                break;

            case("boy1"):
                img_avatar.setImageResource(R.drawable.boy1);
                break;

            case("girl"):
                img_avatar.setImageResource(R.drawable.girl);
                break;

            case("girl1"):
                img_avatar.setImageResource(R.drawable.girl1);
                break;

            case("man"):
                img_avatar.setImageResource(R.drawable.man);
                break;

            case("man1"):
                img_avatar.setImageResource(R.drawable.man1);
                break;

            case("man2"):
                img_avatar.setImageResource(R.drawable.man2);
                break;

            case("woman"):
                img_avatar.setImageResource(R.drawable.woman);
                break;

            case("woman1"):
                img_avatar.setImageResource(R.drawable.woman1);
                break;

            default:
                img_avatar.setImageResource(R.drawable.error);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        Button b = (Button)v;
        if (b.getText().equals(btn_deconnexion.getText())){
            finish();
        }
        if(b.getText().equals(btn_moncompte.getText())){

        }
        if (b.getText().equals(btn_participer.getText())){

        }
        if (b.getText().equals(btn_concoursvenir.getText())){

        }
    }
}
