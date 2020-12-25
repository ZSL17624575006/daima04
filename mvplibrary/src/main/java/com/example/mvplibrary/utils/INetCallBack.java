package com.example.mvplibrary.utils;

public interface INetCallBack<T> {

    public void onSuccess(T t);

    public void onFail(String err);
}
