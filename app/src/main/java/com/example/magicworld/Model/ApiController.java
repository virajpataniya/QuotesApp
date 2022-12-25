package com.example.magicworld.Model;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ApiController {
    private static final String url1="https://love-quote.p.rapidapi.com/";

    private static final String url2="https://healthruwords.p.rapidapi.com/";

    private static ApiController clientObj;

    private static Retrofit retrofit;

    private static Request request1;

    private static Request request2;

    // https://quotable.io/quotes/



    ApiController(){

//        retrofit=new Retrofit.Builder()
//                .baseUrl(url1)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();

        request1=new Request.Builder()
                .url(url1)
                .get()
                .addHeader("X-RapidAPI-Key", "80fa1c58afmsh3c9551d22b698f0p1b6babjsn92c01d7f15c6")
                .addHeader("X-RapidAPI-Host", "love-quote.p.rapidapi.com")
                .build();



    }

    public static synchronized ApiController getInstance(){
        if (clientObj==null)
            clientObj=new ApiController();

            return clientObj;

    }

//    public AllApiSet getApi(){
//        return retrofit.create(AllApiSet.class);
//    }
}
