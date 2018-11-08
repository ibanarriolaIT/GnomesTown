package com.altran.ibanarriola.gnomestown.view.presenter;

import com.altran.ibanarriola.gnomestown.common.BasePresenter;
import com.altran.ibanarriola.gnomestown.repository.model.Gnome;
import com.altran.ibanarriola.gnomestown.usecase.GetGnomesList;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class GnomeListPresenter extends BasePresenter{

    GetGnomesList getGnomesList;

    public GnomeListPresenter(GetGnomesList getGnomesList){
        this.getGnomesList = getGnomesList;
    }

    public void getGnomesInTown(){
        getGnomesList.execute()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(gnomeList -> ((View) getView()).onGnomesDataReceived(gnomeList.getGnomeList()),
                throwable -> ((View) getView()).onErrorReceivingGnomes());
    }

    public interface View {
        void onGnomesDataReceived(List<Gnome> gnomes);
        void onErrorReceivingGnomes();
    }
}
