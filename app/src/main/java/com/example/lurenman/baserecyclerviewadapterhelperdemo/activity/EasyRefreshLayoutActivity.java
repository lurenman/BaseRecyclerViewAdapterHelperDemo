package com.example.lurenman.baserecyclerviewadapterhelperdemo.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.ajguan.library.EasyRefreshLayout;
import com.ajguan.library.LoadModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.R;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.adapter.PullToRefreshAdapter;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.animation.CustomAnimation;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.entity.PullToRefreshEntity;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.views.RefreshHeaderView;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author: baiyang.
 * Created on 2017/11/27.
 */

public class EasyRefreshLayoutActivity extends BaseActivity {
    private static final String TAG = "EasyRefreshLayoutActivi";
    private RecyclerView recyclerview;
    private EasyRefreshLayout  easyRefreshLayout;
    private PullToRefreshAdapter mPullToRefreshAdapter;
    private List<PullToRefreshEntity> mDataLists = new ArrayList<>();
    private static final int PAGE_SIZE = 6;//每页请求的size数
    private int mLoadMoreCounts = 0;//请求加载更多的次数

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_easyrefreshlayout);
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        easyRefreshLayout = (EasyRefreshLayout) findViewById(R.id.easylayout);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void initVariables() {
        mPullToRefreshAdapter = new PullToRefreshAdapter();
        mPullToRefreshAdapter.openLoadAnimation(new CustomAnimation());
        mPullToRefreshAdapter.isFirstOnly(false);
        recyclerview.setAdapter(mPullToRefreshAdapter);
        easyRefreshLayout.setRefreshHeadView(new RefreshHeaderView(this));
        easyRefreshLayout.autoRefresh();//开始刷新

    }

    @Override
    protected void initEnvent() {
        super.initEnvent();
        easyRefreshLayout.addEasyEvent(new EasyRefreshLayout.EasyEvent() {
            @Override
            public void onRefreshing() {
                referesh();

            }

            @Override
            public void onLoadMore() {

            }
        });
        //加载更多 这个监听一设置就算开启
        mPullToRefreshAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                LoadMore();
            }
        });

    }
    private void referesh() {
        mLoadMoreCounts = 0;//重置Counts
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                //先清除一下
                mDataLists.clear();
                mPullToRefreshAdapter.setEnableLoadMore(false);//这里的作用是防止下拉刷新的时候还可以上拉加载
                for (int i = 0; i < PAGE_SIZE; i++) {
                    PullToRefreshEntity pullToRefreshEntity = new PullToRefreshEntity();
                    pullToRefreshEntity.setTitle("item" + i);
                    pullToRefreshEntity.setUrl("http://file.ataw.cn/HospPerformance/Model/Image/2017/06/20/File/20170620173507137A9A7CC4BD991149058A765A34095728CF.jpg?ut=20170620173516");
                    mDataLists.add(pullToRefreshEntity);
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mPullToRefreshAdapter.setNewData(mDataLists);

                        //这块是判断一下返回的数据如果小于三个那就隐藏加载更多布局
                        if (mDataLists.size() <= 3) {
                            //第一页如果不够一页就不显示没有更多数据布局
                            mPullToRefreshAdapter.loadMoreEnd(true);
                            Toast.makeText(getApplicationContext(), "没有更多数据了", Toast.LENGTH_SHORT).show();
                        } else {
                            mPullToRefreshAdapter.loadMoreComplete();
                        }
                        mPullToRefreshAdapter.setEnableLoadMore(true);
                       // mSwipeRefreshLayout.setRefreshing(false);
                        easyRefreshLayout.refreshComplete();//这个也代表停止刷新
                    }

                });

            }
        }, 2, TimeUnit.SECONDS);
        easyRefreshLayout.setLoadMoreModel(LoadModel.NONE);//感觉它这个加载更多的布局形式不好看所以还是用 mPullToRefreshAdapter的

    }
    private void LoadMore() {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                final List<PullToRefreshEntity> arrays = new ArrayList<>();
                int size = mDataLists.size();//我们没有对这个数组做变化，它的size在变
                Log.e(TAG, "run:mDataLists.size:--------- " + size);
                mLoadMoreCounts++;
                Log.e(TAG, "run: mLoadMoreCounts:-------- " + mLoadMoreCounts);
                int pageSize = 0;
                //当第二次加载的时候我们就返回三条数据模拟没有更多数据了
                if (mLoadMoreCounts == 2) {
                    pageSize = 3;
                } else {
                    pageSize = PAGE_SIZE;
                }

                for (int i = size; i < size + pageSize; i++) {
                    PullToRefreshEntity pullToRefreshEntity = new PullToRefreshEntity();
                    pullToRefreshEntity.setTitle("item" + i);
                    pullToRefreshEntity.setUrl("http://file.ataw.cn/HospPerformance/Model/Image/2017/06/20/File/20170620173507137A9A7CC4BD991149058A765A34095728CF.jpg?ut=20170620173516");
                    arrays.add(pullToRefreshEntity);
                    //mDataLists.addAll(arrays);//不要对这个数据进行操作，否则会添加数据错乱(这个mDataLists数据变化会影响刷新)
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mPullToRefreshAdapter.addData(arrays);
                        if (arrays.size() < PAGE_SIZE) {
                            mPullToRefreshAdapter.loadMoreEnd(false);//如果数据不够6条了就显示没有更多数据了
                            Toast.makeText(getApplicationContext(), "没有更多数据了", Toast.LENGTH_SHORT).show();
                        } else {
                            mPullToRefreshAdapter.loadMoreComplete();
                        }

                    }
                });
            }
        }, 1, TimeUnit.SECONDS);

    }
    @Override
    protected void loadData() {

    }
}
