package com.example.sersai.examenpmm;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    public Alquiler[] datos = new Alquiler[]{
            new Alquiler("Megane ", "Seat", 20,0,false, "", 20,false ,R.drawable.megan1),
            new Alquiler("X-11 ", "Ferrari", 100,0, false,"", 100, false,R.drawable.ferrari1),
            new Alquiler("Leon ", "Seat", 30,0, false,"",30,false,R.drawable.leon2),
            new Alquiler("Fiesta ", "Ford", 40,0,false, "", 40, false,R.drawable.fiesta1)

    };
    public Alquiler [] mialquiler;
    public int indice = 0;
    public Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.spinner);
        AdaptadorAlquiler miAdaptador = new AdaptadorAlquiler(this);
        spinner.setAdapter(miAdaptador);
        spinner.setSelection(-1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                indice = pos;
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        final RadioButton botonSinSeguro = (RadioButton) findViewById(R.id.sinSeguro);
        final RadioButton botonTodoRiesgo = (RadioButton) findViewById(R.id.TodoRiesgo);
        final CheckBox checkBoxAire = (CheckBox) findViewById(R.id.aire);
        final CheckBox checkBoxGPS = (CheckBox) findViewById(R.id.gps);
        final CheckBox checkBoxRadio = (CheckBox) findViewById(R.id.radio);
        Button calcular = (Button) findViewById(R.id.calcular);
        final RadioGroup seguro = (RadioGroup) findViewById(R.id.seguros);
        final TextView resultado = (TextView) findViewById(R.id.resultado);
        final EditText precioCalcul = (EditText) findViewById(R.id.precioaCalcular);
        final Object texto = spinner.getSelectedItem();
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean flag = false;
                if(botonSinSeguro.isChecked()){
                    datos[indice].setSeguro("Sin seguro");
                    flag = true;
                }else if(botonTodoRiesgo.isChecked()){
                   datos[indice].setSeguro("Seguro todo riesgo");
                    flag = true;
                }else{
                    Toast.makeText(getApplicationContext(), "Debes seleccionar un seguro",Toast.LENGTH_SHORT).show();
                    flag = false;
                }
                if(checkBoxAire.isChecked()){
                    datos[indice].setExtras(true);
                }
                String comparador = precioCalcul.getText().toString();
                if(comparador.equalsIgnoreCase("")){
                    Toast.makeText(getApplicationContext(), "Debes introducir un precio",Toast.LENGTH_SHORT).show();
                    flag = false;
                }else{
                    datos[indice].setPrecio((int) Float.parseFloat(precioCalcul.getText().toString()));
                }
                if (flag == true){
                    Intent intent = new Intent(MainActivity.this, Pantalla2.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Objeto", datos[indice]);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                resultado.setText(datos[indice].toString());
            }
        });
    }
    class AdaptadorAlquiler extends ArrayAdapter{
        Activity context;
        AdaptadorAlquiler(Activity context){
            super(context, R.layout.listzonas, datos);
            this.context = context;
        }
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        public View getDropDownView(int position, View convertView, ViewGroup parent){
            View vista = getView(position, convertView, parent);
            return vista;
        }
        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listzonas, null);
            TextView modelo = (TextView) item.findViewById(R.id.modelo);
            TextView marca = (TextView) item.findViewById(R.id.marca);
            TextView seguro = (TextView) item.findViewById(R.id.seguros);
            TextView precio = (TextView) item.findViewById(R.id.precio);
            ImageView imagen = (ImageView) item.findViewById(R.id.coche);
            modelo.setText(datos[position].getModelo());
            marca.setText(datos[position].getMarca());
            seguro.setText(datos[position].getSeguro());
            precio.setText(String.valueOf(datos[position].getPrecio()));
            imagen.setBackground(getDrawable(datos[position].getImagen()));
            return item;
        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
}