package com.bwie.gl_livevideo.home.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.gl_livevideo.R;
import com.bwie.gl_livevideo.home.activity.DmodifyActivity;
import com.bwie.gl_livevideo.home.activity.SetUpActivity;
import com.bwie.gl_livevideo.home.bean.User_bean;
import com.bwie.gl_livevideo.main.bean.Follow_bean;
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.DomainCombiner;
import java.util.ArrayList;

/**
 * 作者：高磊
 * on 2016/9/5.
 */
public class Frag_User extends Fragment {

    //定义变量
    View view;
    private ArrayList<User_bean> list;
    private ImageView minformation, mheadimg, msex, mlevelimg, mqw1, mqw2, mqw3, mtjimg;
    private TextView mname, mautograph, msongchu, mshoudao, mID, mgznums, mfsnums, mzsnums, mcfnums, mdyscnums, mzshichang;
    private LinearLayout dmodify, dguanzhu, dfengsi, dzuanshi, dcaifu, dgongxian, dlevel, dtuijian, djuzuan, duihuan, dshezhi;

    Handler hand = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                User_bean ub = (User_bean) msg.obj;
                list = new ArrayList<User_bean>();
                list.add(ub);


            }

        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.user_frag, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //添加数据
        add();

        into("http://live.jufan.tv/cgi/user/getUserInfo?r=mxscmh&sign=FE1190E554D48D1EC1BC4EDE56999905E3A7B1ED&targetUid=500056449");

    }

    private void into(final String str) {
        new Thread() {
            @Override
            public void run() {

                HttpURLConnection open;
                try {

                    open = (HttpURLConnection) new URL(str).openConnection();
                    // 设置连接超时时间
                    open.setConnectTimeout(10000);
                    // 设置读取时间
                    open.setReadTimeout(10000);
                    open.connect();
                    // 获取响应码
                    int rc = open.getResponseCode();
                    if (200 == rc) {
                        // 输入流
                        InputStream is = open.getInputStream();
                        // 建数组
                        byte[] by = new byte[1024];
                        // 将内容放到
                        ByteArrayOutputStream bos = new ByteArrayOutputStream();
                        // 读内容
                        int len = -1;
                        while ((len = is.read(by)) != -1) {
                            bos.write(by, 0, len);
                        }
                        is.close();
                        // 将流转成字符串
                        final String text = bos.toString("utf-8");
                        Gson gson = new Gson();
                        User_bean ub = gson.fromJson(text, User_bean.class);
                        hand.obtainMessage(1, ub).sendToTarget();


                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }.start();
    }

    private void add() {
        //获取控件
        //信息
        minformation = (ImageView) view.findViewById(R.id.user_information);
        //头像
        mheadimg = (ImageView) view.findViewById(R.id.user_headimg);
        //性别
        msex = (ImageView) view.findViewById(R.id.user_sex);
        //等级
        mlevelimg = (ImageView) view.findViewById(R.id.user_levelimg);
        //推荐小红点
        mtjimg = (ImageView) view.findViewById(R.id.user_tjimg);
        //抢位 ???????????
        mqw1 = (ImageView) view.findViewById(R.id.user_qw_01);
        mqw2 = (ImageView) view.findViewById(R.id.user_qw_02);
        mqw3 = (ImageView) view.findViewById(R.id.user_qw_03);
        //姓名
        mname = (TextView) view.findViewById(R.id.user_name);
        //钻石数量
        mzsnums = (TextView) view.findViewById(R.id.user_zsnums);
        //财富数量
        mcfnums = (TextView) view.findViewById(R.id.user_cfnums);
        //签名
        mautograph = (TextView) view.findViewById(R.id.user_autograph);
        //送出数量
        msongchu = (TextView) view.findViewById(R.id.user_songchu);
        //收到数量
        mshoudao = (TextView) view.findViewById(R.id.user_shoudao);
        //id
        mID = (TextView) view.findViewById(R.id.user_id);
        //关注数量
        mgznums = (TextView) view.findViewById(R.id.user_gznums);
        //粉丝数量
        mfsnums = (TextView) view.findViewById(R.id.user_fsnums);
        //总时长
        mzshichang = (TextView) view.findViewById(R.id.user_zscnums);
        //当月时长
        mdyscnums = (TextView) view.findViewById(R.id.user_dyscnums);
        //修改资料
        dmodify = (LinearLayout) view.findViewById(R.id.user_modify);
        //关注
        dguanzhu = (LinearLayout) view.findViewById(R.id.user_guanzhu);
        //粉丝
        dfengsi = (LinearLayout) view.findViewById(R.id.user_fengsi);
        //钻石
        dzuanshi = (LinearLayout) view.findViewById(R.id.user_zuanshi);
        //财富
        dcaifu = (LinearLayout) view.findViewById(R.id.user_caifu);
        //贡献榜
        dgongxian = (LinearLayout) view.findViewById(R.id.user_gonxian);
        //等级
        dlevel = (LinearLayout) view.findViewById(R.id.user_level);
        //推荐
        dtuijian = (LinearLayout) view.findViewById(R.id.user_tuijian);
        //聚钻
        djuzuan = (LinearLayout) view.findViewById(R.id.user_juzuan);
        //兑换
        duihuan = (LinearLayout) view.findViewById(R.id.user_duihuan);
        //设置
        dshezhi = (LinearLayout) view.findViewById(R.id.user_shezhi);

        onclik();

    }

    private void onclik() {
        mheadimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //点击事件
        dmodify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DmodifyActivity.class);
                startActivity(intent);
            }
        });
        //设置
        dshezhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SetUpActivity.class);
                startActivity(intent);

            }
        });
    }
}
