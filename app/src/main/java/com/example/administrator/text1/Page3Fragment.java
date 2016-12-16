package com.example.administrator.text1;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.Timer;

/**
 * Created by Administrator on 2016/12/6.
 */

public class Page3Fragment extends Fragment {

    private Data data;
    private ListView lv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        lv = (ListView) inflater.inflate(R.layout.listview_show_fragment_pager3, null);
        return lv;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        RequestParams prams = new RequestParams(Contences.PATH_URL);
        x.http().get(prams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                //将下载好的数据转换成字符串,传到对应的类中
                data = gson.fromJson(result, Data.class);
                Log.d("Page3Fragment", data.getTrailers().get(21).getMovieName());
                MyAdapter adapter = new MyAdapter();
                lv.setAdapter(adapter);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.d("Page3Fragment", "错误" + ex.getMessage());

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return data.getTrailers().size();
        }

        @Override
        public Object getItem(int position) {
            return data.getTrailers().get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            View view = null;
            ViewHouder vh = null;
            if (convertView == null) {
                vh = new ViewHouder();
                view = View.inflate(getContext(), R.layout.listview_item_fragment_pager3, null);
                vh.iv_icon = (ImageView) view.findViewById(R.id.iv_listview_item_icon);
                vh.tv_title = (TextView) view.findViewById(R.id.tv_title_listview_item);
                vh.tv_des = (TextView) view.findViewById(R.id.tv_des_listview_item);
                view.setTag(vh);
            } else {
                view = convertView;
                vh = (ViewHouder) view.getTag();
            }
            //图片建造者模式
            ImageOptions.Builder builder = new ImageOptions.Builder();
            ImageOptions option = builder.setConfig(Bitmap.Config.RGB_565)
                                        .setSize(60, 60)
                                        .setFadeIn(true)//渐入渐出效果
                                        .setUseMemCache(true)//使用内存缓存
                                        .setLoadingDrawableId(R.mipmap.ic_launcher)//设置等待加载时的图片
                                        .setFailureDrawableId(R.drawable.a)//设置加载失败时的图片
                                        .setRadius(5)//设置圆角
                                        .build();
            x.image().bind(vh.iv_icon, data.getTrailers().get(position).getCoverImg(), option);
            vh.tv_title.setText(data.getTrailers().get(position).getMovieName());
            vh.tv_des.setText(data.getTrailers().get(position).getSummary());

            return view;
        }

        class ViewHouder {
            ImageView iv_icon;
            TextView tv_title;
            TextView tv_des;
        }
    }
}

