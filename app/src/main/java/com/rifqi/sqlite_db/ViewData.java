package com.rifqi.sqlite_db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rifqi.sqlite_db.adapter.ReyclerViewAdapter;
import com.rifqi.sqlite_db.database.DBMahasiswa;
import com.rifqi.sqlite_db.model.DataFilter;

import java.util.ArrayList;

public class ViewData extends AppCompatActivity {

    private DBMahasiswa database ;

    private RecyclerView recyclerView ;
    private ReyclerViewAdapter adapter ;

    private ArrayList<DataFilter> dataList ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        dataList = new ArrayList<>();

        database = new DBMahasiswa(getBaseContext());

        recyclerView = findViewById(R.id.recycler_view);
        getData();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        adapter = new ReyclerViewAdapter(dataList);
        recyclerView.setAdapter(adapter);

        //underline pada item
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.underline));
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    private void getData() {

        SQLiteDatabase readData = database.getReadableDatabase();
        Cursor cursor = readData.rawQuery("SELECT * FROM " +DBMahasiswa.MyColumns.NamaTable,null) ;
        cursor.moveToFirst();

        for ( int count=0 ; count < cursor.getCount(); count++){
            cursor.moveToPosition(count);
            dataList.add(new DataFilter(cursor.getString(0),
                    cursor.getString(1), cursor.getString(2)));
        }
    }
}
