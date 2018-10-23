package com.example.kf.thetest.drawview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.kf.thetest.R;
import com.example.kf.thetest.Util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 自定义的view，能够随意拖动。
 */

@SuppressLint("AppCompatCustomView")
public class CustomView extends ImageView implements View.OnTouchListener {
    private boolean first = true;
    private Bitmap bitmap = null;
    private Context context;
    private float BeiJingX;//北京
    private float BeiJingy;
    private float TianJinx;//天津
    private float TianJiny;
    private float HaErbinx;//哈尔滨
    private float HaErbiny;
    private float ChangChunx;//长春
    private float ChangChuny;
    private float ShenYangx;//沈阳
    private float ShenYangy;
    private BreatheView breatheView;

    public List<DistancePointData> dataList = new ArrayList<DistancePointData>();

    private SetCicyDistance setCicyDistance = null;

    public CustomView(Context context) {
        super(context);
        this.context = context;
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.mapbg);
        breatheView = new BreatheView(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.mapbg);
        breatheView = new BreatheView(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.mapbg);
        breatheView = new BreatheView(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.mapbg);
        breatheView = new BreatheView(context);
    }

    private float downX;
    private float downY;

    private long downTime;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.e("bitmap====", "width==" + bitmap.getWidth() + "heigth==" + bitmap.getHeight());
        super.onMeasure(bitmap.getWidth(), bitmap.getHeight());
        setMeasuredDimension(bitmap.getWidth() * 2, bitmap.getHeight() * 2);
        breatheView.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        /**
         * 北京 this.getWidth() * 8 / 10-Util.dip2px(context,80), this.getHeight() * 1 / 3+Util.dip2px(context,60
         * 哈尔滨this.getWidth()*9/10
         */
        super.onDraw(canvas);
        Paint paint = new Paint();
        if (first) {
            first = false;
            canvas.drawBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), paint);
        } else {
            Log.e("onDraw===", "unDraw");
        }
        Log.e("onDraw===", "Draw");
        drawPoint(canvas);
    }

    private void drawPoint(Canvas canvas) {
//        setCityDistance();
        float value = 5.f;
        setCicyDistance = new SetCicyDistance(context, this);
        dataList = setCicyDistance.getDataList();
        Paint circlepaint = new Paint();
        circlepaint.setColor(getResources().getColor(R.color.a9bed3));
        //北京
        canvas.drawCircle(setCicyDistance.getBeiJingX(), setCicyDistance.getBeiJingy(), Util.dip2px(context, value), circlepaint);
        //天津
        canvas.drawCircle(setCicyDistance.getTianJinx(), setCicyDistance.getTianJiny(), Util.dip2px(context, value), circlepaint);
        //哈尔滨
        canvas.drawCircle(setCicyDistance.getHaErbinx(), setCicyDistance.getHaErbiny(), Util.dip2px(context, value), circlepaint);
        //长春
        canvas.drawCircle(setCicyDistance.getChangChunx(), setCicyDistance.getChangChuny(), Util.dip2px(context, value), circlepaint);
        //沈阳
        canvas.drawCircle(setCicyDistance.getShenYangx(), setCicyDistance.getShenYangy(), Util.dip2px(context, value), circlepaint);
        //大连
        canvas.drawCircle(setCicyDistance.getDaLianx(), setCicyDistance.getDaLiany(), Util.dip2px(context, value), circlepaint);
        //青岛
        canvas.drawCircle(setCicyDistance.getQingDaox(), setCicyDistance.getQingDaoy(), Util.dip2px(context, value), circlepaint);
        //济南
        canvas.drawCircle(setCicyDistance.getJiNanx(), setCicyDistance.getJiNany(), Util.dip2px(context, value), circlepaint);
        //郑州
        canvas.drawCircle(setCicyDistance.getZhengZhoux(), setCicyDistance.getZhengZhouy(), Util.dip2px(context, value), circlepaint);
        //合肥
        canvas.drawCircle(setCicyDistance.getHeFeix(), setCicyDistance.getHeiFeiy(), Util.dip2px(context, value), circlepaint);
        //南京
        canvas.drawCircle(setCicyDistance.getNanJingx(), setCicyDistance.getNanJingy(), Util.dip2px(context, value), circlepaint);
        //上海
        canvas.drawCircle(setCicyDistance.getShangHaix(), setCicyDistance.getShangHaiy(), Util.dip2px(context, value), circlepaint);
        //宁波
        canvas.drawCircle(setCicyDistance.getNingBox(), setCicyDistance.getNingBoy(), Util.dip2px(context, value), circlepaint);
        //杭州
        canvas.drawCircle(setCicyDistance.getHangZhoux(), setCicyDistance.getHangZhouy(), Util.dip2px(context, value), circlepaint);
        //武汉
        canvas.drawCircle(setCicyDistance.getWuHanx(), setCicyDistance.getWuHany(), Util.dip2px(context, value), circlepaint);
        //长沙
        canvas.drawCircle(setCicyDistance.getChangShax(), setCicyDistance.getChangShay(), Util.dip2px(context, value), circlepaint);
        //南昌
        canvas.drawCircle(setCicyDistance.getNanChangx(), setCicyDistance.getNanChangy(), Util.dip2px(context, value), circlepaint);
        //福州
        canvas.drawCircle(setCicyDistance.getFuZhoux(), setCicyDistance.getFuZhouy(), Util.dip2px(context, value), circlepaint);
        //厦门
        canvas.drawCircle(setCicyDistance.getXiaMenx(), setCicyDistance.getXiaMeny(), Util.dip2px(context, value), circlepaint);
        //台北
        canvas.drawCircle(setCicyDistance.getTaiBeix(), setCicyDistance.getTaiBeiy(), Util.dip2px(context, value), circlepaint);
        //广州
        canvas.drawCircle(setCicyDistance.getGuangZhoux(), setCicyDistance.getGuangZhouy(), Util.dip2px(context, value), circlepaint);
        //深圳
        canvas.drawCircle(setCicyDistance.getShenZhenx(), setCicyDistance.getShenZheny(), Util.dip2px(context, value), circlepaint);

        //深圳
        canvas.drawCircle(setCicyDistance.getShenZhenx(), setCicyDistance.getShenZheny(), Util.dip2px(context, value), circlepaint);
        //香港
        canvas.drawCircle(setCicyDistance.getXiangGangx(), setCicyDistance.getXiangGangy(), Util.dip2px(context, value), circlepaint);
        //澳门
        canvas.drawCircle(setCicyDistance.getAoMenx(), setCicyDistance.getAoMeny(), Util.dip2px(context, value), circlepaint);
        //海口
        canvas.drawCircle(setCicyDistance.getHaiKoux(), setCicyDistance.getHaiKouy(), Util.dip2px(context, value), circlepaint);
        //南宁
        canvas.drawCircle(setCicyDistance.getNanNingx(), setCicyDistance.getNanNingy(), Util.dip2px(context, value), circlepaint);
        //贵阳
        canvas.drawCircle(setCicyDistance.getGuiYangx(), setCicyDistance.getGuiYangy(), Util.dip2px(context, value), circlepaint);
        //重庆
        canvas.drawCircle(setCicyDistance.getChongQingx(), setCicyDistance.getChongQingy(), Util.dip2px(context, value), circlepaint);
        //西安
        canvas.drawCircle(setCicyDistance.getXiAnx(), setCicyDistance.getXiAny(), Util.dip2px(context, value), circlepaint);
        //成都
        canvas.drawCircle(setCicyDistance.getChengDux(), setCicyDistance.getChengDuy(), Util.dip2px(context, value), circlepaint);
        //昆明
        canvas.drawCircle(setCicyDistance.getKunMingx(), setCicyDistance.getKunMingy(), Util.dip2px(context, value), circlepaint);
        //拉萨
        canvas.drawCircle(setCicyDistance.getLaSax(), setCicyDistance.getLaSay(), Util.dip2px(context, value), circlepaint);
        //乌鲁木齐
        canvas.drawCircle(setCicyDistance.getWuLuMUQix(), setCicyDistance.getWuLuMUQiy(), Util.dip2px(context, value), circlepaint);

        //西宁
        canvas.drawCircle(setCicyDistance.getXiNingx(), setCicyDistance.getXINingy(), Util.dip2px(context, value), circlepaint);
        //兰州
        canvas.drawCircle(setCicyDistance.getLanZhoux(), setCicyDistance.getLanZhouy(), Util.dip2px(context, value), circlepaint);
        //银川
        canvas.drawCircle(setCicyDistance.getYinChuanx(), setCicyDistance.getYinChuany(), Util.dip2px(context, value), circlepaint);
        //呼和浩特
        canvas.drawCircle(setCicyDistance.getHuHeHaoTex(), setCicyDistance.getHuHeHaoTey(), Util.dip2px(context, value), circlepaint);
        //太原
        canvas.drawCircle(setCicyDistance.getTaiYuanx(), setCicyDistance.getTaiYuany(), Util.dip2px(context, value), circlepaint);
        //石家庄
        canvas.drawCircle(setCicyDistance.getShiJiaZhuangx(), setCicyDistance.getShiJiaZhuangy(), Util.dip2px(context, value), circlepaint);

//        Paint paintLine = new Paint();
//        paintLine.setColor(Color.GREEN);
//        paintLine.setStrokeWidth(Util.dip2px(context, 1));
//        canvas.drawLine(0, getHeight() * 1 / value, this.getWidth(), getHeight() * 1 / 5, paintLine);
//        canvas.drawLine(0, getHeight() * 2 / 5, this.getWidth(), getHeight() * 2 / 5, paintLine);
//        canvas.drawLine(0, getHeight() * 3 / 5, this.getWidth(), getHeight() * 3 / 5, paintLine);
//        canvas.drawLine(0, getHeight() * 4 / 5, this.getWidth(), getHeight() * 4 / 5, paintLine);
//        Paint paintLine3 = new Paint();
//        paintLine.setColor(Color.BLACK);
//        paintLine.setStrokeWidth(Util.dip2px(context, 1));
//        canvas.drawLine(0, getHeight() * 1 / 3, this.getWidth(), getHeight() * 1 / 3, paintLine3);
//        canvas.drawLine(0, getHeight() * 2 / 3, this.getWidth(), getHeight() * 2 / 3, paintLine3);

        Paint paintLineVertical = new Paint();
        paintLineVertical.setColor(Color.YELLOW);
        paintLineVertical.setStrokeWidth(Util.dip2px(context, 1));
        canvas.drawLine(0, getHeight() * 1 / 10, this.getWidth(), getHeight() * 1 / 10, paintLineVertical);
        canvas.drawLine(0, getHeight() * 2 / 10, this.getWidth(), getHeight() * 2 / 10, paintLineVertical);
        canvas.drawLine(0, getHeight() * 3 / 10, this.getWidth(), getHeight() * 3 / 10, paintLineVertical);
        canvas.drawLine(0, getHeight() * 4 / 10, this.getWidth(), getHeight() * 4 / 10, paintLineVertical);
        canvas.drawLine(0, getHeight() * 5 / 10, this.getWidth(), getHeight() * 5 / 10, paintLineVertical);
        canvas.drawLine(0, getHeight() * 6 / 10, this.getWidth(), getHeight() * 6 / 10, paintLineVertical);
        canvas.drawLine(0, getHeight() * 7 / 10, this.getWidth(), getHeight() * 7 / 10, paintLineVertical);
        canvas.drawLine(0, getHeight() * 8 / 10, this.getWidth(), getHeight() * 8 / 10, paintLineVertical);
        canvas.drawLine(0, getHeight() * 9 / 10, this.getWidth(), getHeight() * 9 / 10, paintLineVertical);

        Paint paintLineHorizontal = new Paint();
        paintLineHorizontal.setColor(Color.YELLOW);
        paintLineHorizontal.setStrokeWidth(Util.dip2px(context, 1));
        canvas.drawLine(getWidth() * 1 / 10, 0, getWidth() * 1 / 10, getHeight(), paintLineHorizontal);
        canvas.drawLine(getWidth() * 2 / 10, 0, getWidth() * 2 / 10, getHeight(), paintLineHorizontal);
        canvas.drawLine(getWidth() * 3 / 10, 0, getWidth() * 3 / 10, getHeight(), paintLineHorizontal);
        canvas.drawLine(getWidth() * 4 / 10, 0, getWidth() * 4 / 10, getHeight(), paintLineHorizontal);
        canvas.drawLine(getWidth() * 5 / 10, 0, getWidth() * 5 / 10, getHeight(), paintLineHorizontal);
        canvas.drawLine(getWidth() * 6 / 10, 0, getWidth() * 6 / 10, getHeight(), paintLineHorizontal);
        canvas.drawLine(getWidth() * 7 / 10, 0, getWidth() * 7 / 10, getHeight(), paintLineHorizontal);
        canvas.drawLine(getWidth() * 8 / 10, 0, getWidth() * 8 / 10, getHeight(), paintLineHorizontal);
        canvas.drawLine(getWidth() * 9 / 10, 0, getWidth() * 9 / 10, getHeight(), paintLineHorizontal);


        Matrix treeLeaf_Matrix = new Matrix();
//scale, 缩放.
//*** 并且对treeLeaf_Matrix对象进行reset().
        treeLeaf_Matrix.setScale(1, 1);
//translate, 位移, 对图片中的每个像素点实现位移.
        treeLeaf_Matrix.postTranslate(setCicyDistance.getHaErbinx() - Util.dip2px(context, 80), setCicyDistance.getHaErbiny() - Util.dip2px(context, 80));


        Bitmap baseBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.center_gray);
        Bitmap afterBitmap = Bitmap.createBitmap(
                (int) (baseBitmap.getWidth()),
                (int) (baseBitmap.getHeight()), baseBitmap.getConfig());

        canvas.drawBitmap(baseBitmap, treeLeaf_Matrix, paintLineHorizontal);
        DrawGreyLine(canvas);
        Spoor(canvas);
        drawCircle(canvas);

    }

    private void DrawGreyLine(Canvas canvas) {//默认灰线
        Paint paintPath = new Paint();
        paintPath.setColor(getResources().getColor(R.color.a9bed3));
        paintPath.setStyle(Paint.Style.STROKE);
        paintPath.setStrokeWidth(5);

        //画虚线
        paintPath.setPathEffect(new DashPathEffect(new float[]{Util.dip2px(context, 4), Util.dip2px(context, 4)}, Util.dip2px(context, 2)));
        Path path = new Path();
        for (int i = 0; i < dataList.size(); i++) {
            if (i == 0) {
                path.moveTo(dataList.get(i).getX(), dataList.get(i).getY());
            } else {
                path.lineTo(dataList.get(i).getX(), dataList.get(i).getY());
            }
        }

        canvas.drawPath(path, paintPath);
    }

    private void Spoor(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStrokeWidth(10);
        LinearGradient linearGradient = new LinearGradient(100, 100, 500, 500, getResources().getColor(R.color.color1de8b8), getResources().getColor(R.color.color1dc4e9), Shader.TileMode.CLAMP);
        paint.setShader(linearGradient);
        paint.setStyle(Paint.Style.STROKE);
        Path path = new Path();
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                path.moveTo(dataList.get(i).getX(), dataList.get(i).getY());
            } else {
                path.lineTo(dataList.get(i).getX(), dataList.get(i).getY());
            }
        }
        canvas.drawPath(path, paint);
    }

    /**
     * 移动画布
     */
    public void move() {
        int l = (int) (getLeft() - setCicyDistance.getBeiJingX());
        int r = (int) (getRight() - setCicyDistance.getBeiJingX());
        int t = (int) (getTop());
        int b = (int) (getBottom());
        this.layout(l, t, r, b);
        invalidate();
    }

    private void drawCircle(Canvas canvas) {
        Paint paintC = new Paint();
        paintC.setStyle(Paint.Style.FILL);
        paintC.setColor(getResources().getColor(R.color.color03e3f5));
//空心圆
        Paint paintStorke = new Paint();
        paintStorke.setColor(getResources().getColor(R.color.white));
        paintStorke.setStyle(Paint.Style.STROKE);
        paintStorke.setStrokeWidth(2);

        //模糊描边
        Paint paintAp = new Paint();
        paintAp.setColor(getResources().getColor(R.color.border));
        paintAp.setAlpha(50);
        paintAp.setStyle(Paint.Style.FILL_AND_STROKE);
        paintStorke.setStrokeWidth(4);

        for (int i = 0; i < 3; i++) {
            canvas.drawCircle(dataList.get(i).getX(), dataList.get(i).getY(), Util.dip2px(context, 10), paintAp);
            canvas.drawCircle(dataList.get(i).getX(), dataList.get(i).getY(), Util.dip2px(context, 4), paintC);
            canvas.drawCircle(dataList.get(i).getX(), dataList.get(i).getY(), Util.dip2px(context, 6), paintStorke);
        }
    }

    @Override
    public void setOnTouchListener(OnTouchListener l) {
        super.setOnTouchListener(l);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (this.isEnabled()) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    downX = event.getX();
                    downY = event.getY();
                    Log.e("move=====down=", "downx:" + downX + "downY:" + downY);
                    break;
                case MotionEvent.ACTION_MOVE:
                    final float xDistance = event.getX() - downX;
                    final float yDistance = event.getY() - downY;
                    if (xDistance != 0 && yDistance != 0) {
                        int l = (int) (getLeft() + xDistance);
                        int r = (int) (getRight() + xDistance);
                        int t = (int) (getTop() + yDistance);
                        int b = (int) (getBottom() + yDistance);
                        Log.e("move=====move=", "l:" + l + "r:" + r + "t:" + t + "b:" + b);
                        this.layout(l, t, r, b);
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    setPressed(false);
                    break;
                case MotionEvent.ACTION_CANCEL:
                    setPressed(false);
                    break;
            }
            return true;
        }
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        if (this.isEnabled()) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    downX = event.getX();
                    downY = event.getY();
                    if (downX > getWidth() - 500) {
                        return true;
                    }
                    Log.e("move=====down=", "downx:" + downX + "downY:" + downY);
                    break;
                case MotionEvent.ACTION_MOVE:
                    final float xDistance = event.getX() - downX;
                    final float yDistance = event.getY() - downY;
                    if (xDistance != 0 && yDistance != 0) {
                        int l = (int) (getLeft() + xDistance);
                        int r = (int) (getRight() + xDistance);
                        int t = (int) (getTop() + yDistance);
                        int b = (int) (getBottom() + yDistance);
                        Log.e("move=====move=", "l==:" + l + "r==:" + r + "t==:" + t + "b==:" + b +
                                "left==" + getLeft() + "top==" + getTop() + "right==" + getRight() + "bottom==" + getBottom() + "**" + "width==" + this.getWidth() + "height==" + this.getHeight());
                        this.layout(l, t, r, b);
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    setPressed(false);
                    break;
                case MotionEvent.ACTION_CANCEL:
                    setPressed(false);
                    break;
            }
            return true;
        }
        return false;
    }
}