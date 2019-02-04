package com.example.sersai.proyectofinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Actions extends AppCompatActivity {

    private Usuario modUsuario;
    private EditText etnombre, etedad, etdescrip;
    private Button buttonupdate, buttondelete;
    private ClientesSQLiteHelper clientesSQLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actions);

        Intent intent = getIntent();
        modUsuario = (Usuario) intent.getSerializableExtra("usuario");

        clientesSQLiteHelper = new ClientesSQLiteHelper(this);

        etnombre = (EditText) findViewById(R.id.etname);
        etedad = (EditText) findViewById(R.id.etedad);
        etdescrip = (EditText) findViewById(R.id.etdescripcion);
        buttondelete = (Button) findViewById(R.id.btndelete);
        buttonupdate = (Button) findViewById(R.id.btnupdate);

        etnombre.setText(modUsuario.getName());
        etedad.setText(modUsuario.getEdad());
        etdescrip.setText(modUsuario.getDescripcion());

        buttonupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clientesSQLiteHelper.updateUser(modUsuario.getId(), etnombre.getText().toString(), etedad.getText().toString(), etdescrip.getText().toString());
                Toast.makeText(Actions.this, "Actualizado", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Actions.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        buttondelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clientesSQLiteHelper.deleteUSer(modUsuario.getId());
                Toast.makeText(Actions.this, "Deleteado", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Actions.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

    }
}
