package com.example.kf.thetest.drawview;

import android.app.Activity;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.kf.thetest.R;

import java.util.Calendar;

public class DrawViewActivity extends Activity {
    /**
     * 用于记录拖拉图片移动的坐标位置
     */
    private Matrix matrix = new Matrix();
    /**
     * 用于记录图片要进行拖拉时候的坐标位置
     */
    private Matrix currentMatrix = new Matrix();

    /**
     * 两个手指的开始距离
     */
    private float startDis;
    /**
     * 两个手指的中间点
     */
    private PointF midPoint;
    /**
     * 用于记录开始时候的坐标位置
     */
    private PointF startPoint = new PointF();

    private RelativeLayout mRlFather;
    private RelativeLayout mRlMezi;
    private DisplayMetrics dm;
    private int lastX, lastY;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable);
        FrameLayout fram = findViewById(R.id.fram);
        dm = getResources().getDisplayMetrics();
        final int screenWidth = dm.widthPixels;
        final int screenHeight = dm.heightPixels - 50;
//        BaseDragZoomImageView image = findViewById(R.id.image);
//        Matrix matrix = new Matrix();
//        matrix.postTranslate(-700, 0);
//        image.setImageMatrix(matrix);
//        ImageView img_index = findViewById(R.id.img_index);
//        Matrix matrix = new Matrix();
//        matrix.postTranslate(-1300, 0);
//        img_index.setImageMatrix(matrix);
//        DragView image_dragview = findViewById(R.id.image_dragview);
//        DragViewUtil.drag(img_index);
        final CustomView view_dragview = findViewById(R.id.view_dragview);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                view_dragview.move();
            }
        }, 500);

//        view_dragview.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.e("image====", "width===" + view_dragview.getHeight() + "heigth===" + view_dragview.getHeight());
//            }
//        });

//        Matrix matrix = new Matrix();
//        matrix.postTranslate(-700, 0);
//        view_dragview.setImageMatrix(matrix);
//        DragViewUtil.drag(view_dragview);

    }

//    private void move(ImageView imageView) {
//        imageView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                /** 通过与运算保留最后八位 MotionEvent.ACTION_MASK = 255 */
//                switch (event.getAction() & MotionEvent.ACTION_MASK) {
//                    // 手指压下屏幕
//                    case MotionEvent.ACTION_DOWN:
//                        // 记录ImageView当前的移动位置
//                        startPoint.set(event.getX(), event.getY());
//                        break;
//                    // 手指在屏幕上移动，改事件会被不断触发
//                    case MotionEvent.ACTION_MOVE:
//                        // 拖拉图片
////                        if (mode == MODE_DRAG) {
//                        float dx = event.getX() - startPoint.x; // 得到x轴的移动距离
//                        float dy = event.getY() - startPoint.y; // 得到x轴的移动距离
//                        // 在没有移动之前的位置上进行移动
//                        matrix.set(currentMatrix);
//                        matrix.postTranslate(dx, dy);
////                        }
////                        // 放大缩小图片
////                        else if (mode == MODE_ZOOM) {
////                            float endDis = distance(event);// 结束距离
////                            if (endDis > 10f) { // 两个手指并拢在一起的时候像素大于10
////                                float scale = endDis / startDis;// 得到缩放倍数
////                                matrix.set(currentMatrix);
////                                matrix.postScale(scale, scale, midPoint.x, midPoint.y);
////                                Log.e("move======", this.getHeight() + "**" + this.getWidth());
////                            }
////                        }
//                        break;
//                    // 手指离开屏幕
//                    case MotionEvent.ACTION_UP:
//                        // 当触点离开屏幕，但是屏幕上还有触点(手指)
//                    case MotionEvent.ACTION_POINTER_UP:
////                        mode = 0;
//                        break;
//                    // 当屏幕上已经有触点(手指)，再有一个触点压下屏幕
//                    case MotionEvent.ACTION_POINTER_DOWN:
////                        mode = MODE_ZOOM;
////                        /** 计算两个手指间的距离 */
////                        startDis = distance(event);
////                        /** 计算两个手指间的中间点 */
////                        if (startDis > 10f) { // 两个手指并拢在一起的时候像素大于10
////                            midPoint = mid(event);
////                            //记录当前ImageView的缩放倍数
////                            currentMatrix.set(getImageMatrix());
////                        }
//                        break;
//                }
////                setImageMatrix(matrix);
//                return true;
//            }
//        });
//
//    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

//    @Override
//    public boolean onTouch(View v, MotionEvent event) {
//
//        int ea = event.getAction();
//        final int screenWidth = dm.widthPixels;
//        final int screenHeight = dm.heightPixels;
//        switch (v.getId()) {
//            case R.id.view_dragview:
//                switch (ea) {
//                    case MotionEvent.ACTION_DOWN:
//                        lastX = (int) event.getRawX();// 获取触摸事件触摸位置的原始X坐标
//                        lastY = (int) event.getRawY();
//                        break;
//                    case MotionEvent.ACTION_MOVE:
//                        int dx = (int) event.getRawX() - lastX;
//                        int dy = (int) event.getRawY() - lastY;
//                        int l = v.getLeft() + dx;
//                        int b = v.getBottom() + dy;
//                        int r = v.getRight() + dx;
//                        int t = v.getTop() + dy;
////                        // 下面判断移动是否超出屏幕
////                        if (l < 0) {
////                            l = 0;
////                            r = l + v.getWidth();
////                        }
////                        if (t < 0) {
////                            t = 0;
////                            b = t + v.getHeight();
////                        }
////                        if (r > screenWidth) {
////                            r = screenWidth;
////                            l = r - v.getWidth();
////                        }
////                        if (b > screenHeight) {
////                            b = screenHeight;
////                            t = b - v.getHeight();
////                        }
//                        v.layout(l, t, r, b);
////                        lastX = (int) event.getRawX();
////                        lastY = (int) event.getRawY();
////                        v.postInvalidate();
//                        break;
//                    case MotionEvent.ACTION_UP:
//                        break;
//                    default:
//                        break;
//                }
//            default:
//                break;
//        }
//        return true;
//    }
}
