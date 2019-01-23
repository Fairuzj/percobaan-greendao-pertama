package com.example.ok.percobaan1;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class InputActivity extends AppCompatActivity {

    Button submit,btn_ganti,balik,btn_simpan;
    EditText nameText,addressText,luaslahanpadi,tgl_tanam,tgl_siappanen,nik,j_pekerja;
    Repository repository;
    TextView textView,textView2;
    ImageView img_gambar,img_hasil;
    final int PICK_IMAGE_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_);
        submit=findViewById(R.id.simpan);
        nameText=findViewById(R.id.nama_pemilik);
        addressText=findViewById(R.id.hasil_panen);
        textView = findViewById(R.id.textView);
        btn_ganti = findViewById(R.id.btn_ganti);
        img_gambar = findViewById(R.id.img_gambar);
        luaslahanpadi	=	findViewById	(R.id.luaslahan);
        tgl_tanam		=	findViewById	(R.id.tgl_tanama);
        tgl_siappanen	=	findViewById	(R.id.tgl_siap);
        nik				=	findViewById	(R.id.nik);
        j_pekerja		=	findViewById	(R.id.jml_tenaga);
        textView2       =   findViewById    (R.id.textView2);
        repository=new Repository();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create new object
                Padi padi=new Padi();
                //set value to object attribute
                padi.setHasilpanen(addressText.getText().toString().trim());
                padi.setPemilik(nameText.getText().toString().trim());
                padi.setLuaslahan(Integer.parseInt(luaslahanpadi.getText().toString()));
                padi.setTgl_tanam(tgl_tanam.getText().toString());
                padi.setTgl_siappanen(tgl_siappanen.getText().toString());
                padi.setNik(Integer.parseInt(nik.getText().toString()));
                padi.setPekerja(Integer.parseInt(j_pekerja.getText().toString()));
                //insert data to database
                repository.addData(padi);
//                textView.setText(nama);
//                textView2.setText(alamat);
                Toast.makeText(InputActivity.this,"berhasil memasukkan data",Toast.LENGTH_LONG).show();
                balik();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_IMAGE_REQUEST_CODE && resultCode == RESULT_OK && data != null && data.getData() !=null){
            try{
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), data.getData());
                img_gambar.setImageBitmap(bitmap);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void balik(){
        Intent back = new Intent(InputActivity.this, MainActivity.class);
        startActivity(back);
    }
}