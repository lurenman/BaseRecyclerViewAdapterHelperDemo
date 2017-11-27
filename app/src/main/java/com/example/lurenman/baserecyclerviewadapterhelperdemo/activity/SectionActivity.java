package com.example.lurenman.baserecyclerviewadapterhelperdemo.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.R;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.adapter.SectionAdapter;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.entity.AnimationEntity;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.entity.MySectionEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: baiyang.
 * Created on 2017/11/27.
 */

public class SectionActivity extends BaseActivity {

    private RecyclerView rv_list;
    private SectionAdapter mSectionAdapter;
    private List<MySectionEntity> mDataLists=new ArrayList<>();

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_section);
        rv_list = (RecyclerView) findViewById(R.id.rv_list);
        rv_list.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void initVariables() {
        for (int i = 0; i < 10; i++) {
            AnimationEntity animationEntity = new AnimationEntity();
            animationEntity.setTitle("item"+i);
            animationEntity.setUrl("http://file.ataw.cn/HospPerformance/Model/Image/2017/06/20/File/20170620173507137A9A7CC4BD991149058A765A34095728CF.jpg?ut=20170620173516");
            MySectionEntity mySectionEntity = new MySectionEntity(true, "Section" + i);
            MySectionEntity mySectionEntity1 = new MySectionEntity(animationEntity);
            mySectionEntity.setSectionIndex(i);
            mDataLists.add(mySectionEntity);
            mDataLists.add(mySectionEntity1);
        }
        mSectionAdapter=new SectionAdapter(R.layout.rv_item_animation,R.layout.section_head,mDataLists);
        rv_list.setAdapter(mSectionAdapter);

    }

    @Override
    protected void initEnvent() {
        super.initEnvent();
        mSectionAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                MySectionEntity adapterItem = (MySectionEntity) adapter.getItem(position);
                if (adapterItem.isHeader)
                {
                    Toast.makeText(getApplicationContext(),adapterItem.header, Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    protected void loadData() {

    }
}
