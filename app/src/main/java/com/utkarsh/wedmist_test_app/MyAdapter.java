package com.utkarsh.wedmist_test_app;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;


import java.util.List;

public class MyAdapter extends ArrayAdapter {
    List<String> title;
    List<String> title2;
    List<String> title3;
    List<String> title4;
    List<Integer> images;
    Context context;
    int c=0;

    public MyAdapter(@NonNull Context context,List<String> title,List<String> title2,
                     List<String> title3,List<String> title4,List<Integer> images) {
        super(context, R.layout.items,title);
        this.images=images;
        this.title3=title3;
        this.title2=title2;
        this.title=title;
        this.title4=title4;
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view= LayoutInflater.from(context).inflate(R.layout.items,parent,false);
        ImageView imageView=view.findViewById(R.id.imageView1);
        TextView textView =view.findViewById(R.id.textview1);
        TextView textView2 =view.findViewById(R.id.textview2);
        TextView textView3 =view.findViewById(R.id.textview3);
        TextView textView4 =view.findViewById(R.id.textview4);
        ImageView favIcon=view.findViewById(R.id.favicon);

        //notification code

        favIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c++;
                if(c%2!=0) {
                    ImageViewCompat.setImageTintList(favIcon, ColorStateList.valueOf(ContextCompat.getColor(context,
                            R.color.red)));
                    Toast.makeText(context,title.get(position)+" has been added to favs",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    ImageViewCompat.setImageTintList(favIcon, ColorStateList.valueOf(ContextCompat.getColor(context,
                            R.color.grey)));

                }
            }
        });

        textView.setText(title.get(position));
        textView2.setText(title2.get(position));
        textView3.setText(title3.get(position));
        textView4.setText(title4.get(position));
        imageView.setImageResource(images.get(position));

        return view;
    }
}
