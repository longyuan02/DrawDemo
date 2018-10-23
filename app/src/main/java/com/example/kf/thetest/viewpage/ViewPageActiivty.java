package com.example.kf.thetest.viewpage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.kf.thetest.R;

import java.util.ArrayList;
import java.util.List;

public class ViewPageActiivty extends AppCompatActivity {
    private ViewPager view_pager;
    private Button btn1, btn2;
    private List<View> pages=new ArrayList<View>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpage);
        view_pager = (ViewPager) findViewById(R.id.view_pager);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        View view1= LayoutInflater.from(this).inflate(R.layout.view_viewpage1,null);
        pages.add(view1);
        View view2= LayoutInflater.from(this).inflate(R.layout.view_viewpage2,null);
        pages.add(view2);
        initPager();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view_pager.setCurrentItem(0);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view_pager.setCurrentItem(1);
            }
        });

    }
    private void initPager() {
        PagerAdapter adapter=new ViewAdapter(pages);
        view_pager.setAdapter(adapter);
        view_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                Log.w("onPageScrolled===",position+"");
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
}
