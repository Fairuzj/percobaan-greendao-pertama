package com.example.ok.percobaan1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class InputActivity extends AppCompatActivity {

    Button submit;
    EditText nameText,addressText;
    Repository repository;
    TextView textView,textView2;
    Button balik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        submit=findViewById(R.id.submit);
        nameText=findViewById(R.id.name);
        addressText=findViewById(R.id.address);
        textView = findViewById(R.id.textView);

        balik=findViewById(R.id.btn_balik);

        balik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent=new Intent(MainActivity.this,InputActivity.class);
//                startActivity(intent);
                balik();
            }
        });


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
            }
        });

    }
    public void balik(){
        Intent back = new Intent(InputActivity.this, MainActivity.class);
        startActivity(back);
    }
}