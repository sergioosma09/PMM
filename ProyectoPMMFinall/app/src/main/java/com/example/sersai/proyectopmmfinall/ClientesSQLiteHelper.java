package com.example.sersai.proyectopmmfinall;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class ClientesSQLiteHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "user_database";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_USER = "users";
    private static final String TABLE_USER_EDAD = "users_edad";
    private static final String TABLE_USER_DESCRIPTION = "users_descripcion";
    private static final String KEY_ID = "id";
    private static final String KEY_FIRSTNAME = "name";
    private static final String KEY_EDAD = "edad";
    private static final String KEY_DESCRIPTION = "descripcion";


    private static final String CREATE_TABLE_USER = "CREATE TABLE "
            + TABLE_USER + "(" + KEY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_FIRSTNAME + " TEXT );";

    private static final String CREATE_TABLE_USER_EDAD = "CREATE TABLE "
            + TABLE_USER_EDAD + "(" + KEY_ID + " INTEGER,"+ KEY_EDAD + " TEXT );";

    private static final String CREATE_TABLE_USER_DESCRIPTION = "CREATE TABLE "
            + TABLE_USER_DESCRIPTION + "(" + KEY_ID + " INTEGER,"+ KEY_DESCRIPTION + " TEXT );";

    public ClientesSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        Log.d("table", CREATE_TABLE_USER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_USER_EDAD);
        db.execSQL(CREATE_TABLE_USER_DESCRIPTION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_USER + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_USER_EDAD + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_USER_DESCRIPTION + "'");
        onCreate(db);
    }

    public void addUser(String name, String edad, String descrip) {
        SQLiteDatabase db = this.getWritableDatabase();
       
        ContentValues valores = new ContentValues();
        valores.put(KEY_FIRSTNAME, name);
      
        long id = db.insertWithOnConflict(TABLE_USER, null, valores, SQLiteDatabase.CONFLICT_IGNORE);

      
        ContentValues valoresEdad = new ContentValues();
        valoresEdad.put(KEY_ID, id);
        valoresEdad.put(KEY_EDAD, edad);
        db.insert(TABLE_USER_EDAD, null, valoresEdad);

       
        ContentValues valoresDescrip = new ContentValues();
        valoresDescrip.put(KEY_ID, id);
        valoresDescrip.put(KEY_DESCRIPTION, descrip);
        db.insert(TABLE_USER_DESCRIPTION, null, valoresDescrip);
    }

    public ArrayList<Usuario> getAllUsers() {
        ArrayList<Usuario> userModelArrayList = new ArrayList<Usuario>();

        String selectQuery = "SELECT  * FROM " + TABLE_USER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
       
        if (c.moveToFirst()) {
            do {
                Usuario usuario = new Usuario();
                usuario.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                usuario.setName(c.getString(c.getColumnIndex(KEY_FIRSTNAME)));

              
                String selectHobbyQuery = "SELECT  * FROM " + TABLE_USER_EDAD +" WHERE "+KEY_ID+" = "+ usuario.getId();
                Log.d("",selectHobbyQuery);
               
                Cursor cEdad = db.rawQuery(selectHobbyQuery, null);

                if (cEdad.moveToFirst()) {
                    do {
                        usuario.setEdad(cEdad.getString(cEdad.getColumnIndex(KEY_EDAD)));
                    } while (cEdad.moveToNext());
                }

                
                String selectCityQuery = "SELECT  * FROM " + TABLE_USER_DESCRIPTION+" WHERE "+KEY_ID+" = "+ usuario.getId();;
              
                Cursor cDescription = db.rawQuery(selectCityQuery, null);

                if (cDescription.moveToFirst()) {
                    do {
                        usuario.setDescripcion(cDescription.getString(cDescription.getColumnIndex(KEY_DESCRIPTION)));
                    } while (cDescription.moveToNext());
                }
                
                userModelArrayList.add(usuario);
            } while (c.moveToNext());
        }
        return userModelArrayList;
    }


    public void updateUser(int id, String name, String edad, String description) {
        SQLiteDatabase db = this.getWritableDatabase();

       
        ContentValues values = new ContentValues();
        values.put(KEY_FIRSTNAME, name);
        db.update(TABLE_USER, values, KEY_ID + " = ?", new String[]{String.valueOf(id)});

       
        ContentValues valuesEdad = new ContentValues();
        valuesEdad.put(KEY_EDAD, edad);
        db.update(TABLE_USER_EDAD, valuesEdad, KEY_ID + " = ?", new String[]{String.valueOf(id)});

        
        ContentValues valuesDescrip = new ContentValues();
        valuesDescrip.put(KEY_DESCRIPTION, description);
        db.update(TABLE_USER_DESCRIPTION, valuesDescrip, KEY_ID + " = ?", new String[]{String.valueOf(id)});
    }

    public void deleteUSer(int id) {

        
        SQLiteDatabase db = this.getWritableDatabase();

       
        db.delete(TABLE_USER, KEY_ID + " = ?",new String[]{String.valueOf(id)});

       
        db.delete(TABLE_USER_EDAD, KEY_ID + " = ?", new String[]{String.valueOf(id)});

        
        db.delete(TABLE_USER_DESCRIPTION, KEY_ID + " = ?",new String[]{String.valueOf(id)});
    }

}
