package com.ss.example;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sowmi on 29/08/16.
 */

public class SampleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private ArrayList<SampleData> data = new ArrayList<>();
    private static  final  int HEADER_TYPE = 1;
    private static final int ROW_TYPE = 2;

    public SampleAdapter(ArrayList<SampleData> data) {
        this.data = data;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    @Override
    public int getItemViewType(int position) {
        if(data.get(position).isHeader()){
           return HEADER_TYPE;
        }else{
            return ROW_TYPE;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){

            case HEADER_TYPE:
                View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item_header , parent , false);
                return  new HeaderViewHoler(view);

            case ROW_TYPE:
                View rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item_row , parent , false);
                return  new RowViewHolder(rowView);

            default:
                return null;

        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
       int viewType = getItemViewType(position);
        switch (viewType){
            case HEADER_TYPE:
                HeaderViewHoler headerViewHoler = (HeaderViewHoler)holder;
                headerViewHoler.headerTextView.setText(data.get(position).getTitle());
                break;
            case ROW_TYPE:
                RowViewHolder rowViewHolder = (RowViewHolder)holder;
                rowViewHolder.rowTextView.setText(data.get(position).getTitle());
                break;
            default:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public static class HeaderViewHoler extends RecyclerView.ViewHolder{
        public TextView headerTextView;
        public HeaderViewHoler(View itemView) {
            super(itemView);
            headerTextView = (TextView)itemView.findViewById(R.id.samplerecyclerview_header);
        }
    }

    public static class RowViewHolder extends RecyclerView.ViewHolder{

        public TextView rowTextView;
        public RowViewHolder(View itemView) {
            super(itemView);
            rowTextView = (TextView)itemView.findViewById(R.id.samplerecyclerview_row);
        }
    }
}
