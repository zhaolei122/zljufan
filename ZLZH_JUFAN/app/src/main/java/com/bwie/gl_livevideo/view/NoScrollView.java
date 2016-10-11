package com.bwie.gl_livevideo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * 作    者：赵雷&周辉
 * 时    间：2015/9/3
 */
public class NoScrollView extends GridView {


    public NoScrollView(Context context) {
        super(context);
    }

    public NoScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
