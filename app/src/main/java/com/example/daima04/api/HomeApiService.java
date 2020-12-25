package com.example.daima04.api;

import com.example.daima04.bean.HomeListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface HomeApiService {
    String URLBean = "https://cdwan.cn/api/";
    @GET("index")
    Observable<HomeListBean> getHomeListBean();
}
