package com.altran.ibanarriola.gnomestown.injection;

import com.altran.ibanarriola.gnomestown.repository.GnomesRepository;
import com.altran.ibanarriola.gnomestown.repository.datasource.ApiDataSource;
import com.altran.ibanarriola.gnomestown.repository.model.GnomeList;
import com.altran.ibanarriola.gnomestown.usecase.GetGnomesList;
import com.altran.ibanarriola.gnomestown.view.activity.GnomeListActivity;
import com.altran.ibanarriola.gnomestown.view.presenter.GnomeListPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class GnomeListModule {

    @Provides
    GnomesRepository providesGnomesRepository(ApiDataSource apiDataSource){
        return new GnomesRepository(apiDataSource);
    }

    @Provides
    GetGnomesList providesGetGnomeList(GnomesRepository gnomesRepository){
        return new GetGnomesList(gnomesRepository);
    }

    @Provides
    GnomeListPresenter.View provideGnomeListView(GnomeListActivity gnomeListActivity){
        return gnomeListActivity;
    }

    @Provides @PerActivity
    GnomeListPresenter providesGnomeListPresenter(GetGnomesList getGnomesList){
        return new GnomeListPresenter(getGnomesList);
    }
}
