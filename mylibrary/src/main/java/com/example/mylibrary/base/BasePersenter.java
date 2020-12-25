package com.example.mylibrary.base;

import com.example.mylibrary.interfaces.IBasePersenter;
import com.example.mylibrary.interfaces.IBaseView;

import java.lang.ref.WeakReference;

public abstract class BasePersenter<V extends IBaseView> implements IBasePersenter<V> {
    protected V mView;
    //通过弱引用把V层关联
    WeakReference<V> weakReference;


    @Override
    public void attachView(V view) {
        weakReference = new WeakReference<V>(view);
        mView = weakReference.get();
    }

    @Override
    public void unAttachView() {
        mView = null;
    }

}
