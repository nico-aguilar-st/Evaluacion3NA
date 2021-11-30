package com.csto.evaluacion3nicolsaguilar;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.Nullable;

public class Conexion extends SQLiteOpenHelper {
    public static String Nom_DB="VotosResultados.db";
    public static int ver_DB=1;
    public static String Nom_Tab="create table Registro (id INTEGER PRIMARY KEY autoincrement, Vot_Null integer not null, Vot_B integer not null, Vot_k integer not null)";

    public Conexion(@Nullable Context context) {
        super(context, Nom_DB,null, ver_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Nom_Tab);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Registro ");
        sqLiteDatabase.execSQL(Nom_Tab);
    }

}
