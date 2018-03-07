package ru.geekbrains.android3_1;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by stanislav on 2/26/2018.
 */

public interface MainView extends MvpView
{
     public void setButton1Text(int value);
     public void setButton2Text(int value);
     public void setButton3Text(int value);
}
