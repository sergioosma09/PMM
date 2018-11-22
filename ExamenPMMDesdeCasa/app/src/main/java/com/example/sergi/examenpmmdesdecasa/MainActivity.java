package com.example.sergi.examenpmmdesdecasa;

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
import android.view.MenuItem;
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

    public Coches[] coches = new Coches[]{

            new Coches("Megane","Renault",20,0, 0, false, false, false, false, R.drawable.megan1),
            new Coches("X-11","Ferrari",100,0, 0, false, false, false, false, R.drawable.ferrari1),
            new Coches("Leon","Seat",30, 0,0, false, false, false, false, R.drawable.leon1),
            new Coches("Fiesta","Ford",40, 0,0, false, false, false, false, R.drawable.fiesta1)
    };
    public Coches [] micoche;
    public int indice = 0;
    public Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.spinner);
        AdaptadorZonas miAdaptador = new AdaptadorZonas(this);
        spinner.setAdapter(miAdaptador);
        spinner.setSelection(-1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                indice = pos;
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        final RadioButton buttonSeguro = (RadioButton) findViewById(R.id.sinSeguro);
        final RadioButton buttonTodoRiesgo = (RadioButton) findViewById(R.id.todoRiesgo);
        final CheckBox aireAcondicionado = (CheckBox) findViewById(R.id.aire);
        final CheckBox gps = (CheckBox) findViewById(R.id.gps);
        final CheckBox radio = (CheckBox) findViewById(R.id.radio);
        final Button calcular = (Button) findViewById(R.id.calcular);
        final Button factura = (Button) findViewById(R.id.factura);

        final TextView resultado = (TextView) findViewById(R.id.resultado);
        final EditText horas = (EditText) findViewById(R.id.horas);
        final Object texto = spinner.getSelectedItem();
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                coches[indice].setPrecioTotal(0);
                boolean flag = false;
                if(buttonSeguro.isChecked()){
                    coches[indice].setSeguro(false);
                    flag = true;
                }else if(buttonTodoRiesgo.isChecked()){
                    coches[indice].setSeguro(true);
                    flag = true;
                }else{
                    Toast.makeText(getApplicationContext(), "Selecciona una forma de seguro",Toast.LENGTH_SHORT).show();
                    flag = false;
                }
                if(aireAcondicionado.isChecked()){
                    coches[indice].setAire(true);
                    coches[indice].setPrecioTotal(coches[indice].getPrecioTotal() + 50);
                }
                if(gps.isChecked()){
                    coches[indice].setGps(true);
                    coches[indice].setPrecioTotal(coches[indice].getPrecioTotal() + 50);
                }
                if(radio.isChecked()){
                    coches[indice].setRadio(true);
                    coches[indice].setPrecioTotal(coches[indice].getPrecioTotal() + 50);
                }
                String comparador = horas.getText().toString();
                if(comparador.equalsIgnoreCase("")){
                    Toast.makeText(getApplicationContext(), "Introduce las horas",Toast.LENGTH_SHORT).show();
                    flag = false;
                }else{
                    coches[indice].setHoras(Integer.parseInt(horas.getText().toString()));
                }
                float totalHoras = 0;
                totalHoras = coches[indice].getPrecio() * Float.parseFloat(horas.getText().toString());

                if(coches[indice].isSeguro() == true){
                    totalHoras = (totalHoras + coches[indice].getPrecioTotal()) * 6/5;
                    coches[indice].setPrecioTotal(totalHoras);
                }else{
                    totalHoras = (totalHoras + coches[indice].getPrecioTotal());
                    coches[indice].setPrecioTotal(totalHoras);
                }
                resultado.setText(String.valueOf(coches[indice].getPrecioTotal()));
            }
        });

        factura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Pantalla2.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("Objeto", coches[indice]);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    class AdaptadorZonas extends ArrayAdapter{
        Activity context;
        AdaptadorZonas(Activity context){
            super(context, R.layout.listazonas, coches);
            this.context = context;

        }
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        public View getDropDownView(int position, View convertView, ViewGroup parent){
            View vista = getView(position, convertView, parent);
            return vista;
        }
        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        public View getView(int position, View convertiView, ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listazonas, null);

            TextView modelo = (TextView) item.findViewById(R.id.modelo);
            TextView marca = (TextView) item.findViewById(R.id.marca);
            TextView precio = (TextView) item.findViewById(R.id.precio);
            ImageView imagen = (ImageView) item.findViewById(R.id.imagenSpinner);

            modelo.setText(coches[position].getNombre());
            marca.setText(coches[position].getMarca());
            precio.setText(String.valueOf(coches[position].getPrecio()));
            imagen.setBackground(getDrawable(coches[position].getImagen()));
            return item;
        }
    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflate  = getMenuInflater();
        inflate.inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.MenuOpc1:
                Intent intent1 = new Intent(MainActivity.this, PantallaImagen.class);
                startActivity(intent1);
                return true;

            case R.id.MenuOpc2:
                Intent intent2 = new Intent(MainActivity.this, MiDibujo.class);
                startActivity(intent2);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}