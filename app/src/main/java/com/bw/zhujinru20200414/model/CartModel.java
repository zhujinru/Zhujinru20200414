package com.bw.zhujinru20200414.model;

import com.bw.zhujinru20200414.contract.CartContract;
import com.bw.zhujinru20200414.contract.RegisterContract;
import com.bw.zhujinru20200414.model.bean.CartBean;
import com.bw.zhujinru20200414.model.bean.RegisterBean;
import com.bw.zhujinru20200414.util.NetUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * date:2020/4/14
 * author:朱金茹(Lenovo)
 * function:购物车M层
 */
public class CartModel implements CartContract.IModel {
    @Override
    public void getCartData(IModelCallBack iModelCallBack) {
        NetUtil.getInstance().getApi().cartdata().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CartBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CartBean cartBean) {
                        iModelCallBack.onCartSuccess(cartBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallBack.onCartFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
