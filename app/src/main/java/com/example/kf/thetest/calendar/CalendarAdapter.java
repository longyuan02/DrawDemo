package com.example.kf.thetest.calendar;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kf.thetest.R;

import java.util.List;

/**
 * Created by kf on 2018/1/23.
 */

public class CalendarAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context Ccontext;
    private List<CalendarData> list;
    private LayoutInflater layoutInflater;

    public CalendarAdapter(Context context) {
        this.Ccontext = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.item_calendar, null, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            ((ViewHolder) holder).tv1.setText(list.get(position).getDate());
            String record = list.get(position).getRecord();
            if (record.equals("1")) {//
                ((ViewHolder) holder).lnview.setBackgroundResource(R.drawable.shape_whiteblue);
            }else {
                ((ViewHolder) holder).lnview.setBackgroundResource(0x00000000);
            }
        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv1;
        ImageView img1;
        LinearLayout lnview;

        public ViewHolder(View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.tv1);
            img1 = itemView.findViewById(R.id.img1);
            lnview = itemView.findViewById(R.id.lnview);
        }
    }

    public List<CalendarData> getList() {
        return list;
    }

    public void setList(List<CalendarData> list) {
        this.list = list;
    }
}
