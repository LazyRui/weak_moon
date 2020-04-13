package com.bw.day13_wanzixi.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

/**
 * 懒加载的核心代码
 *
 * setUserVisibleHint();
 */
public abstract class BaseFragment extends Fragment {
    //是否已经加载过数据
    public boolean mHavaLoadData;

    //表示数据是否已经请求完毕
    public boolean mLoadDataFinished;

    //表示控件是否初始化完毕,,给控件设置数据避免空指针
    public boolean mViewInflateFinished;

    //Fragment的XML布局转换为Java对象
    private View mRootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //首先我们先判断有没有布局的对象,有的话直接返回出去即可
        if (mRootView !=null){
            return mRootView;
        }
        mRootView=initRootView(inflater,container,savedInstanceState);
        //初始化控件
        initView( mRootView );
        //初始化完毕,我们改变其中的值
        mViewInflateFinished =true;
        return mRootView;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //如果还没有加载过数据  用户切换到这个Fragment ,那么我们就开始加载数据
        if(!mHavaLoadData && isVisibleToUser){
            //开始加载数据
            loadDataStart();
            mHavaLoadData =true;
        }
    }

    //初始化布局的操作
    protected abstract View initRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);
    //初始化控件的操作
    protected  abstract void initView(View view);
    //加载数据的操作
    protected abstract void loadDataStart();
}
