package com.bw.zhujinru20200414.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.bw.zhujinru20200414.R;
import com.bw.zhujinru20200414.base.BaseActivity;
import com.bw.zhujinru20200414.contract.CartContract;
import com.bw.zhujinru20200414.model.bean.CartBean;
import com.bw.zhujinru20200414.presenter.CartPresenter;
import com.bw.zhujinru20200414.view.adapter.CartAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 购物车类
 */
public class CartActivity extends BaseActivity<CartPresenter> implements CartContract.IView {

    @BindView(R.id.elv)
    ExpandableListView elv;
    @BindView(R.id.allchecks)
    CheckBox allchecks;
    @BindView(R.id.alprice)
    TextView alprice;
    @BindView(R.id.n)
    Button n;
    private CartAdapter cartAdapter;

    @Override
    protected CartPresenter providerPresenter() {
        return new CartPresenter();
    }

    @Override
    protected void initData() {
        mPresenter.getCartData();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int layoutId() {
        return R.layout.activity_cart;
    }

    @Override
    protected void onActivityDestroy() {

    }

    @Override
    public void onCartSuccess(CartBean cartBean) {
        List<CartBean.OrderDataBean> orderData = cartBean.getOrderData();
        cartAdapter = new CartAdapter(orderData);
        cartAdapter.setOnCartClickListener(new CartAdapter.onCartClickListener() {
            @Override
            public void onCartClick() {
                allchecks.setChecked(cartAdapter.isAllcheck());
                alprice.setText("￥"+ cartAdapter.claPrice());
            }
        });


        elv.setAdapter(cartAdapter);
        //将二级列表展开
        for (int i = 0; i < orderData.size(); i++) {
            elv.expandGroup(i);
        }
    }

    @Override
    public void onCartFailure(Throwable throwable) {

    }

    @OnClick({R.id.allchecks, R.id.n})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.allchecks:
                boolean allcheck = cartAdapter.isAllcheck();
                allcheck=!allcheck;
                cartAdapter.isAllcheck(allcheck);

                allchecks.setChecked(cartAdapter.isAllcheck());
                alprice.setText("￥"+ cartAdapter.claPrice());
                break;
            case R.id.n:
                break;
        }
    }
}
