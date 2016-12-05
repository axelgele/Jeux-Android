package com.example.axel.projet_jeux;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.Random;

import static android.content.ContentValues.TAG;


/**
 * Created by Axel on 11/10/2016.
 */
//PAsser par des setter pour recuperer les valuers du spinner


public class CustomView extends View implements View.OnTouchListener{
    private ArrayList <Objet> objetList;
    //private ArrayList <Intrus> intrus;
    private static final String TAG = "CustomView";

    private Paint paint;
    private Bitmap bitmap;
    private Bitmap bitmap2;
    private Intrus intru;
    private int speedX,speedY;
    private Random rdm;
    public int screenWidth;
    public int screenHeight;
    private boolean bIsOk = false;
    private int nbBete;
    private int xMax;
    private int xTouch;
    private int yMax;
    private int yTouch;



    private LeJeux nombre;
    //private String nbOcc=nombre.Valeur;


    public CustomView(Context context, AttributeSet attrs){
        super (context,attrs);
        init();
        Log.d(TAG, "Nouvelle vue");

    }

    public void setnbBete(int _nbBete){
        nbBete=_nbBete;
    }

    public void  init(){

        paint=new Paint();
        rdm = new Random();
        objetList = new ArrayList<>();
        //intru = new ArrayList<>();


        Resources res=getResources();
        bitmap= BitmapFactory.decodeResource(res, R.mipmap.occ);

        Resources Intru=getResources();
        bitmap2= BitmapFactory.decodeResource(Intru, R.drawable.intru);

        removeCallbacks(animator);
        post(animator);
       // Log.d(TAG, "onTouch : Ecran pression.");
    }

    /* public void setNbOcc(String nombreOcc){
        this.nbOcc=nombreOcc;
    }
    public String getNbOcc(){
        return this.nbOcc;
    }*/

    private Objet addObject(){
        Objet _object;

        _object = new Objet(bitmap,screenWidth,screenHeight,rdm.nextInt(10 - 4)+1, rdm.nextInt(25 - 15)+1);
       // Log.d(TAG, "nouvel objet");
        return _object;
    }

   /* private Intrus addIntru(){
        Intrus _intru;

        _intru= new Intrus(bitmap2,screenWidth,screenHeight,rdm.nextInt(10-4)+1,rdm.nextInt(25-15)+1);
        Log.d(TAG, "nouvel intru");
        return _intru;
    } */

    protected void onDraw(Canvas canvas){
            // Probleme : il rajoute un nouvel objet a mon arrayList
            //SOlution : le add doit s'executer une seule fois

 //               intru.add(this.addIntru());
 //               intru.get(0).draw(canvas);
 //               intru.get(0).update();

        intru = new Intrus(bitmap2,xMax,yMax,rdm.nextInt(10 - 5)+1, rdm.nextInt(15 - 10 + 1 )+1);

        for(int i=0; i< nbBete; i++) {

                objetList.add(this.addObject());
                objetList.get(i).draw(canvas);
                objetList.get(i).update();
        }
        intru.draw(canvas);

        intru.update();
       // Log.d(TAG, "Draw");
    }


    private Runnable animator=new Runnable() {
        @Override
        public void run() {
            invalidate();

                postDelayed(this,10);
            //Log.d(TAG, "Run");
        }};


    protected void onLayout(boolean changed,int left,int top,int right,int bottom){
        super.onLayout(changed,left,top,right,bottom);

        screenWidth=getWidth();
        screenHeight=getHeight();
        xMax = this.getWidth();
        yMax = this.getHeight();
        Log.d(TAG, "Redefinie vue.");
    }


    public boolean onTouch(View view, MotionEvent motionEvent){
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {

            Log.d(TAG, "onTouch : Ecran pression.");

            xTouch = (int) motionEvent.getX() + 30;
            yTouch = (int) motionEvent.getY() + 30;

            if (((xTouch < (intru.getX() + intru.getObject().getWidth()) + 30) && (xTouch > (intru.getX() + intru.getObject().getWidth()) - 30)) &&
                    ((yTouch < (intru.getY() + intru.getObject().getHeight()) + 30) && (yTouch > (intru.getY() + intru.getObject().getHeight()) - 30))) {

                Log.d(TAG, "onTouch : You win.");
            }
            return true;
        }

        return false;
    }

}