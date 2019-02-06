package com.example.sergi.finalproyect;

import android.app.Activity;
import android.content.Context;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ItemActivity extends Activity {
    //referencias a elementos de pantalla
    TextView mName = null;
    TextView mFood = null;
    TextView mType = null;
    TextView mId_pizza = null;
    //identificador de entrada
    Integer  mRowId = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        //botón de salvar
        Button saveBtn = (Button) findViewById(R.id.add);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                setResult(RESULT_OK);
                saveData();
                finish();
            }
        });
// obtener referencias
        mName = (TextView) findViewById(R.id.name);
        mFood = (TextView) findViewById(R.id.food);
        mType = (TextView) findViewById(R.id.type);
        mId_pizza = (TextView) findViewById(R.id.id_pizza);
    }
    protected void saveData() {
//obtener datos
        String nameText = mName.getText().toString();
        String foodText = mFood.getText().toString();
        String typeText = mType.getText().toString();
        String id_pizzaText = mId_pizza.getText().toString();
        //insertar
        try{
            MainActivity.mDbHelper.open();
            MainActivity.mDbHelper.insertItem(nameText, foodText, typeText, Integer.parseInt(id_pizzaText));
            MainActivity.mDbHelper.close();
        } catch (SQLException e) {
            e.printStackTrace();
            showMessage(R.string.dataError);
        }
    }

    private void showMessage(int message){
        Context context = getApplicationContext();
        CharSequence text = getResources().getString(message);
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}