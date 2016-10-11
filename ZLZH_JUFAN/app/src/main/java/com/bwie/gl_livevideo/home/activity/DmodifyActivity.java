package com.bwie.gl_livevideo.home.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.bwie.gl_livevideo.R;
import com.bwie.gl_livevideo.base.BaseActivity;

import java.security.DomainCombiner;

public class DmodifyActivity extends BaseActivity {

    //定义变量
    private LinearLayout headimg;
    private LinearLayout name;
    private LinearLayout sex;
    private LinearLayout auto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dmodify);

        add();
        //头部
        initHeader();
        initWidget();
        setWidgetState();


    }

    private void add() {
        //获取控件
        headimg = (LinearLayout) findViewById(R.id.dom_headimg);
        name = (LinearLayout) findViewById(R.id.dom_name);
        sex = (LinearLayout) findViewById(R.id.dom_sex);
        auto = (LinearLayout) findViewById(R.id.dom_auto);

        //点击事件
        headimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DmodifyActivity.this, HeadImgActivity.class);
                startActivity(intent);
            }
        });
        //昵称选择
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DmodifyActivity.this, NicknameActivity.class);
                startActivity(intent);
            }
        });
        //性别选择
        sex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //签名选择
        auto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public void initHeader() {

        //初始化头部控件
        inittHeaderWidget();
        //设置头部内容title
        setTitle(getString(R.string.title_bianji));
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
