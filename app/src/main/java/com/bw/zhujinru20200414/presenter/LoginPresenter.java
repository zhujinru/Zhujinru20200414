package com.bw.zhujinru20200414.presenter;

import com.bw.zhujinru20200414.base.BasePresenter;
import com.bw.zhujinru20200414.contract.LoginContract;
import com.bw.zhujinru20200414.model.LoginModel;
import com.bw.zhujinru20200414.model.bean.LoginBean;

/**
 * date:2020/4/14
 * author:朱金茹(Lenovo)
 * function:登录P层
 */
public class LoginPresenter extends BasePresenter<LoginContract.IView> implements LoginContract.IPresenter {

    private LoginModel loginModel;

    @Override
    protected void initModel() {
        loginModel = new LoginModel();
    }

    @Override
    public void getLoginData(String phone, String pwd) {
        loginModel.getLoginData(phone, pwd, new LoginContract.IModel.IModelCallBack() {
            @Override
            public void onLoginSuccess(LoginBean loginBean) {
                view.onLoginSuccess(loginBean);
            }

            @Override
            public void onLoginFailure(Throwable throwable) {
                view.onLoginFailure(throwable);
            }
        });
    }
}
