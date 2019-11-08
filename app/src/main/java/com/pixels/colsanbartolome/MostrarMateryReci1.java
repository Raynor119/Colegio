package com.pixels.colsanbartolome;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;





public class MostrarMateryReci1  extends RecyclerView.Adapter<MostrarMateryReci1.ViewHolder> implements View.OnClickListener{

    public int idtex;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView Materia,Promedio;

        Context context;



        public ViewHolder(View itemView) {

            super(itemView);



            Materia=(TextView)itemView.findViewById(R.id.MAterit);







        }

    }

    public List<cursos> promedioLista;



    private View.OnClickListener listener;



    public  MostrarMateryReci1(List<cursos> promedioLista){



        this.promedioLista=promedioLista;



    }

    @Override

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cursos,parent,false);

        ViewHolder viewHolder=new ViewHolder(view);



        view.setOnClickListener(this);



        return viewHolder;

    }



    @Override

    public void onBindViewHolder(ViewHolder holder,int position){





        holder.Materia.setText(promedioLista.get(position).getCursos());









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