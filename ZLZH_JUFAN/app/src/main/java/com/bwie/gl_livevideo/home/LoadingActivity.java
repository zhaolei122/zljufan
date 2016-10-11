package com.bwie.gl_livevideo.home;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import com.bwie.gl_livevideo.MainActivity;

import com.bwie.gl_livevideo.R;

public class LoadingActivity extends Activity {

    /*定义变量*/
    private ViewPager mvp;
    private List<View> listv;
    private Boolean key;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        duqu();
        setContentView(R.layout.activity_loading);
        SharedPreferences sp = getSharedPreferences("test", MODE_PRIVATE);
        editor = sp.edit();
        add();
        into();

    }

    private void duqu() {
        SharedPreferences sp = getSharedPreferences("test", MODE_PRIVATE);
        key = sp.getBoolean("key", false);
        if (key) {
            Intent intent = new Intent(LoadingActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private void into() {
        mvp.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return listv.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(listv.get(position));
                return listv.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(listv.get(position));
            }
        });
    }

    private void add() {
        mvp = (ViewPager) findViewById(R.id.lvp);
        listv = new ArrayList<View>();
        View v1 = View.inflate(this, R.layout.hy_01, null);
        View v2 = View.inflate(this, R.layout.hy_02, null);
        View v3 = View.inflate(this, R.layout.hy_03, null);
        listv.add(v1);
        listv.add(v2);
        listv.add(v3);
        Button btn = (Button) v3.findViewById(R.id.load_btn);
        //btn.setBackgroundColor(Color.argb(200, 0, 200, 0));
        //体验 首页
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoadingActivity.this, MainActivity.class);
                editor.putBoolean("key", true);
                editor.commit();
                startActivity(intent);
                finish();
            }
        });

    }

}
