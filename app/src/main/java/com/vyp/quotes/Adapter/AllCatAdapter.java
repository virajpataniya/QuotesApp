package com.vyp.quotes.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vyp.quotes.Model.AllCategorymodel;
import com.vyp.quotes.R;
import com.vyp.quotes.View.Activity.QuotesActivity;

import java.util.ArrayList;

public class AllCatAdapter extends RecyclerView.Adapter<AllCatAdapter.catviewholder> {
    ArrayList<AllCategorymodel> categoryList;

    Context context;

    public AllCatAdapter(ArrayList<AllCategorymodel> categoryList, Context context) {
        this.categoryList = categoryList;
        this.context=context;
    }

    //This will create blank view
    @NonNull
    @Override
    public catviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_category_cardview,parent,false);
        return new catviewholder(view);
    }

    //This will bind the empty view with recycler view & resources.
    @Override
    public void onBindViewHolder(@NonNull catviewholder holder, int position) {

        final AllCategorymodel temp= categoryList.get(position);
        holder.imgCat.setImageResource(categoryList.get(position).getImage());
        holder.catHeader.setText(categoryList.get(position).getHeader());

        holder.imgCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, QuotesActivity.class);
                intent.putExtra("image",temp.getImage());
                intent.putExtra("Header",temp.getHeader());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    //This will return the array
    @Override
    public int getItemCount() {
        return categoryList.size();
    }



    /*This class will taking reference of views from the XML file.
    Here it will take reference from single_category.xml
     */
    class catviewholder  extends RecyclerView.ViewHolder {

        ImageView imgCat;
        TextView catHeader;
        public catviewholder(@NonNull View itemView) {
            super(itemView);

            imgCat=itemView.findViewById(R.id.imgCat);
            catHeader=itemView.findViewById(R.id.catHeader);

        }
    }

}

