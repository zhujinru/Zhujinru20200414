package com.bw.zhujinru20200414.view.fragment;


import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.bw.zhujinru20200414.R;
import com.bw.zhujinru20200414.base.BaseFragment;
import com.bw.zhujinru20200414.contract.RegisterContract;
import com.bw.zhujinru20200414.model.bean.RegisterBean;
import com.bw.zhujinru20200414.presenter.RegisterPresenter;

import java.util.regex.Pattern;

import butterknife.BindView;

/**
 * 注册fragment
 */
public class RegisterFragment extends BaseFragment<RegisterPresenter> implements RegisterContract.IView {

    @BindView(R.id.re_phone)
    EditText rePhone;
    @BindView(R.id.re_pwd)
    EditText rePwd;
    @BindView(R.id.re_btn)
    Button reBtn;

    @Override
    protected RegisterPresenter providerPresenter() {
        return new RegisterPresenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View inflate) {
        reBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = rePhone.getText().toString().trim();
                String pwd = rePwd.getText().toString().trim();
                String PHONE="^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
                boolean matches = Pattern.matches(PHONE, phone);
                if (matches){
                    mPresenter.getRegisterData(phone,pwd);
                    Toast.makeText(getActivity(), "成功", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getActivity(), "失败", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_register;
    }

    @Override
    protected void onActivityDestroy() {

    }

    @Override
    public void onRegisterSuccess(RegisterBean registerBean) {
        Toast.makeText(getActivity(), "请求成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRegisterFailure(Throwable throwable) {

    }
}
