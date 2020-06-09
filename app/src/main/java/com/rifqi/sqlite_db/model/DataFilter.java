package com.rifqi.sqlite_db.model;

public class DataFilter {

    private String NIM ;
    private String Nama ;
    private String Jurusan ;

    public DataFilter(String NIM, String Nama, String Jurusan) {
        this.NIM = NIM;
        this.Nama = Nama ;
        this.Jurusan = Jurusan ;
    }

    public String getNama() {
        return Nama;
    }


    public String getNIM() {
        return NIM;
    }


    public String getJurusan() {
        return Jurusan;
    }

}
