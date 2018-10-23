package com.example.kf.thetest.horizontallistview;


import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kf.thetest.R;

import java.util.List;

public class MyRightAdapter extends BaseAdapter {
    private Context context;
    List<RightModel> list;

    public MyRightAdapter(Context context, List<RightModel> models) {
        super();
        this.context = context;
        this.list = models;
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
        ViewHold viewHold;
        if (convertView == null) {
            viewHold = new ViewHold();
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_right_item, null);
            viewHold.ln_addView = convertView.findViewById(R.id.ln_addView);
            viewHold.img_division = convertView.findViewById(R.id.img_division);
            addView(viewHold.ln_addView, position);
//            viewHold.textView0 = (TextView) convertView.findViewById(R.id.right_item_textview0);
//            viewHold.textView1 = (TextView) convertView.findViewById(R.id.right_item_textview1);
//            viewHold.textView2 = (TextView) convertView.findViewById(R.id.right_item_textview2);
//            viewHold.textView3 = (TextView) convertView.findViewById(R.id.right_item_textview3);
//            viewHold.textView4 = (TextView) convertView.findViewById(R.id.right_item_textview4);
//            viewHold.textView5 = (TextView) convertView.findViewById(R.id.right_item_textview5);
            convertView.setTag(viewHold);
        } else {
            viewHold = (ViewHold) convertView.getTag();
        }

        getTextView(convertView, viewHold.ln_addView, position);
        if (position == 11) {
            viewHold.img_division.setVisibility(View.VISIBLE);
        } else {
            viewHold.img_division.setVisibility(View.INVISIBLE);
        }
//        viewHold.textView0.setText(list.get(position).getText0());
//        viewHold.textView1.setText(list.get(position).getText1());
//        viewHold.textView2.setText(list.get(position).getText2());
//        viewHold.textView3.setText(list.get(position).getText3());
//        viewHold.textView4.setText(list.get(position).getText4());
//        viewHold.textView5.setText(list.get(position).getText5());
        return convertView;
    }

    private void addView(LinearLayout linearLayout, int position) {
        for (int i = 0; i < list.size(); i++) {
            TextView tv = new TextView(context);
            tv.setTextColor(context.getResources().getColor(R.color.colorPrimaryDark));
            tv.setGravity(Gravity.CENTER);
            LinearLayout.LayoutParams layoutParamsEditInfo = new LinearLayout.LayoutParams(dip2px(150), dip2px(40));
            if (i == 11) {
                tv.setText("");
            } else {
                tv.setText(list.get(position).getText1());
            }


            linearLayout.addView(tv, layoutParamsEditInfo);
            Log.w("addview", i + "**" + list.get(position).getText1());
        }
    }

    private void getTextView(View convertView, LinearLayout linearLayout, int position) {
        Log.w("position", position + "");
        for (int i = 0; i < list.size(); i++) {
            TextView lv = (TextView) convertView.findViewById(linearLayout.getChildAt(i).getId());
            if (lv != null) {
                if (11 == position) {
                    lv.setText("");

                } else {
                    lv.setText(list.get(position).getText1());
                }
            }

            Log.w("getView", i + "");
        }
    }


    static class ViewHold {
        TextView textView0, textView1, textView2, textView3, textView4, textView5;
        ImageView img_division;
        LinearLayout ln_addView;
    }

    /**
     * 屏幕密度转换
     */
    public int dip2px(float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
