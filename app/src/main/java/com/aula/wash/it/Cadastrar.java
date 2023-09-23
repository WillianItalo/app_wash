package com.aula.wash.it;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Cadastrar extends AppCompatActivity {

    private Button voltarLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        getSupportActionBar().hide();

        voltarLogin = findViewById(R.id.voltarLogin);

        voltarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navegue para a tela de login (MainActivity) quando o botão for clicado
                Intent intent = new Intent(Cadastrar.this, MainActivity.class);
                startActivity(intent);

                // Finalize a atividade atual (CadastrarActivity)
                finish();
            }
        });
    }
}
