package com.example.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, password, repassword;
    Button signup, signin;
    DBHelpher DB;
    TextView txt1,txt2,txt3,txt4,txt5;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username =(EditText) findViewById(R.id.username);
        password =(EditText) findViewById(R.id.password);
        repassword =(EditText) findViewById(R.id.repassword);
        signin  =(Button) findViewById(R.id.btnsignin);
        signup =(Button) findViewById(R.id.btnsignup);
        txt1=(TextView)findViewById(R.id.tv1);
        txt2=(TextView)findViewById(R.id.tv2);
        txt3=(TextView)findViewById(R.id.tv3);
        txt4=(TextView)findViewById(R.id.tv4);
        txt5=(TextView)findViewById(R.id.tv5);
        DB=new DBHelpher(this);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usename=username.getText().toString();
                String pass=password.getText().toString();
                String repass=repassword.getText().toString();

                if (usename.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(MainActivity.this,"FILL DETAILS",Toast.LENGTH_SHORT).show();
                else
                {
                    if(pass.equals(repass))
                    {
                        Boolean checkuser=DB.checkusername(usename);
                        if(checkuser==false)
                        {
                            Boolean insert =DB.insertData(usename,pass);
                            if(insert==true)
                            {
                                Toast.makeText(MainActivity.this,"REGISTERED SUCCESSFULLY",Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
                                startActivity(intent);
                            }
                            else
                            {
                                Toast.makeText(MainActivity.this, "REGISTRATION FAILED", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "USER ALREADY EXISTS", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "PASSWORD NOT MATCHING", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });




    }

    }
