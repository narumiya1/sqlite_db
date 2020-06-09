package com.rifqi.sqlite_db.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rifqi.sqlite_db.R;
import com.rifqi.sqlite_db.model.DataFilter;

import java.util.ArrayList;

public class ReyclerViewAdapter extends RecyclerView.Adapter<ReyclerViewAdapter.ViewHolder> {

    
    private ArrayList<DataFilter> dataList ;

    public ReyclerViewAdapter(ArrayList<DataFilter> dataList){
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_design, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //memanggil nilai/value view pada posisi tertentu
        final String Nama = (String) dataList.get(position).getNama();
        final String Jurusan = (String) dataList.get(position).getJurusan();
        final String NIM = (String) dataList.get(position).getNIM();

        holder.Nama.setText(Nama);
        holder.Jurusan.setText(Jurusan);
        holder.Nim.setText(NIM);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView Nama, Jurusan, Nim;

        public ViewHolder(View itemView) {
            super(itemView);


            Nama = itemView.findViewById(R.id.name_v);
            Jurusan = itemView.findViewById(R.id.jurusan_v);
            Nim = itemView.findViewById(R.id.nim_v);

        }
    }
}
