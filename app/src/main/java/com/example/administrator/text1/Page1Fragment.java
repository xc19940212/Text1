package com.example.administrator.text1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.xutils.DbManager;
import org.xutils.common.util.KeyValue;
import org.xutils.db.Selector;
import org.xutils.db.sqlite.WhereBuilder;
import org.xutils.ex.DbException;
import org.xutils.x;

import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2016/12/6.
 */

public class Page1Fragment extends Fragment {
    //    private  String imgUrl="http://img5.mtime.cn/mg/2016/12/02/103948.81410564.jpg";
    private TextView tv;
//    private ImageView iv;
    //接受信息
//    private Handler handler=new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            switch (msg.what){
//                case 1:
//                    iv.setImageBitmap((Bitmap) msg.obj);
//            }
//        }
//    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//         iv= new ImageView(getContext());
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    URL url=new URL(imgUrl);
//                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//                    conn.setRequestMethod("GET");
//                    conn.setConnectTimeout(5000);
//                    conn.setReadTimeout(5000);
//                    conn.connect();
//                    InputStream in = conn.getInputStream();
//                    Bitmap bitmap=BitmapFactory.decodeStream(in);
//                    Message msg=new Message();
//                    msg.what=1;
//                    msg.obj=bitmap;
//                    //发送信息
//                    handler.sendMessage(msg);
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
        tv = new TextView(getContext());
        DbManager.DaoConfig configs = new DbManager.DaoConfig();
        configs.setDbDir(new File("data/data/com.example.administrator.text1/xutil_db"))
                .setDbName("my_db")
                .setDbVersion(1)
                .setDbOpenListener(new DbManager.DbOpenListener() {
                    @Override
                    public void onDbOpened(DbManager db) {

                    }
                })
                .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                    @Override
                    public void onUpgrade(DbManager db, int oldVersion, int newVersion) {

                    }
                });
        DbManager db = x.getDb(configs);

//        for (int i = 0; i < 100; i++) {
//            Person p = new Person();
//            p.setName("阿斗" + i);
//            p.setAge(20 + i);
//            p.setGender(i % 2 == 0 ? "male" : "femal");
//            try {
//                db.save(p);
//            } catch (DbException e) {
//                e.printStackTrace();
//            }
//        }
//        WhereBuilder where=WhereBuilder.b("id","=",10);
//        try {
//            db.delete(Person.class,where);
//        } catch (DbException e) {
//            e.printStackTrace();
//        }

//        KeyValue KeyValue=new KeyValue("name","小三");
//        try {
//            db.update(Person.class,where, KeyValue);
//        } catch (DbException e) {
//            e.printStackTrace();
//        }
        try {
//            List<Person> all = db.sellector(Person.class).where("name", "like","%"+5+"%")
//                    .findAll();
//            List<Person> all = db.selector(Person.class).where("id", ">", "70").and("age", "<", "100")
//                    .findAll();
//
//            StringBuffer sb=new StringBuffer();
//            for (int i = 0; i <all.size() ; i++) {
//
//                        sb.append(all.get(i).getName()+"\n");
//            }
        List<Person> all = db.selector(Person.class).where("name", "=", "小三").offset(10).findAll();

            StringBuffer sb=new StringBuffer();
            for (int i = 0; i <all.size() ; i++) {

                sb.append(all.get(i).getName()+"\n");
            }
        tv.setText(sb);
//            Person first = db.selector(Person.class).where("name", "=", "小三").findFirst();
//            tv.setText(first.getName()+"\n"+first.getGender()+"\n"+first.getAge());
        } catch (DbException e) {
            e.printStackTrace();
        }


        tv.setGravity(Gravity.CENTER);
        return tv;
    }
}
