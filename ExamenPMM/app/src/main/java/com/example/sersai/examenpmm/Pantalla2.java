package com.example.sersai.examenpmm;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
public class Pantalla2 extends AppCompatActivity {
    private TextView lblMessage;
    private View vista;
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        Intent intent = getIntent();
        final TextView modelo = (TextView) findViewById(R.id.modelo2);
        final TextView seguro = (TextView) findViewById(R.id.seguro2);
        final TextView precio = (TextView) findViewById(R.id.precio2);
        final TextView tiempo = (TextView) findViewById(R.id.tiempo2);
        final TextView precioHora = (TextView) findViewById(R.id.precioporhora2);
        final ImageView coche = (ImageView) findViewById(R.id.coche);
        final Button volver = (Button) findViewById(R.id.volver);
        Alquiler alquilerObjeto = (Alquiler) intent.getSerializableExtra("Objeto");
        float precioTotal = alquilerObjeto.getPrecio() + alquilerObjeto.getPrecio();
        modelo.setText(alquilerObjeto.getModelo());
        seguro.setText(alquilerObjeto.getSeguro());
        precioHora.setText(String.valueOf(alquilerObjeto.getPrecio()));
        coche.setBackground(getDrawable(alquilerObjeto.getImagen()));
        vista=findViewById(R.id.vista);

        registerForContextMenu(coche);
        if(alquilerObjeto.getExtras() == true){
            precioTotal += 50;
        }

        if(alquilerObjeto.getSeguro().equalsIgnoreCase("Sin seguro")){
            precioTotal += 0;
        }else{
            precioTotal += precioTotal+(precioTotal*0.2);
        }
        precio.setText(String.valueOf(precioTotal));
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Pantalla2.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu,v,menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contextmenu, menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.MenuOp1:
                lblMessage.setText("Modelo");
            case R.id.MenuOp2:
                lblMessage.setText("Seguro");
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
