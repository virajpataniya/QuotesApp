package com.example.magicworld.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AllApiSet {
//    @GET("id")
//    Call<ApiModel> getData();
    @GET("lovequote")
    Call<List<ApiModel>> loveCatData();

    @GET("v1/quotes/?t=Wisdom&maxR=1&size=medium&id=731")
    Call<List<ApiModel>> inspirationalCatData();

    //This class would contains the different APIs for different categories of quotes.
}
