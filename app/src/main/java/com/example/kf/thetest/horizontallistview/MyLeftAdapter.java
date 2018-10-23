package com.example.kf.thetest.horizontallistview;

import java.util.List;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.kf.thetest.R;

public class MyLeftAdapter extends BaseAdapter {

    private Context context;
    private List<LeftData> list;
    private LayoutInflater inflate = null;

    public MyLeftAdapter(Context context, List<LeftData> list) {
        super();
        this.context = context;
        this.list = list;
        inflate = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if (list != null) {
            return list.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (position == 11) {
            convertView = showSpecialty(position, convertView, parent);
        } else {
            convertView = ShowViewHolder(position, convertView, parent);
        }
        return convertView;
    }


    private View ShowViewHolder(int position, View view, ViewGroup parent) {
        if (view == null || !(view.getTag() instanceof ViewHold)) {
            view = inflate.inflate(R.layout.layout_left_item, null);
            view.setTag(new ViewHold(view));
        }
        if (view != null && view.getTag() instanceof ViewHold) {
            ViewHold viewHold = (ViewHold) view.getTag();
            viewHold.textView.setText(list.get(position).getName());
        }

        return view;
    }

    private class ViewHold {
        TextView textView;

        ViewHold(View view) {
            textView = view.findViewById(R.id.left_container_textview0);
        }


    }


    //显示产品特点
    private View showSpecialty(int position, View view, ViewGroup parent) {
        if (view == null || !(view.getTag() instanceof Specialty)) {
            view = inflate.inflate(R.layout.view_lefttype, null);
            view.setTag(new Specialty(view));
        }
        if (view.getTag() != null && view.getTag() instanceof Specialty) {
            Specialty viewHl = (Specialty) view.getTag();
        }
        return view;
    }


    private class Specialty {
        Specialty(View view) {
        }
    }

}
