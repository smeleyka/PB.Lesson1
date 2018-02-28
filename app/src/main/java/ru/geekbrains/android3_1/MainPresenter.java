package ru.geekbrains.android3_1;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

/**
 * Created by stanislav on 2/26/2018.
 */

public class MainPresenter extends MvpBasePresenter<MainView> {

    public final int BTN1 = 0;
    public final int BTN2 = 1;
    public final int BTN3 = 2;

    private CounterModel model;

    public MainPresenter() {
        this.model = new CounterModel();
    }

    private int calculateCounterValue(int index) {
        model.setAt(index, model.getAt(index) + 1);
        return model.getAt(index);
    }

    public void buttonClick(int index) {
        switch (index) {
            case BTN1:
                getView().setButtonText(BTN1, calculateCounterValue(BTN1));
                break;
            case BTN2:
                getView().setButtonText(BTN2, calculateCounterValue(BTN2));
                break;
            case BTN3:
                getView().setButtonText(BTN3, calculateCounterValue(BTN3));
                break;
        }
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
