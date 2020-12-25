package com.example.daima04.fragment;

import android.graphics.Color;
import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.daima04.R;
import com.example.daima04.adapter.BannerAdapter;
import com.example.daima04.adapter.MyAdapter;
import com.example.daima04.bean.HomeListBean;
import com.example.daima04.contract.HomeContract;
import com.example.daima04.presenter.HomePresneter;
import com.example.mvplibrary.base.BaseFragment;
import com.example.mvplibrary.utils.URLConstant;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeFragment extends BaseFragment<HomePresneter> implements HomeContract.IHomeView {

    @BindView(R.id.home_rv)
    RecyclerView homeRv;
    private ArrayList<HomeListBean.DataBean.BannerBean> bannerBeans;
    private BannerAdapter bannerAdapter;
    private ArrayList<HomeListBean.DataBean.ChannelBean> channelBeans;

    @Override
    protected void initData() {
        presenter.Home(URLConstant.NEWLIST);
    }

    @Override
    protected void initView() {
        bannerBeans = new ArrayList<>();
        channelBeans = new ArrayList<>();
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(getContext());
        //设置回收复用线程池大小
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        homeRv.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 10);
        //通栏
        MyAdapter myAdapter = initTongLan();
        //Banner
        bannerAdapter = initBanner();
        //channel---居家
        //ChannelAdapter channelAdapter = initChannel();

        DelegateAdapter adapter = new DelegateAdapter(layoutManager, true);
        adapter.addAdapter(myAdapter);
        adapter.addAdapter(bannerAdapter);
        homeRv.setLayoutManager(layoutManager);
        homeRv.setAdapter(adapter);
    }

    private BannerAdapter initBanner() {
        ColumnLayoutHelper columnLayoutHelper = new ColumnLayoutHelper();
        columnLayoutHelper.setPadding(0, 0, 0, 0);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        columnLayoutHelper.setMargin(40, 20, 40, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        columnLayoutHelper.setBgColor(Color.WHITE);
        columnLayoutHelper.setItemCount(1);
        columnLayoutHelper.setAspectRatio(2);
        BannerAdapter bannerAdapter = new BannerAdapter(columnLayoutHelper, bannerBeans);
        return bannerAdapter;
    }

    private MyAdapter initTongLan() {
        /**
         TODO 设置通栏布局
         */
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        // 公共属性
        singleLayoutHelper.setItemCount(3);// 设置布局里Item个数
        //singleLayoutHelper.setPadding(0, 0, 0, 0);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        //singleLayoutHelper.setMargin(40, 20, 40, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        singleLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        singleLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比
        MyAdapter myAdapter = new MyAdapter(singleLayoutHelper);
        return myAdapter;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.home_fragment;
    }

    @Override
    public HomePresneter getPresenter() {
        return new HomePresneter();
    }

    @Override
    public void tips(String string) {

    }

    @Override
    public <T> void HomeRelt(T t) {
        HomeListBean bean = (HomeListBean) t;
        //首页banner
        List<HomeListBean.DataBean.BannerBean> banner = bean.getData().getBanner();
        bannerBeans.clear();
        bannerBeans.addAll(banner);
        bannerAdapter.notifyDataSetChanged();
        //首页------居家
        List<HomeListBean.DataBean.ChannelBean> channel = bean.getData().getChannel();
        channelBeans.clear();
        channelBeans.addAll(channel);
        Log.d("TAG", "HomeRelt: "+banner.size());
    }
}
