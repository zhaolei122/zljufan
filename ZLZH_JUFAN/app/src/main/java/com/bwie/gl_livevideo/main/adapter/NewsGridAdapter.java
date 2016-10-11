package com.bwie.gl_livevideo.main.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.gl_livevideo.R;
import com.bwie.gl_livevideo.main.bean.BeanHot;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import java.util.List;

/**
 * 作者：高磊
 * on 2016/9/7.
 */
public class NewsGridAdapter extends BaseAdapter {

    private List<BeanHot.ContentBean.ListBean> list;
    private Context context;

    public NewsGridAdapter(Context context, List<BeanHot.ContentBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list != null ? list.size() : 0;
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
            convertView = View.inflate(context, R.layout.news_grid_item, null);
            vh.bimg = (ImageView) convertView.findViewById(R.id.news_bigheadimg);
            vh.name = (TextView) convertView.findViewById(R.id.news_name);
            vh.place = (TextView) convertView.findViewById(R.id.news_place);
            vh.live = (TextView) convertView.findViewById(R.id.live_nums);
            convertView.setTag(vh);
        } else {
            vh = (VHolder) convertView.getTag();
        }
        //赋值
        vh.name.setText(list.get(position).getName());
        vh.place.setText(list.get(position).getPlace());
        vh.live.setText(list.get(position).getOnline() + "");

        // ImageLoder缓存图片
        DisplayImageOptions options1 = new DisplayImageOptions.Builder()
                .showStubImage(R.mipmap.li_default_head) // 设置图片下载期间显示的图片
                .showImageForEmptyUri(R.mipmap.li_default_head) // 设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.mipmap.li_default_head) // 设置图片加载或解码过程中发生错误显示的图片
                .cacheInMemory(true) // 设置下载的图片是否缓存在内存中
                .cacheOnDisc(true) // 设置下载的图片是否缓存在SD卡中
                .displayer(new RoundedBitmapDisplayer(10))
                        // 设置成圆角、圆形图片,我这里将new
                        // RoundedBitmapDisplayer的参数设置为90,就是圆形图片，其他角度可以根据需求自行修改
                .build();
        //图片赋值
        ImageLoader mImageLoader = ImageLoader.getInstance();
        //ImageUrl.images[i]
        mImageLoader.displayImage(list.get(position).getBigheadimg(), vh.bimg, options1);

        return convertView;
    }

    class VHolder {
        ImageView bimg;
        TextView name, place, live;
    }

}
