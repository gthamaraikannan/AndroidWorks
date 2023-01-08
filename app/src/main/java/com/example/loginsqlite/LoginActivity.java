package com.example.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText username12, password12;
    Button buttonlogin12;
    DBHelpher DB;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username12=(EditText) findViewById(R.id.username1);
        password12=(EditText) findViewById(R.id.password1);
        buttonlogin12=(Button) findViewById(R.id.buttonlogin);
        DB=new DBHelpher(this);

        buttonlogin12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user=username12.getText().toString();
                String pass=password12.getText().toString();

                if(user.equals("")||pass.equals(""))
                {
                    Toast.makeText(LoginActivity.this, "PLEASE ENTER ALL FIELDS", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Boolean checkuserpassword=DB.checkusernamepassword(user,pass);
                    if(checkuserpassword==true)
                    {
                        Toast.makeText(LoginActivity.this, "SIGN IN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this, "invalid credentials ", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}