package com.vyp.quotes.View.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.vyp.quotes.Adapter.QuotesAdapter;
import com.vyp.quotes.Model.QuoteModel;
import com.vyp.quotes.R;

import java.util.ArrayList;

import okhttp3.OkHttpClient;


public class QuotesActivity extends AppCompatActivity {
    TextView txtId;
    RecyclerView sameCatRecyclerView;
    QuotesAdapter samecatObj;
    OkHttpClient client = new OkHttpClient();
    private DatabaseReference mDatabase;
    String header = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);
        setTitle("Same Category");

        txtId = findViewById(R.id.typeTxtId);

        sameCatRecyclerView = findViewById(R.id.sameCatRecyclerView);
        sameCatRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        header = getIntent().getStringExtra("Header");
        txtId.setText(header);

//        samecatObj = new QuotesAdapter(getSameCatList(), getApplicationContext());
//        sameCatRecyclerView.setAdapter(samecatObj);
        getSameCatList();
    }

    public void getSameCatList() {

        ArrayList<QuoteModel> quoteArrayList = new ArrayList<>();

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                } else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
                    DataSnapshot dataSnapshot = task.getResult();

                    for (DataSnapshot quoteSnapshot : dataSnapshot.getChildren()) {
                        QuoteModel quote = quoteSnapshot.getValue(QuoteModel.class);

                        switch (header){
                            case "Happiness":
                                if (quote.getCategory().equalsIgnoreCase("Happiness Quotes")){
                                    quoteArrayList.add(quote);
                                }
                                break;
                            case "Romantic":
                                break;
                            case "Sad Quotes":
                                break;
                            case "Daily Quotes":
                                break;
                            case "Motivational Quotes":
                                if (quote.getCategory().equalsIgnoreCase("Inspiring Life Quotes")){
                                    quoteArrayList.add(quote);
                                }
                                break;
                            case "Extras":
                                break;
                            case "Harsh Truth":
                                break;
                            case "Nine":
                                break;
                            case "Ten":
                                break;
                            default:
                                Log.e("viraj","wrong category");
                        }
                    }
                    samecatObj = new QuotesAdapter(quoteArrayList, getApplicationContext());
                    sameCatRecyclerView.setAdapter(samecatObj);
                }
            }
        });

//        try {
//            Gson gson = new Gson();
//            Type listType = new TypeToken<List<QuoteModel>>() {}.getType();
//            List<QuoteModel> quotes = gson.fromJson(jsonString, listType);
//            quoteArrayList.addAll(quotes);
//            samecatObj = new QuotesAdapter(quoteArrayList, getApplicationContext());
//            sameCatRecyclerView.setAdapter(samecatObj);
//            Log.d("firebase", "111");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        return quoteArrayList;

    }
}