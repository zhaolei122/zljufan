package com.bwie.gl_livevideo.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.Handler;

import java.util.Timer;
import java.util.TimerTask;

import com.bwie.gl_livevideo.R;

public class ImageActivity extends Activity {

    private Timer timer;
    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            //接收传来的值
            int item = (Integer) msg.obj;
            if (item > 0) {

            } else {
                //倒计时结束，跳转到主界面
                timer.cancel();
                Intent intent = new Intent(ImageActivity.this, LoadingActivity.class);
                startActivity(intent);
                finish();
            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        into();
    }

    private void into() {
        // 倒计时操作
        timer = new Timer();
        TimerTask task = new TimerTask() {
            int count = 2;

            @Override
            public void run() {
                Message msg = handler.obtainMessage();
                msg.obj = count;
                count--;
                handler.sendMessage(msg);
            }
        };
        timer.schedule(task, 1000, 1000);

    }

}
