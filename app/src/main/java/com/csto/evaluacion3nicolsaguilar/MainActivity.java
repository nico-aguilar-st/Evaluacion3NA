package com.csto.evaluacion3nicolsaguilar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton RB1, RB2, RB3;
    Button BT1, BT2;
    int x, y, a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RB1 = (RadioButton) findViewById(R.id.rb_nulo);
        RB2 = (RadioButton) findViewById(R.id.rb_gb);
        RB3 = (RadioButton) findViewById(R.id.rb_jak);
        BT1 = (Button) findViewById(R.id.btn_vot);
        BT2 = (Button) findViewById(R.id.btn_voll);

        BT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db;
                if (RB1.isChecked())
                {
                    int x = 1;
                }
                if (RB2.isChecked())
                {
                    int Y = 1;
                }
                if (RB3.isChecked())
                {
                    int a = 1;
                }
                Conexion conx =new Conexion(getApplicationContext());
                db=conx.getWritableDatabase();
                ContentValues cv=new ContentValues();
                cv.put("Nulo",x);
                cv.put("VotoG",y);
                cv.put("VotoK",a);
                db.insert("Registro",null,cv);
                Toast.makeText(getApplicationContext(),"registro insertado",Toast.LENGTH_LONG).show();
            }

        });
        BT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(),pag2.class);
                startActivity(I);
            }
        });
    }
    public void AlertAgui(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Atencion!");
        builder.setMessage("¿Esta Seguro de Continuar?");
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                SQLiteDatabase db;
                Conexion conx =new Conexion(getApplicationContext());
                db=conx.getWritableDatabase();
                ContentValues cv=new ContentValues();
                cv.put("Nulo",RB1.getText().toString());
                cv.put("VotoG",RB2.getText().toString());
                cv.put("VotoK",RB3.getText().toString());
                db.insert("Registro",null,cv);
                Toast.makeText(getApplicationContext(),"registro insertado",Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }


    }
//}