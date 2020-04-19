package com.bw.zhujinru20200414.presenter;

import com.bw.zhujinru20200414.base.BasePresenter;
import com.bw.zhujinru20200414.contract.RegisterContract;
import com.bw.zhujinru20200414.model.RegisterModel;
import com.bw.zhujinru20200414.model.bean.RegisterBean;

/**
 * date:2020/4/14
 * author:朱金茹(Lenovo)
 * function:注册P层
 */
public class RegisterPresenter extends BasePresenter<RegisterContract.IView> implements RegisterContract.IPresenter {

    private RegisterModel registerModel;

    @Override
    protected void initModel() {
        registerModel = new RegisterModel();
    }

    @Override
    public void getRegisterData(String phone, String pwd) {
        registerModel.getRegisterData(phone, pwd, new RegisterContract.IModel.IModelCallBack() {
            @Override
            public void onRegisterSuccess(RegisterBean registerBean) {
                view.onRegisterSuccess(registerBean);
            }

            @Override
            public void onRegisterFailure(Throwable throwable) {
                view.onRegisterFailure(throwable);
            }
        });
    }
}
