package com.bwie.gl_livevideo.home.base;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.gl_livevideo.R;

import java.util.ArrayList;
import java.util.List;


public class MyHorizatalScrollView extends HorizontalScrollView implements View.OnClickListener {

    private LinearLayout linearLayout;
    private List<View> list = new ArrayList<View>();
    private String[] titles;
    private ViewPager viewPager;

    public MyHorizatalScrollView(Context context, AttributeSet attrs,
                                 int defStyle) {
        super(context, attrs, defStyle);
        //调用initView
        initView();
    }

    public MyHorizatalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //调用initView
        initView();
    }

    public MyHorizatalScrollView(Context context) {
        super(context);
        //调用initView
        initView();
    }

    private void initView() {
        //LinearLayout
        linearLayout = new LinearLayout(getContext());
        this.addView(linearLayout);
    }

    public void setTitles(String[] titles) {

        this.titles = titles;
        list.clear();
        for (int i = 0; i < titles.length; i++) {
            View view = View.inflate(getContext(), R.layout.horiztal_item_xml,
                    null);
            TextView tv_tab = (TextView) view.findViewById(R.id.tv_tab);
            TextView tv_line = (TextView) view.findViewById(R.id.tv_line);
            list.add(view);
            tv_tab.setText(titles[i]);
            if (i == 0) {

                //编程红色
                tv_tab.setTextColor(Color.RED);
                //显示能看见
                tv_line.setVisibility(View.VISIBLE);
            } else {
                tv_tab.setTextColor(Color.BLACK);
                tv_line.setVisibility(View.GONE);
            }
            view.setId(i);
            view.setOnClickListener(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            linearLayout.addView(view, params);
        }
    }

    public void setCurrentItem(int poisiton) {

        int width = linearLayout.getChildAt(poisiton).getWidth();
        this.scrollTo(width * poisiton, 0);
        for (int i = 0; i < titles.length; i++) {
            View view = list.get(i);
            TextView tv_tab = (TextView) view.findViewById(R.id.tv_tab);
            TextView tv_line = (TextView) view.findViewById(R.id.tv_line);
            if (poisiton == i) {
                viewPager.setCurrentItem(i);
                tv_tab.setTextColor(Color.RED);
                tv_line.setVisibility(View.VISIBLE);
            } else {
                tv_tab.setTextColor(Color.BLACK);
                tv_line.setVisibility(View.GONE);
            }
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.viewPager = viewPager;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                setCurrentItem(arg0);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        setCurrentItem(v.getId());
    }

}
