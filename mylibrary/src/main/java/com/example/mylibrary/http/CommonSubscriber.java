package com.example.mylibrary.http;

import android.text.TextUtils;
import android.view.View;

import com.example.mylibrary.interfaces.Callback;

import io.reactivex.subscribers.ResourceSubscriber;

public abstract class CommonSubscriber<T> extends ResourceSubscriber<T> {
    private Callback callback;
    private String errorMsg;
    private boolean isShowErrorState = false;

    protected CommonSubscriber(Callback callback){
        this.callback = callback;
    }

    protected CommonSubscriber(Callback callback, String emsg){
        this.callback = callback;
        errorMsg = emsg;
    }

    @Override
    public void onError(Throwable t) {
        //LoadingUtil.getInstance().hideLoading();
        if(callback == null) return;
        if(errorMsg != null && TextUtils.isEmpty(errorMsg)){
            callback.fail(errorMsg);
        }
    }

    @Override
    public void onComplete() {
//        LoadingUtil.getInstance().hideLoading();
//        mView.showLoading(View.GONE);
    }
}
