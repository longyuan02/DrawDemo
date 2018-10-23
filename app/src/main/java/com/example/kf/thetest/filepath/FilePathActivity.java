package com.example.kf.thetest.filepath;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.kf.thetest.R;

public class FilePathActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filepath);
        Button btn = findViewById(R.id.btn_commit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String sdDir = Environment.getExternalStorageDirectory().toString();//获取跟目录
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(sdDir));
//                startActivity(intent);

//                final int REQUEST_CODE_SELECT_IMAGE = 1;
//                Intent openAlbumIntent = new Intent(Intent.ACTION_GET_CONTENT);
//                openAlbumIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "file/*");
//                startActivityForResult(openAlbumIntent, REQUEST_CODE_SELECT_IMAGE);

                showFileChooser();
            }
        });
    }

    /**
     * 调用文件选择软件来选择文件
     **/
    private void showFileChooser() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        try {
            startActivityForResult(Intent.createChooser(intent, "请选择一个要上传的文件"),
                    1);
        } catch (android.content.ActivityNotFoundException ex) {
            // Potentially direct the user to the Market with a Dialog
            Toast.makeText(this, "请安装文件管理器", Toast.LENGTH_SHORT)
                    .show();
        }
    }
}
