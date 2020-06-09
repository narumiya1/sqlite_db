package com.rifqi.sqlite_db;


import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.rifqi.sqlite_db.database.DBMahasiswa;

public class MainActivity extends AppCompatActivity {

    private EditText NIM, Nama, TanggalLahir, Alamat ;
    private RadioButton Male, Female ;
    private Spinner Jurusan ;

    private String setNim , setNama, setTanggalLahir, setAlamat , setJurusan, setJenisKelamin ;
    private DBMahasiswa dbMahasiswa ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbMahasiswa = new DBMahasiswa(getBaseContext());

        Button simpan = findViewById(R.id.save);


        NIM = findViewById(R.id.nim);
        Nama = findViewById(R.id.nama);
        TanggalLahir = findViewById(R.id.date);
        Alamat = findViewById(R.id.alamat);

        Male = findViewById(R.id.male);
        Female = findViewById(R.id.famale);

        Jurusan = findViewById(R.id.fakultas_jurusan);

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setData();
                saveData();
                Toast.makeText(getApplicationContext(), "Data berhasil disimpan", Toast.LENGTH_SHORT).show();


            }
        });

        Button viewData = findViewById(R.id.readData);
        viewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ViewData.class));
            }
        });

    }


    private void setData() {
        setNim = NIM.getText().toString();
        setNama = Nama.getText().toString();
        setAlamat = Alamat.getText().toString();
        setTanggalLahir = TanggalLahir.getText().toString();

        setJurusan = Jurusan.getSelectedItem().toString();

        if (Male.isChecked()){
            setJenisKelamin = Male.getText().toString();
        }else if ( Female.isChecked()){
            setJenisKelamin = Female.getText().toString();
        }

        setAlamat= Alamat.getText().toString();

    }


    private void saveData() {

        SQLiteDatabase create = dbMahasiswa.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBMahasiswa.MyColumns.NIM, setNim);
        values.put(DBMahasiswa.MyColumns.Nama, setNama);
        values.put(DBMahasiswa.MyColumns.Jurusan, setJurusan);
        values.put(DBMahasiswa.MyColumns.JenisKelamin, setJenisKelamin);
        values.put(DBMahasiswa.MyColumns.TanggalLahir, setTanggalLahir);
        values.put(DBMahasiswa.MyColumns.Alamat, setAlamat);

        create.insert(DBMahasiswa.MyColumns.NamaTable,null, values);

    }

    private void clearData(){
        NIM.setText("");
        Nama.setText("");
        TanggalLahir.setText("");
        Alamat.setText("");
    }
}
