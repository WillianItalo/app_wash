package com.aula.wash.it;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.Objects;

public class Pedido extends AppCompatActivity {

    private Spinner paymentMethodSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);
        // OCULTA A BARRA DO LABEL
        Objects.requireNonNull(getSupportActionBar()).hide();
        // TROCA A COR DA BARRA DE STATUS
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.azul_do_wash_azul));
        }

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        Menu menu = bottomNavigationView.getMenu();

        menu.findItem(R.id.idPedido).setChecked(true);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.idPagamento) {
                startActivity(new Intent(Pedido.this, Pagamento.class));
                return true;
            } else if (itemId == R.id.idEntrega) {
                startActivity(new Intent(Pedido.this, Entrega.class));
                return true;
            } else if (itemId == R.id.idHome) {
                startActivity(new Intent(Pedido.this, TelaCentral.class));
                return true;
            } else if (itemId == R.id.idServico) {
                startActivity(new Intent(Pedido.this, Servico.class));
                return true;
            } else if (itemId == R.id.idPedido) {
                startActivity(new Intent(Pedido.this, Pedido.class));
                return true;
            }
            // Se nenhum item corresponder, retorne falso
            return false;
        });

        // VOLTA PARA A TELA DE SERVIÇOS AO CLICAR NO BOTÃO DE VOLTAR (btnVoltarCarrinho)
        ImageButton btnVoltarCarrinho = findViewById(R.id.btnvoltarCarrinho);

        btnVoltarCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Crie uma Intent para voltar para a tela de Servico
                Intent intent = new Intent(Pedido.this, Servico.class);

                // Inicie a nova Activity
                startActivity(intent);
            }
        });


        TextView txtCadastroNV = findViewById(R.id.txtCadastroNV);
        txtCadastroNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Crie uma Intent para voltar para a tela de Servico
                Intent intent = new Intent(Pedido.this, Cadastrar_endereco.class);

                // Inicie a nova Activity
                startActivity(intent);
            }
        });



        // Inicialize o Spinner
        paymentMethodSpinner = findViewById(R.id.paymentMethodSpinner);

        // Defina as opções de pagamento, incluindo "Selecionar" como a primeira opção
        String[] paymentOptions = {"Selecionar", "Cartão de Crédito", "Cartão de Débito", "Dinheiro", "PIX"};

        // Crie um ArrayAdapter e conecte-o ao Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, paymentOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        paymentMethodSpinner.setAdapter(adapter);


        // Inicialize o Spinner
        Spinner addressSpinner = findViewById(R.id.addressSpinner);

        //  lista de endereços salvos em um array
        String[] savedAddresses = {"Selecionar", "Endereço 1", "Endereço 2", "Endereço 3"};

        // ArrayAdapter e conecte-o ao Spinner
        ArrayAdapter<String> addressAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, savedAddresses);
        addressAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        addressSpinner.setAdapter(addressAdapter);


    }
}
