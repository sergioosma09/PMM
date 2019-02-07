package com.example.sergi.finalproyect;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DataBaseHelper {
    private Context mCtx = null;
    private DataBaseHelperInternal mDbHelper = null;
    private SQLiteDatabase mDb = null;
    private static final String DATABASE_NAME = "Pizzeria";
    private static final int DATABASE_VERSION = 3;
    // tabla y campos
    private static final String DATABASE_TABLE_PIZZERIA = "pizzeria";
    public static final String SL_ID = "_id";
    public static final String SL_NAME = "name";
    public static final String SL_FOOD = "food";
    public static final String SL_ID_PIZZA = "importance";
    public static final String SL_TYPE = "type";


    private static final String DATABASE_TABLE_PEDIDO="pedido";
    public static final String PEDIDO_ID="id";
    public static final String PEDIDO_NAME="name";
    public static final String PEDIDO_PRICE="price";

    // SQL de creación de la tabla
    private static final String DATABASE_CREATE_PIZZERIA =
            "create table "+ DATABASE_TABLE_PIZZERIA +" ("+SL_ID+" integer primary key, "+ SL_NAME +" text not null, "+ SL_FOOD +" text not null, "
                    + SL_ID_PIZZA +" integer not null, "+ SL_TYPE +" text)";
    private static final String DATABASE_CREATE_PEDIDO =
            "create table "+ DATABASE_TABLE_PEDIDO +" ("+PEDIDO_ID+" integer primary key, "+ PEDIDO_NAME +" text not null, "
            + PEDIDO_PRICE +" integer not null )";
    //constructor
    public DataBaseHelper(Context ctx) {
        this.mCtx = ctx;
    }
    //clase privada para control de la SQLite
    private static class DataBaseHelperInternal extends SQLiteOpenHelper {
        public DataBaseHelperInternal(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);		}

        @Override
        public void onCreate(SQLiteDatabase db) {
            createTables(db);
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            deleteTables(db);
            createTables(db);
        }
        private void createTables(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE_PIZZERIA);
            db.execSQL(DATABASE_CREATE_PEDIDO);
        }

        private void deleteTables(SQLiteDatabase db) {
            db.execSQL("DROP TABLE IF EXISTS " + DataBaseHelper.DATABASE_TABLE_PIZZERIA);
            db.execSQL("DROP TABLE IF EXISTS " + DataBaseHelper.DATABASE_TABLE_PEDIDO);
        }
    }

    public DataBaseHelper open()  {
        mDbHelper = new DataBaseHelperInternal(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        mDbHelper.close();
    }

    //obtener todos los elementos
    public Cursor getItems() {
        //Parametros:nombreTabla,campos,campoWhere,condicionWhere,Group By, Havong, Order by
        return mDb.query(DATABASE_TABLE_PIZZERIA, new String[] {SL_ID, SL_NAME, SL_FOOD, SL_ID_PIZZA}, null, null, null, null, SL_ID_PIZZA);
        return mDb.query(DATABASE_TABLE_PEDIDO, new String[] {SL_ID, SL_NAME, SL_FOOD, SL_ID_PIZZA}, null, null, null, null, SL_ID_PIZZA);

    }



    //crear elemento
    public long insertItem(String name, String food, String type, int id_pizza){
        ContentValues initialValues = new ContentValues();
        initialValues.put(SL_ID_PIZZA, id_pizza);
        initialValues.put(SL_NAME, name);
        initialValues.put(SL_FOOD, food);
        initialValues.put(SL_TYPE, type);
        return mDb.insert(DATABASE_TABLE_PIZZERIA, null, initialValues);
    }
    public void drop(){
        this.mCtx.deleteDatabase(DATABASE_NAME);
    }

}