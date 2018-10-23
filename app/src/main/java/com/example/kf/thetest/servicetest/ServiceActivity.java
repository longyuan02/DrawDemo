package com.example.kf.thetest.servicetest;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.kf.thetest.R;

/**
 * Created by kf on 2018/2/11.
 */

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {
    private Button start, stop, binding, unbinding;
    private ToastService.MyBinder myBinder;
    private ServiceConnection serviceConnection=new ServiceConnection(){
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBinder= (ToastService.MyBinder) service;
            myBinder.startDownload();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }

        @Override
        public void onBindingDied(ComponentName name) {

        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicetest);
        start = (Button) findViewById(R.id.start);
        stop = (Button) findViewById(R.id.stop);
        binding = (Button) findViewById(R.id.binding);
        unbinding = (Button) findViewById(R.id.unbinding);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
        binding.setOnClickListener(this);
        unbinding.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent=null;
        switch (v.getId()) {
            case R.id.start:
                intent=new Intent(ServiceActivity.this,ToastService.class);
                startService(intent);
                break;
            case R.id.stop:
                intent=new Intent(ServiceActivity.this,ToastService.class);
                stopService(intent);
                break;
            case R.id.binding:
                intent=new Intent(ServiceActivity.this,ToastService.class);
                bindService(intent,serviceConnection,BIND_AUTO_CREATE);
                break;
            case R.id.unbinding:
                unbindService(serviceConnection);
                break;
        }
    }
}
