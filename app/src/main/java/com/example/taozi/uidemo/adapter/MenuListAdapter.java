package com.example.taozi.uidemo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.taozi.uidemo.R;
import com.example.taozi.uidemo.bean.MenuBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Taozi on 2016/5/31.
 */
public class MenuListAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<MenuBean> datas = new ArrayList<>();
    private MenuBean menuBean;

    public MenuListAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
        datas.add(new MenuBean(R.drawable.ic_toggle_star, "首页"));
        datas.add(new MenuBean(R.drawable.ic_toggle_star, "热点"));
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder holder = null;
        menuBean = datas.get(position);
        if (convertView == null) {
            holder = new MyViewHolder();
            convertView = mInflater.inflate(R.layout.menus_list, null);
            holder.imgeMenu = (ImageView) convertView.findViewById(R.id.iv_menu);
            holder.tvMenu = (TextView) convertView.findViewById(R.id.tv_menu);
            convertView.setTag(holder);
        } else {
            holder = (MyViewHolder) convertView.getTag();

        }
        holder.imgeMenu.setImageResource(menuBean.getMenuImage());
        holder.tvMenu.setText(menuBean.getMenuName());
        return convertView;
    }

    public static class MyViewHolder {
        ImageView imgeMenu;
        TextView tvMenu;
    }
}
