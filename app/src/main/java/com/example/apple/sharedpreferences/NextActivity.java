package com.example.apple.sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PrivateKey;

public class NextActivity extends AppCompatActivity {
    private Button previous;
    private Button loading;
    private TextView gt_nane,gt_pass;
    public static final String DEFAULT = "N/A";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        gt_nane = (TextView) findViewById(R.id.gt_name);
        gt_pass = (TextView) findViewById(R.id.gt_pass);
        previous = (Button) findViewById(R.id.previous);
        previous.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NextActivity.this,MainActivity.class);
                startActivity(intent);
                Toast.makeText(NextActivity.this,"Go to Previous", Toast.LENGTH_LONG).show();
            }
        });
        loading = (Button) findViewById(R.id.loading);
        loading.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("Myfile", Context.MODE_PRIVATE);
               String name = sharedPreferences.getString("name", DEFAULT);
                String password =sharedPreferences.getString("password", DEFAULT);
                if (name.equals( DEFAULT)||password.equals( DEFAULT)){
                    Toast.makeText(NextActivity.this, "Data was not found", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(NextActivity.this, "Data will be Loaded sucessfully", Toast.LENGTH_LONG).show();
                    gt_nane.setText(name);
                    gt_pass.setText(password);
                }
            }
        });

    }
}
