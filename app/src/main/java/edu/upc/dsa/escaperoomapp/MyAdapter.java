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
                case "pista":
                    myViewHolder.type.setText("Pista");
                    break;
                case "llave":
                    myViewHolder.type.setText("Llave");
                    break;
                case "shield":
                    myViewHolder.type.setText("Escudo");
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

            //nombre = nombre.substring(0, 1).toUpperCase() + nombre.substring(1);

            myViewHolder.name.setText(nombre);
            switch (nombre)
            {
                case "woodSword":
                    Picasso.get().load("https://www.sccpre.cat/mypng/detail/70-705224_espada-de-madera-cross.png").into(myViewHolder.img);
                    break;
                case "ironSword":
                    Picasso.get().load("https://i.pinimg.com/originals/55/40/4a/55404a52fb3359bdeaff4394d7cb81d0.png").into(myViewHolder.img);
                    break;
                case "goldSword":
                    Picasso.get().load("https://vignette.wikia.nocookie.net/horadeaventura/images/7/7f/Espadador.png/revision/latest?cb=20121124030750&path-prefix=es").into(myViewHolder.img);
                    break;
                case "pistaB":
                    Picasso.get().load("https://i.pinimg.com/originals/d3/c8/60/d3c860c48ad9f9bb48346528f74d3f48.png").into(myViewHolder.img);
                    break;
                case "pistaY":
                    Picasso.get().load("https://4.bp.blogspot.com/-w6rNRWPnMFU/UmFae6uZLyI/AAAAAAAABBM/-R1T3m-Pm2I/s640/preguntas.png").into(myViewHolder.img);
                    break;
                case "pistaR":
                    Picasso.get().load("https://pngimage.net/wp-content/uploads/2018/06/interrogantes-png-6.png").into(myViewHolder.img);
                    break;
                case "llaveB":
                    Picasso.get().load("https://scontent-mad1-1.xx.fbcdn.net/v/t1.0-9/59627072_2381151755270864_7056317532851929088_n.jpg?_nc_cat=111&_nc_ht=scontent-mad1-1.xx&oh=2b3a0a634a078c0fdd3e487fccfac39d&oe=5D5EBFF3").into(myViewHolder.img);
                    break;
                case "llaveY":
                    Picasso.get().load("https://scontent-mad1-1.xx.fbcdn.net/v/t1.0-9/59904610_2381158021936904_3630824489995993088_n.jpg?_nc_cat=105&_nc_ht=scontent-mad1-1.xx&oh=b09ac4773b91ee855ae246c60469be4e&oe=5D2FAC40").into(myViewHolder.img);
                    break;
                case "llaveR":
                    Picasso.get().load("https://scontent-mad1-1.xx.fbcdn.net/v/t1.0-9/60104433_2381144115271628_7427805772727189504_n.jpg?_nc_cat=103&_nc_ht=scontent-mad1-1.xx&oh=ea2c6e453da7810df10e08054d6b06f3&oe=5D68709D").into(myViewHolder.img);
                    break;
                case "ironShield":
                    Picasso.get().load("https://www.armouronline.com/foto/produkty/titulni_397_iron_shield.jpg").into(myViewHolder.img);
                    break;
                case "goldShield":
                    Picasso.get().load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSTjp_NQI_rE6W0lb0jMDdJpw9sdvgWzAWS1yD6Qmaz5isubG2d").into(myViewHolder.img);
                    break;
                case "woodShield":
                    Picasso.get().load("https://static.turbosquid.com/Preview/2016/11/25__06_34_55/shield_01.jpgE5C8EC95-DF67-4AEA-A488-77CE8ED30F38Original.jpg").into(myViewHolder.img);
                    break;
                default:
                    Picasso.get().load("https://i.pinimg.com/originals/d3/c8/60/d3c860c48ad9f9bb48346528f74d3f48.png").into(myViewHolder.img);
                    break;
            }
        }
        else
            myViewHolder.name.setText("Not defined");

        if (objetosList.get(i).getAtributo() != null)
            myViewHolder.cost.setText("Info : " + objetosList.get(i).getAtributo());
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