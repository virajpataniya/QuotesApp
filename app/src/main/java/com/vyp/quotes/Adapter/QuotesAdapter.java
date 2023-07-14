package com.vyp.quotes.Adapter;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vyp.quotes.Model.QuoteModel;
import com.vyp.quotes.R;
import com.vyp.quotes.database.DatabaseHelper;

import java.util.List;

public class QuotesAdapter extends RecyclerView.Adapter<QuotesAdapter.SameViewHolder> {

    //    ArrayList<Samecatmodel> data;
    public List<QuoteModel> quoteModelList;
    DatabaseHelper databaseHelper;
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
    public void onBindViewHolder(@NonNull SameViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.catShayari.setText(quoteModelList.get(position).getQuote());

        if (databaseHelper.isFavouriteIdPresent(quoteModelList.get(position).getId())){
            Drawable drawable = holder.favourite.getDrawable();
            drawable.setColorFilter(context.getResources().getColor(R.color.red), PorterDuff.Mode.SRC_IN);
            holder.favourite.setImageDrawable(drawable);
        }
        holder.favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable drawable = holder.favourite.getDrawable();
                if (databaseHelper.isFavouriteIdPresent(quoteModelList.get(position).getId())){
                    drawable.setColorFilter(context.getResources().getColor(R.color.purple_200), PorterDuff.Mode.SRC_IN);
                    holder.favourite.setImageDrawable(drawable);
                    databaseHelper.removeFavourite(quoteModelList.get(position).getId());
                } else {
                    drawable.setColorFilter(context.getResources().getColor(R.color.red), PorterDuff.Mode.SRC_IN);
                    holder.favourite.setImageDrawable(drawable);
                    databaseHelper.addFavourite(quoteModelList.get(position).getCategory(),quoteModelList.get(position).getId());
                }
            }
        });

        holder.copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("quote", quoteModelList.get(position).getQuote());
                clipboard.setPrimaryClip(clip);
                Toast.makeText(context, "Copied!", Toast.LENGTH_SHORT).show();
            }
        });

        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = quoteModelList.get(position).getQuote();

                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, content);

                Intent chooserIntent = Intent.createChooser(shareIntent, "Share via");
                chooserIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(chooserIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return quoteModelList.size();
    }

    class SameViewHolder extends RecyclerView.ViewHolder {

        TextView catShayari;
        ImageButton favourite, copy, share;

        public SameViewHolder(@NonNull View itemView) {
            super(itemView);
            catShayari = itemView.findViewById(R.id.catShayari);
            favourite = itemView.findViewById(R.id.favourite);
            copy = itemView.findViewById(R.id.copy);
            share = itemView.findViewById(R.id.share);
            databaseHelper = new DatabaseHelper(context);
        }
    }
}
