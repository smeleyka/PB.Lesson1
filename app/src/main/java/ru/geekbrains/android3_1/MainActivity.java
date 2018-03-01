package ru.geekbrains.android3_1;

import android.support.annotation.NonNull;
import android.os.Bundle;
import android.support.constraint.solver.Cache;
import android.util.Log;
import android.widget.Button;

import com.hannesdorfmann.mosby.mvp.viewstate.MvpViewStateActivity;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends MvpViewStateActivity<MainView, MainPresenter> implements MainView {
    final static String BTN_COUNTER1 = "btn1";
    final static String BTN_COUNTER2 = "btn2";
    final static String BTN_COUNTER3 = "btn3";

    @BindView(R.id.btnCounter1)
    Button button1;
    @BindView(R.id.btnCounter2)
    Button button2;
    @BindView(R.id.btnCounter3)
    Button button3;

    protected void onCreate(Bundle savedInstanceState) {
        Log.d("A_STATE", "CREATE");
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
        Log.d("A_STATE", "START");
        Cache chache = new Cache();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("A_STATE", "RESUME");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("A_STATE", "PASUE");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("A_STATE", "STOP");


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("A_STATE", "DESTROY");

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("A_STATE", "SAVE INSTANCE" + button1.toString());

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("A_STATE", "RESTORE INSTANCE");


    }

    @Override
    public ViewState<MainView> createViewState() {
        return new MyCustomViewState();
    }

    @Override
    public void onNewViewStateInstance() {

    }
}
