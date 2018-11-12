package com.example.sersai.examenprueba;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Zona[] datos = new Zona[]{
            new Zona("Zona A", "Asia y Oceanía", 30),
            new Zona("Zona B", "América y África", 20),
            new Zona("Zona C", "Europa", 10)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdaptadorTitulares adaptador = new AdaptadorTitulares(this);
        ListView lstOpciones = findViewById(R.id.LstOpciones);
        lstOpciones.setAdapter(adaptador);


        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView arg0, View arg1, int position, long id) {
                String mensaje = "Zona: " + datos[position].getZona() + " Continente: " + datos[position].getContinente() + " Precio: " + datos[position].getPrecio();

                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
            }
        });
    }
        static class ViewHolder {
            TextView lblZona;
            TextView lblContinente;
            TextView lblPrecio;
        }



        class AdaptadorTitulares extends ArrayAdapter {
            Activity context;
            AdaptadorTitulares(Activity context) {
                super(context, R.layout.listitem_zona, datos);
                this.context = context;
            }
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            public View getView(int position, View convertView, ViewGroup parent) {
                View item = convertView;
                ViewHolder holder;
                if(item == null)
                { LayoutInflater inflater = context.getLayoutInflater();
                    item = inflater.inflate(R.layout.listitem_zona, null);

                    holder = new ViewHolder();
                    holder.lblZona =item.findViewById(R.id.LblZona);
                    holder.lblContinente =item.findViewById(R.id.LblContinente);
                    holder.lblPrecio =item.findViewById(R.id.LblPrecio);

                    item.setTag(holder);
                }
                else
                {
                    holder = (ViewHolder)item.getTag(); }
                holder.lblZona.setText(datos[position].getZona());
                holder.lblContinente.setText(datos[position].getContinente());
                holder.lblPrecio.setText(datos[position].getPrecio());
                return(item);
            }
        }
    }
