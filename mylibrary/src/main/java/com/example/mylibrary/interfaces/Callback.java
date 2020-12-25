package com.example.mylibrary.interfaces;

public interface Callback<T> {
    void fail(String msg);

    void success(T t);
}
