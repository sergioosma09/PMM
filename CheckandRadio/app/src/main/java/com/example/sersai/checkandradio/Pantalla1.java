package com.example.sersai.checkandradio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class Pantalla1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);

        final Button miBoton = (Button) findViewById(R.id.checkbox);
        final Button miBoton2 = (Button) findViewById(R.id.radio);

        miBoton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent mio=new Intent(Pantalla1.this, Check.class);
                Bundle miBundle=new Bundle();
                mio.putExtras(miBundle);
                startActivity(mio);
            }
        });
        miBoton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent mio2=new Intent(Pantalla1.this, Radio.class);
                Bundle miBundle=new Bundle();
                mio2.putExtras(miBundle);
                startActivity(mio2);
            }
        });
    }
}
