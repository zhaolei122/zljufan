package com.bwie.gl_livevideo.view;


import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.os.Process;

import com.baidu.cyberplayer.core.BVideoView;
import com.bwie.gl_livevideo.R;
import com.bwie.gl_livevideo.home.HeartLayout;

public class AirectseedingActivity extends Activity implements BVideoView.OnPreparedListener, BVideoView.OnCompletionListener,
        BVideoView.OnErrorListener, BVideoView.OnInfoListener, BVideoView.OnPlayingBufferCacheListener {
//  /*  private final String TAG = "VideoViewPlayingActivity";
//
//    *//**

    private String AK = "68600dfd6b12454691f8845ab830d481";   //请录入您的AK !!!
    private LinearLayout dianzan;
    HeartLayout heartLayout;

    private String mVideoSource = null;

    private ImageButton mPlaybtn = null;
    private ImageButton mPrebtn = null;
    private ImageButton mForwardbtn = null;

    private LinearLayout mController = null;

    private SeekBar mProgress = null;
    private TextView mDuration = null;
    private TextView mCurrPostion = null;

    private int mLastPos = 0;

    @Override
    public boolean onInfo(int i, int i1) {
        return false;
    }

    private enum PLAYER_STATUS {
        PLAYER_IDLE, PLAYER_PREPARING, PLAYER_PREPARED,
    }

    private PLAYER_STATUS mPlayerStatus = PLAYER_STATUS.PLAYER_IDLE;

    private BVideoView mVV = null;

    private EventHandler mEventHandler;
    private HandlerThread mHandlerThread;

    private final Object SYNC_Playing = new Object();

    private PowerManager.WakeLock mWakeLock = null;
    private static final String POWER_LOCK = "VideoViewPlayingActivity";

    private boolean mIsHwDecode = false;

    private final int EVENT_PLAY = 0;
    private final int UI_EVENT_UPDATE_CURRPOSITION = 1;

    class EventHandler extends Handler {
        public EventHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case EVENT_PLAY:

                    if (mPlayerStatus != PLAYER_STATUS.PLAYER_IDLE) {
                        synchronized (SYNC_Playing) {
                            try {
                                SYNC_Playing.wait();
                                //Log.v(TAG, "wait player status to idle");
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    }


                    mVV.setVideoPath(mVideoSource);

                    if (mLastPos > 0) {

                        mVV.seekTo(mLastPos);
                        mLastPos = 0;
                    }


                    mVV.showCacheInfo(true);


                    mVV.start();

                    mPlayerStatus = PLAYER_STATUS.PLAYER_PREPARING;
                    break;
                default:
                    break;
            }
        }
    }

    Handler mUIHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {

                case UI_EVENT_UPDATE_CURRPOSITION:

                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_airectseeding);
        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        mWakeLock = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK | PowerManager.ON_AFTER_RELEASE, POWER_LOCK);

        mIsHwDecode = getIntent().getBooleanExtra("isHW", false);
        Uri uriPath = getIntent().getData();
        if (null != uriPath) {
            String scheme = uriPath.getScheme();
            if (null != scheme) {
                mVideoSource = uriPath.toString();
            } else {
                mVideoSource = uriPath.getPath();
            }
        }

        initUI();


        mHandlerThread = new HandlerThread("event handler thread",
                Process.THREAD_PRIORITY_BACKGROUND);

        mHandlerThread.start();
        mEventHandler = new EventHandler(mHandlerThread.getLooper());
        into();
    }

    private void into() {
        dianzan = (LinearLayout) findViewById(R.id.dianzan);
        dianzan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //开启飘花效果
                heartLayout = (HeartLayout) findViewById(R.id.heart_layout);

                heartLayout.addFavor();

            }
        });
    }

    private void initUI() {


        BVideoView.setAK(AK);


        mVV = (BVideoView) findViewById(R.id.video_view);

        mVV.setOnPreparedListener(this);
        mVV.setOnCompletionListener(this);
        mVV.setOnErrorListener(this);
        mVV.setOnInfoListener(this);

    }


    @Override
    protected void onPause() {
        super.onPause();

        if (mPlayerStatus == PLAYER_STATUS.PLAYER_PREPARED) {
            mLastPos = mVV.getCurrentPosition();
            mVV.stopPlayback();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Log.v(TAG, "onResume");
        if (null != mWakeLock && (!mWakeLock.isHeld())) {
            mWakeLock.acquire();
        }
        mEventHandler.sendEmptyMessage(EVENT_PLAY);
    }

    private long mTouchTime;
    private boolean barShow = true;

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandlerThread.quit();
    }


    @Override
    public void onPlayingBufferCache(int percent) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean onError(int what, int extra) {
        // TODO Auto-generated method stub
        //Log.v(TAG, "onError");
        synchronized (SYNC_Playing) {
            SYNC_Playing.notify();
        }
        mPlayerStatus = PLAYER_STATUS.PLAYER_IDLE;
        mUIHandler.removeMessages(UI_EVENT_UPDATE_CURRPOSITION);
        return true;
    }


    @Override
    public void onCompletion() {
    }

    @Override
    public void onPrepared() {
        mPlayerStatus = PLAYER_STATUS.PLAYER_PREPARED;
        mUIHandler.sendEmptyMessage(UI_EVENT_UPDATE_CURRPOSITION);
    }
}

