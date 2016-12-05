package com.example.axel.projet_jeux;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/**
 * Created by Axel on 10/10/2016.
 */

 class Occurence {
    private BitmapDrawable img=null;
    private int x,y;
    private int occW, occH;
    private int wEcran,hEcran;
    private boolean move=true;

    private static final int INCREMENT=15;
    private int speedX=INCREMENT, speedY=INCREMENT;

    private final Context mContext;

        public Occurence(final Context c){
            x=0;y=0;
            mContext=c;
        }

    public BitmapDrawable setImage(final Context c, final int ressource, final int w,final int h)
    {
        Drawable dr = c.getResources().getDrawable(ressource);
        Bitmap bitmap=((BitmapDrawable)dr).getBitmap();
        return  new BitmapDrawable(c.getResources(),Bitmap.createScaledBitmap(bitmap,w,h,true));
    }

    public boolean isMovin(){
        return move;
    }

    public void setMove(boolean move){
        this.move=move;
    }

    public void resize(int wScreen,int hScreen){
        wEcran=wScreen;
        hEcran=hScreen;

        occW=wEcran/10;
        occH=hEcran/10;
        img= setImage(mContext,R.mipmap.occ,occW,occH);
    }

    public void setX(int x){
        this.x=x;
    }

    public void setY(int y){
        this.y=y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getOccW(){
        return occW;
    }

    public int getOccH(){
        return occH;
    }

    public void moveWithCollisionDetection()
    {
        if (move != true){
            return;
        }

        x+=speedX;
        y+=speedY;

        if(x+occW>wEcran){
            speedX=INCREMENT;
        }
        if(y+occH>hEcran){
            speedY=INCREMENT;
        }

        if(x<0){
            speedX=INCREMENT;
        }
        if (y<0){
            speedY=INCREMENT;
        }
    }

    public void draw (Canvas canvas) {
        if (img == null) {return;}
        canvas.drawBitmap(img.getBitmap(),x,y,null);
    }

    }
