package ru.geekbrains.android3_1;

import android.support.annotation.NonNull;
import android.os.Bundle;
import android.widget.Button;

import com.hannesdorfmann.mosby.mvp.MvpActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends MvpActivity<MainView, MainPresenter> implements MainView
{
    @BindView(R.id.btnCounter1) Button button1;
    @BindView(R.id.btnCounter2) Button button2;
    @BindView(R.id.btnCounter3) Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @NonNull
    @Override
    public MainPresenter createPresenter()
    {
        return new MainPresenter();
    }

    @OnClick({R.id.btnCounter1, R.id.btnCounter2, R.id.btnCounter3})
    public void buttonClick(Button button)
    {
        switch (button.getId())
        {
            case R.id.btnCounter1:
                presenter.buttonClick(0);
                break;
            case R.id.btnCounter2:
                presenter.buttonClick(1);
                break;
            case R.id.btnCounter3:
                presenter.buttonClick(2);
                break;
        }
    }

    @Override
    public void setButtonText(int index, int value)
    {
        switch (index)
        {
            case 0:
                button1.setText(String.format(getString(R.string.count), value));
                break;
            case 1:
                button2.setText(String.format(getString(R.string.count), value));
                break;
            case 2:
                button3.setText(String.format(getString(R.string.count), value));
                break;
        }
    }
}
