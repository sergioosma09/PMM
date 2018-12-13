package com.example.sersai.fragmentosdiversos;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SimpleFragment extends Fragment {
    int mNum;
    static SimpleFragment newInstance(int number) {
        SimpleFragment f = new SimpleFragment();
        Bundle args = new Bundle();
        args.putInt("num", number);// Mantenemos el numero para usarlo en cualquier momento.
        f.setArguments(args);
        return f;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // obtenemos el nÃºmero que se habia pasado como argumento en
        // la creaciÃ³n de la instancia
        mNum = getArguments().getInt("num");
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v  = null;
        if (mNum % 2 == 0){// dependiendo de si es par o impar mostramos distintos layouts
            v = inflater.inflate(R.layout.layout1, container, false);
            View tv = v.findViewById(R.id.text);
            //informamos el nÃºmero de Fragment
            ((TextView)tv).setText("Fragmento nÃºmero #" + mNum);
        }
        else{
            v = inflater.inflate(R.layout.layout2, container, false);
            View tv = v.findViewById(R.id.text2);//informamos el numero de Fragment
            ((TextView)tv).setText("Fragmento nÃºmero #" + mNum);
        }
        return v;
    }
}