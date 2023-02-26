package com.example.god;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {
    ImageButton btnTest3;
    ImageButton btnTest2;
    ImageButton btnTest;
    ImageButton btnTest1;
    private boolean isResume;
    ImageButton Quit;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTest3 = findViewById(R.id.contacts);
        btnTest3.setOnClickListener(view -> {
            Intent intent;
            intent = new Intent(MainActivity.this, contactActivity.class);
            startActivity(intent);
        });
        btnTest2 = findViewById(R.id.sms);
        btnTest2.setOnClickListener(view -> {
            Intent intent;
            intent = new Intent(MainActivity.this, smsActivity.class);
            startActivity(intent);
        });
        ImageButton alertd = findViewById(R.id.alert);
        alertd.setOnClickListener(view -> openDialog());

        btnTest1=findViewById(R.id.mic);
        btnTest1.setOnClickListener(view -> {
            if(!isResume){
                isResume=true;
                btnTest1.setImageResource(
                        R.drawable.micon
                );
            }
            else{
                isResume=false;
                btnTest1.setImageResource(
                        R.drawable.micoff
                );
            }
        });

        btnTest=findViewById(R.id.cam);
        btnTest.setOnClickListener(view -> {
            if(!isResume){
                isResume=true;
                btnTest.setImageResource(
                        R.drawable.camon
                );
            }
            else{
                isResume=false;
                btnTest.setImageResource(
                        R.drawable.camoff
                );
            }
        });

        Quit = findViewById(R.id.exit);
        Quit.setOnClickListener(v -> finish());
    }

    public void openDialog(){
        ExampleDialog exampleDialog=new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(),"example dialog");
    }


}