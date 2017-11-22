package com.example.lurenman.baserecyclerviewadapterhelperdemo.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.MyApp;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.R;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.adapter.HeaderAndFooterAdapter;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.entity.HeaderAndFooterEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: baiyang.
 * Created on 2017/11/21.
 */

public class HeaderAndFooterActivity extends BaseActivity {

    private RecyclerView rv_list;
    private HeaderAndFooterAdapter mHeaderAndFooterAdapter;
    private List<HeaderAndFooterEntity> mDataLists=new ArrayList<>();

    @Override
    protected void initViews() {
     setContentView(R.layout.activity_headerandfooter);
        rv_list = (RecyclerView) findViewById(R.id.rv_list);
        rv_list.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void initVariables() {
        for (int i = 0; i < 10; i++) {
            HeaderAndFooterEntity headerAndFooterEntity = new HeaderAndFooterEntity();
            headerAndFooterEntity.setTitle("item"+i);
            headerAndFooterEntity.setUrl("http://file.ataw.cn/HospPerformance/Model/Image/2017/06/20/File/20170620173507137A9A7CC4BD991149058A765A34095728CF.jpg?ut=20170620173516");
            mDataLists.add(headerAndFooterEntity);
        }
        mHeaderAndFooterAdapter=new HeaderAndFooterAdapter(R.layout.rv_item_headandfoot,mDataLists);
        View headView = View.inflate(MyApp.AppContext, R.layout.head_view,null);
        View footView= View.inflate(MyApp.AppContext, R.layout.foot_view,null);
        mHeaderAndFooterAdapter.addHeaderView(headView);
        mHeaderAndFooterAdapter.addFooterView(footView);
       // mHeaderAndFooterAdapter.setHeaderViewAsFlow(true);
        rv_list.setAdapter(mHeaderAndFooterAdapter);


    }

    @Override
    protected void initEnvent() {
        super.initEnvent();
        //这个head和foot都不占position计数
        mHeaderAndFooterAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(getApplicationContext(), "Click"+position+"点击了", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void loadData() {

    }
}
