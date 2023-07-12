package com.vyp.quotes.View.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vyp.quotes.Adapter.AllCatAdapter;
import com.vyp.quotes.Model.AllCategorymodel;
import com.vyp.quotes.R;

import java.util.ArrayList;

public class CategoryFragment extends Fragment {


    RecyclerView ctRecView;
    AllCatAdapter ctAdapterObj;


    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        ctRecView = view.findViewById(R.id.catRecyclerView);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        ctRecView.setLayoutManager(gridLayoutManager);


        ctAdapterObj = new AllCatAdapter(getCategoryList(), getContext());
        ctRecView.setAdapter(ctAdapterObj);

        return view;

    }


    public ArrayList<AllCategorymodel> getCategoryList() {

        ArrayList<AllCategorymodel> arrListObj = new ArrayList<>();

        AllCategorymodel c1 = new AllCategorymodel(R.drawable.joke1, "Jokes");
        arrListObj.add(c1);

        AllCategorymodel c2 = new AllCategorymodel(R.drawable.romantic, "Romantic");
        arrListObj.add(c2);

        AllCategorymodel c3 = new AllCategorymodel(R.drawable.facts, "Facts");
        arrListObj.add(c3);

        AllCategorymodel c4 = new AllCategorymodel(R.drawable.sad, "Sad Quotes");
        arrListObj.add(c4);

        AllCategorymodel c5 = new AllCategorymodel(R.drawable.dailyquote, "Daily Quotes");
        arrListObj.add(c5);

        AllCategorymodel c6 = new AllCategorymodel(R.drawable.motivation, "Motivational Quotes");
        arrListObj.add(c6);

        AllCategorymodel c7 = new AllCategorymodel(R.drawable.joke, "Extras");
        arrListObj.add(c7);

        AllCategorymodel c8 = new AllCategorymodel(R.drawable.sad, "Harsh Truth");
        arrListObj.add(c8);

        AllCategorymodel c9 = new AllCategorymodel(R.drawable.joke1, "Nine");
        arrListObj.add(c9);

        AllCategorymodel c10 = new AllCategorymodel(R.drawable.romantic, "Ten");
        arrListObj.add(c10);

        return arrListObj;
    }
}