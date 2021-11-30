package com.csto.evaluacion3nicolsaguilar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class pag2 extends AppCompatActivity {
    Button btnp2;
    TextView t1, t2, t3, t4;
    int cont1, cont2, cont3, cont4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pag2);

        btnp2 = (Button) findViewById(R.id.btn_voll);

        btnp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(I);
            }
        });
        SQLiteDatabase db;
        Conexion conx = new Conexion(getApplicationContext());
        db = conx.getReadableDatabase();
        Cursor C = db.query("Resultados", null, null, null, null, null, null);
        if (C != null) {
            if (C.moveToFirst()) {
                do {
                    int num1 = C.getInt(1);
                    int num2 = C.getInt(2);
                    int num3 = C.getInt(3);
                    int num4 = C.getInt(4);

                    if (num1==1){
                        cont1++;
                    }
                    if (num2==1){
                        cont2++;
                    }
                    if (num3==1){
                        cont3++;
                    }
                    if (num4==1){
                        cont4++;
                    }
                }
                while (C.moveToNext());
            }
        }

        t1.setText(cont1);
        t2.setText(cont2);
        t3.setText(cont3);
        t4.setText(cont4);
    }
}