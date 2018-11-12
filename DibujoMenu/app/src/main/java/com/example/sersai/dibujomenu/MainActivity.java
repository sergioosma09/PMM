package com.example.sersai.dibujomenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView lblMensaje;
    private ImageView miImagen;
    private View vista;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblMensaje=findViewById(R.id.etiqueta);
        miImagen=findViewById(R.id.miImagen);
        vista=findViewById(R.id.vista);
        registerForContextMenu(miImagen);
        registerForContextMenu(vista);

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
                lblMensaje.setText("Opcion 1 pulsada!");
                return true;
            case R.id.MenuOp2:
                lblMensaje.setText("Opcion 2 pulsada!");
                return true;
            case R.id.MenuOp3:
                lblMensaje.setText("Opcion 3 pulsada!");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.MenuOpc1:
                lblMensaje.setText("Opcion 1 pulsada!");
                return true;
            case R.id.MenuOpc2:
                lblMensaje.setText("Opcion 2 pulsada!");
                return true;
            case R.id.MenuOpc3:
                lblMensaje.setText("Opcion 3 pulsada!");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
