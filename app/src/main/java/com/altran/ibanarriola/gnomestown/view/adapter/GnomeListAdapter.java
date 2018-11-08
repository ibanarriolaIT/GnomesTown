package com.altran.ibanarriola.gnomestown.view.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.altran.ibanarriola.gnomestown.R;
import com.altran.ibanarriola.gnomestown.repository.model.Gnome;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GnomeListAdapter extends RecyclerView.Adapter<GnomeListAdapter.ViewHolder> {

    private List<Gnome> gnomes;
    private Context context;

    private OnItemClickListener listener;

    public GnomeListAdapter(Context context, List<Gnome> gnomes) {
        this.context = context;
        this.gnomes = gnomes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gnome_list_element, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Gnome gnome = gnomes.get(position);

        holder.name.setText(gnome.getName());
        holder.age.setText(String.valueOf(gnome.getAge()));
        String url = gnome.getPhoto().replace("http://", "https://");
        Picasso.with(context).load(url)
                .noPlaceholder()
                .fit()
                .centerCrop()
                .into(holder.photo);
        holder.itemCard.setOnClickListener(v -> listener.onMessageItemClick(gnome));
    }

    @Override
    public int getItemCount() {
        return gnomes.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.Gnome_Photo)
        protected ImageView photo;
        @BindView(R.id.Gnome_Name)
        protected TextView name;
        @BindView(R.id.Gnome_Age)
        protected TextView age;
        @BindView(R.id.Item_Card)
        CardView itemCard;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public interface OnItemClickListener {

        void onMessageItemClick(Gnome gnome);
    }
}
