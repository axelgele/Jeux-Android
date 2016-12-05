package com.example.axel.projet_jeux;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Axel on 10/10/2016.
 */


public class LeJeux extends Activity
{
    final String Valeur="Valeur_Spinner";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jeu);
        Intent intent= getIntent();
        TextView afficher= (TextView) findViewById(R.id.win);
        //int value = intent.getIntExtra("Valeur");
        CustomView maCustomView = (CustomView) this.findViewById(R.id.ViewJeu);

        maCustomView.setnbBete(Integer.parseInt(intent.getStringExtra(Valeur)));

        if(intent!=null){
            afficher.setText(intent.getStringExtra(Valeur));
        }
    }

}
