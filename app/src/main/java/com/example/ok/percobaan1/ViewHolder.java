package com.example.ok.percobaan1;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ViewHolder extends RecyclerView.ViewHolder {

    TextView name,address;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        name=itemView.findViewById(R.id.item_name);
        address = itemView.findViewById(R.id.item_address);
    }

    public TextView getName() {
        return name;
    }

    public TextView getAddress(){
        return address;
    }
}

