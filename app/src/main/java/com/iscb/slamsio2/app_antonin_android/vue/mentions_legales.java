package com.iscb.slamsio2.app_antonin_android.vue;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.iscb.slamsio2.app_antonin_android.R;

public class mentions_legales extends AppCompatActivity implements View.OnClickListener {
    //Variables
    private ImageView btn_back;
    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentions_legales);

        //Lien logique -> physique
        btn_back = (ImageView) this.findViewById(R.id.ml_btn_retour);
        //
        btn_back.setOnClickListener(this);
    }

    public void onClick(View v) {
        finish();
    }
}
