package com.altran.ibanarriola.gnomestown.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class GnomeStringListAdapter extends RecyclerView.Adapter<GnomeStringListAdapter.ViewHolder> {

    List<String> professions;

    public GnomeStringListAdapter(List<String> professions){
        this.professions = professions;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = new TextView(parent.getContext());
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(professions.get(position));
    }

    @Override
    public int getItemCount() {
        return professions.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView;
        }
    }
}
