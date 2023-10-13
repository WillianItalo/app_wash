package com.aula.wash.it;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterServicos extends RecyclerView.Adapter<AdapterServicos.MyViewHolder> {
    private List<ServicosNovos> ServicosNovos;
    public AdapterServicos(List<ServicosNovos> ServicoNovos) {
        this.ServicosNovos = ServicoNovos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.service_item, parent, false);
        return new MyViewHolder(itemLista);
    }

    //ATRIBUI OS ARQUIVOS PARA CARA SERVIÇO
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ServicosNovos ServicoNovos = ServicosNovos.get(position);
        holder.imgServico.setImageResource(ServicoNovos.getImgServico());
        holder.txtServico.setText(ServicoNovos.getTxtServico());
        holder.txtTitulo.setText(ServicoNovos.getTxtTitulo());
        holder.txtPreco.setText(ServicoNovos.getTxtPreco());
    }

    // QUANTIDADE DE LISTA DE SERVIÇO QUE SERA DUPLICADA
    @Override
    public int getItemCount() {
        return ServicosNovos.size();
    }

    // FAZ AS REFERENCIAS NO LAYOUT DO SERVICE_ITEM.XML
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgServico;
        private TextView txtServico;
        private TextView txtTitulo;
        private TextView txtPreco;
        public MyViewHolder( View itemView) {
            super(itemView);

            imgServico = itemView.findViewById(R.id.imgServico);
            txtServico = itemView.findViewById(R.id.txtServico);
            txtTitulo = itemView.findViewById(R.id.txtTitulo);
            txtPreco = itemView.findViewById(R.id.txtPreco);
        }
    }
}
