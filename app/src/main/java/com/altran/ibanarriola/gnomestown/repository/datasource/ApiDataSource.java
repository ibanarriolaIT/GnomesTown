package com.altran.ibanarriola.gnomestown.repository.datasource;


import com.altran.ibanarriola.gnomestown.repository.model.GnomeList;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiDataSource {

    @Headers({
            "Content-Type: application/json"
    })
    @GET("/rrafols/mobile_test/master/data.json")
    Single<GnomeList> getGnomes();

}
