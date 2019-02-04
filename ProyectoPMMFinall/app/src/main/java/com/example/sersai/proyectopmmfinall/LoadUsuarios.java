package com.example.sersai.proyectopmmfinall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class LoadUsuarios extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Usuario> UsuArrayList;
    private DatosCliente datosCliente;
    private ClientesSQLiteHelper clientesSQLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_usuarios);

        listView = (ListView) findViewById(R.id.lista);

        clientesSQLiteHelper = new ClientesSQLiteHelper(this);

        UsuArrayList = clientesSQLiteHelper.getAllUsers();

        datosCliente = new DatosCliente(this, UsuArrayList);
        listView.setAdapter(datosCliente);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(LoadUsuarios.this, Actions.class);
                intent.putExtra("usuario", UsuArrayList.get(position));
                startActivity(intent);
            }
        });

    }
}
