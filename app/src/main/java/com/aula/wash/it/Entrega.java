package com.aula.wash.it;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Objects;


public class Entrega extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrega);
        Objects.requireNonNull(getSupportActionBar()).hide();


    }
}