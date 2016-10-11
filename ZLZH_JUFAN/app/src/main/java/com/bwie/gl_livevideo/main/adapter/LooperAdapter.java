package com.bwie.gl_livevideo.main.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.bwie.gl_livevideo.main.WebActivity;
import com.bwie.gl_livevideo.main.bean.ImageUrl;

/**
 * 作者：高磊
 * on 2016/9/5.
 */
public class LooperAdapter extends PagerAdapter {

    private Context context;
    private List<ImageView> list;
    private ArrayList<ImageUrl.Contents.Banners> listi;

    public LooperAdapter(Context context, List<ImageView> list, ArrayList<ImageUrl.Contents.Banners> listi) {
        this.context = context;
        this.list = list;
        this.listi = listi;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        ImageView iv = list.get(position % ImageUrl.images.length);
        container.addView(iv);
       /* iv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        //

                        break;
                    case MotionEvent.ACTION_CANCEL:
                        Intent intent = new Intent(context, WebActivity.class);
                        intent.putExtra("url", listi.get(position).url);
                        context.startActivity(intent);
                        break;
                    case MotionEvent.ACTION_UP:

                        break;
                }
                return true;
            }
        });*/
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WebActivity.class);
                intent.putExtra("url", listi.get(position).url);
                context.startActivity(intent);
            }
        });

        return iv;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);

    }
}
