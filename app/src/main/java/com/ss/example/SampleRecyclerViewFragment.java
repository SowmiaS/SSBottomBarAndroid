package com.ss.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.util.ArrayList;

/**
 * Created by sowmi on 29/08/16.
 */

public class SampleRecyclerViewFragment extends Fragment {

    private RecyclerView recyclerview;
    private SampleAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        recyclerview = new RecyclerView(this.getContext());
        recyclerview.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
        return recyclerview;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new SampleAdapter(sampleData());
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT , ViewGroup.LayoutParams.MATCH_PARENT);
        recyclerview.setLayoutManager(new LinearLayoutManager(this.getContext() , LinearLayoutManager.VERTICAL , false));
        recyclerview.setLayoutParams(params);
        recyclerview.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private ArrayList<SampleData> sampleData() {
        ArrayList<SampleData> data = new ArrayList<SampleData>();
        int year = 2000;
        for (int j = 0; j < 10; j++) {
            data.add(new SampleData("May "+year , true));
            for (int i = 0; i < 10; i++) {
                 data.add(new SampleData("Row Data" + i));
             }
            year++;
        }

        return  data;
    }
}
