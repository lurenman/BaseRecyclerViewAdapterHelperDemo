package com.example.lurenman.baserecyclerviewadapterhelperdemo.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.MyApp;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.R;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.entity.AnimationEntity;

import java.util.List;

/**
 * @author: baiyang.
 * Created on 2017/11/21.
 */

public class AnimationAdapter extends BaseQuickAdapter<AnimationEntity,BaseViewHolder> {
    public AnimationAdapter(int layoutResId, @Nullable List<AnimationEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AnimationEntity item) {
        ImageView imageView =(ImageView) helper.getView(R.id.iv_icon);
        helper.setText(R.id.tv_title,item.getTitle());
        //MyApp.AppContext
        Glide.with(mContext).load(item.getUrl()).centerCrop()
                .placeholder(R.drawable.defaultimg).error(R.drawable.defaultimg).into(imageView);

    }
}
