package com.bwie.gl_livevideo.base;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwie.gl_livevideo.R;

import java.io.InputStream;

public abstract class BaseActivity extends FragmentActivity implements View.OnClickListener {


    //用来控制头部控件的显示
    public static final int BA_LETT_IMAGE = 0;
    public static final int BA_LEFT_TEXT = 1;
    public static final int BA_RIGHT_IMAGE = 2;
    public static final int BA_RIGHT_TEXT = 3;
    public static final int BA_LETI_IMAGE_RIGHT_IMAGE = 4;
    public static final int BA_LETI_IMAGE_RIGHT_TEXT = 5;
    public static final int BA_LEFT_TEXT_RIGHT_IMAGE = 6;
    public static final int BA_LEFT_TEXT_RIGHT_TEXT = 7;
    public static final int BA_RIGHT_IMAGE_TWO_IMAGE = 8;


    //头部控件
    private TextView tv_main_title_left_return;
    private TextView tv_main_title_textview;
    private TextView tv_main_title_setting;
    private ImageView iv_right_view;
    private ImageView iv_left_view;

    //右边第二张图片
    private ImageView iv_right_view_two;
    private LinearLayout ll_left_layout;
    private RelativeLayout rl_main_title;


    //初始化头部控件的方法
    public abstract void initHeader();

    //查找控件的方法
    public abstract void initWidget();

    //设置状态的方法
    public abstract void setWidgetState();


    //初始化头部控件
    public void inittHeaderWidget() {

        tv_main_title_left_return = (TextView) findViewById(R.id.id_tv_back);
        tv_main_title_textview = (TextView) findViewById(R.id.tv_main_title_textview);
        tv_main_title_setting = (TextView) findViewById(R.id.tv_main_title_setting);
        iv_right_view = (ImageView) findViewById(R.id.iv_right_view);
        iv_left_view = (ImageView) findViewById(R.id.iv_left_view);
        ll_left_layout = (LinearLayout) findViewById(R.id.ll_left_layout);

        rl_main_title = (RelativeLayout) findViewById(R.id.rl_main_title);
        iv_right_view_two = (ImageView) findViewById(R.id.iv_right_view_two);
    }


    //左边的控件显示
    public void addBtnLeftListener(View.OnClickListener listener) {
        tv_main_title_left_return.setVisibility(View.VISIBLE);
        tv_main_title_left_return.setOnClickListener(listener);
    }


    //左边文字控件自定义文字内容
    public void addBtnLeftTextListener(View.OnClickListener listener, String title) {
        tv_main_title_left_return.setVisibility(View.VISIBLE);
        tv_main_title_left_return.setOnClickListener(listener);
        tv_main_title_left_return.setText(title);
    }


    //左边的图片控件显示
    public void addIMGLeftListener(View.OnClickListener listener) {
        iv_left_view.setVisibility(View.VISIBLE);
        ll_left_layout.setOnClickListener(listener);
    }

    //左边控件自定义图片
    public void addIMGLeftBitmaplistener(View.OnClickListener listener, int id) {
        InputStream is = getResources().openRawResource(id);
        Bitmap mBitmap = BitmapFactory.decodeStream(is);
        iv_left_view.setVisibility(View.VISIBLE);
        iv_left_view.setImageBitmap(mBitmap);
        ll_left_layout.setOnClickListener(listener);
    }


    //右边文字控件
    public void addBtnRightListener(View.OnClickListener listener) {
        tv_main_title_setting.setVisibility(View.VISIBLE);
        tv_main_title_setting.setOnClickListener(listener);
    }

    //右边文字控件自定义文字内容
    public void addBtnRightTextListener(View.OnClickListener listener, String title) {
        tv_main_title_setting.setVisibility(View.VISIBLE);
        tv_main_title_setting.setOnClickListener(listener);
        tv_main_title_setting.setText(title);
    }

    //右边图片控件
    public void addIMGRightListener(View.OnClickListener listener) {
        iv_right_view.setVisibility(View.VISIBLE);
        iv_right_view.setOnClickListener(listener);
    }

    //右边图片控件自定义图片
    public void addIMGRightBitmapListener(View.OnClickListener listener, int id) {
        InputStream is = getResources().openRawResource(id);
        Bitmap mBitmap = BitmapFactory.decodeStream(is);
        iv_right_view.setVisibility(View.VISIBLE);
        iv_right_view.setOnClickListener(listener);
        iv_right_view.setImageBitmap(mBitmap);
    }


    public void setTitle(String title) {//设置中间文字的内容
        iv_left_view.setVisibility(View.GONE);
        iv_right_view.setVisibility(View.GONE);
        tv_main_title_setting.setVisibility(View.GONE);
        tv_main_title_left_return.setVisibility(View.GONE);
        iv_right_view_two.setVisibility(View.GONE);
        tv_main_title_textview.setText(title);
    }


    //控制头部控件的显示与隐藏
    public void setTitleVisible(int staute) {
        switch (staute) {
            case 0://显示左边的图片返回键
                iv_left_view.setVisibility(View.VISIBLE);
                break;
            case 1://显示左边的文字返回键
                tv_main_title_setting.setVisibility(View.VISIBLE);
                break;
            case 2://显示右边的图片返回键
                iv_right_view.setVisibility(View.VISIBLE);
                break;
            case 3://显示右边的文字返回键
                tv_main_title_left_return.setVisibility(View.VISIBLE);
                break;
            case 4://显示左边的图片和右边的图片返回键
                iv_left_view.setVisibility(View.VISIBLE);
                iv_right_view.setVisibility(View.VISIBLE);
                break;
            case 5://显示左边的图片和右边的文字返回键
                iv_left_view.setVisibility(View.VISIBLE);
                tv_main_title_left_return.setVisibility(View.VISIBLE);
                break;
            case 6://显示左边的文字和右边的图片返回键
                iv_right_view.setVisibility(View.VISIBLE);
                tv_main_title_setting.setVisibility(View.VISIBLE);
                break;
            case 7://显示左边的文字和右边的文字返回键
                tv_main_title_setting.setVisibility(View.VISIBLE);
                tv_main_title_left_return.setVisibility(View.VISIBLE);
            case 8://同事显示右边两张图片的控件
                iv_right_view_two.setVisibility(View.VISIBLE);
                iv_right_view.setVisibility(View.VISIBLE);
                break;
            case 9://全部隐藏
                iv_right_view_two.setVisibility(View.GONE);
                iv_right_view.setVisibility(View.GONE);
                break;
        }
    }


    @Override
    public void onClick(View v) {

    }
}
