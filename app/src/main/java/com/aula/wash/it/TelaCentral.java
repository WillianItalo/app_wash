package com.aula.wash.it;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaCentral extends AppCompatActivity {

    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_central);
        getSupportActionBar().hide();

        btnVoltar = findViewById(R.id.btnVoltar);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navegue de volta para a tela de login (MainActivity)
                Intent intent = new Intent(TelaCentral.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
