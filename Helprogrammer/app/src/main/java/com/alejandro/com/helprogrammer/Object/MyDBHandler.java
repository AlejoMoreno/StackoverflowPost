package com.alejandro.com.helprogrammer.Object;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by GSN on 01/05/2015.
 */
public class MyDBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "helprogrammer.db";
    private static final String TABLE_USUARIOS = "usuarios";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_USUARIO = "usuario";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_INTERES = "interes";

    public MyDBHandler(Context context, String name,
                       SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " +
                TABLE_USUARIOS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_USUARIO + ","
                + COLUMN_PASSWORD + "," + COLUMN_EMAIL + "," + COLUMN_INTERES + ")";
        db.execSQL(CREATE_PRODUCTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USUARIOS);
        onCreate(db);
    }

    public void addUsuario(User usuario) {

        ContentValues values = new ContentValues();
        values.put(COLUMN_USUARIO, usuario.getUsuario());
        values.put(COLUMN_PASSWORD, usuario.getPassword());
        values.put(COLUMN_EMAIL, usuario.geteMail());
        values.put(COLUMN_INTERES, usuario.getInteres());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_USUARIOS, null, values);
        db.close();
    }

    public User findUser(String userEmail) {
        String query = "Select * FROM " + TABLE_USUARIOS + " WHERE " + COLUMN_EMAIL + " =  \"" + userEmail + "\"";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        User usuario = new User();
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            usuario.setId(Integer.parseInt(cursor.getString(0)));
            usuario.setUsuario(cursor.getString(1));
            usuario.seteMail(cursor.getString(2));
            usuario.setInteres(cursor.getString(3));
            cursor.close();
        } else {
            usuario = null;
        }
        db.close();
        return usuario;
    }

    public boolean deleteUser(String userEmail) {

        boolean result = false;
        String query = "Select * FROM " + TABLE_USUARIOS + " WHERE " + COLUMN_EMAIL + " =  \"" + userEmail + "\"";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        User usuario = new User();
        if (cursor.moveToFirst()) {
            usuario.setId(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_USUARIOS, COLUMN_ID + " = ?",
                    new String[] { String.valueOf(usuario.getId()) });
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }
}
