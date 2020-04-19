package com.bw.zhujinru20200414.contract;

import com.bw.zhujinru20200414.model.bean.LoginBean;
import com.bw.zhujinru20200414.model.bean.RegisterBean;

/**
 * date:2020/4/14
 * author:朱金茹(Lenovo)
 * function:注册契约
 */
public interface RegisterContract {
    interface IView{
        void onRegisterSuccess(RegisterBean registerBean);
        void onRegisterFailure(Throwable throwable);
    }
    interface IPresenter{
        void getRegisterData(String phone, String pwd);
    }
    interface IModel{
        void getRegisterData(String phone, String pwd,IModelCallBack iModelCallBack);
        interface IModelCallBack{
            void onRegisterSuccess(RegisterBean registerBean);
            void onRegisterFailure(Throwable throwable);
        }
    }
}
