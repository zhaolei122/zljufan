package com.bwie.gl_livevideo.home;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.bwie.gl_livevideo.R;

public class SeachActivity extends Activity {

    //定义变量
    private EditText editText;
    private Button mbtn;
    private ListView mlv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seach);
        //获取控件
        add();


    }

    private void add() {
        editText = (EditText) findViewById(R.id.seach_editor);
        mbtn = (Button) findViewById(R.id.seach_btn);
        mlv = (ListView) findViewById(R.id.seach_lv);

    }
}
