package com.example.sersai.spinnersimple;

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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner miSpinner;
    private Persona[] personas=new Persona[]{
            new Persona("Angeles", "Campos", 21),
            new Persona ("Consuelo", "Martin", 20),
            new Persona ("Fernando", "Molina", 26)
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miSpinner = (Spinner) findViewById(R.id.spinner1);
        AdaptadorPersona miAdaptador=new AdaptadorPersona(this);
        miSpinner.setAdapter(miAdaptador);

        miSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView arg0, View arg1, int position, long id){
                String mensaje="";
                mensaje="Item clicked => " + personas[position];
                showToast(mensaje);

            }
            public void onNothingSelected(AdapterView<?> adapterView){

            }
        });
    }
    public void showToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
    class AdaptadorPersona extends ArrayAdapter<Persona> {
        public Activity miActividad;
        public AdaptadorPersona(Activity laActividad){
            super(laActividad, R.layout.desmilista, personas);
            this.miActividad=laActividad;
        }
        public View getDropDownView(int position, View convertView, ViewGroup parent){
            View vistaDesplegada=getView(position, convertView, parent);
            return  vistaDesplegada;
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public View getView(int position, View convertView, ViewGroup parent) {
            View item = convertView;
            ViewHolder holder;
            if(item == null)
            { LayoutInflater inflater = context.getLayoutInflater();
                item = inflater.inflate(R.layout.listitem_titular, null);

                holder = new ViewHolder();
                holder.lblTitulo = (TextView)item.findViewById(R.id.LblTitulo);
                holder.lblSubtitulo = (TextView)item.findViewById(R.id.LblSubTitulo);
                holder.lblImagen = (ImageView)item.findViewById(R.id.ivImagen);

                item.setTag(holder);
            }
            else
            {
                holder = (ViewHolder)item.getTag(); }
            holder.lblTitulo.setText(datos[position].getTitulo());
            holder.lblSubtitulo.setText(datos[position].getSubTitulo());
            holder.lblImagen.setBackground(getDrawable(datos[position].getImagen()));
            return(item);
        }
    }




}
