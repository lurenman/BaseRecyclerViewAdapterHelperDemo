package com.example.lurenman.baserecyclerviewadapterhelperdemo.activity;

import android.graphics.Shader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.MyApp;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.R;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.adapter.AnimationAdapter;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.animation.CustomAnimation;
import com.example.lurenman.baserecyclerviewadapterhelperdemo.entity.AnimationEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: baiyang.
 * Created on 2017/11/21.
 */

public class AnimationActivity extends BaseActivity implements AdapterView.OnItemSelectedListener {

    private RecyclerView rv_list;
    private Spinner spinnerStyle;
    private AnimationAdapter mAnimationAdapter;
    private List<AnimationEntity> mDataLists=new ArrayList<>();
    @Override
    protected void initViews() {
        setContentView(R.layout.activity_animation);
        rv_list = (RecyclerView) findViewById(R.id.rv_list);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        rv_list.setHasFixedSize(true);
        rv_list.setLayoutManager(new LinearLayoutManager(this));
        spinnerStyle = (Spinner) findViewById(R.id.spinnerStyle);
        spinnerStyle.setOnItemSelectedListener(this);

    }

    @Override
    protected void initVariables() {
        for (int i = 0; i < 20; i++) {
            AnimationEntity animationEntity = new AnimationEntity();
            animationEntity.setTitle("item"+i);
            animationEntity.setUrl("http://file.ataw.cn/HospPerformance/Model/Image/2017/06/20/File/20170620173507137A9A7CC4BD991149058A765A34095728CF.jpg?ut=20170620173516");
            mDataLists.add(animationEntity);
        }

    }

    @Override
    protected void initEnvent() {
        super.initEnvent();
        mAnimationAdapter=new AnimationAdapter(R.layout.rv_item_animation,mDataLists);
        mAnimationAdapter.openLoadAnimation();//打开动画
        mAnimationAdapter.isFirstOnly(false);//这个设置是否紧第一次加载动画，这里我设置false
        //设置不显示动画数量
       // mAnimationAdapter.setNotDoAnimationCount(3);
        mAnimationAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                //通过这个方法能拿到对应的实体
                AnimationEntity animationEntity = (AnimationEntity) adapter.getItem(position);
                Toast.makeText(MyApp.AppContext,"Click:"+ animationEntity.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0://这个是默认选择的
                mAnimationAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
                break;
            case 1:
                mAnimationAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
                break;
            case 2:
                mAnimationAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
                break;
            case 3:
                mAnimationAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
                break;
            case 4:
                mAnimationAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_RIGHT);
                break;
            case 5:
                mAnimationAdapter.openLoadAnimation(new CustomAnimation());
                break;
            default:
                break;
        }
        rv_list.setAdapter(mAnimationAdapter);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
