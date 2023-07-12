package com.vyp.quotes.View.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);
        setTitle("Same Category");

        txtId = findViewById(R.id.typeTxtId);

        sameCatRecyclerView = findViewById(R.id.sameCatRecyclerView);
        sameCatRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        txtId.setText(getIntent().getStringExtra("Header"));

        samecatObj = new QuotesAdapter(getSameCatList(), getApplicationContext());

        sameCatRecyclerView.setAdapter(samecatObj);
    }

    public ArrayList<QuoteModel> getSameCatList() {

        ArrayList<QuoteModel> sameCatArrayListObj = new ArrayList<>();

        QuoteModel s1 = new QuoteModel("Kai jeet baki hai kai haar baki hai \n" +
                "Abi to zindgi ka saar baki hai \n" +
                "Yaha se chale hai nayi manjil ke liye \n" +
                "Yeh ek panna tha abi to kitab baki hai \n" +
                "\n ");
        sameCatArrayListObj.add(s1);

        QuoteModel s2 = new QuoteModel("inkaar kiya jinhone mera samay dekhkar\n" +
                "vada hai mera essa smay bhi lauga ki\n" +
                "milna padega mujse smay leka\n" +
                "\n");
        sameCatArrayListObj.add(s2);

        QuoteModel s3 = new QuoteModel("Maafi Chahta Hu Gunahgaar hu Tera\n" +
                "Aye DiL\n" +
                "Tujhe Uske Hawale Kiya jise Teri Qadar kabhi na hui\n" +
                "\n");
        sameCatArrayListObj.add(s3);

        return sameCatArrayListObj;

    }
}