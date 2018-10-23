package com.example.kf.thetest.filepath

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.kf.thetest.R
import kotlinx.android.synthetic.main.activity_filepath.*
import android.content.Intent
import android.net.Uri
import android.os.Environment
import java.io.File


class FilePathKTActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_filepath)
        btn_commit.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
//                //getUrl()获取文件目录，例如返回值为/storage/sdcard1/MIUI/music/mp3_hd/单色冰淇凌_单色凌.mp3
//                val file = File(getUrl())
//                //获取父目录
//                val parentFlie = File(file.getParent())
//                val intent = Intent(Intent.ACTION_GET_CONTENT)
//                intent.setDataAndType(Uri.fromFile(parentFlie), "*/*")
//                intent.addCategory(Intent.CATEGORY_OPENABLE)
//                startActivity(intent)
               var sdDir:String = Environment.getExternalStorageDirectory().toString();//获取跟目录
                var intent:Intent=Intent(Intent.ACTION_VIEW, Uri.parse(sdDir));
                startActivity(intent)
            }

        })
    }
//    public String getSDPath(){
//        File sdDir = null;
//        boolean sdCardExist = Environment.getExternalStorageState()
//                .equals(Android.os.Environment.MEDIA_MOUNTED); //判断sd卡是否存在
//        if (sdCardExist) {
//            sdDir = Environment.getExternalStorageDirectory();//获取跟目录
//        }
//        return sdDir.toString();
//    }

}