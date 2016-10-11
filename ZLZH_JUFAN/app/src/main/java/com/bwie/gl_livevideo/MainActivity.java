package com.bwie.gl_livevideo;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.bwie.gl_livevideo.home.fragment.Frag_Home;
import com.bwie.gl_livevideo.home.fragment.Frag_Video;
import com.bwie.gl_livevideo.home.fragment.Frag_User;
import com.igexin.sdk.PushManager;

public class MainActivity extends FragmentActivity {

    //定义变量
    private CheckBox mhome, mvideo, muser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //PushManager.getInstance().initialize(this.getApplicationContext());

        //默认显示界面
        Frag_Home fh = new Frag_Home();
        getSupportFragmentManager().beginTransaction().replace(R.id.frag_lay, fh).commit();
        //添加数据
        add();
        into();
    }

    private void into() {

        //首页点击
        mhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 手动获取cid
                /*String cid = PushManager.getInstance().getClientid(MainActivity.this);
                Toast.makeText(MainActivity.this, "当前应用的cid为：" + cid, Toast.LENGTH_LONG).show();
                Log.d("GetuiSdkDemo", "当前应用的cid为：" + cid);*/

                mhome.setChecked(true);
                muser.setChecked(false);
                Frag_Home fh = new Frag_Home();
                getSupportFragmentManager().beginTransaction().replace(R.id.frag_lay, fh).commit();

            }
        });
        //主播点击
        mvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Frag_Video fv = new Frag_Video();
                getSupportFragmentManager().beginTransaction().replace(R.id.frag_lay, fv).commit();
            }
        });
        //个人点击
        muser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mhome.setChecked(false);
                muser.setChecked(true);
                Frag_User fu = new Frag_User();
                getSupportFragmentManager().beginTransaction().replace(R.id.frag_lay, fu).commit();
            }
        });

    }

    //获取控件
    private void add() {
        mhome = (CheckBox) findViewById(R.id.check_home);
        mvideo = (CheckBox) findViewById(R.id.check_video);
        muser = (CheckBox) findViewById(R.id.check_user);
    }
}
