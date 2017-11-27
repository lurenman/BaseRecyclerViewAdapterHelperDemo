package com.example.lurenman.baserecyclerviewadapterhelperdemo.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.R;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.entity.AnimationEntity;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.entity.MySectionEntity;

import java.util.List;

/**
 * @author: baiyang.
 * Created on 2017/11/27.
 */

public class SectionAdapter extends BaseSectionQuickAdapter<MySectionEntity, BaseViewHolder> {
    public SectionAdapter(int layoutResId, int sectionHeadResId, List<MySectionEntity> data) {
        super(layoutResId, sectionHeadResId, data);
    }

    @Override
    protected void convertHead(BaseViewHolder helper, MySectionEntity item) {
        // helper.setText(R.id.tv_headTitle, "Section" + item.getSectionIndex());
        helper.setText(R.id.tv_headTitle, item.header);
    }

    @Override
    protected void convert(BaseViewHolder helper, MySectionEntity item) {
        AnimationEntity entity = item.t;
        ImageView imageView = (ImageView) helper.getView(R.id.iv_icon);
        helper.setText(R.id.tv_title, entity.getTitle());
        //MyApp.AppContext
        Glide.with(mContext).load(entity.getUrl()).centerCrop()
                .placeholder(R.drawable.defaultimg).error(R.drawable.defaultimg).into(imageView);


    }
}
