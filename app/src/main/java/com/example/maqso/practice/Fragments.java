package com.example.maqso.practice;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by maqso on 11/1/2017.
 */

public class Fragments extends Fragment {

    public FragmentListener listener;

    public Fragments() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {

        View view = inflater.inflate(R.layout.fragments, container, false);
        listener.message("hello World");
        String[] fruitArray = {"Apple", "Banana", "Orange", "Grapes"};
        RecyclerView rv = (RecyclerView) view.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(view.getContext()));
        rv.setAdapter(new CustomAdapter(fruitArray));
        return view;

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentListener) {
            listener = (FragmentListener) context;
        } else {
            throw new RuntimeException("");
        }

    }

    @Override
    public void onDetach() {
        listener = null;
        super.onDetach();

    }


    public interface FragmentListener {

        public void message(String str);

    }

}
