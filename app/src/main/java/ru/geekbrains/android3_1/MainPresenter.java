package ru.geekbrains.android3_1;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import io.reactivex.functions.Consumer;

/**
 * Created by stanislav on 2/26/2018.
 */

public class MainPresenter extends MvpBasePresenter<MainView> {

    private CounterModel model;

    public MainPresenter() {
        this.model = new CounterModel();
    }

    public void button1Click() {
        model.getAt(0).subscribe(integer -> getView().setButton1Text(integer));
    }

    public void button2Click(){
        model.getAt(0).subscribe(integer -> getView().setButton1Text(integer));
    }

    public void button3Click(){
        model.getAt(0).subscribe(integer -> getView().setButton1Text(integer));
    }

    @Override
    public void attachView(MainView view) {
        super.attachView(view);
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
    }
}
