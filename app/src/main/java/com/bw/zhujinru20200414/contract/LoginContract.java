package com.bw.zhujinru20200414.contract;

import com.bw.zhujinru20200414.model.bean.LoginBean;

/**
 * date:2020/4/14
 * author:朱金茹(Lenovo)
 * function:登录契约
 */
public interface LoginContract {
    interface IView{
        void onLoginSuccess(LoginBean loginBean);
        void onLoginFailure(Throwable throwable);
    }
    interface IPresenter{
        void getLoginData(String phone, String pwd);
    }
    interface IModel{
        void getLoginData(String phone, String pwd, IModelCallBack iModelCallBack);
        interface IModelCallBack{
            void onLoginSuccess(LoginBean loginBean);
            void onLoginFailure(Throwable throwable);
        }
    }
}
