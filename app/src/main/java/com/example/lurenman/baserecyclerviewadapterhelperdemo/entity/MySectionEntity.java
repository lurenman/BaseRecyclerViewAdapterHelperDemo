package com.example.lurenman.baserecyclerviewadapterhelperdemo.entity;

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * @author: baiyang.
 * Created on 2017/11/27.
 */

public class MySectionEntity extends SectionEntity<AnimationEntity> {
    private int sectionIndex;
    public MySectionEntity(boolean isHeader, String header) {
        super(isHeader, header);
    }

    public MySectionEntity(AnimationEntity animationEntity) {
        super(animationEntity);
    }

    public int getSectionIndex() {
        return sectionIndex;
    }

    public void setSectionIndex(int sectionIndex) {
        this.sectionIndex = sectionIndex;
    }
}
