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
    EditText nameText,addressText;
    Repository repository;
    TextView textView,textView2;
    ImageView img_gambar,img_hasil;
    final int PICK_IMAGE_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        submit=findViewById(R.id.submit);
        nameText=findViewById(R.id.name);
        addressText=findViewById(R.id.address);
        textView = findViewById(R.id.textView);
        btn_ganti = findViewById(R.id.btn_ganti);
        img_gambar = findViewById(R.id.img_gambar);

//        balik=findViewById(R.id.btn_balik);
//
//        balik.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Intent intent=new Intent(MainActivity.this,InputActivity.class);
////                startActivity(intent);
//                balik();
//            }
//        });

        btn_ganti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select chooser"), PICK_IMAGE_REQUEST_CODE);
            }
        });

//        btn_simpan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                BitmapDrawable bitmapDrawable = (BitmapDrawable) img_gambar.getDrawable();
//                Bitmap bitmap = bitmapDrawable.getBitmap();
//
//                ContextWrapper contextWrapper = new ContextWrapper(getApplicationContext());
//                File dir = contextWrapper.getDir("simpan", Context.MODE_PRIVATE);
//                Random random = new Random();
//                String nama_gambar = "img_"+random.nextInt(1000)+System.currentTimeMillis()+".jpg";
//                File file = new File(dir, nama_gambar);
//
//                FileOutputStream fos = null;
//
//                try{
//                    fos = new FileOutputStream(file);
//                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
//                    fos.flush();
//                    fos.close();
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//
//                String path = dir.getAbsolutePath();
//                String imageName = nama_gambar;
//
//                Toast.makeText(contextWrapper, "path : "+path+", nama file : "+imageName, Toast.LENGTH_SHORT).show();
//
//
//                File file_gambar = new File(path, imageName);
//                try {
//                    Bitmap bitmap1 = Bitmap.createBitmap(BitmapFactory.decodeStream(new FileInputStream(file_gambar)));
//                    img_hasil.setImageBitmap(bitmap1);
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                }
//            }
//        });


        textView2 = findViewById(R.id.textView2);

        repository=new Repository();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create new object
                User user=new User();
                //set value to object attribute
                String alamat = user.setAddress(addressText.getText().toString().trim());
                String nama = user.setName(nameText.getText().toString().trim());
                //insert data to database
                repository.addData(user);
                textView.setText(nama);
                textView2.setText(alamat);
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