package com.example.lurenman.baserecyclerviewadapterhelperdemo.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.R;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.entity.ClickEntity;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.entity.EmptyEntity;

import java.util.List;

/**
 * @author: baiyang.
 * Created on 2017/11/21.
 */

public class EmptyAdapter extends BaseQuickAdapter<EmptyEntity, BaseViewHolder> {
    public EmptyAdapter(int layoutResId, @Nullable List<EmptyEntity> data) {
        super(layoutResId, data);

    }

    @Override
    protected void convert(BaseViewHolder helper, EmptyEntity item) {
        helper.setText(R.id.tv_title, item.getTitle());
        helper.addOnClickListener(R.id.iv_icon);//添加点击事件
        helper.addOnLongClickListener(R.id.iv_icon);//添加长按事件
//        ImageView imageView =(ImageView) helper.getView(R.id.iv_icon);
//        int layoutPosition = helper.getLayoutPosition();

    }
}
