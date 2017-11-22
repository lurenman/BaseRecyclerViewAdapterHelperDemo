package com.example.lurenman.baserecyclerviewadapterhelperdemo.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.R;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.entity.HeaderAndFooterEntity;

import java.util.List;

/**
 * @author: baiyang.
 * Created on 2017/11/21.
 */

public class HeaderAndFooterAdapter extends BaseQuickAdapter<HeaderAndFooterEntity,BaseViewHolder> {
    public HeaderAndFooterAdapter(int layoutResId, @Nullable List<HeaderAndFooterEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HeaderAndFooterEntity item) {
        ImageView imageView =(ImageView) helper.getView(R.id.iv_icon);
        helper.setText(R.id.tv_title,item.getTitle());
        //MyApp.AppContext
        Glide.with(mContext).load(item.getUrl()).centerCrop()
                .placeholder(R.drawable.defaultimg).error(R.drawable.defaultimg).into(imageView);

    }
}
