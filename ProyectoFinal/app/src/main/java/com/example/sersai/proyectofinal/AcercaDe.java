package com.example.sersai.proyectofinal;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class AcercaDe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        ImageView imageView = (ImageView) findViewById(R.id.imagen2);
        registerForContextMenu(imageView);
    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuinfo){
        super.onCreateContextMenu(menu, v, menuinfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.imagen2){
            Toast.makeText(getApplicationContext(), "Acerca De" , Toast.LENGTH_SHORT).show();
            return true;
        }else{
            return true;
        }
    }
}
