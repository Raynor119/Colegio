package com.pixels.colsanbartolome;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;





public class MostrarMateryReci3  extends RecyclerView.Adapter<MostrarMateryReci3.ViewHolder> implements View.OnClickListener{

    public int idtex;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView Materia,Promedio,quien,even;

        Context context;



        public ViewHolder(View itemView) {

            super(itemView);


            even=(TextView)itemView.findViewById(R.id.dd);
            Materia=(TextView)itemView.findViewById(R.id.MAterit);
            Promedio=(TextView)itemView.findViewById(R.id.textView);
            quien=(TextView)itemView.findViewById(R.id.textViewp);







        }

    }

    public List<meventos> promedioLista;



    private View.OnClickListener listener;



    public  MostrarMateryReci3(List<meventos> promedioLista){



        this.promedioLista=promedioLista;



    }

    @Override

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_eventos,parent,false);

        ViewHolder viewHolder=new ViewHolder(view);



        view.setOnClickListener(this);



        return viewHolder;

    }



    @Override

    public void onBindViewHolder(ViewHolder holder,int position){




holder.even.setText("EVENTO");
        holder.Materia.setText(promedioLista.get(position).getMensaje());
        String fecha="";
        int t=0;
        for(int i=0;i<promedioLista.get(position).getFecha().length();i++){
            char cC=promedioLista.get(position).getFecha().charAt(i);
            String cuc=""+cC;
            if(cuc.equals("|")){
                t=i+1;
                break;

            }else{
                fecha=fecha+cuc;
            }
        }
        String hora="";
        for(int i=t;i<promedioLista.get(position).getFecha().length();i++){
            char cC=promedioLista.get(position).getFecha().charAt(i);
            String cuc=""+cC;

            hora=hora+cuc;

        }
        holder.quien.setText("Publicado por: "+promedioLista.get(position).getQuien());
        holder.Promedio.setText("Fecha de Publicacion:"+fecha+"                  Hora:"+hora);








    }






    public void clear() {
        int size = promedioLista.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                promedioLista.remove(0);
            }

            notifyItemRangeRemoved(0, size);
        }
    }


    public void setOnClickListener(View.OnClickListener listener) {

        this.listener=listener;

    }

    @Override

    public void onClick(View view){

        if(listener!=null){





            int positi=idtex;

            listener.onClick(view);





        }



    }



    @Override

    public int getItemCount() {

        return promedioLista.size();

    }

}