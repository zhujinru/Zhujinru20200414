package com.bw.zhujinru20200414.contract;

import com.bw.zhujinru20200414.model.bean.CartBean;
import com.bw.zhujinru20200414.model.bean.LoginBean;

/**
 * date:2020/4/14
 * author:朱金茹(Lenovo)
 * function:购物车契约
 */
public interface CartContract {
    interface IView{
        void onCartSuccess(CartBean cartBean);
        void onCartFailure(Throwable throwable);
    }
    interface IPresenter{
        void getCartData();
    }
    interface IModel{
        void getCartData(IModelCallBack iModelCallBack);
        interface IModelCallBack{
            void onCartSuccess(CartBean cartBean);
            void onCartFailure(Throwable throwable);
        }
    }
}
