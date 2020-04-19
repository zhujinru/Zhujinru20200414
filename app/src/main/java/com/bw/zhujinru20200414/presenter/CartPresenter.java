package com.bw.zhujinru20200414.presenter;

import com.bw.zhujinru20200414.base.BasePresenter;
import com.bw.zhujinru20200414.contract.CartContract;
import com.bw.zhujinru20200414.model.CartModel;
import com.bw.zhujinru20200414.model.bean.CartBean;

/**
 * date:2020/4/14
 * author:朱金茹(Lenovo)
 * function:购物车P层
 */
public class CartPresenter extends BasePresenter<CartContract.IView> implements CartContract.IPresenter {

    private CartModel cartModel;

    @Override
    protected void initModel() {
        cartModel = new CartModel();
    }

    @Override
    public void getCartData() {
        cartModel.getCartData(new CartContract.IModel.IModelCallBack() {
            @Override
            public void onCartSuccess(CartBean cartBean) {
                view.onCartSuccess(cartBean);
            }

            @Override
            public void onCartFailure(Throwable throwable) {
                view.onCartFailure(throwable);
            }
        });
    }
}
