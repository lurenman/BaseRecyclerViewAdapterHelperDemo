package com.example.lurenman.baserecyclerviewadapterhelperdemo.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.lurenman.baserecyclerviewadapterhelperdemo.R;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.adapter.MultipleItemQuickAdapter;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.entity.MultipleItemEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: baiyang.
 * Created on 2017/11/27.
 */

public class MultipleItemActivity extends BaseActivity {
    private List<MultipleItemEntity> mDataLists = new ArrayList<>();
    private RecyclerView rv_list;
    private MultipleItemQuickAdapter mAdapter;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_multipleitem);
        rv_list = (RecyclerView) findViewById(R.id.rv_list);
        rv_list.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void initVariables() {

        MultipleItemEntity multipleItemEntity1 = new MultipleItemEntity(1);
        MultipleItemEntity multipleItemEntity2 = new MultipleItemEntity(2);
        MultipleItemEntity multipleItemEntity3 = new MultipleItemEntity(3);

        mDataLists.add(multipleItemEntity1);
        mDataLists.add(multipleItemEntity2);
        mDataLists.add(multipleItemEntity3);
        for (int i = 0; i < 10; i++) {
            if (i == 4) {//当是第四个的时候我们加载3布局
                MultipleItemEntity multipleItemEntity = new MultipleItemEntity(1);
                mDataLists.add(multipleItemEntity);
                continue;
            }
            MultipleItemEntity multipleItemEntity = new MultipleItemEntity(4);
            multipleItemEntity.setTitle("item" + i);
            multipleItemEntity.setUrl("http://file.ataw.cn/HospPerformance/Model/Image/2017/06/20/File/20170620173507137A9A7CC4BD991149058A765A34095728CF.jpg?ut=20170620173516");
            mDataLists.add(multipleItemEntity);

        }
        mAdapter = new MultipleItemQuickAdapter(mDataLists);
        rv_list.setAdapter(mAdapter);

    }

    @Override
    protected void loadData() {

    }
}
