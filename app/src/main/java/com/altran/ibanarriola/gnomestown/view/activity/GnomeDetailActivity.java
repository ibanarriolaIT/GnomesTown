package com.altran.ibanarriola.gnomestown.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.altran.ibanarriola.gnomestown.R;
import com.altran.ibanarriola.gnomestown.repository.model.Gnome;
import com.altran.ibanarriola.gnomestown.view.adapter.GnomeStringListAdapter;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class GnomeDetailActivity extends AppCompatActivity {

    @BindView(R.id.Gnome_Photo)
    ImageView gnomePhoto;
    @BindView(R.id.Gnome_Name)
    TextView gnomeName;
    @BindView(R.id.Gnome_Age)
    TextView gnomeAge;
    @BindView(R.id.Gnome_Weight)
    TextView gnomeWeight;
    @BindView(R.id.Gnome_Height)
    TextView gnomeHeight;
    @BindView(R.id.Gnome_Hair)
    TextView gnomeHair;
    @BindView(R.id.Gnome_Professions_Label)
    TextView gnomeProfessionsLabel;
    @BindView(R.id.Gnome_Friends_Label)
    TextView gnomeFriendsLabel;
    @BindView(R.id.First_Separator)
    View firstSeparator;
    @BindView(R.id.Second_Separator)
    View secondSeparator;
    @BindView(R.id.Professions_List)
    RecyclerView professionsList;
    @BindView(R.id.Friends_List)
    RecyclerView friendsList;

    Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gnome_detail);
        unbinder = ButterKnife.bind(this);
        setGnomeValues();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    private void setGnomeValues(){
        Intent intent = getIntent();
        Gnome gnome = intent.getParcelableExtra("gnome");
        gnomeName.setText(gnome.getName());
        gnomeAge.setText(String.valueOf(gnome.getAge()));
        gnomeWeight.setText(String.valueOf(gnome.getWeight()));
        gnomeHeight.setText(String.valueOf(gnome.getHeight()));
        gnomeHair.setText(gnome.getHairColor());
        String url = gnome.getPhoto().replace("http://", "https://");
        Picasso.with(this).load(url)
                .noPlaceholder()
                .fit()
                .centerInside()
                .into(gnomePhoto);

        if(gnome.getFriends().size() == 0) {
            gnomeFriendsLabel.setVisibility(View.GONE);
            friendsList.setVisibility(View.GONE);
            secondSeparator.setVisibility(View.GONE);
        }else{
            RecyclerView.LayoutManager friendsListLayoutManager = new LinearLayoutManager(getApplicationContext());
            friendsList.setLayoutManager(friendsListLayoutManager);
            GnomeStringListAdapter friendsAdapter = new GnomeStringListAdapter(gnome.getFriends());
            friendsList.setAdapter(friendsAdapter);
        }
        if(gnome.getProfessions().size() == 0){
            gnomeProfessionsLabel.setVisibility(View.GONE);
            professionsList.setVisibility(View.GONE);
            firstSeparator.setVisibility(View.GONE);
        }else{
            RecyclerView.LayoutManager professionsListLayoutManager = new LinearLayoutManager(getApplicationContext());
            professionsList.setLayoutManager(professionsListLayoutManager);
            GnomeStringListAdapter professionalAdapter = new GnomeStringListAdapter(gnome.getProfessions());
            professionsList.setAdapter(professionalAdapter);
        }
    }
}
