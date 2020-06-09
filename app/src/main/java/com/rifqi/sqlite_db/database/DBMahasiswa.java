package com.rifqi.sqlite_db.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class DBMahasiswa extends SQLiteOpenHelper {


    //inner class/abstarct utk mengatur atribut : nama tabel,kolom , & query
    public static abstract class MyColumns implements BaseColumns {
        //nama tabel
        public static final String NamaTable = "Mahasiswa" ;
        public static final String NIM = "NIM" ;
        public static final String Nama = "Nama_Mahasiswa" ;
        public static final String Jurusan  = "Jurusan" ;
        public static final String JenisKelamin = "Jenis_Kelamin" ;
        public static final String TanggalLahir = "Tanggal_Lahir" ;
        public static final String Alamat = "Alamat" ;

    }

    private static final String NamaDatabase = "mahasiswa.db" ;
    private static final int DatabaseVersion = 14 ;


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
        onCreate(db);
    }
}
