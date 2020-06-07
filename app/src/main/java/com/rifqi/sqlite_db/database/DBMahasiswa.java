package com.rifqi.sqlite_db.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class DBMahasiswa extends SQLiteOpenHelper {


    //inner class/abstarct utk mengatur atribut : nama tabel,kolom , & query
    static abstract class MyColumns implements BaseColumns {
        //nama tabel
        static final String NamaTable = "Mahasiswa" ;
        static final String  NIM = "NIM" ;
        static final String Nama = "Nama_Mahasiswa" ;
        static final String Jurusan  = "Jurusan" ;
        static final String JenisKelamin = "Jenis_Kelamin" ;
        static final String TanggalLahir = "Tanggal_Lahir" ;
        static final String Alamat = "Alamat" ;

    }

    private static final String NamaDatabase = "mahasiswa.db" ;
    private static final int DatabaseVersion = 1 ;


    //query table
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE "+MyColumns.NamaTable+
            "("+MyColumns.NIM+" TEXT PRIMARY KEY, "+MyColumns.Nama+" TEXT NOT NULL, "+MyColumns.Jurusan+
            " TEXT NOT NULL, "+MyColumns.JenisKelamin+" TEXT NOT NULL, "+MyColumns.TanggalLahir+
            " TEXT NOT NULL, "+MyColumns.Alamat+" TEXT NOT NULL)";

    //upgrade database
    private static final String SQL_DELETE_ENTRIES = " DROP TABLE IF EXISTS " +MyColumns.NamaTable ;



    //constructor
    public DBMahasiswa(Context context) {
        super(context ,NamaDatabase, null ,DatabaseVersion);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(SQL_DELETE_ENTRIES);
    }
}
