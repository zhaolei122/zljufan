package com.bwie.gl_livevideo.home.activity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bwie.gl_livevideo.R;
import com.bwie.gl_livevideo.base.BaseActivity;

public class SetUpActivity extends BaseActivity {

    //定义变量
    private LinearLayout shenji;
    private float loadversion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up);
        //添加数据
        add();
        //头部
        initHeader();
        initWidget();
        setWidgetState();

    }

    private void add() {
        shenji = (LinearLayout) findViewById(R.id.shengji);


        shenji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclic();
            }
        });
    }

    private void onclic() {
        PackageManager nPackageManager = getPackageManager();//得到包管理器
        try {
            PackageInfo nPackageInfo = nPackageManager
                    .getPackageInfo(getPackageName(), PackageManager.GET_CONFIGURATIONS);
            loadversion = nPackageInfo.versionCode;//得到现在app的版本号
            Toast.makeText(SetUpActivity.this, "当前版本号：" + loadversion, Toast.LENGTH_LONG).show();

        } catch (PackageManager.NameNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
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


}
