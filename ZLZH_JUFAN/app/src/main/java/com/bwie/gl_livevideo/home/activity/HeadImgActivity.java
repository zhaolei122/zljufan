package com.bwie.gl_livevideo.home.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.gl_livevideo.R;
import com.bwie.gl_livevideo.base.BaseActivity;

public class HeadImgActivity extends BaseActivity {

    //定义变量
    private ImageView img;
    private TextView photoalbum, photograph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head_img);

        //添加数据
        add();

        //头部
        initHeader();
        initWidget();
        setWidgetState();

    }

    //获取控件
    private void add() {
        photoalbum = (TextView) findViewById(R.id.user_photoalbum);
        photograph = (TextView) findViewById(R.id.user_photograph);
        img = (ImageView) findViewById(R.id.user_img);

        photograph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 拍照上传
                Intent it = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(it, 1);
            }
        });

        photoalbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 本地上传实现:
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 2);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {

            switch (requestCode) {
                case 1:
                    Uri uri1 = data.getData();
                    Bitmap b = null;
                    if (uri1 != null) {
                        b = BitmapFactory.decodeFile(uri1.getPath());
                    } else {
                        Bundle extras = data.getExtras();
                        if (extras != null) {
                            b = (Bitmap) extras.get("data");
                        } else {
                            Toast.makeText(HeadImgActivity.this, "获取图片失败!",
                                    Toast.LENGTH_LONG).show();
                            return;
                        }
                    }
                    img.setImageBitmap(b);
                    // 将Bitmap保存至SD卡
                    // 开启异步任务,上传至服务器
                    break;
                case 2:
                    Uri uri = data.getData();
                    Log.d("TAG", "uri: " + uri);
                    img.setImageURI(uri);
                    break;

            }
            ;
        }

    }

    @Override
    public void initHeader() {

        //初始化头部控件
        inittHeaderWidget();
        //设置头部内容title
        setTitle(getString(R.string.title_touxiang));
        //设置左边监听事件
        addIMGLeftListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
                //PreferencesUtil.putPreferences(LiveVideo.MAIN_TITLE_NAME, "李明", getApplicationContext());

                //String name = PreferencesUtil.getPreferences(LiveVideo.MAIN_TITLE_NAME, "", getApplicationContext());

                // ToastUtils.show(getApplicationContext(), "左边被点击+" + name);

            }
        });

        //设置右边监听
        /*addIMGRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.show(getApplicationContext(), "有边被点击");
            }
        });*/


    }

    @Override
    public void initWidget() {
    }

    @Override
    public void setWidgetState() {
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
    }
}
