package com.example.apple.sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button_save;
    private Button button_next;
    private EditText pt_name,pt_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pt_name = (EditText) findViewById(R.id.pt_name);
        pt_pass = (EditText) findViewById(R.id.pt_pass);

        button_save = (Button) findViewById(R.id.button_save);

        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("Myfile", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name",pt_name.getText().toString());
                editor.putString("password",pt_pass.getText().toString());
                editor.commit();

                Toast.makeText(MainActivity.this,"Data will be saved sucessfully", Toast.LENGTH_LONG).show();

            }
        });
        button_next = (Button) findViewById(R.id.button_next);
        button_next.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,NextActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this,"Goto Next", Toast.LENGTH_LONG).show();
            }
        });
    }
}
