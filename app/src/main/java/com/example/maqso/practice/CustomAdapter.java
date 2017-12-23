package com.example.maqso.practice;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static android.R.id.list;

/**
 * Created by maqso on 11/2/2017.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.AdapterViewHolder> {

    String[] list;

    public CustomAdapter(String[] list){

        this.list = list;
    }


    @Override
    public AdapterViewHolder onCreateViewHolder(ViewGroup parent, int type){

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(android.R.layout.simple_list_item_1,parent,false);

        return new AdapterViewHolder(view);
    }


    @Override
    public void onBindViewHolder(AdapterViewHolder holder, int postion){


    }
    @Override
    public int getItemCount(){

        return list.length;
    }

    public class AdapterViewHolder extends ViewHolder{


        public AdapterViewHolder(View itemView) {
            super(itemView);
        }
    }

}
