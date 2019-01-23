package com.example.ok.percobaan1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Adapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /**
     * RecyclerView = menyimpan sebanyak mungkin tampilan item yang muat di layar
     * Dan juga Hanya menggunakan tampilan dalam jumlah terbatas yang digunakan kembali saat tampilan tersebut tidak tampak di layar.
     *
     * Intinya digunakan untuk menyimpan item ke tampilan
     * **/
    RecyclerView listView;

    /**
     * Repository   =   Tempatnya menyimpan Fungsion2 buat database(Table user)
     * */
    Repository repository;
    List<Padi> list;
    MyAdapter adapter;
    Button input;
    ImageView img_gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_utama);

        listView   = (RecyclerView)   this.findViewById(R.id.listUser);
        img_gambar = findViewById(R.id.img_gambar);
        repository=new Repository();
        list=new ArrayList<>();
        adapter=new MyAdapter(list,this);

        listView.setLayoutManager(new LinearLayoutManager(this));
        listView.setHasFixedSize(true);
        listView.setItemAnimator(new DefaultItemAnimator());
        listView.setAdapter(adapter);

    }

    public void inputAdd(){
        Intent input = new Intent(MainActivity.this, InputActivity.class);
        startActivity(input);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //clear previous data in list
        list.clear();

        //get data user from database
        list.addAll(repository.getAllData());
        //renew list
        adapter.notifyDataSetChanged();


    }
    public void addNewItem(View view) {
        // Go to add item activity
        Intent intent = new Intent(this,InputActivity.class);
        intent.putExtra("create",true);
        startActivity(intent);
    }

}