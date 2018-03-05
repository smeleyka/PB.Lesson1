package ru.geekbrains.android3_1;

import android.support.annotation.NonNull;
import android.os.Bundle;
import android.support.constraint.solver.Cache;
import android.util.Log;
import android.widget.Button;

import com.hannesdorfmann.mosby.mvp.viewstate.MvpViewStateActivity;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;
import com.jakewharton.rxbinding2.view.RxView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.disposables.Disposable;


public class MainActivity extends MvpViewStateActivity<MainView, MainPresenter> implements MainView {

    @BindView(R.id.btnCounter1)    Button button1;
    @BindView(R.id.btnCounter2)    Button button2;
    @BindView(R.id.btnCounter3)    Button button3;

    protected Disposable button1Subscription;
    protected Disposable button2Subscription;
    protected Disposable button3Subscription;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("A_STATE", "CREATE");
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        onButton1Click();
        onButton2Click();
        onButton3Click();
    }

    private void onButton3Click() {
        button1Subscription = RxView.clicks(button1).subscribe(o -> presenter.button1Click());
    }

    private void onButton2Click() {
        button2Subscription = RxView.clicks(button2).subscribe(o -> presenter.button2Click());
    }

    private void onButton1Click() {
        button3Subscription = RxView.clicks(button3).subscribe(o -> presenter.button3Click());

    }

    @NonNull
    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
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
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("A_STATE", "SAVE INSTANCE");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("A_STATE", "RESTORE INSTANCE");
    }

    @Override
    public ViewState<MainView> createViewState() {
        return MyCustomViewState.getInstatnce();
    }

    @Override
    public void onNewViewStateInstance() {
        System.out.println("NewViewInstance");
    }
}
