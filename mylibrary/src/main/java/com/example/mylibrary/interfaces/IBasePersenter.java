package com.example.mylibrary.interfaces;

public interface IBasePersenter<V extends IBaseView> {
    void attachView(V view);

    void unAttachView();

}
