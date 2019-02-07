package com.example.sergi.finalproyect;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ListActivity{
    //acciones
    public static final int NEW_ITEM = 1;
    public static final int SHOW_ITEM = 2;
    public static final int DELETE_ITEM=3;

    private DataBaseHelper dataBaseHelper;

    //elemento seleccionado
    private int mLastRowSelected = 0;
    public static DataBaseHelper mDbHelper = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // abrir la base de datos
        mDbHelper = new DataBaseHelper(this);
<<<<<<< HEAD
        mDbHelper.open();
=======
>>>>>>> d944fb68d9e1df4cd7125b702faaf50bcee21bdb
        try {
            fillData();
        } catch (SQLException e) {
            e.printStackTrace();
            showMessage(R.string.dataError);
        }
        Button botonIni=(Button)findViewById(R.id.BotonPrincipal);
        botonIni.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent (MainActivity.this,ItemActivity.class);
                startActivityForResult(intent, NEW_ITEM);
            }


        });
        Button delete=(Button)findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
<<<<<<< HEAD
                mDbHelper.drop();
                Toast.makeText(MainActivity.this, "Eliminada la tabla", Toast.LENGTH_SHORT).show();
=======
                dataBaseHelper.drop();
                Toast.makeText(MainActivity.this, "Eliminado Correctamente!", Toast.LENGTH_SHORT).show();
>>>>>>> d944fb68d9e1df4cd7125b702faaf50bcee21bdb

            }


        });
        Button actualiza=(Button)findViewById(R.id.upgrade);
        actualiza.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent (MainActivity.this,MainActivity.class);
                startActivityForResult(intent, SHOW_ITEM);
            }


        });

        Button botonFactura=findViewById(R.id.BotonFactura);
        botonFactura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
    }

    private void showMessage(int message){
        Context context = getApplicationContext();
        CharSequence text = getResources().getString(message);
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
    private void fillData() {
        // se abre la base de datos y se obtienen los elementos
        mDbHelper.open();
        Cursor itemCursor = mDbHelper.getItems();
        ListEntry item = null;
        ArrayList<ListEntry> resultList = new ArrayList<ListEntry>();
        // se procesa el resultado
        while (itemCursor.moveToNext()) {
            int id = itemCursor.getInt(itemCursor.getColumnIndex(DataBaseHelper.SL_ID));
            String name = itemCursor.getString(itemCursor.getColumnIndex(DataBaseHelper.SL_NAME));
            String food = itemCursor.getString(itemCursor.getColumnIndex(DataBaseHelper.SL_FOOD));
            int id_pizza = itemCursor.getInt(itemCursor.getColumnIndex(DataBaseHelper.SL_ID_PIZZA));
            item = new ListEntry();
            item.id = id;
            item.name = name;
            item.food = food;
            item.id_pizza = id_pizza;
            resultList.add(item);
        }
        //cerramos la base de datos
        itemCursor.close();
        mDbHelper.close();
        //se genera el adaptador
        TaskAdapter items = new TaskAdapter(this, R.layout.row_list, resultList, getLayoutInflater());
        //asignar adaptador a la lista
        setListAdapter(items);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.new_item:
                Intent intent = new Intent (this,ItemActivity.class);
                startActivityForResult(intent, NEW_ITEM);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private class TaskAdapter extends ArrayAdapter<ListEntry> {
        private LayoutInflater mInflater;
        private List<ListEntry> mObjects;

        private TaskAdapter(Context context, int resource, List<ListEntry> objects, LayoutInflater mInflater) {
            super(context, resource, objects);
            this.mInflater = mInflater;
            this.mObjects = objects;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ListEntry listEntry = mObjects.get(position);
            // obtención de la vista de la línea de la tabla
            View row = mInflater.inflate(R.layout.row_list, null);
            //rellenamos datos
            TextView food = (TextView) row.findViewById(R.id.row_food);
            TextView name = (TextView) row.findViewById(R.id.row_item);
            food.setText(listEntry.food);
            name.setText(listEntry.name);

            // dependiendo del id de la pizza, se muestran distintas imagenes
            ImageView icon = (ImageView) row.findViewById(R.id.row_id);
            icon.setTag(new Integer(listEntry.id));
            switch (listEntry.id_pizza) {
                case 1:
                    icon.setImageResource(R.drawable.barbacoa);
                    break;
                case 2:
                    icon.setImageResource(R.drawable.pecado);
                    break;
                case 3:
                    icon.setImageResource(R.drawable.bourbon);
                    break;
                default:
                    icon.setImageResource(R.drawable.texas);
                    break;
            }
            return row;
        }
    }
    private class ListEntry {
        int id;
        String name;
        String food;
        int id_pizza;
    }

}