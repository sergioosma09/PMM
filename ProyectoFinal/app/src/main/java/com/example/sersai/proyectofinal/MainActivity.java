package com.example.sersai.proyectofinal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
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
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public Pizzas[] pizzas = new Pizzas[]{

            new Pizzas("Barbacoa",10,0,false, false, false, false, false,  R.drawable.barbacoa),
            new Pizzas("Pecado Carnal",10,0,false, false, false, false, false,  R.drawable.pecado),
            new Pizzas("Bourbon",10,0, false,false, false, false, false,  R.drawable.bourbon),
            new Pizzas("Texas",10,0, false,false, false, false, false,  R.drawable.texas)
    };
    public Pizzas [] mipizza;
    public int indice = 0;
    public Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Abrimos la base de datos en modo escritura
        ClientesSQLiteHelper cliBDh = new ClientesSQLiteHelper(this, "DBClientes", null, 1);

        //Obtenemos referencia a la base de datos para poder modificarla.
        SQLiteDatabase bd = cliBDh.getWritableDatabase();
        spinner = (Spinner) findViewById(R.id.spinner);
        AdaptadorPizzas miAdaptador = new AdaptadorPizzas(this);
        spinner.setAdapter(miAdaptador);
        spinner.setSelection(-1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                indice = pos;
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        final RadioButton buttonRecoger = (RadioButton) findViewById(R.id.recoger);
        final RadioButton buttonDomicilio = (RadioButton) findViewById(R.id.domicilio);
        final CheckBox patatas = (CheckBox) findViewById(R.id.patatas);
        final CheckBox bebida = (CheckBox) findViewById(R.id.bebida);
        final CheckBox salsa = (CheckBox) findViewById(R.id.salsa);
        final Button calcular = (Button) findViewById(R.id.calcular);
        final Button factura = (Button) findViewById(R.id.factura);

        final TextView resultado = (TextView) findViewById(R.id.resultado);

        final Object texto = spinner.getSelectedItem();
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pizzas[indice].setPrecioTotal(10);
                boolean flag = false;
                if(buttonRecoger.isChecked()){
                    pizzas[indice].setSeguro(true);
                    flag = true;
                }else if(buttonDomicilio.isChecked()){
                    pizzas[indice].setSeguro(true);
                    flag = true;
                }else{
                    Toast.makeText(getApplicationContext(), "Selecciona una forma de conseguir la pizza",Toast.LENGTH_SHORT).show();
                    flag = false;
                }

                if(patatas.isChecked()){
                    pizzas[indice].setPatatas(true);
                    pizzas[indice].setPrecioTotal(pizzas[indice].getPrecioTotal() + 1);
                }
                if(bebida.isChecked()){
                    pizzas[indice].setBebida(true);
                    pizzas[indice].setPrecioTotal(pizzas[indice].getPrecioTotal() + 1);
                }
                if(salsa.isChecked()){
                    pizzas[indice].setSalsa(true);
                    pizzas[indice].setPrecioTotal(pizzas[indice].getPrecioTotal() + 1);
                }
                if(buttonDomicilio.isChecked()){
                    pizzas[indice].setDomicilio(true);
                    pizzas[indice].setPrecioTotal(pizzas[indice].getPrecioTotal() + 5);
                }

                resultado.setText(String.valueOf(pizzas[indice].getPrecioTotal()));
            }
        });

        factura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Pantalla2.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("Objeto", pizzas[indice]);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    class AdaptadorPizzas extends ArrayAdapter {
        Activity context;
        AdaptadorPizzas(Activity context){
            super(context, R.layout.listapizzas, pizzas);
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
            View item = inflater.inflate(R.layout.listapizzas, null);

            TextView nombre = (TextView) item.findViewById(R.id.nombre);
            TextView precio = (TextView) item.findViewById(R.id.precio);
            ImageView imagen = (ImageView) item.findViewById(R.id.imagenSpinner);

            nombre.setText(pizzas[position].getNombre());
            precio.setText(String.valueOf(pizzas[position].getPrecio()));
            imagen.setBackground(getDrawable(pizzas[position].getImagen()));
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
                Intent intent1 = new Intent(MainActivity.this, Imagen.class);
                startActivity(intent1);
                return true;

            case R.id.MenuOpc2:
                Intent intent2 = new Intent(MainActivity.this, AcercaDe.class);
                startActivity(intent2);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
