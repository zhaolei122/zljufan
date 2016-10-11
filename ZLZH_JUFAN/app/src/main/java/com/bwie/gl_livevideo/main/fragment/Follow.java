package com.bwie.gl_livevideo.main.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bwie.gl_livevideo.R;
import com.bwie.gl_livevideo.main.adapter.FollowListAdapter;
import com.bwie.gl_livevideo.main.adapter.LooperAdapter;
import com.bwie.gl_livevideo.main.bean.Follow_bean;
import com.bwie.gl_livevideo.main.bean.ImageUrl;
import com.bwie.gl_livevideo.view.AirectseedingActivity;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者：赵雷&周辉
 * on
 */
public class Follow extends Fragment {

    //定义变量
    View view;
    private ViewPager mvp;
    private List<ImageView> listv;
    private ArrayList<Follow_bean.Contents.Bean> listf;
    private ArrayList<ImageUrl.Contents.Banners> listi;
    private RadioGroup mRadioGroup;
    private ImageLoader mImageLoader;
    private ListView mlv;
    private TextView tv;

    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            if (msg.what == 1) {
                Follow_bean fb = (Follow_bean) msg.obj;
                listf.addAll(fb.content.list);
                mlv.setAdapter(new FollowListAdapter(getActivity(), listf));
                //
                setListViewHeightBasedOnChildren(mlv);

            } else {
                mvp.setCurrentItem(mvp.getCurrentItem() + 1);
                //发送
                sendMessageDelay();
            }
        }

        ;
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.follow_frag, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        add();
        initViews();
        //发送
        sendMessageDelay();
        //点击操作
        into();
    }

    private void into() {
        mlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //播放
                Intent intent = new Intent(getActivity(), AirectseedingActivity.class);
                intent.setData(Uri.parse(listf.get(position).video));
                startActivity(intent);
            }
        });
    }

    //ScrollView嵌套ListView
    public void setListViewHeightBasedOnChildren(ListView listView) {

        ListAdapter listAdapter = listView.getAdapter();

        if (listAdapter == null) {

            return;

        }

        int totalHeight = 0;

        for (int i = 0; i < listAdapter.getCount(); i++) {

            View listItem = listAdapter.getView(i, null, listView);

            listItem.measure(0, 0);

            totalHeight += listItem.getMeasuredHeight();

        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();

        params.height = totalHeight

                + (listView.getDividerHeight() * (listAdapter.getCount() - 1));

        // params.height += 5;// if without this statement,the listview will be

        // a

        // little short

        // listView.getDividerHeight()获取子项间分隔符占用的高度

        // params.height最后得到整个ListView完整显示需要的高度

        listView.setLayoutParams(params);
    }

    //
    private void sendMessageDelay() {
        mHandler.sendEmptyMessageDelayed(0, 2000);
    }

    private void initViews() {

        initImageViews();
        mvp.setAdapter(new LooperAdapter(getActivity(), listv, listi));

        initDots();

        mvp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int index) {
                mRadioGroup.check(index % ImageUrl.images.length);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }

    private void initDots() {

        int wrap = RadioGroup.LayoutParams.WRAP_CONTENT;
        RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(wrap, wrap);
        params.leftMargin = 5;
        for (int i = 0; i < ImageUrl.images.length; i++) {
            RadioButton rb = new RadioButton(getActivity());
            rb.setId(i);
            //
            rb.setButtonDrawable(R.drawable.x_dot_selector);
            //
            if (i == 0) {
                mRadioGroup.addView(rb);
            } else {
                mRadioGroup.addView(rb, params);
            }
        }
        mRadioGroup.check(0);
    }

    private void initImageViews() {
        for (int i = 0; i < ImageUrl.images.length; i++) {
            ImageView iv = new ImageView(getActivity());
            //图片点击事件
            //iv.setOnTouchListener(new ImageTouchEvent());
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            // ImageLoder缓存图片
            DisplayImageOptions options = new DisplayImageOptions.Builder()
                    .cacheOnDisc(true).cacheInMemory(true).build();
            //图片赋值
            mImageLoader = ImageLoader.getInstance();
            //ImageUrl.images[i]
            mImageLoader.displayImage(ImageUrl.images[i], iv, options);
            // 添加进集合
            listv.add(iv);
        }
    }

    //添加数据
    private void add() {
        listv = new ArrayList<ImageView>();
        listf = new ArrayList<Follow_bean.Contents.Bean>();
        listi = new ArrayList<ImageUrl.Contents.Banners>();
        //获取控件
        mvp = (ViewPager) view.findViewById(R.id.hot_vp);
        mRadioGroup = (RadioGroup) view.findViewById(R.id.rg);
        mlv = (ListView) view.findViewById(R.id.follow_lv);
        mlv.setFocusable(false);
        tv = (TextView) view.findViewById(R.id.texts);


        //解析数据
        analytical("http://live.jufan.tv/cgi/hall/get?sign=3E1C02CDE8AE682136B658A73F63406D700846EC&r=xjjf&page=0&type=hot&userid=500056449");
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
                        Follow_bean fb = gson.fromJson(text, Follow_bean.class);
                        final ImageUrl iu = gson.fromJson(text, ImageUrl.class);
                        tv.post(new Runnable() {
                            @Override
                            public void run() {
                                listi.addAll(iu.content.banner);
                                //[[[[[[[[[tv.setText(listi.size() + "");
                            }
                        });
                        //mHandler.obtainMessage(1, iu).sendToTarget();
                        mHandler.obtainMessage(1, fb).sendToTarget();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }.start();
    }

    class ImageTouchEvent implements View.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    //
                    mHandler.removeCallbacksAndMessages(null);
                    break;
                case MotionEvent.ACTION_CANCEL:
                case MotionEvent.ACTION_UP:
                    //发送
                    sendMessageDelay();
                    break;
            }
            return true;
        }
    }

}
