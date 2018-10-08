package com.example.sergi.layouts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableRow;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button miBoton = (Button) findViewById(R.id.Linear);
        final Button miBoton2 = (Button) findViewById(R.id.Table);
        final Button miBoton3 = (Button) findViewById(R.id.Constraint);

        miBoton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent mio=new Intent(MainActivity.this, LinearLayout.class);
                Bundle miBundle=new Bundle();
                mio.putExtras(miBundle);
                startActivity(mio);
            }
        });
        miBoton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent mio2=new Intent(MainActivity.this, TableLayout.class);
                Bundle miBundle=new Bundle();
                mio2.putExtras(miBundle);
                startActivity(mio2);
            }
        });
        miBoton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent mio3=new Intent(MainActivity.this, ConstraintLayout.class);
                Bundle miBundle=new Bundle();
                mio3.putExtras(miBundle);
                startActivity(mio3);
            }
        });
    }


}
