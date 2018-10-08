package com.example.sersai.diferenteseventos;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.sersai.diferenteseventos.R.layout.activity_main;

public class miBoton extends android.support.v7.widget.AppCompatButton implements
        View.OnClickListener {
    Context ctx=null;
    TextView etiqueta;

    public miBoton(Context context) {
        super(context);
        ctx=context;
        this.setOnClickListener(this);//recoger evento
    }
    //cuando se cree desde un recurso XML
    public miBoton(Context context, AttributeSet attr){
        super(context,attr);
        ctx=context;
        this.setOnClickListener(this);
    }
    //cuando se cree desde un recurso XML
    public miBoton(Context context, AttributeSet attr,
                    int defaultStyles){
        super(context, attr, defaultStyles);
        ctx=context;
        this.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        Toast.makeText(ctx, "Pulsado mi botón",
                Toast.LENGTH_SHORT).show();

        etiqueta=(TextView)((Activity)ctx).findViewById(R.id.miEtiqueta);

    }
}
