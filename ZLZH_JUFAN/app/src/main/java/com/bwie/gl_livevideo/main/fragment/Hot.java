package com.bwie.gl_livevideo.main.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.bwie.gl_livevideo.R;
import com.bwie.gl_livevideo.main.adapter.HotAdapter;
import com.bwie.gl_livevideo.main.bean.BeanHot;
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * 作者：高磊
 * on 2016/9/5.
 */
public class Hot extends Fragment {

    //定义变量
    View view;
    private GridView mgv;
    private TextView tv;

    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            if (msg.what == 1) {
                List<BeanHot.ContentBean.ListBean> b = (List) msg.obj;
                mgv.setAdapter(new HotAdapter(getActivity(), b));

            }
        }

        ;
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.hot_frag, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //添加数据
        add();
    }

    //获取控件
    private void add() {
        mgv = (GridView) view.findViewById(R.id.hot_gv);
        tv = (TextView) view.findViewById(R.id.texts);

        //解析数据
        analytical("http://live.jufan.tv/cgi/hall/get?sign=A2A031A7CEFAAACDBE108413B6FE98C9FC2A311E&r=ofkh&page=0&type=new&userid=500056507");
    }

    private void analytical(final String urls) {
        new Thread() {
            @Override
            public void run() {
                HttpURLConnection open;
                try {

                    open = (HttpURLConnection) new URL(urls).openConnection();
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
                        final BeanHot fb = gson.fromJson(text, BeanHot.class);

                        final List<BeanHot.ContentBean.ListBean> b = fb.getContent().getList();
                        tv.post(new Runnable() {
                            @Override
                            public void run() {
                                //mgv.setAdapter(new HotAdapter(getActivity(), b));
                            }
                        });

                        mHandler.obtainMessage(1, b).sendToTarget();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }.start();
    }
}
