package com.altran.ibanarriola.gnomestown.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.altran.ibanarriola.gnomestown.R;
import com.altran.ibanarriola.gnomestown.common.BaseView;
import com.altran.ibanarriola.gnomestown.repository.model.Gnome;
import com.altran.ibanarriola.gnomestown.view.adapter.GnomeListAdapter;
import com.altran.ibanarriola.gnomestown.view.presenter.GnomeListPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.DaggerAppCompatActivity;

public class GnomeListActivity extends DaggerAppCompatActivity
        implements GnomeListPresenter.View, BaseView, GnomeListAdapter.OnItemClickListener {

    @Inject
    GnomeListPresenter gnomeListPresenter;

    @BindView(R.id.Gnome_List)
    RecyclerView gnomeRecyclerView;

    Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        onInit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        gnomeListPresenter.detachView();
    }

    @Override
    public void onGnomesDataReceived(List<Gnome> gnomes) {
        GnomeListAdapter adapter = new GnomeListAdapter(this, gnomes);
        adapter.setOnItemClickListener(this);
        RecyclerView.LayoutManager listLayoutManager = new LinearLayoutManager(getApplicationContext());
        gnomeRecyclerView.setLayoutManager(listLayoutManager);
        gnomeRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onErrorReceivingGnomes() {
        Toast.makeText(this, R.string.error_getting_gnomes, Toast.LENGTH_LONG);
    }

    @Override
    public void onInit() {
        gnomeListPresenter.attachView(this);
        gnomeListPresenter.getGnomesInTown();
    }

    @Override
    public void onMessageItemClick(Gnome gnome) {
        Intent intent = new Intent(this, GnomeDetailActivity.class);
        intent.putExtra("gnome", gnome);
        startActivity(intent);
    }
}
