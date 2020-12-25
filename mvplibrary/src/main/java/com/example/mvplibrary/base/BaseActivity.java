package com.example.mvplibrary.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView{

    public P presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        if (presenter == null){
            presenter = getPresenter();
            presenter.attachView(this);
        }
        initView();
        initData();
    }
    protected abstract void initData();

    protected abstract void initView();

    protected abstract int getLayoutID();

    public abstract P getPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //MVP解绑
        if (presenter != null){
            presenter.detachView();
        }
    }
}
