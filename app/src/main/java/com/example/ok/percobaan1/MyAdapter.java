package com.example.ok.percobaan1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Padi> list;
    Context context;

    public MyAdapter(List<Padi> list, Context context){
        this.list=list;
        this.context=context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder item=(ViewHolder) viewHolder;
        Padi padi=list.get(i);

        item.getName().setText(padi.getPemilik());

        Log.e("name",padi.getPemilik());

        item.getHasil().setText(padi.getHasilpanen());

        Log.e("address",padi.getHasilpanen());
    }


    @Override
    public int getItemCount() {

        return list.size();
    }
}