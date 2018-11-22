package com.example.sersai.biciproyecto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SoloBici extends Activity {
    private Button BAcercaDe;
    private Button BJuego;

    public void lanzarJuego(){
        Intent i = new Intent(this, Juego.class);
        startActivity(i);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solo_bici);

        final TextView LbTextView = (TextView) findViewById(R.id.LblMensaje);

        BJuego = (Button) findViewById(R.id.Boton01);
        BJuego.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                lanzarJuego();
            }
        });


    }
}
