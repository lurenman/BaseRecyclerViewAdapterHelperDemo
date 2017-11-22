package com.example.lurenman.baserecyclerviewadapterhelperdemo.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.R;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.entity.PullToRefreshEntity;

import java.util.List;

/**
 * @author: baiyang.
 * Created on 2017/11/22.
 */

public class PullToRefreshAdapter extends BaseQuickAdapter<PullToRefreshEntity,BaseViewHolder> {
    public PullToRefreshAdapter() {
        super(R.layout.rv_item_pulltorefresh, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, PullToRefreshEntity item) {
        ImageView imageView =(ImageView) helper.getView(R.id.iv_icon);
        helper.setText(R.id.tv_title,item.getTitle());
        //MyApp.AppContext
        Glide.with(mContext).load(item.getUrl()).centerCrop()
                .placeholder(R.drawable.defaultimg).error(R.drawable.defaultimg).into(imageView);

    }
}
