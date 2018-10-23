package com.example.kf.thetest.select;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.kf.thetest.R;

import java.util.ArrayList;

/**
 * Created by kf on 2017/12/29.
 */

public class SelectActivity extends AppCompatActivity {
    private TextView showTv, outstr1,outstr2,outstr3;
    private PickerScrollView picker, picker2, picker3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        showTv = (TextView) findViewById(R.id.showTv);
        outstr1 = (TextView) findViewById(R.id.outstr1);
        outstr2 = (TextView) findViewById(R.id.outstr2);
        outstr3 = (TextView) findViewById(R.id.outstr3);
        picker = (PickerScrollView) findViewById(R.id.picker);
        picker2 = (PickerScrollView) findViewById(R.id.picker2);
        picker3 = (PickerScrollView) findViewById(R.id.picker3);
        ArrayList list = new ArrayList<Pickers>();
        String[] id = new String[]{"1", "2", "3", "4", "5", "6"};
        String[] name = new String[]{"1", "2", "3", "4", "5", "6"};
        for (int i = 0; i < name.length; i++) {
            list.add(new Pickers(name[i], id[i]));
        }
        // 设置数据，默认选择第一条
        picker.setData(list);
        picker.setSelected(0);

        picker2.setData(list);
        picker2.setSelected(0);

        picker3.setData(list);
        picker3.setSelected(0);
        picker.setOnSelectListener(new PickerScrollView.onSelectListener() {
            @Override
            public void onSelect(Pickers pickers) {
                outstr1.append(pickers.getShowConetnt());
            }
        });
        picker2.setOnSelectListener(new PickerScrollView.onSelectListener() {
            @Override
            public void onSelect(Pickers pickers) {
                outstr2.append(pickers.getShowConetnt());
            }
        });
        picker3.setOnSelectListener(new PickerScrollView.onSelectListener() {
            @Override
            public void onSelect(Pickers pickers) {
                outstr3.append(pickers.getShowConetnt());
            }
        });
    }
}
