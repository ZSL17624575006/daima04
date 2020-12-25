package com.example.daima04.presenter;

import com.example.daima04.bean.HomeListBean;
import com.example.daima04.contract.HomeContract;
import com.example.daima04.model.HomeModel;
import com.example.mvplibrary.base.BasePresenter;
import com.example.mvplibrary.utils.INetCallBack;

public class HomePresneter extends BasePresenter<HomeContract.IHomeView, HomeModel> implements HomeContract.IHomePresenter{

    @Override
    public void Home(String url) {
        iModel = new HomeModel(this);
        iModel.getHomeData(url, new INetCallBack<HomeListBean>() {
            @Override
            public void onSuccess(HomeListBean itemBean) {
                iView.HomeRelt(itemBean);
            }

            @Override
            public void onFail(String err) {
                iView.tips(err);
            }
        });
    }

    @Override
    public HomeModel getiModel() {
        return new HomeModel(this);
    }
}
