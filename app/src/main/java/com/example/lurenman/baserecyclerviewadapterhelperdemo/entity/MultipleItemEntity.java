package com.example.lurenman.baserecyclerviewadapterhelperdemo.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * @author: baiyang.
 * Created on 2017/11/27.
 */

public class MultipleItemEntity implements MultiItemEntity {
    public static final int TYPE_1 = 1;//供外面使用的静态常量也可以写在adapter中。
    public static final int TYPE_2 = 2;
    public static final int TYPE_3 = 3;
    public static final int TYPE_4 = 4;
    private String title;
    private String url;
    private int itemType;

    public MultipleItemEntity(int itemType) {
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
