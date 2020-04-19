package com.bw.zhujinru20200414.view.adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bw.zhujinru20200414.R;
import com.bw.zhujinru20200414.model.bean.CartBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * date:2020/4/14
 * author:朱金茹(Lenovo)
 * function:购物车适配器
 */
public class CartAdapter extends BaseExpandableListAdapter {
    private List<CartBean.OrderDataBean> orderData;

    public CartAdapter(List<CartBean.OrderDataBean> orderData) {

        this.orderData = orderData;
    }

    @Override
    public int getGroupCount() {
        return orderData.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return orderData.get(i).getCartlist().size();
    }

    @Override
    public Object getGroup(int i) {
        return null;
    }

    @Override
    public Object getChild(int i, int i1) {
        return null;
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
//商家
    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        PViewHolder pViewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.p_child, viewGroup, false);
            pViewHolder = new PViewHolder(view);
            view.setTag(pViewHolder);
        } else {
            pViewHolder = (PViewHolder) view.getTag();
        }
        CartBean.OrderDataBean orderDataBean = orderData.get(i);
        pViewHolder.pName.setText(orderDataBean.getShopName());
        boolean sell = true;
        for (int j = 0; j < orderDataBean.getCartlist().size(); j++) {
            if (orderDataBean.getCartlist().get(j).isIscheck() == false) {
                sell = false;
                break;
            }
        }
        pViewHolder.pCb.setChecked(sell);
        boolean finalSell = sell;
        pViewHolder.pCb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean cart = true;
                cart = finalSell;
                cart = !cart;
                for (int j = 0; j < orderDataBean.getCartlist().size(); j++) {
                    orderDataBean.getCartlist().get(j).setIscheck(cart);
                }
                notifyDataSetChanged();
                if (onCartClickListener != null) {
                    onCartClickListener.onCartClick();
                }
            }
        });
        return view;
    }
//商品
    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        CViewHolder cViewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.c_child, viewGroup, false);
            cViewHolder = new CViewHolder(view);
            view.setTag(cViewHolder);
        } else {
            cViewHolder = (CViewHolder) view.getTag();
        }
        CartBean.OrderDataBean.CartlistBean cartlistBean = orderData.get(i).getCartlist().get(i1);
        cViewHolder.cName.setText(cartlistBean.getProductName());
        cViewHolder.cPrice.setText("￥"+cartlistBean.getPrice());
        Uri parse = Uri.parse(cartlistBean.getDefaultPic());
        cViewHolder.cImg.setImageURI(parse);
        cViewHolder.cCb.setChecked(cartlistBean.isIscheck());
        cViewHolder.cCb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartlistBean.setIscheck(!cartlistBean.isIscheck());
                notifyDataSetChanged();
                if (onCartClickListener != null) {
                    onCartClickListener.onCartClick();
                }
            }
        });
        return view;
    }
//计算价格
    public double claPrice(){
        double allprice=0.0;
        for (int i = 0; i < orderData.size(); i++) {
            List<CartBean.OrderDataBean.CartlistBean> cartlist = orderData.get(i).getCartlist();
            for (int j = 0; j < cartlist.size(); j++) {
                if (cartlist.get(j).isIscheck()){
                    double price = cartlist.get(j).getPrice();
                    double count = cartlist.get(j).getCount();
                    allprice+=price*count;
                    notifyDataSetChanged();
                }
            }
        }
        return allprice;
    }
    //是否选中
    public boolean isAllcheck(){
        boolean allch=true;
        for (int i = 0; i < orderData.size(); i++) {
            List<CartBean.OrderDataBean.CartlistBean> cartlist = orderData.get(i).getCartlist();
            for (int j = 0; j < cartlist.size(); j++) {
                if (cartlist.get(j).isIscheck()==false){
                    allch=false;
                }
            }
        }
        return allch;
    }
//改变选中状态
    public void isAllcheck(boolean allcjeck){
        for (int i = 0; i < orderData.size(); i++) {
            List<CartBean.OrderDataBean.CartlistBean> cartlist = orderData.get(i).getCartlist();
            for (int j = 0; j < cartlist.size(); j++) {
                cartlist.get(j).setIscheck(allcjeck);
                notifyDataSetChanged();
                if (onCartClickListener != null) {
                    onCartClickListener.onCartClick();
                }
            }
        }

    }




    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }

    static class PViewHolder {
        @BindView(R.id.p_cb)
        CheckBox pCb;
        @BindView(R.id.p_name)
        TextView pName;

        PViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
//接口回调
    onCartClickListener onCartClickListener;

    public void setOnCartClickListener(CartAdapter.onCartClickListener onCartClickListener) {
        this.onCartClickListener = onCartClickListener;
    }

    public interface onCartClickListener {
        void onCartClick();
    }

    static class CViewHolder {
        @BindView(R.id.c_cb)
        CheckBox cCb;
        @BindView(R.id.c_img)
        SimpleDraweeView cImg;
        @BindView(R.id.c_name)
        TextView cName;
        @BindView(R.id.c_price)
        TextView cPrice;

        CViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
