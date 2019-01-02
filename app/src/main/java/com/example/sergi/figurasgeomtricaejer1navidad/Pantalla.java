package com.example.sergi.figurasgeomtricaejer1navidad;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Pantalla extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla);

        Intent intent = getIntent();
        DatosFiguras figuras = (DatosFiguras) intent.getSerializableExtra("Objeto");

        TextView textView = (TextView) findViewById(R.id.textFiguras);
        ImageView imageView = (ImageView) findViewById(R.id.imageFiguras);

        textView.setText(figuras.getForma());
        imageView.setBackground(getDrawable(figuras.getImagen()));

    }
}
