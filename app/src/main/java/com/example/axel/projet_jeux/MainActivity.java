package com.example.axel.projet_jeux;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity
{
    String Valeur="Valeur_Spinner";
    String ChoixJoueur;

    String choix = "0";

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        //final String number;


        final Spinner spinner = (Spinner) findViewById(R.id.spinner);

        Button ButtonConnexion = (Button) findViewById(R.id.button6);
        final CheckBox para1 = (CheckBox) findViewById(R.id.button2);
        final CheckBox para2 = (CheckBox) findViewById(R.id.button3);
        final CheckBox para3 = (CheckBox) findViewById(R.id.button4);

//        checkBox = (CheckBox)findViewById(R.id.button2);
        para1.setChecked(true);

        para1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (para1.isChecked() == true){

                    para3.setChecked(false);
                    para2.setChecked(false);
                    choix = "1";
                }
            }
        });

        para2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (para2.isChecked() == true){

                    para1.setChecked(false);
                    para3.setChecked(false);
                    choix = "2";
                }
            }
        });

        para3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (para3.isChecked() == true){

                    para1.setChecked(false);
                    para2.setChecked(false);
                    choix = "3";
                }
            }
        });






        ButtonConnexion.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View actuelView)
{
        Intent intent = new Intent(MainActivity.this, LeJeux.class);
        //Bundle extras = new Bundle();


        intent.putExtra("val1",spinner.getSelectedItem().toString());

        intent.putExtra("val2",choix);


      //  Log.d(String.valueOf(intent),"voici l'intent");

        startActivity(intent);

}
});
    }
}
