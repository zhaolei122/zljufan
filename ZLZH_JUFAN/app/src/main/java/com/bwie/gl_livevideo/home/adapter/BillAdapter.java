package com.bwie.gl_livevideo.home.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.gl_livevideo.R;
import com.bwie.gl_livevideo.home.bean.Bill_bean;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import java.util.ArrayList;

public class BillAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Bill_bean.ContentBean.DataBean> list;

    public BillAdapter(Context context, ArrayList<Bill_bean.ContentBean.DataBean> list) {
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
            convertView = View.inflate(context, R.layout.frag_wee_item, null);
            vh.id = (TextView) convertView.findViewById(R.id.bill_id);
            vh.name = (TextView) convertView.findViewById(R.id.bill_name);
            vh.level = (TextView) convertView.findViewById(R.id.bill_level);
            vh.num = (TextView) convertView.findViewById(R.id.bill_num);
            vh.img = (ImageView) convertView.findViewById(R.id.bill_img);
            vh.add = (ImageView) convertView.findViewById(R.id.bill_add);
            convertView.setTag(vh);
        } else {
            vh = (VHolder) convertView.getTag();
        }
        //编辑
        vh.id.setText(position + 1 + "");
        if (position == 0) {
            vh.id.setBackgroundResource(R.mipmap.rich_list_first);
            vh.id.setText("");
        }
        if (position == 1) {
            vh.id.setBackgroundResource(R.mipmap.rich_list_sec);
            vh.id.setText("");
        }
        if (position == 2) {
            vh.id.setBackgroundResource(R.mipmap.rich_list_third);
            vh.id.setText("");
        }

        vh.name.setText(list.get(position).getNickname());
        vh.num.setText(list.get(position).getOut_amount() + "");
        vh.level.setText(list.get(position).getLevel() + "");
        // ImageLoder缓存图片
        DisplayImageOptions options1 = new DisplayImageOptions.Builder()
                .showStubImage(R.mipmap.li_default_head) // 设置图片下载期间显示的图片
                .showImageForEmptyUri(R.mipmap.li_default_head) // 设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.mipmap.li_default_head) // 设置图片加载或解码过程中发生错误显示的图片
                .cacheInMemory(true) // 设置下载的图片是否缓存在内存中
                .cacheOnDisc(true) // 设置下载的图片是否缓存在SD卡中
                .displayer(new RoundedBitmapDisplayer(90))
                        // 设置成圆角、圆形图片,我这里将new
                        // RoundedBitmapDisplayer的参数设置为90,就是圆形图片，其他角度可以根据需求自行修改
                .build();
        //图片赋值
        ImageLoader mImageLoader = ImageLoader.getInstance();
        //ImageUrl.images[i]
        mImageLoader.displayImage(list.get(position).getHeadImgSmall(), vh.img, options1);
        vh.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });


        return convertView;
    }

    class VHolder {
        TextView id, name, level, num;
        ImageView img, add;
    }
}
