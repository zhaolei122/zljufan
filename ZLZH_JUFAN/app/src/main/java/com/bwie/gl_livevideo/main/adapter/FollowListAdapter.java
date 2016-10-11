package com.bwie.gl_livevideo.main.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.gl_livevideo.R;
import com.bwie.gl_livevideo.main.bean.Follow_bean;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import java.util.ArrayList;


public class FollowListAdapter extends BaseAdapter {

    private ArrayList<Follow_bean.Contents.Bean> list;
    private Context context;

    public FollowListAdapter(Context context, ArrayList<Follow_bean.Contents.Bean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        VHolder vh;
        if (convertView == null) {
            vh = new VHolder();
            convertView = View.inflate(context, R.layout.follow_list, null);
            vh.bimg = (ImageView) convertView.findViewById(R.id.follow_bigheadimg);
            vh.simg = (ImageView) convertView.findViewById(R.id.follow_smallheadimg);
            vh.name = (TextView) convertView.findViewById(R.id.follow_name);
            vh.place = (TextView) convertView.findViewById(R.id.follow_place);
            convertView.setTag(vh);
        } else {
            vh = (VHolder) convertView.getTag();
        }
        //赋值
        vh.name.setText(list.get(position).name);
        vh.place.setText(list.get(position).place);
        //
        // ImageLoder缓存图片
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showStubImage(R.mipmap.li_default_head) // 设置图片下载期间显示的图片
                .showImageForEmptyUri(R.mipmap.li_default_head) // 设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.mipmap.li_default_head) // 设置图片加载或解码过程中发生错误显示的图片
                .cacheInMemory(true) // 设置下载的图片是否缓存在内存中
                .cacheOnDisc(true) // 设置下载的图片是否缓存在SD卡中
                .displayer(new RoundedBitmapDisplayer(90))
                        // 设置成圆角、圆形图片,我这里将new
                        // RoundedBitmapDisplayer的参数设置为90,就是圆形图片，其他角度可以根据需求自行修改
                .build();
        // ImageLoder缓存图片
        DisplayImageOptions options1 = new DisplayImageOptions.Builder()
                .cacheInMemory(true) // 设置下载的图片是否缓存在内存中
                .cacheOnDisc(true) // 设置下载的图片是否缓存在SD卡中
                .displayer(new RoundedBitmapDisplayer(10))
                        // 设置成圆角、圆形图片,我这里将new
                        // RoundedBitmapDisplayer的参数设置为90,就是圆形图片，其他角度可以根据需求自行修改
                .build();
        //图片赋值
        ImageLoader mImageLoader = ImageLoader.getInstance();
        //ImageUrl.images[i]
        mImageLoader.displayImage(list.get(position).bigheadimg, vh.bimg, options1);
        mImageLoader.displayImage(list.get(position).midheadimg, vh.simg, options);

        return convertView;
    }

    class VHolder {
        ImageView bimg, simg;
        TextView name, place;
    }
}
