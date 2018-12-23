package com.example.sergi.ejercicio4anavidad;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SimpleFragment extends Fragment {
    int mNum;
    int Imagen;
    int [] imagenes = new int[]{
            R.drawable.azafata, R.drawable.img3, R.drawable.lopeteguiout};

    int random = (int) (Math.random() * imagenes.length);

    static SimpleFragment newInstance(int number, int laImagen) {
        SimpleFragment f = new SimpleFragment();
        Bundle args = new Bundle();
        args.putInt("num", number);// Mantenemos el numero para usarlo en cualquier momento.
        //args.putInt("imagen", laImagen);
        f.setArguments(args);
        return f;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // obtenemos el nÃºmero que se habia pasado como argumento en
        // la creaciÃ³n de la instancia
        mNum = getArguments().getInt("num");
        //Imagen = getArguments().getInt("imagen");

    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v  = null;

        if (mNum % 2 == 0){// dependiendo de si es par o impar mostramos distintos layouts
            v = inflater.inflate(R.layout.layout2, container, false);
            Toast.makeText(getActivity(),String.valueOf(random), Toast.LENGTH_SHORT).show();
            View tv = v.findViewById(R.id.text2);
            View img = v.findViewById(R.id.image);
            //informamos el nÃºmero de Fragment
            ((TextView)tv).setText("Fragmento nÃºmero #" + mNum);
            ((ImageView)img).setImageResource(imagenes[random]);
        }
        else{
            Toast.makeText(getActivity(),String.valueOf(random), Toast.LENGTH_SHORT).show();
            v = inflater.inflate(R.layout.layout1, container, false);
            View tv = v.findViewById(R.id.text);//informamos el numero de Fragment
            ((TextView)tv).setText("Fragmento nÃºmero #" + mNum);
        }
        return v;
    }
}