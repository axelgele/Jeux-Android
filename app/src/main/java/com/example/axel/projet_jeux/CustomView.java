package com.example.axel.projet_jeux;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import static android.content.ContentValues.TAG;


/**
 * Created by Axel on 11/10/2016.
 */
//PAsser par des setter pour recuperer les valuers du spinner


public class CustomView extends View implements View.OnTouchListener {
    private ArrayList<Objet> objetList;
    //private ArrayList <Intrus> intrus;
    private static final String TAG = "CustomView";

    private Paint paint;
    private Bitmap bitmap;
    private Bitmap bitmap2;
    private Activity activity;
    private Intrus intru;
    private Random rdm;
    public int screenWidth;
    public int screenHeight;
    private int nbBete;
    private int xMax;
    private int xTouch;
    private int yMax;
    private int yTouch;
    private MediaPlayer son;
    private int choix ;


    private LeJeux nombre;
    //private String nbOcc=nombre.Valeur;

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public MediaPlayer getMediaPlayer(){return son;}

    public void setMediaplayer(MediaPlayer son) {
        this.son = son;
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        Log.d(TAG, "Nouvelle vue");

    }

    public void setnbBete(int _nbBete) {
        nbBete = _nbBete;
    }


    public void setChoix(int _choix){choix = _choix;}

    public void init() {

        paint = new Paint();
        rdm = new Random();
        objetList = new ArrayList<>();
        //intru = new ArrayList<>();
        Log.d(String.valueOf(nbBete),"Le nombre de bestiole!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

       // Log.d(choix,"Le choix!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        super.setOnTouchListener(this);
        son  = MediaPlayer.create(getContext(),R.raw.simps);






        Resources res = getResources();
        bitmap = BitmapFactory.decodeResource(res, R.drawable.objet);



        removeCallbacks(animator);
        post(animator);
        Log.d(TAG, "yes");
        }

    /* public void setNbOcc(String nombreOcc){
        this.nbOcc=nombreOcc;
    }
    public String getNbOcc(){
        return this.nbOcc;
    }*/

    private Objet addObject() {
        Objet _object;

        _object = new Objet(bitmap, screenWidth, screenHeight, rdm.nextInt(10 - 4) + 1, rdm.nextInt(12- 2) + 1);
        // Log.d(TAG, "nouvel objet");
        return _object;
    }

    private Intrus addIntru(){
        Intrus _intru;

        _intru= new Intrus(bitmap2,screenWidth,screenHeight,rdm.nextInt(6-2)+1,rdm.nextInt(7-2)+1);
        Log.d(TAG, "nouvel intru");
        return _intru;
    }

    protected void onDraw(Canvas canvas) {
        // Probleme : il rajoute un nouvel objet a mon arrayList
        //SOlution : le add doit s'executer une seule fois

                      // intru.add(this.addIntru());
                      // intru.get(0).draw(canvas);
                      // intru.get(0).update();
        Resources Intru = getResources();
        if(intru == null) {
            if (choix == 1){bitmap2 = BitmapFactory.decodeResource(Intru, R.drawable.intruun);}

           else if (choix == 2){             bitmap2 = BitmapFactory.decodeResource(Intru, R.drawable.intrudeux);}

                else{ bitmap2 = BitmapFactory.decodeResource(Intru, R.drawable.intrutrois);}

            intru = new Intrus(bitmap2,screenWidth+1,screenHeight+1, rdm.nextInt(10 - 5) + 1, rdm.nextInt(15 - 10 + 1) + 1);}

        for (int i = 0; i < nbBete; i++) {
            objetList.add(this.addObject());
            objetList.get(i).draw(canvas);
            objetList.get(i).update();
        }

        intru.draw(canvas);

        intru.update();
    }



    private Runnable animator = new Runnable() {
        @Override
        public void run() {
            invalidate();

            postDelayed(this, 10);
            //Log.d(TAG, "Run");
        }
    };


    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        screenWidth = getWidth()+1;
        screenHeight = getHeight()+1;
        xMax = this.getWidth();
        yMax = this.getHeight();
       // Log.d(TAG, "Redefinie vue.");
    }


    public void setTvToUpdate(TextView win) {
        win = win;
        //win.setText("wesh");
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {

            Log.d(TAG, "onTouch : Ecran pression.");

            xTouch = (int) motionEvent.getX() + 60;
            yTouch = (int) motionEvent.getY() + 60;
            //CustomView cv = (CustomView) findViewById(R.id.ViewJeu);
            // TextView textVictoire = (TextView)findViewById(R.id.win);
            //cv.setTvToUpdate(win);


                           if (((xTouch < (intru.getX() + intru.getObject().getWidth()) + 60) && (xTouch > (intru.getX() + intru.getObject().getWidth()) - 60)) &&
                        ((yTouch < (intru.getY() + intru.getObject().getHeight()) + 60) && (yTouch > (intru.getY() + intru.getObject().getHeight()) - 60))) {
                               son.seekTo(0);
                               son.start();
                               new AlertDialog.Builder(activity)
                               .setCancelable(false)
                                       .setTitle("C'est gagné !!!")
                                       .setMessage("T'a plié le game !")
                                       .setIcon(R.drawable.win)
                                       .setPositiveButton("Rejouer", new DialogInterface.OnClickListener() {
                                           public void onClick(DialogInterface dialog, int which) {
                                               activity.recreate();

                                           }
                                       })
                                       .setNegativeButton("Retour au menu", new DialogInterface.OnClickListener() {
                                           public void onClick(DialogInterface dialog, int which) {
                                               activity.finish();
                                           }
                                       })
                                       .show();
                                Log.d(TAG, "onTouch : Le but a Gerlaaaaaaaaand.");
                                //textVictoire.setText("poej");
                               //myAwesomeTextView.setText("Le but a Gerlaaaaaaaand");

                return true;
            }


        }
        return false;
    }
}
