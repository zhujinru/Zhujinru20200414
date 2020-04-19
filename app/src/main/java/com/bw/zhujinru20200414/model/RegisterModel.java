package com.bw.zhujinru20200414.model;

import com.bw.zhujinru20200414.contract.LoginContract;
import com.bw.zhujinru20200414.contract.RegisterContract;
import com.bw.zhujinru20200414.model.bean.LoginBean;
import com.bw.zhujinru20200414.model.bean.RegisterBean;
import com.bw.zhujinru20200414.util.NetUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * date:2020/4/14
 * author:朱金茹(Lenovo)
 * function:注册M层
 */
public class RegisterModel implements RegisterContract.IModel {
    @Override
    public void getRegisterData(String phone, String pwd, IModelCallBack iModelCallBack) {
        NetUtil.getInstance().getApi().registdata(phone,pwd).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegisterBean registerBean) {
                        iModelCallBack.onRegisterSuccess(registerBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallBack.onRegisterFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
