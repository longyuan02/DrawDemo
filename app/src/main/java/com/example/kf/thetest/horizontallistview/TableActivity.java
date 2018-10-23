package com.example.kf.thetest.horizontallistview;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.kf.thetest.R;

public class TableActivity extends Activity {
    private LinearLayout leftContainerView;
    private ListView leftListView;
    private List<LeftData> leftlList;
    private LinearLayout rightContainerView;
    private ListView rightListView;
    private List<RightModel> models;
//    private SyncHorizontalScrollView titleHorsv;
//    private SyncHorizontalScrollView contentHorsv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_tab_view);
        leftContainerView = (LinearLayout) findViewById(R.id.left_container);
        leftListView = (ListView) findViewById(R.id.left_container_listview);
        rightContainerView = (LinearLayout) findViewById(R.id.right_container);
        rightListView = (ListView) findViewById(R.id.right_container_listview);
//        titleHorsv = (SyncHorizontalScrollView) findViewById(R.id.title_horsv);
//        contentHorsv = (SyncHorizontalScrollView) findViewById(R.id.content_horsv);
        // ???????????????????
//        titleHorsv.setScrollView(contentHorsv);
//        contentHorsv.setScrollView(titleHorsv);

        // ??????????????
//        leftContainerView.setBackgroundColor(Color.YELLOW);
        initLeftData();
        MyLeftAdapter adapter = new MyLeftAdapter(this, leftlList);
        leftListView.setAdapter(adapter);
        UtilTools.setListViewHeightBasedOnChildren(leftListView);
        // ??????????????
//        rightContainerView.setBackgroundColor(Color.GRAY);
        initRightData();
        MyRightAdapter myRightAdapter = new MyRightAdapter(this, models);
        rightListView.setAdapter(myRightAdapter);
        UtilTools.setListViewHeightBasedOnChildren(rightListView);
    }

    private void initRightData() {
        models = new ArrayList<RightModel>();
        for (int i = 0; i < 18; i++) {
            if (i == 11) {
                models.add(new RightModel("", "", "", "", "", ""));
            } else {
                models.add(new RightModel("111", i + "" + i + "**", "333", "444", "555", "666"));
            }

        }
//        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
//        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
//        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
//        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
//        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
//        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
//        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
//        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
//        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
//        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
//        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
//        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
//        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
//        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
//        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
//
//        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
//        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
//        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
//        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
    }

    private void initLeftData() {
        leftlList = new ArrayList<LeftData>();
        for (int i = 0; i < 18; i++) {
            LeftData ld = new LeftData();
            ld.setName("数据信息" + i);
            ld.setType(i + "");
            leftlList.add(ld);
        }
    }
}