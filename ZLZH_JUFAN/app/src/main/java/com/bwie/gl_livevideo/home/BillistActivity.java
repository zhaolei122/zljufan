
package com.bwie.gl_livevideo.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;

import com.bwie.gl_livevideo.R;
import com.bwie.gl_livevideo.base.BaseActivity;
import com.bwie.gl_livevideo.home.base.MyHorizatalScrollView;
import com.bwie.gl_livevideo.home.fragment.AllBill;
import com.bwie.gl_livevideo.home.fragment.WeekBill;

import java.util.ArrayList;
import java.util.List;

public class BillistActivity extends BaseActivity {

    //定义变量
    private MyHorizatalScrollView mhsv;
    private ViewPager mvp;
    //标题
    private String[] titles = {"周榜", "总榜"};
    private List<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billist);
        //获取控件
        mhsv = (MyHorizatalScrollView) findViewById(R.id.bill_hsc);
        mvp = (ViewPager) findViewById(R.id.bill_vp);
        //头部
        initHeader();
        initWidget();
        setWidgetState();

        //滑动效果
        mhsv.setTitles(titles);
        setData();

        mhsv.setViewPager(mvp);
        //适配
        mvp.setAdapter(new MyAdapter(getSupportFragmentManager()));

    }//适配器

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int arg0) {
            return list.get(arg0);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }

    private void setData() {
        list = new ArrayList<Fragment>();
        //接口1添加到list集合里面
        list.add(new WeekBill());
        //接口2添加到list集合里面
        list.add(new AllBill());
    }

    @Override
    public void initHeader() {

        //初始化头部控件
        inittHeaderWidget();
        //设置头部内容title
        setTitle(getString(R.string.mkain_title));
        //设置左边监听事件
        addIMGLeftListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
                //PreferencesUtil.putPreferences(LiveVideo.MAIN_TITLE_NAME, "李明", getApplicationContext());

                //String name = PreferencesUtil.getPreferences(LiveVideo.MAIN_TITLE_NAME, "", getApplicationContext());

                // ToastUtils.show(getApplicationContext(), "左边被点击+" + name);

            }
        });

        //设置右边监听
        /*addIMGRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.show(getApplicationContext(), "有边被点击");
            }
        });*/


    }

    @Override
    public void initWidget() {
    }

    @Override
    public void setWidgetState() {
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
    }
}
