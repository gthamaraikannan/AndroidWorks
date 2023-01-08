package com.example.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //@SuppressLint({"MissingInflatedId", "LocalSuppress"})
        TextView txtt1=(TextView) findViewById(R.id.tvvv1);
    }
}