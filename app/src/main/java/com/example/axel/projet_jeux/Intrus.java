package com.example.axel.projet_jeux;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.Random;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

import java.util.Random;

import static android.R.attr.bitmap;

/**
 * Created by Axel on 04/11/2016.
 */

public class Intrus {
    private Random rdm;
    private Bitmap mObjet;
    private int mxMax = 0;
    private int mxSpeed;
    private int myMax = 0;
    private int mySpeed;
    private  float x;
    private  float y;

    public float getX() { return x; }
    public  float getY() { return y; }
    public Bitmap getObject() { return mObjet; }

    public Intrus(Bitmap object,int xM, int yM,int xSpeed,int ySpeed){
        this.mObjet=object;
        this.mxMax=xM;
        this.myMax=yM;
        this.mxSpeed = xSpeed + 8;
        this.mySpeed = ySpeed + 8;

        init();
    }

    public void  init(){
        rdm = new Random();

        x = rdm.nextInt(mxMax - 0)+1;
        y = rdm.nextInt(myMax - 0)+1;
    }

    public void update() { // PAs a moi

        x += mxSpeed;
        y += mySpeed;

        //Faire une layout et lui dire de pas depasser les bords de cette layout

        if (x > mxMax-mObjet.getWidth() || x < 0) {
            mxSpeed = mxSpeed*-1;
            //number.changeText();}
        }
        if (y > myMax-mObjet.getHeight() || y < 0) {
            mySpeed = mySpeed*-1;
        }

    }


    public void draw(Canvas canvas) {
        canvas.drawBitmap(mObjet,x,y,null);
    }


/*    public Intrus(Bitmap object, int xMax, int yMax, int xSpeed, int ySpeed, int speed, String sColor) {
        this.mObjet = object;
        this.mxMax = xMax;
        this.myMax = yMax;
        this.mxSpeed = xSpeed;
        this.mySpeed = ySpeed;
        init();
  }*/


}