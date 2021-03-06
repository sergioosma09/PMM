package com.example.sergi.finalproyect;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class Pantalla2 extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public Pizzas pizzaObjeto;



    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        Intent intent = getIntent();
        final TextView modelo = (TextView) findViewById(R.id.nombre2);
        final TextView extrasTotal = (TextView) findViewById(R.id.extras2);
        final TextView conseguir = (TextView) findViewById(R.id.seguro2);
        final TextView precio = (TextView) findViewById(R.id.precio2);
        final ImageView imagen2 = (ImageView) findViewById(R.id.imagen2);


        pizzaObjeto = (Pizzas) intent.getSerializableExtra("Objeto");

        float precioTotal = pizzaObjeto.getPrecioTotal();
        modelo.setText(pizzaObjeto.getNombre());
        if(pizzaObjeto.isDomicilio() == true){
            conseguir.setText("A domicilio");

        }else{
            conseguir.setText("A recoger");
        }
        precio.setText(String.valueOf(pizzaObjeto.getPrecioTotal()));
        imagen2.setBackground(getDrawable(pizzaObjeto.getImagen()));
        registerForContextMenu(imagen2);
        float extras = 0;
        precio.setText(String.valueOf(precioTotal) + " €");
        if(pizzaObjeto.isBebida() == true){
            extras += 1;
        }
        if(pizzaObjeto.isPatatas() == true){
            extras += 1;
        }
        if(pizzaObjeto.isSalsa() == true){
            extras += 1;
        }
        extrasTotal.setText(String.valueOf(extras) + " €");
    }
}

