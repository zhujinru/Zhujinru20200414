package com.bw.zhujinru20200414.base;

/**
 * date:2020/4/14
 * author:朱金茹(Lenovo)
 * function:p层基类
 */
public abstract class BasePresenter<V> {
    protected V view;

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();

    public void attach(V view) {
        this.view = view;
    }
    public void detach(){
        view=null;
    }
}
