package com.example.summerone;

import android.content.Context;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter {
     private List list=new ArrayList();

    public CustomAdapter( Context context, int resource) {
        super(context, resource);
    }

    public void add(Details object) {
        list.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row=convertView;
        NewsHolder holder;
        if (row==null){
            LayoutInflater layoutInflater=(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.design,parent,false);
            holder=new NewsHolder();
            holder.author=(TextView) row.findViewById(R.id.author);
            holder.title=(TextView)row.findViewById(R.id.titlel);
            holder.content=(TextView)row.findViewById(R.id.contentl);
            holder.published=(TextView)row.findViewById(R.id.published);
            holder.image=(ImageView)row.findViewById(R.id.newsimage);
            holder.link=(TextView)row.findViewById(R.id.link);
            row.setTag(holder);
        }
        else{
            holder=(NewsHolder) row.getTag();
        }
        Details det=(Details)this.getItem(position);
        holder.author.setText(det.getAuthor());
        holder.published.setText(det.getPublishedAt());
        holder.content.setText(det.getContent());
        holder.title.setText(det.getTitle());
        holder.link.setText(det.getLink());
        ImageLoader.getInstance().displayImage(det.getImageUrl(),holder.image);

        return row;
    }
    static class NewsHolder{
        TextView author,published,content,title,link;
        ImageView image;


    }

}

