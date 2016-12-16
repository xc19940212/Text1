package com.example.administrator.text1;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016/12/6.
 */

public class Page2Fragment extends Fragment {
    private ImageView iv;
    private Timer timer;
    private int[] imgRes = {R.drawable.a, R.drawable.b};
    private int currentImg = 0;
    private Handler hander = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    iv.setBackgroundResource(imgRes[currentImg++]);
                    currentImg = currentImg % 2;
                    break;
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        iv = new ImageView(getContext());
        timer = new Timer();
//        timer.schedule(new TimerTask() {
//             @Override
//             public void run() {
//                hander.sendEmptyMessage(0);
//             }
//         },2000,2000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                while (true) {
                    hander.sendEmptyMessage(0);
                    SystemClock.sleep(2000);
                }
            }
        }, 2000, 2000);


        return iv;
    }
}
