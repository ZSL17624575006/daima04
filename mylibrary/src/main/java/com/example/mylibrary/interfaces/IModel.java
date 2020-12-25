package com.example.mylibrary.interfaces;

import io.reactivex.disposables.Disposable;

public interface IModel {
    void addDisposable(Disposable disposable);

    void clear();
}
