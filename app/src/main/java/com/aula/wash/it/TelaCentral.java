package com.aula.wash.it;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.ViewFlipper;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputEditText;
import java.util.Objects;

public class TelaCentral extends AppCompatActivity {

    private TextInputEditText searchEditText;
    private static final int REQUEST_CODE_SPEECH_INPUT = 100;
    private ViewFlipper viewFlipper;
    private float lastX;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_central);
        Objects.requireNonNull(getSupportActionBar()).hide();

        new Handler().postDelayed(() -> new Intent(TelaCentral.this, TelaCentral.class), 3000);

        // MENU BOTTOM
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        Menu menu = bottomNavigationView.getMenu();


        // Marcar o item "Home" como ativo
        menu.findItem(R.id.idHome).setChecked(true);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.idPagamento) {
                startActivity(new Intent(TelaCentral.this, Pagamento.class));
                return true;
            } else if (itemId == R.id.idEntrega) {
                startActivity(new Intent(TelaCentral.this, Entrega.class));
                return true;
            } else if (itemId == R.id.idServico) {
                startActivity(new Intent(TelaCentral.this, Servico.class));
                return true;
            } else if (itemId == R.id.idPedido) {
                startActivity(new Intent(TelaCentral.this, Pedido.class));
                return true;
            }
            // Se nenhum item corresponder, retorne falso
            return false;
        });


        // Inicialize os elementos de interface do usuário
        searchEditText = findViewById(R.id.searchEditText);
        ConstraintLayout mainLayout = findViewById(R.id.layouprincipal);


        // Adicionar um ouvinte de toque ao campo de pesquisa para detectar o toque no drawableEnd
        searchEditText.setOnTouchListener((v, event) -> {
            // Verificar se o toque ocorreu no drawableEnd
            if (event.getAction() == MotionEvent.ACTION_UP) {
                int drawableEndX = searchEditText.getWidth() - searchEditText.getPaddingEnd() - searchEditText.getCompoundDrawablesRelative()[2].getIntrinsicWidth();
                if (event.getRawX() >= drawableEndX) {
                    // O toque ocorreu no drawableEnd
                    // Adicione aqui o código para lidar com o clique no drawableEnd
                    startVoiceRecognition(); // Exemplo: iniciar reconhecimento de voz
                    return true; // Consumir o evento de toque
                }
            }
            return false; // Deixe o sistema lidar com outros toques
        });

        // Adicione um ouvinte de clique ao layout principal para remover o foco do campo de pesquisa
        mainLayout.setOnTouchListener((v, event) -> {
            // Remova o foco do campo de pesquisa ao tocar fora dele
            if (searchEditText.hasFocus()) {
                searchEditText.clearFocus();
                hideKeyboard(searchEditText);
            }
            return false;
        });

        // Inicialize o ViewFlipper
        viewFlipper = findViewById(R.id.sliderflipper);

        // Adicione um ouvinte de toque para detectar gestos de deslize
        viewFlipper.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    lastX = event.getX();
                    break;
                case MotionEvent.ACTION_UP:
                    float currentX = event.getX();
                    if (lastX < currentX) {
                        // Deslize para a esquerda (anterior)
                        viewFlipper.showPrevious();
                    } else if (lastX > currentX) {
                        // Deslize para a direita (próximo)
                        viewFlipper.showNext();
                    }
                    break;
            }
            return true;
        });

        // Inicialize os botões para trocar imagens
        ImageButton btnAnterior = findViewById(R.id.btnAnterior);
        ImageButton btnProximo = findViewById(R.id.btnProximo);

        // Adicione um ouvinte de clique para os botões
        btnAnterior.setOnClickListener(v -> viewFlipper.showPrevious());

        btnProximo.setOnClickListener(v -> viewFlipper.showNext());
    }

    // Iniciar o reconhecimento de voz
    private void startVoiceRecognition() {
        Intent intent = new Intent(android.speech.RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(android.speech.RecognizerIntent.EXTRA_LANGUAGE_MODEL, android.speech.RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(android.speech.RecognizerIntent.EXTRA_LANGUAGE, java.util.Locale.getDefault());

        try {
            startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT);
        } catch (Exception e) {
            // Trate qualquer exceção que possa ocorrer ao iniciar o reconhecimento de voz
        }
    }

    // Lidar com o resultado do reconhecimento de voz
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_SPEECH_INPUT && resultCode == RESULT_OK && data != null) {
            java.util.ArrayList<String> result = data.getStringArrayListExtra(android.speech.RecognizerIntent.EXTRA_RESULTS);
            if (result != null && !result.isEmpty()) {
                String recognizedText = result.get(0);
                searchEditText.setText(recognizedText);
            }
        }
    }

    // Método para ocultar o teclado virtual
    private void hideKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
