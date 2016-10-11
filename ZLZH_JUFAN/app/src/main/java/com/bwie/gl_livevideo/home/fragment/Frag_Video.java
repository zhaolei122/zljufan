package com.bwie.gl_livevideo.home.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bwie.gl_livevideo.R;
import com.bwie.gl_livevideo.live.LivePublisherDemoActivity;

public class Frag_Video extends Fragment {

    //定义变量
    View view;
    private Button start;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.video_frag, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        start = (Button) view.findViewById(R.id.start);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LivePublisherDemoActivity.class);
                startActivity(intent);
            }
        });
    }

}
