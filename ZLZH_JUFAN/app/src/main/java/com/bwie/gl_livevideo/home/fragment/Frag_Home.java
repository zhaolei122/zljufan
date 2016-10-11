package com.bwie.gl_livevideo.home.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.gl_livevideo.R;
import com.bwie.gl_livevideo.home.BillistActivity;
import com.bwie.gl_livevideo.home.SeachActivity;
import com.bwie.gl_livevideo.main.fragment.Follow;
import com.bwie.gl_livevideo.main.fragment.Hot;
import com.bwie.gl_livevideo.main.fragment.News;
import com.viewpagerindicator.TabPageIndicator;

/**
 * 作者：高磊
 * on 2016/9/5.
 */
public class Frag_Home extends Fragment {
    View view;
    //定义变量
    private ImageView seach, billist;
    private ViewPager mvp;
    private String[] title = {"关注", "热点", "最新"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_frag, container, false);
        //获取组件
        mvp = (ViewPager) view.findViewById(R.id.home_vp);
        seach = (ImageView) view.findViewById(R.id.home_seach);
        billist = (ImageView) view.findViewById(R.id.home_billist);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //搜索
        seach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SeachActivity.class);
                startActivity(intent);
            }
        });
        //榜单
        billist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BillistActivity.class);
                startActivity(intent);
            }
        });

        //分类
        TabPageIndicator tpi = (TabPageIndicator) view.findViewById(R.id.tpi);
        mvp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return new Hot();
                    case 1:
                        return new Follow();
                    default:
                        return new News();
                }
            }

            @Override
            public int getCount() {
                return title != null ? title.length : 0;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return title[position];
            }
        });
        //显示View
        mvp.setCurrentItem(2);
        tpi.setViewPager(mvp);
    }
}
