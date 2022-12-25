package com.example.magicworld.categoryactivities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.magicworld.Adapter.samecatadapter;
import com.example.magicworld.Model.AllApiSet;
import com.example.magicworld.Model.ApiModel;
import com.example.magicworld.Model.Samecatmodel;
import com.example.magicworld.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;


public class SameListActivity extends AppCompatActivity {

    ImageView imgId;
    TextView txtId, catShayari;
    RecyclerView sameCatRecyclerView;
    samecatadapter samecatObj;
    OkHttpClient client=new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_same_list);
        setTitle("Same Category");

        imgId=findViewById(R.id.typeImgId);
        txtId=findViewById(R.id.typeTxtId);
        catShayari=findViewById(R.id.catShayari);


        sameCatRecyclerView=(RecyclerView)findViewById(R.id.sameCatRecyclerView);
        sameCatRecyclerView.setLayoutManager(new LinearLayoutManager(this));


//        Retrofit retrofit= new Retrofit.Builder()
//                .baseUrl("https://quotable.io/quotes/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                                .build();

//        AllApiSet allApiSet = retrofit.create(AllApiSet.class);

        try {
            processData();
        } catch (IOException e) {
            e.printStackTrace();
        }


        imgId.setImageResource(getIntent().getIntExtra("Image Name",0));
        txtId.setText(getIntent().getStringExtra("Header"));


//        samecatObj=new samecatadapter(getSameCatList(), getApplicationContext());

    }

    public void processData() throws IOException {
//        Call<List<ApiModel>> call = ApiController
//                         .getInstance()
//                                 .getApi().inspirationalCatData();

        request1();

//        call.enqueue(new Callback<List<ApiModel>>() {
//            @Override
//            public void onResponse(Call<List<ApiModel>> call, Response<List<ApiModel>> response) {
//                if (!response.isSuccessful()){
//                    catShayari.setText("Code: " + response.code());
//                    return;
//                }

//                List<ApiModel> apiModelObj= response.body();
//
//                if (apiModelObj!=null)
//                {
////                    String content= "";
////                    content+= "ID" + apiModelObj.get_id() + "\n";
////                    content+= "Shayari" + apiModelObj.getContent() +"\n";
////                    content+= "Author" + apiModelObj.getAuthor() + "\n";
//
////                    catShayari.append(content);
//                    samecatObj=new samecatadapter(data, getApplicationContext() );
//                    sameCatRecyclerView.setAdapter(samecatObj);
//                }

            }

//            @Override
//            public void onFailure(Call<List<ApiModel>> call, Throwable t) {
//                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
//                catShayari.setText(t.getMessage());
//            }
//        });


    public void request1() throws IOException {
      Request request2=new Request.Builder()
                .url("https://healthruwords.p.rapidapi.com/v1/quotes/?t=Wisdom&maxR=1&size=medium&id=731")
                .get()
                .addHeader("X-RapidAPI-Key", "SIGN-UP-FOR-KEY")
                .addHeader("X-RapidAPI-Host", "healthruwords.p.rapidapi.com")
                .build();

        client.newCall(request2).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(@NonNull okhttp3.Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull okhttp3.Call call, @NonNull okhttp3.Response response) throws IOException {


                List<AllApiSet> data= (List<AllApiSet>) response.body();
                Log.e("TAGG",data.size()+"");

                //List<ApiModel> listData= (List<ApiModel>) data;
               //samecatadapter adapter = new samecatadapter(listData);
               // sameCatRecyclerView.setAdapter(adapter);

            }
        });


    }


    public ArrayList<Samecatmodel> getSameCatList() {

    ArrayList<Samecatmodel> sameCatArrayListObj= new ArrayList<>();

    Samecatmodel s1= new Samecatmodel("Kai jeet baki hai kai haar baki hai \n" +
            "Abi to zindgi ka saar baki hai \n" +
            "Yaha se chale hai nayi manjil ke liye \n" +
            "Yeh ek panna tha abi to kitab baki hai \n" +
            "\n ");
    sameCatArrayListObj.add(s1);

        Samecatmodel s2= new Samecatmodel("inkaar kiya jinhone mera samay dekhkar\n" +
                "vada hai mera essa smay bhi lauga ki\n" +
                "milna padega mujse smay leka\n" +
                "\n");
        sameCatArrayListObj.add(s2);

        Samecatmodel s3= new Samecatmodel("Maafi Chahta Hu Gunahgaar hu Tera\n" +
                "Aye DiL\n" +
                "Tujhe Uske Hawale Kiya jise Teri Qadar kabhi na hui\n" +
                "\n");
        sameCatArrayListObj.add(s3);



    return sameCatArrayListObj;

    }
}