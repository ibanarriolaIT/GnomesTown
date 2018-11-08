package com.altran.ibanarriola.gnomestown;

import com.altran.ibanarriola.gnomestown.repository.GnomesRepository;
import com.altran.ibanarriola.gnomestown.repository.model.GnomeList;
import com.altran.ibanarriola.gnomestown.usecase.GetGnomesList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.reactivex.observers.TestObserver;
import io.reactivex.subjects.PublishSubject;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class GetGnomesListTest {

    @Mock
    GnomesRepository gnomesRepository;
    @Mock
    GnomeList gnomeList;

    @InjectMocks
    GetGnomesList getGnomesList;

    private PublishSubject<GnomeList> gnomeListPublishSubject = PublishSubject.create();

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        when(gnomesRepository.getGnomes()).thenReturn(gnomeListPublishSubject.take(1).singleOrError());
    }

    @Test
    public void testExecuteGetGnomesListSuccess(){
        TestObserver testObserver = getGnomesList.execute().test();
        gnomeListPublishSubject.onNext(gnomeList);
        testObserver.assertComplete();
    }

    @Test
    public void testExecuteGetGnomesListError(){
        Throwable throwable = new Throwable();
        TestObserver testObserver = getGnomesList.execute().test();
        gnomeListPublishSubject.onError(throwable);
        testObserver.assertError(throwable);
    }

}