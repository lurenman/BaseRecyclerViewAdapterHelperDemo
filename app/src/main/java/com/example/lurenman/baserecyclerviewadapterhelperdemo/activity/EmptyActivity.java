package com.example.lurenman.baserecyclerviewadapterhelperdemo.activity;

import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.example.lurenman.baserecyclerviewadapterhelperdemo.R;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.adapter.EmptyAdapter;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.entity.EmptyEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: baiyang.
 * Created on 2017/11/22.
 */

public class EmptyActivity extends BaseActivity {
    private static final String TAG = "EmptyActivity";
    private EmptyAdapter mEmptyAdapter;
    private RecyclerView rv_list;
    private FloatingActionButton btn_reset;
    private View EmptyView;//空的view
    private List<EmptyEntity> mDataLists = new ArrayList<>();

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_empty);
        rv_list = (RecyclerView) findViewById(R.id.rv_list);
        rv_list.setLayoutManager(new LinearLayoutManager(this));
        btn_reset = (FloatingActionButton) findViewById(R.id.btn_reset);
        //EmptyView = View.inflate(getApplicationContext(), R.layout.empty_view, null);
        EmptyView = getLayoutInflater().inflate(R.layout.empty_view, (ViewGroup) rv_list.getParent(), false);


    }
    @Override
    protected void initVariables() {
        for (int i = 0; i < 6; i++) {
            EmptyEntity emptyEntity = new EmptyEntity();
            emptyEntity.setTitle("item" + i);
            mDataLists.add(emptyEntity);
        }
        mEmptyAdapter = new EmptyAdapter(R.layout.rv_item_empty, mDataLists);
        rv_list.setAdapter(mEmptyAdapter);
    }

    @Override
    protected void initEnvent() {
        super.initEnvent();
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mDataLists.clear();
                        //如果用网格布局的话，设置空布局就不能给全屏，可以使用瀑布流布局。
                      //mEmptyAdapter.setNewData(null);//
                        mEmptyAdapter.setNewData(mDataLists);//这要size为0或集合为null才可以设置这种空view
                        mEmptyAdapter.setEmptyView(EmptyView);
                        Log.e(TAG, "run:setEmptyView ----------");
                    }
                }, 500);
            }
        });
    }

    @Override
    protected void loadData() {

    }
}
