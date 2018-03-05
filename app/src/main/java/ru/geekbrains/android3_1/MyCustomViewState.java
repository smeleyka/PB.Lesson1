package ru.geekbrains.android3_1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby.mvp.viewstate.RestorableViewState;

/**
 * Created by smeleyka on 01.03.18.
 */

public class MyCustomViewState implements RestorableViewState<MainView> {
    private static MyCustomViewState instance;

    private MyCustomViewState() {
    }

    public static synchronized MyCustomViewState getInstatnce() {
        if (instance == null) {
            return new MyCustomViewState();
        }
        return instance;
    }


    @Override
    public void saveInstanceState(@NonNull Bundle out) {

        System.out.println("Save");
    }

    @Override
    public RestorableViewState<MainView> restoreInstanceState(Bundle in) {
        System.out.println("Restore");

        return null;
    }

    @Override
    public void apply(MainView view, boolean retained) {

    }
}
