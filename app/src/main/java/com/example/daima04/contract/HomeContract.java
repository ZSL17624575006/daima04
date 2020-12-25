package com.example.daima04.contract;

import com.example.mvplibrary.base.BaseModel;
import com.example.mvplibrary.base.BaseView;
import com.example.mvplibrary.utils.INetCallBack;

//TODO  契约类
public class HomeContract {
    public interface IHomeModel extends BaseModel {
        <T> void getHomeData(String url, INetCallBack<T> callBack);
    }
    public interface IHomePresenter{
        void Home(String url);
    }
    public interface IHomeView extends BaseView {
        <T> void HomeRelt(T t);
    }
}
