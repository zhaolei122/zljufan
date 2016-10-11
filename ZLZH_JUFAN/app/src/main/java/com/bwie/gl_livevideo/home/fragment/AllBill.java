package com.bwie.gl_livevideo.home.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bwie.gl_livevideo.R;
import com.bwie.gl_livevideo.home.adapter.BillAdapter;
import com.bwie.gl_livevideo.home.bean.Bill_bean;
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * 作者：高磊
 * on 2016/9/12.
 */
public class AllBill extends Fragment {

    //定义变量
    View view;
    private ListView lv;
    private ArrayList<Bill_bean.ContentBean.DataBean> list;
    Handler hand = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            list = new ArrayList<Bill_bean.ContentBean.DataBean>();
            if (msg.what == 1) {
                Bill_bean bean = (Bill_bean) msg.obj;
                list.addAll(bean.getContent().getData());
                lv.setAdapter(new BillAdapter(getActivity(), list));
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.all_bill, container, false);
        lv = (ListView) view.findViewById(R.id.all_list);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        into();
    }

    private void into() {
        new Thread() {
            @Override
            public void run() {
                HttpURLConnection open;
                try {
                    open = (HttpURLConnection) new URL("http://api.vas.jufan.tv/cgi/rank/sendTopAll?r=atzo&page=1&user_id=500059702&sign=19A3502607C983AED110878B0BF592EF0CEDBC2B").openConnection();
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
                        Bill_bean bean = gson.fromJson(text, Bill_bean.class);
                        //发送
                        hand.obtainMessage(1, bean).sendToTarget();

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }.start();

    }


}
