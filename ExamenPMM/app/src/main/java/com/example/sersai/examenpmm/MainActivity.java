package com.example.sersai.examenpmm;

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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private View vista;
    private static int precio;
    private static double horas;
    private static EditText tiempo;
    private static RadioButton noSeguro;
    private static RadioButton seguro;
    private static TextView eleccion;
    private static CheckBox aire;
    private static CheckBox gps;
    private static CheckBox radio;
    private static TextView precioTotal;
    private double total;
    private double extras = 0;
    private Alquiler alquiler;
    private Alquiler[] datos = new Alquiler[] {
            new Alquiler(0, "Megane", "Seat", 20, R.drawable.megan1),
            new Alquiler(1, "X-11", "Ferrari", 100, R.drawable.ferrari1),
            new Alquiler(2, "Leon", "Seat", 30, R.drawable.leon2),
            new Alquiler(3, "Fiesta", "Ford", 40, R.drawable.fiesta1)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lstOpciones = (ListView) findViewById(R.id.opciones);
        AdaptadorCoches adaptador = new AdaptadorCoches(this);
        lstOpciones.setAdapter(adaptador);
        eleccion = (TextView) findViewById(R.id.eleccion);
        registerForContextMenu(vista);

        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick (AdapterView arg0, View arg1, int position, long id) {
                if (position == 0) precio = 20;
                if (position == 1) precio = 100;
                if (position == 2) precio = 30;
                if (position == 3) precio = 40;

                eleccion.setText("Coche Elegido: " + datos[position].getMarca() + " " + datos[position].getModelo());

                alquiler = new Alquiler(datos[position].getId(), datos[position].getModelo(), datos[position].getMarca(), datos[position].getPrecio(), datos[position].getImagen());
            }
        });

        tiempo = (EditText) findViewById(R.id.horas);

        noSeguro = (RadioButton) findViewById(R.id.noSeguro);
        noSeguro.toggle();

        seguro = (RadioButton) findViewById(R.id.seguro);

        aire = (CheckBox) findViewById(R.id.aire);

        gps = (CheckBox) findViewById(R.id.gps);
        radio = (CheckBox) findViewById(R.id.radio);

        precioTotal = (TextView) findViewById(R.id.total);
    }

    public void calcular (View view) {


        horas = Double.valueOf(tiempo.getText().toString());

        total = horas * precio;

        if (seguro.isChecked())
            total *= 1.3;

        Bundle miBundle = new Bundle();
        miBundle.putSerializable("TODO", alquiler);
        if (!seguro.isChecked())
            miBundle.putString("Tarifa", "Normal");
        else
            miBundle.putString("Tarifa", "Urgente");
        miBundle.putDouble("Peso", Double.valueOf(tiempo.getText().toString()));

        if (aire.isChecked())
            extras += 50;
        if(gps.isChecked())
            extras += 50;
        if (radio.isChecked())
            extras += 50;

        total += extras;

        if (seguro.isChecked())
            total *= 1.2;

        precioTotal.setText(Double.valueOf(total).toString());
    }

    public void factura (View view) {
        horas = Double.valueOf(tiempo.getText().toString());

        Intent miIntent = new Intent(MainActivity.this, Pantalla2.class);
        Bundle miBundle = new Bundle();

        miBundle.putSerializable("TODO", alquiler);

        miBundle.putDouble("EXTRAS", extras);

        miBundle.putString("HORAS", String.valueOf(horas));

        if (noSeguro.isChecked())
            miBundle.putString("SEGURO", "Sin seguro");
        else
            miBundle.putString("SEGURO", "Seguro a todo riesgo");

        total = horas * precio + extras;

        miBundle.putDouble("PRECIO", total);

        miIntent.putExtras(miBundle);
        startActivity(miIntent);
    }

    static class ViewHolder {
        TextView modelo;
        TextView marca;
        TextView precio;
        ImageView imagen;
    }

    class AdaptadorCoches extends ArrayAdapter {
        Activity context;

        AdaptadorCoches(Activity context) {
            super(context, R.layout.listzonas, datos);
            this.context = context;
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public View getView (int position, View convertView, ViewGroup parent) {
            View item = convertView;
            ViewHolder holder;

            if (item == null) {
                LayoutInflater inflater = context.getLayoutInflater();
                item = inflater.inflate(R.layout.listzonas, null);
                holder = new ViewHolder();
                holder.modelo = (TextView) item.findViewById(R.id.modelo);
                holder.marca = (TextView) item.findViewById(R.id.marca);
                holder.precio = (TextView) item.findViewById(R.id.precio);
                holder.imagen = (ImageView) item.findViewById(R.id.coche);

                item.setTag(holder);
            } else {
                holder = (ViewHolder) item.getTag();
            }

            holder.modelo.setText(datos[position].getModelo());

            holder.marca.setText(datos[position].getMarca());

            holder.precio.setText((int) datos[position].getPrecio());

            holder.imagen.setBackground(getDrawable(datos[position].getImagen()));

            return (item);
        }
        public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu, menu);
            return true;
        }
    }
}

