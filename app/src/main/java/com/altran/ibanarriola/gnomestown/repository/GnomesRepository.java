package com.altran.ibanarriola.gnomestown.repository;

import com.altran.ibanarriola.gnomestown.repository.datasource.ApiDataSource;
import com.altran.ibanarriola.gnomestown.repository.model.GnomeList;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class GnomesRepository {

    ApiDataSource apiDataSource;

    public GnomesRepository(ApiDataSource apiDataSource) {
        this.apiDataSource = apiDataSource;
    }

    public Single<GnomeList> getGnomes() {
        return apiDataSource.getGnomes()
                .onErrorResumeNext(throwable -> Single.error(throwable));
    }

}
