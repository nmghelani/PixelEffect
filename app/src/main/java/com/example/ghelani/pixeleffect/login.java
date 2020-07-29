package com.example.ghelani.pixeleffect;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

    private TextView skip;
    private Button btn_login;
    private CheckBox rememberme;
    private EditText et_username;
    private EditText et_pswd;
    private Button btn_forget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        skip = (TextView) findViewById(R.id.skip);
        btn_login = (Button) findViewById(R.id.btn_login);
        rememberme = (CheckBox) findViewById(R.id.rememberme);
        et_username = (EditText) findViewById(R.id.et_username);
        et_pswd = (EditText) findViewById(R.id.et_pswd);
        btn_forget=(Button)findViewById(R.id.btn_forget);

        btn_login.setOnClickListener(new View.OnClickListener() {
            public String pswd;
            public String name;


            @Override
            public void onClick(View v) {
                name = et_username.getText().toString();
                pswd = et_pswd.getText().toString();
                if (name.isEmpty()) {
                    Toast.makeText(login.this, "Enter username first", Toast.LENGTH_SHORT).show();
                } else if (pswd.isEmpty()) {
                    Toast.makeText(login.this, "please enter password", Toast.LENGTH_SHORT).show();
                } else {
                    if (rememberme.isChecked()) {
                        SharedPreferences sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username", name);
                        editor.putString("password", pswd);
                        editor.commit();
                        //et_username.setBackgroundColor(getResources().getColor(R.color.yellow));
                    }
                }
                SharedPreferences sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();

                if (sharedPreferences.contains("username")&&sharedPreferences.contains("password")) {
                    if (sharedPreferences.getString("username", null).equals("nevil") && sharedPreferences.getString("password", null).equals("1234")) {
                        Intent intent = new Intent(login.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(login.this, "Incorrect password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        SharedPreferences sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        if (sharedPreferences.contains("username")) {
            if (sharedPreferences.getString("username", null).isEmpty()) {
            } else {
                et_username.setText(sharedPreferences.getString("username", null));
            }
        }
        if (sharedPreferences.contains("password")) {
            if (sharedPreferences.getString("password", null).isEmpty()) {
            } else {
                et_pswd.setText(sharedPreferences.getString("password", null));
            }
        }

        btn_forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                if(sharedPreferences.contains("username") && sharedPreferences.contains("password")){
                    editor.clear();
                    editor.commit();
                    et_username.setText(sharedPreferences.getString("username", null));
                    et_pswd.setText(sharedPreferences.getString("password", null));
                }else{
                    Toast.makeText(login.this, "Already forgotten", Toast.LENGTH_SHORT).show();
                }
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
