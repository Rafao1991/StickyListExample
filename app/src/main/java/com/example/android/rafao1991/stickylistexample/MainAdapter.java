package com.example.android.rafao1991.stickylistexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

public class MainAdapter extends BaseAdapter implements StickyListHeadersAdapter {

    private Context context;
    private List<String> list;

    public MainAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        HeaderViewHolder holder;

        if (convertView == null) {
            holder = new HeaderViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.header_main, parent, false);
            holder.textview = (TextView) convertView.findViewById(R.id.textview);
            convertView.setTag(holder);
        } else {
            holder = (HeaderViewHolder) convertView.getTag();
        }

        //set header text as first char in name
        String headerText = "TITLE";
        holder.textview.setText(headerText);
        return convertView;
    }

    @Override
    public long getHeaderId(int position) {
        return getItem(position).toString().toLowerCase().contains("h") ? 1 : 0;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        if (view == null) {
            holder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.adapter_main, viewGroup, false);
            holder.textview = (TextView) view.findViewById(R.id.textview);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.textview.setText(getItem(i).toString());

        return view;
    }

    class HeaderViewHolder {
        TextView textview;
    }

    class ViewHolder {
        TextView textview;
    }
}
