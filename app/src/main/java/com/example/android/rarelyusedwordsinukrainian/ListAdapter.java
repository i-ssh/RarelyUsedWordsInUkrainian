package com.example.android.rarelyusedwordsinukrainian;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User on 01.04.16.
 */
public class ListAdapter extends BaseAdapter {
    Context cont;
    LayoutInflater lInflater;
    ArrayList<ListData> objects;

    ListAdapter(Context context, ArrayList<ListData> mylist){
        cont= context;
        objects= mylist;
        lInflater=(LayoutInflater) cont.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount(){
        return objects.size();
    }

    public Object getItem(int position){
        return objects.get(position);
    }

    public long getItemId(int position){
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent){

        View view = convertView;
        if(view==null){
        // LayoutInflater to work with layout-resources
            view = lInflater.inflate(R.layout.list_item, parent,false);
        }

        ListData p=((ListData) getItem(position));

        // fill View with data
        ((TextView) view.findViewById(R.id.wordListTextView)).setText(p.word);
        return view;
    }
}
