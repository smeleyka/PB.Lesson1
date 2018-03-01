package ru.geekbrains.android3_1;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.hannesdorfmann.mosby.mvp.viewstate.MvpViewStateActivity;
import com.hannesdorfmann.mosby.mvp.viewstate.RestorableViewState;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;

/**
 * Created by smeleyka on 01.03.18.
 */

public class MyCustomViewState implements RestorableViewState<MainView> {
    private static MyCustomViewState instance;

    private MyCustomViewState() {
    }

    public synchronized MyCustomViewState getInstatnce() {
        if (instance == null) {
            return new MyCustomViewState();
        }
        return instance;
    }


    @Override
    public void saveInstanceState(@NonNull Bundle out) {

    }

    @Override
    public RestorableViewState<MainView> restoreInstanceState(Bundle in) {
        return null;
    }

    @Override
    public void apply(MainView view, boolean retained) {

    }
}
