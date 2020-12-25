package com.example.daima04.model;

import com.example.daima04.bean.HomeListBean;
import com.example.daima04.contract.HomeContract;
import com.example.mvplibrary.utils.INetCallBack;
import com.example.mvplibrary.utils.RetrofitUtils;

public class HomeModel implements HomeContract.IHomeModel {
    private HomeContract.IHomePresenter presenter;

    public HomeModel(HomeContract.IHomePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public <T> void getHomeData(String url, INetCallBack<T> callBack) {
        RetrofitUtils.getInstance().get(url, new INetCallBack<HomeListBean>() {
            @Override
            public void onSuccess(HomeListBean itemBean) {
                callBack.onSuccess((T) itemBean);
            }

            @Override
            public void onFail(String err) {
                callBack.onFail(err);
            }
        });
    }
}
