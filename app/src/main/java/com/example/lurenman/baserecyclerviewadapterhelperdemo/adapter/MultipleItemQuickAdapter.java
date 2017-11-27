package com.example.lurenman.baserecyclerviewadapterhelperdemo.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.R;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.entity.MultipleItemEntity;

import java.util.List;

/**
 * @author: baiyang.
 * Created on 2017/11/27.
 */

public class MultipleItemQuickAdapter extends BaseMultiItemQuickAdapter<MultipleItemEntity, BaseViewHolder> {
    public MultipleItemQuickAdapter(List<MultipleItemEntity> data) {
        super(data);
        //添加四种类型
        addItemType(MultipleItemEntity.TYPE_1, R.layout.multiple_item_type1);
        addItemType(MultipleItemEntity.TYPE_2, R.layout.multiple_item_type2);
        addItemType(MultipleItemEntity.TYPE_3, R.layout.multiple_item_type3);
        addItemType(MultipleItemEntity.TYPE_4, R.layout.multiple_item_type4);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultipleItemEntity item) {
        switch (helper.getItemViewType()) {
            case MultipleItemEntity.TYPE_4:
                ImageView imageView =(ImageView) helper.getView(R.id.iv_icon);
                helper.setText(R.id.tv_title,item.getTitle());
                Glide.with(mContext).load(item.getUrl()).centerCrop()
                        .placeholder(R.drawable.defaultimg).error(R.drawable.defaultimg).into(imageView);
                break;
            default:
                break;
        }

    }
}
