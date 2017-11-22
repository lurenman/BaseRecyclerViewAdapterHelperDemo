package com.example.lurenman.baserecyclerviewadapterhelperdemo.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.R;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.entity.ClickEntity;

import java.util.List;

/**
 * @author: baiyang.
 * Created on 2017/11/21.
 */

public class ItemClickAdapter extends BaseQuickAdapter<ClickEntity, BaseViewHolder> {
    public ItemClickAdapter(int layoutResId, @Nullable List<ClickEntity> data) {
        super(layoutResId, data);

    }

    @Override
    protected void convert(BaseViewHolder helper, ClickEntity item) {
        helper.setText(R.id.tv_title, item.getTitle());
        helper.addOnClickListener(R.id.iv_icon);//添加点击事件
        helper.addOnLongClickListener(R.id.iv_icon);//添加长按事件
//        ImageView imageView =(ImageView) helper.getView(R.id.iv_icon);
//        int layoutPosition = helper.getLayoutPosition();

    }
}
