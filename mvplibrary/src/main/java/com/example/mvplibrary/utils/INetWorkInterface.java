package com.example.mvplibrary.utils;

import java.util.HashMap;

public interface INetWorkInterface {
    public <T> void get(String url,INetCallBack<T> callBack);
    public <T> void post(String url,INetCallBack<T> callBack);
    public <T> void post(String url, HashMap<String,String> map, INetCallBack<T> callBack);
}
