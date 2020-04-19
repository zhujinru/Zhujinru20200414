package com.bw.zhujinru20200414.model;

import com.bw.zhujinru20200414.contract.LoginContract;
import com.bw.zhujinru20200414.model.bean.LoginBean;
import com.bw.zhujinru20200414.util.NetUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * date:2020/4/14
 * author:朱金茹(Lenovo)
 * function:登录M层
 */
public class LoginModel implements LoginContract.IModel {
    @Override
    public void getLoginData(String phone, String pwd, IModelCallBack iModelCallBack) {
        NetUtil.getInstance().getApi().logindata(phone,pwd).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        iModelCallBack.onLoginSuccess(loginBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallBack.onLoginFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
