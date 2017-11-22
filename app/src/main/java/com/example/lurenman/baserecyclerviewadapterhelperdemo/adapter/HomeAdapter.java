package com.example.lurenman.baserecyclerviewadapterhelperdemo.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.R;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.entity.HomeItem;

import java.util.List;

/**
 * @author: baiyang.
 * Created on 2017/11/20.
 * 最基本的使用
 */
/*一个泛型Status是数据实体类型，第二个BaseViewHolder是ViewHolder其目的是为了支持扩展ViewHolder。*/
public class HomeAdapter extends BaseQuickAdapter<HomeItem,BaseViewHolder> {

    public HomeAdapter(int layoutResId, @Nullable List<HomeItem> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeItem item) {
        helper.setText(R.id.tv_title,item.getTitle());
    }
}
