package com.vyp.quotes.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vyp.quotes.Model.QuoteModel;
import com.vyp.quotes.R;

import java.util.List;

public class QuotesAdapter extends RecyclerView.Adapter<QuotesAdapter.SameViewHolder> {

    //    ArrayList<Samecatmodel> data;
    public List<QuoteModel> quoteModelList;
    Context context;

    public QuotesAdapter(List<QuoteModel> quoteModelList, Context context) {
        this.quoteModelList = quoteModelList;
        this.context = context;
    }


    @NonNull
    @Override
    public SameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View sameView = inflater.inflate(R.layout.single_quote, parent, false);
        return new SameViewHolder(sameView);
    }

    @Override
    public void onBindViewHolder(@NonNull SameViewHolder holder, int position) {
        holder.catShayari.setText(quoteModelList.get(position).getQuote());
    }

    @Override
    public int getItemCount() {
        return quoteModelList.size();
    }

    class SameViewHolder extends RecyclerView.ViewHolder {

        TextView catShayari;

        public SameViewHolder(@NonNull View itemView) {
            super(itemView);
            catShayari = itemView.findViewById(R.id.catShayari);
        }
    }
}
