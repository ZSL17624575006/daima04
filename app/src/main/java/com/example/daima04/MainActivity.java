package com.example.daima04;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.daima04.fragment.ClassifyFragment;
import com.example.daima04.fragment.HomeFragment;
import com.example.daima04.fragment.MineFragment;
import com.example.daima04.fragment.ShoppingFragment;
import com.example.daima04.fragment.SpecialFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mainBtnv;
    private Fragment[] fragments;
    private int lastFragment;//用于记录上个选择的Fragment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mainBtnv = (BottomNavigationView) findViewById(R.id.main_btnv);

        HomeFragment homeFragment = new HomeFragment();
        ClassifyFragment classifyFragment = new ClassifyFragment();
        MineFragment mineFragment = new MineFragment();
        ShoppingFragment shoppingFragment = new ShoppingFragment();
        SpecialFragment specialFragment = new SpecialFragment();

        fragments = new Fragment[]{homeFragment, specialFragment, classifyFragment, shoppingFragment, mineFragment};
        lastFragment = 0;

        getSupportFragmentManager().beginTransaction().replace(R.id.main_ll,homeFragment).show(homeFragment).commit();

        mainBtnv.setOnNavigationItemSelectedListener(changeFragment);
    }

    //判断选择的菜单
    private BottomNavigationView.OnNavigationItemSelectedListener changeFragment = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                //首页
                case R.id.menu_main_homr: {
                    if(lastFragment!=0) {
                        switchFragment(lastFragment,0);
                        lastFragment=0;
                    }
                    return true;
                }
                //专题
                case R.id.menu_main_special: {
                    if(lastFragment!=1){
                        switchFragment(lastFragment,1);
                        lastFragment=1;
                    }
                    return true;
                }
                //分类
                case R.id.menu_main_classify: {
                    if(lastFragment!=2){
                        switchFragment(lastFragment,2);
                        lastFragment=2;
                    }
                    return true;
                }
                //购物车
                case R.id.menu_main_shopping: {
                    if(lastFragment!=3){
                        switchFragment(lastFragment,3);
                        lastFragment=3;
                    }
                    return true;
                }
                //我的
                case R.id.menu_main_mine: {
                    if(lastFragment!=4){
                        switchFragment(lastFragment,4);
                        lastFragment=4;
                    }
                    return true;
                }
            }
            return false;
        }
    };

    //切换Fragment
    private void switchFragment(int lastfragment,int index) {
        FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
        transaction.hide(fragments[lastfragment]);//隐藏上个Fragment

        if(fragments[index].isAdded()==false) {
            transaction.add(R.id.main_ll,fragments[index]);
        }
        transaction.show(fragments[index]).commitAllowingStateLoss();


    }
}