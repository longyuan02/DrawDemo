package com.example.kf.thetest.crosswiselistviewdelet;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kf.thetest.R;

import java.util.List;

/**
 * Created by kf on 2018/2/22.
 */

public class CrossWiseActivity extends AppCompatActivity{
    private List<ApplicationInfo> mAppList;
    private DragDelListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crosswismain);

        mAppList = getPackageManager().getInstalledApplications(0);
        mListView = (DragDelListView) findViewById(R.id.listView);
        mListView.setAdapter(new AppAdapter(mAppList));
    }
    class AppAdapter extends BaseAdapter {
        private List<ApplicationInfo> mAppList;
        public AppAdapter(List<ApplicationInfo> appList)
        {
            mAppList=appList;
        }
        @Override
        public int getCount() {
            return mAppList.size();
        }

        @Override
        public ApplicationInfo getItem(int position) {
            return mAppList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            ViewHolder holder=null;
            View menuView=null;
            if (convertView == null) {
                convertView = View.inflate(getApplicationContext(),
                        R.layout.item_swipecontent, null);
                menuView = View.inflate(getApplicationContext(),
                        R.layout.view_swipemenu, null);
                convertView = new DragDelItem(convertView,menuView);
                holder=new ViewHolder(convertView);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            ApplicationInfo item = getItem(position);
            holder.iv_icon.setImageDrawable(item.loadIcon(getPackageManager()));
            holder.tv_name.setText(item.loadLabel(getPackageManager()));
            holder.tv_open.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    Toast.makeText(CrossWiseActivity.this, "置顶:"+position, Toast.LENGTH_SHORT).show();
                }
            });
            holder.tv_del.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    Toast.makeText(CrossWiseActivity.this, "删除:"+position, Toast.LENGTH_SHORT).show();
                }
            });
            return convertView;
        }

        class ViewHolder {
            ImageView iv_icon;
            TextView tv_name;
            TextView tv_open,tv_del;
            RelativeLayout relativeLayout;
            public ViewHolder(View view) {
                iv_icon = (ImageView) view.findViewById(R.id.iv_icon);
                tv_name = (TextView) view.findViewById(R.id.tv_name);
                tv_open=(TextView)view.findViewById(R.id.tv_open);
                tv_del=(TextView)view.findViewById(R.id.tv_del);
                relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_layout);
                //改变relativeLayout宽度
                WindowManager wm = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
                int width = wm.getDefaultDisplay().getWidth();
                relativeLayout.setMinimumWidth(width-60);
                view.setTag(this);
            }
        }
    }
}
