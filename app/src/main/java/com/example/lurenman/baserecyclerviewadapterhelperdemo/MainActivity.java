package com.example.lurenman.baserecyclerviewadapterhelperdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.activity.AnimationActivity;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.activity.EmptyActivity;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.activity.HeaderAndFooterActivity;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.activity.ItemClickActivity;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.activity.PullToRefreshActivity;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.activity.SectionActivity;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.adapter.HomeAdapter;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.entity.HomeItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//http://www.jianshu.com/p/b343fcff51b0

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_list;
    private HomeAdapter mHomeAdapter;
    private ArrayList<String> mDatas = new ArrayList<>();
    private ArrayList<HomeItem> mDataList;
    private static final Class<?>[] ACTIVITY = {ItemClickActivity.class, AnimationActivity.class,
            HeaderAndFooterActivity.class, PullToRefreshActivity.class, EmptyActivity.class, SectionActivity.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initDatas();
        initEvents();
    }

    private void initViews() {
        rv_list = (RecyclerView) findViewById(R.id.rv_list);
        rv_list.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initDatas() {
        String[] array = {"ItemClick","Animation", "Header/Footer","PullToRefresh","Empty","Section"};
        List<String> list = Arrays.asList(array);
        mDatas.addAll(list);
        mDataList = new ArrayList<>();
        for (int i = 0; i < mDatas.size(); i++) {
            HomeItem item = new HomeItem();
            item.setTitle(mDatas.get(i));
            mDataList.add(item);
        }
    }

    private void initEvents() {
        mHomeAdapter = new HomeAdapter(R.layout.rv_item_home, mDataList);
        rv_list.setAdapter(mHomeAdapter);
        mHomeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(MainActivity.this, ACTIVITY[position]);
                startActivity(intent);
            }
        });
    }


}
