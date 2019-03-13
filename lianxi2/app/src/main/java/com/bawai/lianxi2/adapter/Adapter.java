package com.bawai.lianxi2.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawai.lianxi2.R;
import com.bawai.lianxi2.bean.Bean;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * @Author：不要不要
 * @E-mail： 2930851278@qq.com
 * @Date：2019/3/13 19:18
 * @Description：描述信息
 */
public class Adapter extends BaseAdapter {
    private ArrayList<Bean> list;
    private Context context;

    public Adapter(ArrayList<Bean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder=null;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.list_ment, null);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.image_11);
            holder.textView = convertView.findViewById(R.id.eeeee);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Bean bean = list.get(position);
        holder.textView.setText(bean.getCommodityName());

        Glide.with(context).load(bean.getMasterPic()).into(holder.imageView);

        return convertView;
    }


    class ViewHolder {
        private ImageView imageView;
        private TextView textView;

    }
}
