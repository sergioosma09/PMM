package com.example.sersai.ejercicio1navidad;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;

    int indice = 0;

    DatosFiguras [] datosFiguras = new DatosFiguras[] {
            new DatosFiguras("Rectangulo",0, 0, R.drawable.rectangulo),
            new DatosFiguras("Triangulo",0, 0, R.drawable.triangulo),
            new DatosFiguras("Cuadrado",0, 0, R.drawable.cuadrado)
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText altura = (EditText) findViewById(R.id.altura);
        final EditText base = (EditText) findViewById(R.id.base);
        final Button calcul = (Button) findViewById(R.id.calcul);

        spinner = (Spinner) findViewById(R.id.spinner);
        AdaptadorFiguras miAdaptador = new AdaptadorFiguras(this);
        spinner.setAdapter(miAdaptador);

        spinner.setSelection(-1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                indice = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        calcul.setOnClickListener(new View.OnClickListener() {

            boolean altura2 = false;
            boolean base2 = false;

            public void onClick(View v) {
                if(altura.getText().toString().length() != 0){
                    altura2 = true;
                }
                if(base.getText().toString().length() != 0){
                    base2 = true;
                }
                if(altura2 && base2){
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Objeto", datosFiguras[indice]);
                    Intent intent = new Intent(MainActivity.this, Pantalla.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
    }
    class AdaptadorFiguras extends ArrayAdapter {
        Activity context;
        AdaptadorFiguras(Activity context){
            super(context, R.layout.spinner, datosFiguras);
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
            View item = inflater.inflate(R.layout.spinner, null);

            TextView figura = (TextView) item.findViewById(R.id.Spinner);
            ImageView imagen = (ImageView) item.findViewById(R.id.imageSpinner);

            figura.setText(datosFiguras[position].getForma());
            imagen.setBackground(getDrawable(datosFiguras[position].getImagen()));

            return item;
        }
    }
}
