package com.example.magicworld.View.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.magicworld.R;
import com.example.magicworld.View.Fragment.AboutFragment;
import com.example.magicworld.View.Fragment.CategoryFragment;
import com.example.magicworld.View.Fragment.FavouritesFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.tab_background_selected)));


        bottomNavigationView= findViewById(R.id.bottomNavigationView);


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if (id==R.id.action_categories){
                    loadFrag(new CategoryFragment(), true);
                }
                else if (id==R.id.action_favourites){
                    loadFrag(new FavouritesFragment(),false);
                }
                else {
                    //Else is for the About Us.
                    loadFrag(new AboutFragment(),false);
                }
                return true;
            }
        });

        bottomNavigationView.setSelectedItemId(R.id.action_categories);

    }

    public void loadFrag(Fragment fragment, Boolean flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if(flag){
            ft.add(R.id.container, fragment);
        }
        else{
        ft.replace(R.id.container,fragment);
        }

        ft.commit();
    }

}