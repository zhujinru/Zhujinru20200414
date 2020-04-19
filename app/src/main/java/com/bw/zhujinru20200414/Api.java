package com.bw.zhujinru20200414;

import com.bw.zhujinru20200414.model.bean.CartBean;
import com.bw.zhujinru20200414.model.bean.LoginBean;
import com.bw.zhujinru20200414.model.bean.RegisterBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * date:2020/4/14
 * author:朱金茹(Lenovo)
 * function:Api
 */
public interface Api {
    @FormUrlEncoded
    @POST("small/user/v1/register")
    Observable<RegisterBean> registdata(@Field("phone") String phone,@Field("pwd") String pwd);
    @FormUrlEncoded
    @POST("small/user/v1/login")
    Observable<LoginBean> logindata(@Field("phone") String phone, @Field("pwd") String pwd);
    @GET("http://blog.zhaoliang5156.cn/api/shop/month_shopcart_new.json")
    Observable<CartBean> cartdata();
}
