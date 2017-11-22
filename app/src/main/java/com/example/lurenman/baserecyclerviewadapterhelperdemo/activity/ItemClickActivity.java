package com.example.lurenman.baserecyclerviewadapterhelperdemo.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.MyApp;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.R;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.adapter.ItemClickAdapter;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.entity.ClickEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: baiyang.
 * Created on 2017/11/20.
 */

public class ItemClickActivity extends BaseActivity {
    private static final String TAG = "ItemClickActivity";
    private RecyclerView rv_list;
    private List<ClickEntity> mDataLists=new ArrayList<>();
    private ItemClickAdapter itemClickAdapter;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_itemclick);
        rv_list = (RecyclerView) findViewById(R.id.rv_list);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        rv_list.setHasFixedSize(true);
        rv_list.setLayoutManager(new LinearLayoutManager(this));
    }
    @Override
    protected void initVariables() {
        for (int i = 0; i < 10; i++) {
            ClickEntity clickEntity = new ClickEntity();
            clickEntity.setTitle("item"+i);
            mDataLists.add(clickEntity);
        }
        itemClickAdapter=new ItemClickAdapter(R.layout.rv_item_click,mDataLists);

        rv_list.setAdapter(itemClickAdapter);

    }

    @Override
    protected void initEnvent() {
        super.initEnvent();
        //item点击事件
        itemClickAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                Toast.makeText(MyApp.AppContext, "Item"+position+"Click", Toast.LENGTH_SHORT).show();
            }
        });
        //item长按事件  参数返回值代表是否事件还继续传递
        itemClickAdapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {

                Toast.makeText(MyApp.AppContext, "Item"+position+"LongClick", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        //itemChild点击事件
        itemClickAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(MyApp.AppContext, "Icon"+position+"Click", Toast.LENGTH_SHORT).show();
            }
        });
        //itemChild长按事件
        itemClickAdapter.setOnItemChildLongClickListener(new BaseQuickAdapter.OnItemChildLongClickListener() {
            @Override
            public boolean onItemChildLongClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(MyApp.AppContext, "Icon"+position+"LongClick", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }

    @Override
    protected void loadData() {

    }
}
