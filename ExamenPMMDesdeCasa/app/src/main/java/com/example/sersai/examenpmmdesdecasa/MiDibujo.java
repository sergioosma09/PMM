package com.example.sersai.examenpmmdesdecasa;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MiDibujo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(new miDibujo(this));


    }
    class miDibujo extends View{
        private ShapeDrawable miDrawable;
        public miDibujo(Context c){
            super(c);
        }

        protected void onDraw(Canvas canvas){



            Paint pince1=new Paint();
            pince1.setColor(Color.BLUE);
            pince1.setStrokeWidth(8);
            pince1.setStyle(Paint.Style.STROKE);
            Paint pince2=new Paint();
            pince2.setColor(Color.RED);
            pince2.setStrokeWidth(8);
            pince2.setStyle(Paint.Style.STROKE);
            pince2.setTextSize(60);
            canvas.drawCircle(672, 1066, 712, pince1);
            int anchura=getWidth();
            int altura=getHeight();
            String mensaje="(" + anchura + ", " + altura + ")";
            canvas.drawText(mensaje, 500, 1000, pince2);



            int x=672; int y=1066;
            int ancho=1440, alto=2112;
            miDrawable=new ShapeDrawable(new OvalShape());
            miDrawable.getPaint().setColor(0xff0000ff);
            miDrawable.setBounds(x,y,x + ancho, y + alto);
            miDrawable.draw(canvas);
        }
    }
}
