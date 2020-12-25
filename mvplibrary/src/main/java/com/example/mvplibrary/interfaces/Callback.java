package com.example.mvplibrary.interfaces;

public interface Callback<T> {
    void fail(String msg);

    void success(T t);
}
