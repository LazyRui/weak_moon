package com.bw.day13_wanzixi.fra;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.fragment.app.Fragment;

import com.bw.day13_wanzixi.R;
import com.bw.day13_wanzixi.base.BaseFragment;

/**
 * A simple {@link Fragment}class.
 */
public class AFragment extends BaseFragment {

    private TextView mTv;

    @Override
    protected View initRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a,container,false);
    }

    @Override
    protected void initView(View view) {
        mTv = (TextView) view.findViewById(R.id.tv);

        //当数据加载完毕的时候,如果我们才进行控件的初始化,那么我们在设置一遍数据即可
        if (mLoadDataFinished){
            //模拟网络数据加载
            initData();
            mTv.setText(workData);
        }
    }

    @Override
    protected void loadDataStart() {
        //一旦获取到数据,就离开标记数据加载完成
        mLoadDataFinished =true;

        //判断控件是否初始化完毕
        if(mViewInflateFinished){
            //模拟网络数据加载
            initData();
            mTv.setText(workData);
        }
    }

    private String workData;
    private void initData() {
        workData ="网上加载的数据设置给TextView";

    }
}
