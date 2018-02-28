package ru.geekbrains.android3_1;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by stanislav on 2/26/2018.
 */

public interface MainView extends MvpView
{
     public void setButtonText(int index, int value);
}
