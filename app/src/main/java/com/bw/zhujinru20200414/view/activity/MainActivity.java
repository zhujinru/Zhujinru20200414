package com.bw.zhujinru20200414.view.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bw.zhujinru20200414.R;
import com.bw.zhujinru20200414.base.BaseActivity;
import com.bw.zhujinru20200414.base.BasePresenter;
import com.bw.zhujinru20200414.view.fragment.LoginFragment;
import com.bw.zhujinru20200414.view.fragment.RegisterFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 主页面
 */
public class MainActivity extends BaseActivity {
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    List<Fragment> fragmentlist=new ArrayList<>();
    List<String> titlist=new ArrayList<>();
    @Override
    protected BasePresenter providerPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        LoginFragment loginFragment = new LoginFragment();
        RegisterFragment registerFragment = new RegisterFragment();
        fragmentlist.add(loginFragment);
        fragmentlist.add(registerFragment);
        titlist.add("登录");
        titlist.add("注册");
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragmentlist.get(position);
            }

            @Override
            public int getCount() {
                return fragmentlist.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return titlist.get(position);
            }
        });
        tab.setupWithViewPager(vp);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onActivityDestroy() {

    }

}
