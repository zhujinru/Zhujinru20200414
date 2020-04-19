package com.bw.zhujinru20200414.view.fragment;


import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.bw.zhujinru20200414.R;
import com.bw.zhujinru20200414.base.BaseFragment;
import com.bw.zhujinru20200414.contract.LoginContract;
import com.bw.zhujinru20200414.model.bean.LoginBean;
import com.bw.zhujinru20200414.presenter.LoginPresenter;
import com.bw.zhujinru20200414.view.activity.CartActivity;

import java.util.regex.Pattern;

import butterknife.BindView;

/**
 * 登录fragment
 */
public class LoginFragment extends BaseFragment<LoginPresenter> implements LoginContract.IView {

    @BindView(R.id.lo_phone)
    EditText loPhone;
    @BindView(R.id.lo_pwd)
    EditText loPwd;
    @BindView(R.id.lo_btn)
    Button loBtn;

    @Override
    protected LoginPresenter providerPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void initData() {


    }

    @Override
    protected void initView(View inflate) {
        loBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = loPhone.getText().toString().trim();
                String pwd = loPwd.getText().toString().trim();
                String PHONE="^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
                boolean matches = Pattern.matches(PHONE, phone);
                if (matches){
                    mPresenter.getLoginData(phone,pwd);
                    Toast.makeText(getActivity(), "成功", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getActivity(), "失败", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_login;
    }

    @Override
    protected void onActivityDestroy() {

    }

    @Override
    public void onLoginSuccess(LoginBean loginBean) {
        Toast.makeText(getActivity(), "请求成功", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getContext(), CartActivity.class));
    }

    @Override
    public void onLoginFailure(Throwable throwable) {

    }
}
