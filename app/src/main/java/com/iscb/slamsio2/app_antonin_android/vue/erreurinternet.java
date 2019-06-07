package com.iscb.slamsio2.app_antonin_android.vue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.iscb.slamsio2.app_antonin_android.R;

public class erreurinternet extends AppCompatActivity implements View.OnClickListener {

    //Propietes
    private Button btn_restart;
    private Button btn_close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erreurinternet);
        init();
    }
    private void init(){
        //Connexion logique -> physique
        btn_restart = (Button)findViewById(R.id.btn_restart);
        btn_close = (Button)findViewById(R.id.btn_close);
        btn_restart.setOnClickListener(this);
        btn_close.setOnClickListener(this);
        //

    }

    @Override
    public void onClick(View v) {
        Button b = (Button)v;
        if (b.getText().equals(btn_restart.getText())){
            Intent i = getBaseContext().getPackageManager().
                    getLaunchIntentForPackage(getBaseContext().getPackageName());
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
        }
        if(b.getText().equals(btn_close.getText())){
            this.finishAffinity();
        }
    }

    //Desactiver la possibilité de retourner à l'activité précédente
    @Override
    public void onBackPressed() {
    }
}
