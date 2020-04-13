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
 * A simple {@link Fragment} subclass.
 */
public class BFragment extends BaseFragment {

    private TextView mTv;

    @Override
    protected View initRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b,container,false);
    }

    @Override
    protected void initView(View view) {
        mTv = (TextView) view.findViewById(R.id.tv);
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
