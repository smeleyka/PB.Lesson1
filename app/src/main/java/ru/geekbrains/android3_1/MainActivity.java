package ru.geekbrains.android3_1;

import android.support.annotation.NonNull;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.hannesdorfmann.mosby.mvp.MvpActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends MvpActivity<MainView, MainPresenter> implements MainView {
    final static String BTN_COUNTER1 = "btn1";
    final static String BTN_COUNTER2 = "btn2";
    final static String BTN_COUNTER3 = "btn3";

    @BindView(R.id.btnCounter1)
    Button button1;
    @BindView(R.id.btnCounter2)
    Button button2;
    @BindView(R.id.btnCounter3)
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.w("A_STATE", "CREATE");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @NonNull
    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @OnClick({R.id.btnCounter1, R.id.btnCounter2, R.id.btnCounter3})
    public void buttonClick(Button button) {
        switch (button.getId()) {
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
    public void setButtonText(int index, int value) {
        switch (index) {
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

    @Override
    protected void onStart() {
        super.onStart();
        Log.w("A_STATE", "START");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w("A_STATE", "RESUME");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w("A_STATE", "PASUE");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.w("A_STATE", "STOP");


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w("A_STATE", "DESTROY");

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putCharSequence(button1.toString(),button1.getText());
        outState.putCharSequence(BTN_COUNTER2,button2.getText());
        outState.putCharSequence(BTN_COUNTER3,button3.getText());
        Log.w("A_STATE", "SAVE INSTANCE" + button1.toString());

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        button1.setText(savedInstanceState.getCharSequence(button1.toString()));
        button2.setText(savedInstanceState.getCharSequence(BTN_COUNTER2));
        button3.setText(savedInstanceState.getCharSequence(BTN_COUNTER3));
        Log.w("A_STATE", "RESTORE INSTANCE");


    }
}
