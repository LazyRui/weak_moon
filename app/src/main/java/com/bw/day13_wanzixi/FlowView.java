package com.bw.day13_wanzixi;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.wuruitao.mvp.model.entity.MovieEntity;

import java.util.List;

/**
 * @ClassName: FlowView
 * @Description: Java类的作用
 * @Author: LazyRui
 * @CreateDate: 2020/4/6 14:40
 */
public class FlowView extends ViewGroup {
    //右侧展示区域使用自定义流式布局来完成，使用第三方不给分

    public FlowView(Context context) {
        super(context);
    }

    public FlowView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
        int left = 0;
        int top = 0;
        int right = 0;
        int botton = 0;

        int childCount = getChildCount();

        if (childCount > 0) {

            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);

                childAt.measure(0, 0);

                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();

                right = left + measuredWidth;

                if (right > getWidth()) {

                    left = 0;
                    right = left + measuredWidth;

                    top = botton + 15;

                }

                botton = top + measuredHeight;

                childAt.layout(left, top, right, botton);

                left += measuredWidth + 15;

            }
        }

    }

    public void addChildeView(MovieEntity.CategoryBean categoryBean) {

        removeAllViews();
        if (categoryBean.getChilds().size() > 0) {


            List<MovieEntity.CategoryBean.ChildsBean> dasdada = categoryBean.getChilds();

            for (int i = 0; i < dasdada.size(); i++) {
                TextView textView = new TextView(getContext());
                MovieEntity.CategoryBean.ChildsBean childsBean = dasdada.get(i);

                textView.setText(childsBean.getTitle());

                addView(textView);
            }


        }


    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (MotionEvent.ACTION_DOWN == event.getAction()) {

            int x = (int) event.getX();
            int y = (int) event.getY();

            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                Rect rect = new Rect();
                childAt.getHitRect(rect);

                //c)点击右侧流式布局的item可以吐司出item上的标题内容，同时改变点击item的背景颜色
                if (rect.contains(x, y)) {

                    childAt.setBackgroundColor(Color.BLUE);
                    TextView t = (TextView) childAt;
                    Toast.makeText(getContext(), t.getText().toString(), Toast.LENGTH_SHORT).show();
                } else {
                    childAt.setBackgroundColor(0);
                }

            }

        }


        return true;


    }
}
