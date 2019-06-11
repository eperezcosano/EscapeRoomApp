package edu.upc.dsa.escaperoomapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import edu.upc.dsa.escaperoomapp.models.Objetos;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(Objetos objetos);
    }

    private Context context;
    private List<Objetos> objetosList;
    private OnItemClickListener listener;

    public MyAdapter(Context context, List<Objetos> objetosList, OnItemClickListener listener) {
        this.context = context;
        this.objetosList = objetosList;
        this.listener = listener;
    }

    public void setObjetosList(List<Objetos> objetosList) {
        this.objetosList = objetosList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        if (objetosList.get(i).getType() != null) {
            String tipo = objetosList.get(i).getType();

            switch (tipo) {
                case "weapon":
                    myViewHolder.type.setText("Arma");
                    myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            listener.onItemClick(objetosList.get(i));
                        }
                    });
                    break;
                default:
                    break;
            }
        }
        else
            myViewHolder.type.setText("Not defined");
        if (objetosList.get(i).getNombre() != null) {
            String nombre = objetosList.get(i).getNombre();

            nombre = nombre.substring(0, 1).toUpperCase() + nombre.substring(1);

            myViewHolder.name.setText(nombre);
            switch (nombre)
            {
                case "Katana":
                    Picasso.get().load("https://puregaming.es/wp-content/uploads/2019/01/Dw8klLOWkAEhrTX.png").into(myViewHolder.img);
                    break;
                case "Fusil":
                    Picasso.get().load("https://3.bp.blogspot.com/-_7onQnAUhjk/W0Zgdxl1YTI/AAAAAAAADHk/-DUkca9CbAguymTgJ64cY-uen7JTZ88ngCLcBGAs/s1600/THOMPSON.png").into(myViewHolder.img);
                    break;
                case "Corredera":
                    Picasso.get().load("https://fortniteestadisticas.com/assets/img//weapons/double-barrel-shotgun.png").into(myViewHolder.img);
                    break;
                default:
                    Picasso.get().load("https://puregaming.es/wp-content/uploads/2019/01/Dw8klLOWkAEhrTX.png").into(myViewHolder.img);
                    break;
            }
        }
        else
            myViewHolder.name.setText("Not defined");

        if (objetosList.get(i).getCoste() != null)
            myViewHolder.cost.setText("Coste : " + Integer.toString(objetosList.get(i).getCoste()));
        else
            myViewHolder.cost.setText("Not defined");

//        if (objetosList.get(i).getAtributo() != null)
//            myViewHolder.atribute.setText("Info: " + objetosList.get(i).getAtributo());
//        else
//            myViewHolder.atribute.setText("Not defined");

        if (objetosList.get(i).getAmount() != null)
            myViewHolder.amount.setText("Cantidad: " + Integer.toString(objetosList.get(i).getAmount()));
        else
            myViewHolder.amount.setText("Not defined");

    }

    @Override
    public int getItemCount() {
        if (objetosList != null)
            return objetosList.size();
        else
            return 0;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView type;
        private TextView name;
        private TextView cost;
        //private TextView atribute;
        private TextView amount;
        private ImageView img;

        public MyViewHolder(View itemView) {
            super(itemView);
            type = itemView.findViewById(R.id.rowType);
            name = itemView.findViewById(R.id.rowName);
            cost = itemView.findViewById(R.id.rowCost);
            //atribute = itemView.findViewById(R.id.rowAtribute);
            amount = itemView.findViewById(R.id.rowAmount);
            img = itemView.findViewById(R.id.rowImg);
        }
    }
}