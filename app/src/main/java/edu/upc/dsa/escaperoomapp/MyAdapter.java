package edu.upc.dsa.escaperoomapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import edu.upc.dsa.escaperoomapp.models.Objetos;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private List<Objetos> objetosList;

    public MyAdapter(Context context, List<Objetos> objetosList) {
        this.context = context;
        this.objetosList = objetosList;
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
        if (objetosList.get(i).getType() != null)
            myViewHolder.type.setText(objetosList.get(i).getType());
        else
            myViewHolder.type.setText("Not defined");
        if (objetosList.get(i).getName() != null)
            myViewHolder.name.setText(objetosList.get(i).getName());
        else
            myViewHolder.name.setText("Not defined");
        if (objetosList.get(i).getCost() != null)
            myViewHolder.cost.setText(objetosList.get(i).getCost());
        else
            myViewHolder.cost.setText("Not defined");
        if (objetosList.get(i).getAtribute() != null)
            myViewHolder.atribute.setText(objetosList.get(i).getAtribute());
        else
            myViewHolder.atribute.setText("Not defined");
        if (objetosList.get(i).getAmount() != null)
            myViewHolder.amount.setText(objetosList.get(i).getAmount());
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
        private TextView atribute;
        private TextView amount;

        public MyViewHolder(View itemView) {
            super(itemView);
            type = itemView.findViewById(R.id.rowType);
            name = itemView.findViewById(R.id.rowName);
            cost = itemView.findViewById(R.id.rowCost);
            atribute = itemView.findViewById(R.id.rowAtribute);
            amount = itemView.findViewById(R.id.rowAmount);
        }
    }
}