package com.example.sergi.dosspinners;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {
    private Spinner spinnerCar, spinnerType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerCar=(Spinner) findViewById(R.id.array_coches);
        spinnerType=(Spinner) findViewById(R.id.array_tipo);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.array_coches,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCar.setAdapter(adapter);
        spinnerCar.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        int[] tipos={R.array.array_audi, R.array.array_ferrari};

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,
        tipos[position],
                android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerType.setAdapter(adapter);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
