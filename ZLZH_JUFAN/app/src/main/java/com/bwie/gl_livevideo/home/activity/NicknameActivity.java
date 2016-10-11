package com.bwie.gl_livevideo.home.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.gl_livevideo.R;
import com.bwie.gl_livevideo.base.BaseActivity;
import com.bwie.gl_livevideo.utils.ToastUtils;

public class NicknameActivity extends BaseActivity {

    //定义变量
    private TextView nick, num;
    private ImageView exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickname);

        //添加数据
        add();
        //头部
        initHeader();
        initWidget();
        setWidgetState();

    }

    private void add() {
        //获取组件
        nick = (TextView) findViewById(R.id.nick_name);
        num = (TextView) findViewById(R.id.nick_nums);
        exit = (ImageView) findViewById(R.id.exit);

        if (nick != null && !nick.equals("")) {
            exit.setVisibility(View.VISIBLE);
        }
        if (nick.length() > 20) {
            nick.setText(nick + "");
        }
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nick.setText("");
            }
        });
        num.setText(20 - nick.length()+"");


    }

    @Override
    public void initHeader() {

        //初始化头部控件
        inittHeaderWidget();
        //设置头部内容title
        setTitle(getString(R.string.title_nickname));

        addBtnLeftTextListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        }, "取消");

        addBtnRightTextListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        }, "保存");
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
