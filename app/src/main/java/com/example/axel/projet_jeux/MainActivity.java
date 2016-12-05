package com.example.axel.projet_jeux;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity
{
    final String Valeur="Valeur_Spinner";

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        //final String number;
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);

        Button ButtonConnexion = (Button) findViewById(R.id.button6);
        ButtonConnexion.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View actuelView)
{
        Intent intent = new Intent(MainActivity.this, LeJeux.class);
        intent.putExtra(Valeur,spinner.getSelectedItem().toString());


        startActivity(intent);
}
});
    }
}
