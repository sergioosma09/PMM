package com.example.sersai.examenpmmdesdecasa;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
public class Pantalla2 extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public Coches cocheObjeto;



    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        Intent intent = getIntent();
        final TextView modelo = (TextView) findViewById(R.id.modelo2);
        final TextView extrasTotal = (TextView) findViewById(R.id.marca2);
        final TextView horas = (TextView) findViewById(R.id.horas2);
        final TextView seguro = (TextView) findViewById(R.id.seguro2);
        final TextView precio = (TextView) findViewById(R.id.precio2);
        final ImageView imagen2 = (ImageView) findViewById(R.id.imagen2);


        cocheObjeto = (Coches) intent.getSerializableExtra("Objeto");

        float precioTotal = cocheObjeto.getPrecioTotal();
        modelo.setText(cocheObjeto.getNombre());
        horas.setText(String.valueOf(cocheObjeto.getPrecio()) + " €");
        if(cocheObjeto.isSeguro() == true){
            seguro.setText("Con seguro");
        }else{
            seguro.setText("Sin seguro");
        }
        precio.setText(String.valueOf(cocheObjeto.getPrecioTotal()));
        imagen2.setBackground(getDrawable(cocheObjeto.getImagen()));
        registerForContextMenu(imagen2);
        float extras = 0;
        precio.setText(String.valueOf(precioTotal) + " €");
        if(cocheObjeto.isGps() == true){
            extras += 50;
        }
        if(cocheObjeto.isAire() == true){
            extras += 50;
        }
        if(cocheObjeto.isRadio() == true){
            extras += 50;
        }
        extrasTotal.setText(String.valueOf(extras) + " €");
    }
}