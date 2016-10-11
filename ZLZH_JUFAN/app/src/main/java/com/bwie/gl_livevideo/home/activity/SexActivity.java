package com.bwie.gl_livevideo.home.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bwie.gl_livevideo.R;
import com.bwie.gl_livevideo.base.BaseActivity;

public class SexActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sex);

        //添加数据
        add();

        initWidget();
        initHeader();
        setWidgetState();

    }

    private void add() {

    }

    @Override
    public void initHeader() {

        //初始化头部控件
        inittHeaderWidget();
        //设置头部内容title
        setTitle(getString(R.string.title_sex
        ));
        //设置左边监听事件
        addBtnLeftTextListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }, "取消");
        //设置右边监听
        addBtnRightTextListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }, "确定");


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
