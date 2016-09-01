package com.ss.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ss.bottombar.BottomBar;
import com.ss.bottombar.BottomBarItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BottomBar.BottomBarItemClickListener{

    private BottomBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.container_main , new SampleRecyclerViewFragment()).commit();
        bottomBar = (BottomBar)findViewById(R.id.bottombar);
        ArrayList<BottomBarItem> items = new ArrayList<>();
        items.add(new BottomBarItem(android.R.drawable.btn_star_big_off , android.R.drawable.btn_star_big_on , android.R.color.white , "Tab1"));
        items.add(new BottomBarItem(android.R.drawable.btn_star_big_off , android.R.drawable.btn_star_big_on , android.R.color.white , "Tab2"));
        items.add(new BottomBarItem(android.R.drawable.btn_star_big_off , android.R.drawable.btn_star_big_on , android.R.color.white , "Tab3"));
        items.add(new BottomBarItem(android.R.drawable.btn_star_big_off , android.R.drawable.btn_star_big_on , android.R.color.white , "Tab4"));
        items.add(new BottomBarItem(android.R.drawable.btn_star_big_off , android.R.drawable.btn_star_big_on , android.R.color.white , "Tab5"));
        bottomBar.setBottomBarItems(items);
        bottomBar.show();
    }


    @Override
    public void onBottomBarItemClick(int position) {
        Log.d("BottomBarClick","onBottomBarClick"+position);
    }
}
