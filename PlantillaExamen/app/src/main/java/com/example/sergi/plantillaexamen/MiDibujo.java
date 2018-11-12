package com.example.sergi.plantillaexamen;

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
        canvas.drawCircle(336, 533, 150, pince1);
    }
}
