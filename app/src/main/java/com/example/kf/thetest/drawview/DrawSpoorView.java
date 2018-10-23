package com.example.kf.thetest.drawview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import com.example.kf.thetest.R;

public class DrawSpoorView extends View {
    public DrawSpoorView(Context context) {
        super(context);
    }

    public DrawSpoorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawSpoorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.mapbg);
//        // 绘图   
//            // 从资源文件中生成位图   
//            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.icon);   
//            // 绘图   
        canvas.drawBitmap(bitmap, 300, 200, paint);
    }

    public void setView() {

    }
}
