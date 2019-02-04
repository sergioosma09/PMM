package com.example.sersai.proyectopmmfinall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonGuardar, buttonMostrar,buttonFactura;
    private EditText nombre, edad, descrip;
    private ClientesSQLiteHelper clientesSQLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clientesSQLiteHelper = new ClientesSQLiteHelper(this);

        buttonGuardar = (Button) findViewById(R.id.btnguardar);
        buttonMostrar = (Button) findViewById(R.id.btnmostrar);
        nombre = (EditText) findViewById(R.id.etnombre);
        edad = (EditText) findViewById(R.id.etedad);
        descrip = (EditText) findViewById(R.id.etdescripcion);
        buttonFactura=findViewById(R.id.factura);


        buttonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clientesSQLiteHelper.addUser(nombre.getText().toString(), edad.getText().toString(), descrip.getText().toString());
                nombre.setText("");
                edad.setText("");
                descrip.setText("");
                Toast.makeText(MainActivity.this, "Guardado", Toast.LENGTH_SHORT).show();
            }
        });

        buttonMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoadUsuarios.class);
                startActivity(intent);
            }
        });
        buttonFactura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

    }
}

