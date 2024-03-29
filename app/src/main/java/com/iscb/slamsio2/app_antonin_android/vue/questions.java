package com.iscb.slamsio2.app_antonin_android.vue;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.iscb.slamsio2.app_antonin_android.Classes_crud.crud_question;
import com.iscb.slamsio2.app_antonin_android.R;
import com.iscb.slamsio2.app_antonin_android.modele.class_participation;
import com.iscb.slamsio2.app_antonin_android.modele.class_questions;

public class questions extends AppCompatActivity implements View.OnClickListener {


        //Propriétés
        private crud_question crud_question;
        private TextView lbl_question_titre;
        private TextView lbl_question_question;
        private RadioButton rbtn_choix1;
        private RadioButton rbtn_choix2;
        private RadioButton rbtn_choix3;
        private Button btn_validerquestion;
        private Button btn_question_indice;
        private class_participation laParticipation;
        private String solution;
        private String indice;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            crud_question = new crud_question();
            init();
        }

        /**
         * La procédure 'init" permet d'effectuer les tâches nécéssaire au bon lancement de l'activitée
         * ****** Elle sera appeler dans la méthode surcharger "OnCreate"
         */
        private void init(){
            //Connexion Logique -> Physique
            lbl_question_titre = (TextView)this.findViewById(R.id.lbl_question_titre);
            lbl_question_question = (TextView)this.findViewById(R.id.lbl_question_question);
            rbtn_choix1 = (RadioButton)this.findViewById(R.id.rbtn_choix1);
            rbtn_choix2 =(RadioButton)this.findViewById(R.id.rbtn_choix2);
            rbtn_choix3 = (RadioButton)this.findViewById(R.id.rbtn_choix3);
            btn_question_indice = (Button) this.findViewById(R.id.btn_question_indice);
            btn_validerquestion = (Button)this.findViewById(R.id.btn_validerquestion);

            //Mise en écoute des boutons
            btn_validerquestion.setOnClickListener(this);
            btn_question_indice.setOnClickListener(this);

            //Recuperation Extra
            laParticipation = getIntent().getParcelableExtra("participation");

        }



        private void prepareQuestion(){
            crud_question acces_question = new crud_question();
            String score = String.valueOf(laParticipation.getScore_participation());
            String nb = String.valueOf(laParticipation.getConcours_participation());
            acces_question.demande_question(score, nb);
            class_questions question = acces_question.getQuestion_en_cours();

            //Affectation graphique
            lbl_question_question.setText(question.getLibelle_question());
            rbtn_choix1.setText(question.getChoix1_question());
            rbtn_choix2.setText(question.getChoix2_question());
            rbtn_choix3.setText(question.getChoix3_question());

            //Recuperation de la reponse
            solution = question.getSolution_question();

        }

        private void show_indice(){
            //APpel de la methode dans le crud_question
            crud_question acces_question = new crud_question();
            String nb = String.valueOf(laParticipation.getConcours_participation());
            acces_question.demande_indice(nb);
            class_questions question = acces_question.getQuestion_en_cours();

            //Affectation graphique
            Context context = getApplicationContext();
            CharSequence text = question.getIndice_question();
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

        private void submit_answer(){
            //APpel de la methode dans le crud_question
            crud_question acces_question = new crud_question();
            String nb = String.valueOf(laParticipation.getConcours_participation());
            acces_question.demande_indice(nb);
            class_questions question = acces_question.getQuestion_en_cours();

            //Ecoute du radio selectionne
            if()
        }

        /**
         * Permet de gerer les actions au clique bouton
         * @param v = l'objet bouton cliqué
         */
        @Override
        public void onClick(View v) {
            Button b = (Button) v;
            if(b.getText().equals(btn_question_indice.getText())){
                show_indice();
            }
            else if (b.getText().equals(btn_validerquestion.getText())){
                RadioButton radioButton1 = (RadioButton) findViewById(R.id.rbtn_choix1);
                RadioButton radioButton2 = (RadioButton) findViewById(R.id.rbtn_choix2);
                RadioButton radioButton3 = (RadioButton) findViewById(R.id.rbtn_choix3);
                radioButton1.setOnClickListener(choix1);
                radioButton2.setOnClickListener(choix2);
                radioButton3.setOnClickListener(choix3);
                View.OnClickListener choix1 = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }

            }
        }

    }
