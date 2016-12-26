package com.example.axel.projet_jeux;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Spinner;
import android.widget.TextView;

import static android.content.ContentValues.TAG;

/**
 * Created by Axel on 10/10/2016.
 */


public class LeJeux extends Activity
{
    final String Valeur="Valeur_Spinner";
    String  ChoixJoueur = "Choix_Du_Joueur";

    //String choix = "intruun";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jeu);

        String val1 = getIntent().getExtras().getString("val1");
        String val2 = getIntent().getExtras().getString("val2");

        Log.d("test intent",val1);
        Log.d("test intru",val2);

        Intent intent= getIntent();

        CustomView maCustomView = (CustomView) this.findViewById(R.id.ViewJeu);

        maCustomView.setActivity(this);

       // mp = MediaPlayer.create(R.raw.musicwin);

        maCustomView.setnbBete(Integer.parseInt(val1));//Marche !

        Log.d("Valuer Intru",val2);

        maCustomView.setChoix(Integer.parseInt(val2));

    }
}
