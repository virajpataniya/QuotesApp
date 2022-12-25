package com.example.magicworld.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.magicworld.Model.ApiModel;
import com.example.magicworld.R;
import com.example.magicworld.Model.Samecatmodel;

import java.util.ArrayList;
import java.util.List;

public class samecatadapter extends RecyclerView.Adapter<samecatadapter.SameViewHolder> {

//    ArrayList<Samecatmodel> data;
    public List<ApiModel> data;
    Context context;

    public samecatadapter(List<ApiModel> data) {
        this.data=data;
    }


    @NonNull
    @Override
    public SameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View sameView= inflater.inflate(R.layout.same_activity_cardview,parent,false);
        return new SameViewHolder(sameView);
    }

    @Override
    public void onBindViewHolder(@NonNull SameViewHolder holder, int position) {
        holder.catShayari.setText(data.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class SameViewHolder extends RecyclerView.ViewHolder{

        TextView catShayari;

        public SameViewHolder(@NonNull View itemView) {
            super(itemView);

            catShayari=itemView.findViewById(R.id.catShayari);
        }
    }
}
