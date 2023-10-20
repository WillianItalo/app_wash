package com.aula.wash.it.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.aula.wash.it.R;
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

        btnVoltarCarrinho.setOnClickListener(view -> {
            Intent intent = new Intent(Pedido.this, Servico.class);

            // Inicie a nova Activity
            startActivity(intent);
        });


        TextView txtCadastroNV = findViewById(R.id.txtCadastroNV);
        txtCadastroNV.setOnClickListener(view -> {
            Intent intent = new Intent(Pedido.this, Cadastrar_endereco.class);
            startActivity(intent);
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

        paymentMethodSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Verifique a opção selecionada no Spinner
                String selectedPaymentMethod = (String) paymentMethodSpinner.getSelectedItem();

                // Se "PIX" for selecionado, exiba um AlertDialog
                if ("PIX".equals(selectedPaymentMethod)) {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Pedido.this);
                    alertDialogBuilder.setMessage("Ir para o pagamento?");
                    alertDialogBuilder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // Iniciar a atividade PIX
                            Intent intent = new Intent(Pedido.this, pg_pix.class);
                            startActivity(intent);
                        }
                    });
                    alertDialogBuilder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // Ação a ser realizada se o usuário clicar em "Não"
                            dialog.dismiss(); // Fechar o AlertDialog
                        }
                    });
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Quando nada é selecionado, se necessário
            }
        });


    }
    // Oculta o teclado virtual ao clicar fora de um campo
    private void hideKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
