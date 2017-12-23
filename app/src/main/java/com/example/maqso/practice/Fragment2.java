package com.example.maqso.practice;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.GridView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment {


    public Fragment2() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);
        String[] fruitArray = {"Apple", "Banana", "Orange", "Grapes"};
        GridView gv = (GridView) view.findViewById(R.id.gv);



        ArrayAdapter<String> adapter  = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,fruitArray);
            gv.setAdapter(adapter);
        return view;
    }

}
