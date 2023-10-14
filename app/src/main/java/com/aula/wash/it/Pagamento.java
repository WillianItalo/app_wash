package com.aula.wash.it;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

public class Pagamento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        // OCULTA A BARRA DO LABEL
        Objects.requireNonNull(getSupportActionBar()).hide();
        // TROCA A COR DA BARRA DE STATUS
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.azul_do_wash_azul));
        }

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        Menu menu = bottomNavigationView.getMenu();


        menu.findItem(R.id.idPagamento).setChecked(true);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.idPagamento) {
                startActivity(new Intent(Pagamento.this, Pagamento.class));
                return true;
            } else if (itemId == R.id.idEntrega) {
                startActivity(new Intent(Pagamento.this, Entrega.class));
                return true;
            } else if (itemId == R.id.idHome) {
                startActivity(new Intent(Pagamento.this, TelaCentral.class));
                return true;
            } else if (itemId == R.id.idServico) {
                startActivity(new Intent(Pagamento.this, Servico.class));
                return true;
            }else if (itemId == R.id.idPedido) {
                startActivity(new Intent(Pagamento.this, Pedido.class));
                return true;
            }
            // Se nenhum item corresponder, retorne falso
            return false;
        });
    }
}