package com.aula.wash.it;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat; // Importe a classe ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Build; // Importe a classe Build

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Servico extends AppCompatActivity {

    private List<ServicosNovos> ServicosNovos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // OCULTA A BARRA DO LABEL
        Objects.requireNonNull(getSupportActionBar()).hide();
        // TROCA A COR DA BARRA DE STATUS
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.azul_do_wash_azul));
        }

        setContentView(R.layout.activity_servico);

        RecyclerView recyclerServicos = findViewById(R.id.RecyclerServicos);
        // DEFINE LAYOUT
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerServicos.setLayoutManager(layoutManager);

        // DEFINE ADAPTER
        this.prepararServicos();
        AdapterServicos adapter = new AdapterServicos(ServicosNovos);
        recyclerServicos.setAdapter(adapter);
    }

    // CONFIGURA UMA NOVA LISTA DE SERVIÇOS
    public void prepararServicos() {
        ServicosNovos servico1 = new ServicosNovos();
        servico1.setImgServico(R.drawable.servico1);
        servico1.setTxtServico("Serviço 1");
        servico1.setTxtTitulo("Higienização geral");
        servico1.setTxtPreco("R$ 50.00");
        this.ServicosNovos.add(servico1);

        ServicosNovos servico2 = new ServicosNovos();
        servico2.setImgServico(R.drawable.servico2);
        servico2.setTxtServico("Serviço 2");
        servico2.setTxtTitulo("Pintura de boost");
        servico2.setTxtPreco("R$ 20.00");
        this.ServicosNovos.add(servico2);

        ServicosNovos servico3 = new ServicosNovos();
        servico3.setImgServico(R.drawable.servico3);
        servico3.setTxtServico("Serviço 3");
        servico3.setTxtTitulo("Pintura de mid");
        servico3.setTxtPreco("R$ 30.00");
        this.ServicosNovos.add(servico3);

        ServicosNovos servico4 = new ServicosNovos();
        servico4.setImgServico(R.drawable.servico4);
        servico4.setTxtServico("Serviço 4");
        servico4.setTxtTitulo("Impermeabilização");
        servico4.setTxtPreco("R$ 20.00");
        this.ServicosNovos.add(servico4);

        ServicosNovos servico5 = new ServicosNovos();
        servico5.setImgServico(R.drawable.servico5);
        servico5.setTxtServico("Serviço 5");
        servico5.setTxtTitulo("Hidratação");
        servico5.setTxtPreco("R$ 30.00");
        this.ServicosNovos.add(servico5);

        ServicosNovos servico6 = new ServicosNovos();
        servico6.setImgServico(R.drawable.servico6);
        servico6.setTxtServico("Serviço 6");
        servico6.setTxtTitulo("Renovação camurça");
        servico6.setTxtPreco("R$ 55.00");
        this.ServicosNovos.add(servico6);

        ServicosNovos servico7 = new ServicosNovos();
        servico7.setImgServico(R.drawable.servico7);
        servico7.setTxtServico("Serviço 7");
        servico7.setTxtTitulo("Colagem");
        servico7.setTxtPreco("R$ 39.99");
        this.ServicosNovos.add(servico7);

        ServicosNovos servico8 = new ServicosNovos();
        servico8.setImgServico(R.drawable.servico8);
        servico8.setTxtServico("Serviço 8");
        servico8.setTxtTitulo("Reparos");
        servico8.setTxtPreco("R$ 39.99");
        this.ServicosNovos.add(servico8);

        ServicosNovos servico9 = new ServicosNovos();
        servico9.setImgServico(R.drawable.servico9);
        servico9.setTxtServico("Serviço 9");
        servico9.setTxtTitulo("Remoção de crease");
        servico9.setTxtPreco("R$ 39.99");
        this.ServicosNovos.add(servico9);


    }
}
