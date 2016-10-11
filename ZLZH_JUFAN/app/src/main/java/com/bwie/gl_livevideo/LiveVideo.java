package com.bwie.gl_livevideo;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import cn.jpush.android.api.JPushInterface;

/**
 * 作    者：赵雷&周辉
 */
public class LiveVideo extends Application {


    //存储本地数据
    public static final String MAIN_TITLE_NAME = "main_title_name";

    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoader imageLoader = ImageLoader.getInstance();
        //使用默认的全局配置
        imageLoader.init(ImageLoaderConfiguration.createDefault(this));
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }
}
