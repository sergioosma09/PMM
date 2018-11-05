package com.example.sersai.dibujomenu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;


import android.util.AttributeSet;
import android.view.View;

class MiDibujo extends View {

    public MiDibujo(Context c) {
        super(c);
    }
    public MiDibujo(Context c, AttributeSet a) {
        super(c,a);
    }
    protected void onDraw(Canvas canvas) {


        Paint pince1 = new Paint();
        pince1.setColor(Color.MAGENTA);
        pince1.setStrokeWidth(8);
        pince1.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(672, 1066, 300, pince1);

        Paint pince3 = new Paint();
        pince3.setColor(Color.YELLOW);
        pince3.setStrokeWidth(100);
        pince3.setStyle(Paint.Style.STROKE);

        Paint pince4 = new Paint();
        pince4.setColor(Color.RED);
        pince4.setStrokeWidth(100);
        pince4.setStyle(Paint.Style.STROKE);

        Paint pince5 = new Paint();
        pince5.setColor(Color.BLUE);
        pince5.setStrokeWidth(100);
        pince5.setStyle(Paint.Style.STROKE);

        Paint pince6 = new Paint();
        pince6.setColor(Color.GRAY);
        pince6.setStrokeWidth(100);
        pince6.setStyle(Paint.Style.STROKE);


        Paint pince7 = new Paint();
        pince7.setColor(Color.GREEN);
        pince7.setStrokeWidth(100);
        pince7.setStyle(Paint.Style.STROKE);


        canvas.drawRect(250,700,300,750,pince3);
        canvas.drawRect(672,1066,725,1100,pince4);
        canvas.drawRect(1100,700,1150,750,pince5);
        canvas.drawRect(250,1600,300,1650,pince6);
        canvas.drawRect(1100,1600,1150,1650,pince7);


    }
}