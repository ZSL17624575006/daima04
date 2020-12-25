package com.example.mylibrary.base;

import com.example.mylibrary.interfaces.IModel;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BaseModel implements IModel {
    CompositeDisposable disposableSet = new CompositeDisposable();
    @Override
    public void addDisposable(Disposable disposable) {
        disposableSet.add(disposable);
    }

    @Override
    public void clear() {
        disposableSet.clear();
    }
}
