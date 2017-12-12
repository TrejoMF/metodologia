package mx.com.bogel.koalix.Adapters;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import mx.com.bogel.koalix.Objects.Propuesta;
import mx.com.bogel.koalix.R;

public class ResultadosAdapter extends RecyclerView.Adapter<ResultadosAdapter.ViewHolder> {

    Context context;
    ArrayList<Propuesta> Propuestas;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_respuesta, null);

        return new ViewHolder(view, new ViewHolder.HolderClick() {
            @Override
            public void onIClick(View view, ViewHolder viewHolder) {
                Bundle args = new Bundle();
            }
        });
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Propuesta propuesta = this.Propuestas.get(position);
        holder.propuestaMarca.setText("Marca: \n"+propuesta.getMarca());
        holder.propuestaGama.setText("Gama: \n"+propuesta.getGama());
        holder.propuestaModelo.setText("Modelo: \n"+propuesta.getModelo());
        holder.propuestaMotor.setText("Motor: \n"+propuesta.getMotor());
        holder.propuestaPlazas.setText("Plazas: \n"+propuesta.getPlazas());
        holder.propuestaPuertas.setText("Puertas: \n"+propuesta.getPuertas());
        holder.propuesta = propuesta;
    }

    @Override
    public int getItemCount() {
        if(this.Propuestas != null)
        {
            return this.Propuestas.size();
        }else{
            return 0;
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView propuestaMarca;
        public TextView propuestaGama;
        public TextView propuestaModelo;
        public TextView propuestaMotor;
        public TextView propuestaPlazas;
        public TextView propuestaPuertas;
        HolderClick holderClick;
        Propuesta propuesta;

        public ViewHolder(View itemView, HolderClick holderClick) {
            super(itemView);
            this.holderClick = holderClick;
            this.propuestaMotor = (TextView)itemView.findViewById(R.id.motor_txt);
            this.propuestaPlazas = (TextView)itemView.findViewById(R.id.plazas_txt);
            this.propuestaPuertas = (TextView)itemView.findViewById(R.id.puertas_txt);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            holderClick.onIClick(v,this);
        }

        public interface HolderClick {
            void onIClick(View view, ViewHolder viewHolder);
        }
    }
    public ResultadosAdapter(Context context, ArrayList<Propuesta> itemsMenu) {
        this.context = context;
        this.Propuestas = itemsMenu;
    }
}

