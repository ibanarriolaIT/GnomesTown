package com.altran.ibanarriola.gnomestown.usecase;

import com.altran.ibanarriola.gnomestown.repository.GnomesRepository;
import com.altran.ibanarriola.gnomestown.repository.model.GnomeList;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class GetGnomesList {

    private final GnomesRepository gnomesRepository;

    public GetGnomesList(GnomesRepository gnomesRepository) {
        this.gnomesRepository = gnomesRepository;
    }

    public Single<GnomeList> execute(){
        return Single.create(emitter -> gnomesRepository.getGnomes()
                .subscribe(
                        emitter::onSuccess,
                        throwable -> {
                            if (!emitter.isDisposed()) {
                                emitter.onError(throwable);
                            }
                        }));
    }
}
