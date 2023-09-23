package com.aula.wash.it;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button telaCadastro;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        // Referencias
        telaCadastro = findViewById(R.id.btnCadastrar);
        btnLogin = findViewById(R.id.btnLogin);

        // evento de clique para o botão de cadastro
        telaCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navegue para a tela de cadastro quando o botão for clicado
                Intent intent = new Intent(MainActivity.this, Cadastrar.class);
                startActivity(intent);
            }
        });

        // evento de clique para o botão de login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navegue para a tela de Login quando o botão for clicado e validado
                Intent intent = new Intent(MainActivity.this, TelaCentral.class);
                startActivity(intent);

                // Finalize a atividade de login (a tela de login) para que não seja possível voltar a ela
                finish();
            }
        });
    }
}
