package com.bw.zhujinru20200414.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * date:2020/4/14
 * author:朱金茹(Lenovo)
 * function:activity基类
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        mPresenter=providerPresenter();
        if (mPresenter != null) {
            mPresenter.attach(this);
        }
        ButterKnife.bind(this);
        initView();
        initData();
    }

    protected abstract P providerPresenter();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int layoutId();
    //解决内存泄漏
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detach();
        }
        onActivityDestroy();
    }

    protected abstract void onActivityDestroy();
}
