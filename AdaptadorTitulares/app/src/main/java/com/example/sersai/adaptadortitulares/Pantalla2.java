package com.example.sersai.adaptadortitulares;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class Pantalla2 extends AppCompatActivity {


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        final TextView titulo = (TextView) findViewById(R.id.LblTitulo);
        final TextView subtitulo = (TextView) findViewById(R.id.LblSubTitulo);
        final ImageView imagen = (ImageView) findViewById(R.id.ivImagen);


        Titular titular = (Titular) getIntent().getSerializableExtra("TODO"); //recoger el objeto
        titulo.setText(titular.getTitulo());
        subtitulo.setText(titular.getSubTitulo());
        imagen.setBackground(getDrawable(titular.getImagen()));
        /*Bundle miBundleRecoger = getIntent().getExtras(); //recoger uno por uno
        titulo.setText(miBundleRecoger.getString("TEXTO1"));
        subtitulo.setText(miBundleRecoger.getString("TEXTO2"));
        imagen.setBackground(getDrawable(miBundleRecoger.getInt("IMAGEN")));*/

        }
    }


