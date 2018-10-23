package com.example.kf.thetest.drawview;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

import com.example.kf.thetest.Util.Util;

import java.util.ArrayList;
import java.util.List;

public class SetCicyDistance implements Parcelable {
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
    private float DaLianx;//大连
    private float DaLiany;

    private float QingDaox;//青岛
    private float QingDaoy;

    private float JiNanx;//济南
    private float JiNany;

    private float ZhengZhoux;//郑州
    private float ZhengZhouy;

    private float HeFeix;//合肥
    private float HeiFeiy;

    private float NanJingx;//南京
    private float NanJingy;

    private float ShangHaix;//上海
    private float ShangHaiy;

    private float NingBox;//宁波
    private float NingBoy;

    private float HangZhoux;//杭州
    private float HangZhouy;


    private float WuHanx;//武汉
    private float WuHany;

    private float ChangShax;//长沙
    private float ChangShay;

    private float NanChangx;//南昌
    private float NanChangy;

    private float FuZhoux;//福州
    private float FuZhouy;

    private float TaiBeix;//台北
    private float TaiBeiy;

    private float XiaMenx;//厦门
    private float XiaMeny;

    private float ShenZhenx;//深圳
    private float ShenZheny;

    private float XiangGangx;//香港
    private float XiangGangy;

    private float AoMenx;//澳门
    private float AoMeny;

    private float GuangZhoux;//广州
    private float GuangZhouy;

    private float HaiKoux;//海口
    private float HaiKouy;

    private float NanNingx;//南宁
    private float NanNingy;

    private float GuiYangx;//贵阳
    private float GuiYangy;

    private float ChongQingx;//重庆
    private float ChongQingy;

    private float XiAnx;//西安
    private float XiAny;

    private float ChengDux;//成都
    private float ChengDuy;


    private float KunMingx;//昆明
    private float KunMingy;

    private float LaSax;//拉萨
    private float LaSay;

    private float WuLuMUQix;//乌鲁木齐
    private float WuLuMUQiy;

    private float XiNingx;//西宁
    private float XiNingy;

    private float LanZhoux;//兰州
    private float LanZhouy;

    private float YinChuanx;//银川
    private float YinChuany;

    private float HuHeHaoTex;//呼和浩特
    private float HuHeHaoTey;

    private float TaiYuanx;//太原
    private float TaiYuany;

    private float ShiJiaZhuangx;//石家庄
    private float ShiJiaZhuangy;
    public List<DistancePointData> dataList = new ArrayList<DistancePointData>();//两个北京点位信息


    public SetCicyDistance(Context context, View view) {
//        哈尔滨this.getWidth()*9/10
        BeiJingX = view.getWidth() * 8 / 10 - Util.dip2px(context, 83);
        BeiJingy = view.getHeight() * 1 / 3 + Util.dip2px(context, 60);
        DistancePointData data1 = new DistancePointData(BeiJingX, BeiJingy);

        TianJinx = view.getWidth() * 8 / 10 - Util.dip2px(context, 55);
        TianJiny = view.getHeight() * 1 / 3 + Util.dip2px(context, 90);
        DistancePointData data2 = new DistancePointData(TianJinx, TianJiny);

        HaErbinx = view.getWidth() * 9 / 10;
        HaErbiny = view.getHeight() * 1 / 5 - Util.dip2px(context, 5);
        DistancePointData data3 = new DistancePointData(HaErbinx, HaErbiny);

        ChangChunx = view.getWidth() * 9 / 10 - Util.dip2px(context, 30);
        ChangChuny = view.getHeight() * 1 / 5 + Util.dip2px(context, 55);
        DistancePointData data4 = new DistancePointData(ChangChunx, ChangChuny);

        ShenYangx = view.getWidth() * 9 / 10 - Util.dip2px(context, 65);
        ShenYangy = view.getHeight() * 3 / 10 + Util.dip2px(context, 10);
        DistancePointData data5 = new DistancePointData(ShenYangx, ShenYangy);

        DaLianx = view.getWidth() * 17 / 20 + Util.dip2px(context, 10);
        DaLiany = view.getHeight() * 4 / 10 - Util.dip2px(context, 45);
        DistancePointData data6 = new DistancePointData(DaLianx, DaLiany);

        QingDaox = view.getWidth() * 8 / 10 + Util.dip2px(context, 30);
        QingDaoy = view.getHeight() * 1 / 2 - Util.dip2px(context, 30);
        DistancePointData data7 = new DistancePointData(QingDaox, QingDaoy);

        JiNanx = view.getWidth() * 15 / 20 + Util.dip2px(context, 33);
        JiNany = view.getHeight() * 1 / 2 - Util.dip2px(context, 15);
        DistancePointData data8 = new DistancePointData(JiNanx, JiNany);

        ZhengZhoux = view.getWidth() * 7 / 10 + Util.dip2px(context, 10);
        ZhengZhouy = view.getHeight() * 1 / 2 + Util.dip2px(context, 50);
        DistancePointData data9 = new DistancePointData(ZhengZhoux, ZhengZhouy);

        HeFeix = view.getWidth() * 15 / 20 + Util.dip2px(context, 55);
        HeiFeiy = view.getHeight() * 6 / 10 + Util.dip2px(context, 30);
        DistancePointData data10 = new DistancePointData(HeFeix, HeiFeiy);

        NanJingx = view.getWidth() * 17 / 20 - Util.dip2px(context, 50);
        NanJingy = view.getHeight() * 6 / 10 - Util.dip2px(context, 10);
        DistancePointData data11 = new DistancePointData(NanJingx, NanJingy);

        ShangHaix = view.getWidth() * 9 / 10 - Util.dip2px(context, 50);
        ShangHaiy = view.getHeight() * 6 / 10 + Util.dip2px(context, 20);
        DistancePointData data12 = new DistancePointData(ShangHaix, ShangHaiy);

        NingBox = view.getWidth() * 9 / 10 - Util.dip2px(context, 50);
        NingBoy = view.getHeight() * 13 / 20 + Util.dip2px(context, 10);
        DistancePointData data13 = new DistancePointData(NingBox, NingBoy);

        HangZhoux = view.getWidth() * 17 / 20 - Util.dip2px(context, 10);
        HangZhouy = view.getHeight() * 13 / 20 + Util.dip2px(context, 15);
        DistancePointData data14 = new DistancePointData(HangZhoux, HangZhouy);

        WuHanx = view.getWidth() * 15 / 20 - Util.dip2px(context, 10);
        WuHany = view.getHeight() * 13 / 20 + Util.dip2px(context, 15);
        DistancePointData data15 = new DistancePointData(WuHanx, WuHany);

        ChangShax = view.getWidth() * 7 / 10 - Util.dip2px(context, 10);
        ChangShay = view.getHeight() * 7 / 10 + Util.dip2px(context, 30);
        DistancePointData data16 = new DistancePointData(ChangShax, ChangShay);

        NanChangx = view.getWidth() * 15 / 20 + Util.dip2px(context, 5);
        NanChangy = view.getHeight() * 7 / 10 - Util.dip2px(context, 15);
        DistancePointData data17 = new DistancePointData(NanChangx, NanChangy);

        FuZhoux = view.getWidth() * 17 / 20 - Util.dip2px(context, 20);
        FuZhouy = view.getHeight() * 8 / 10 - Util.dip2px(context, 55);
        DistancePointData data18 = new DistancePointData(FuZhoux, FuZhouy);

        TaiBeix = view.getWidth() * 9 / 10 - Util.dip2px(context, 15);
        TaiBeiy = view.getHeight() * 8 / 10 - Util.dip2px(context, 15);
        DistancePointData data19 = new DistancePointData(TaiBeix, TaiBeiy);

        XiaMenx = view.getWidth() * 17 / 20 - Util.dip2px(context, 60);
        XiaMeny = view.getHeight() * 8 / 10 + Util.dip2px(context, 25);
        DistancePointData data20 = new DistancePointData(XiaMenx, XiaMeny);


        GuangZhoux = view.getWidth() * 7 / 10 + Util.dip2px(context, 40);
        GuangZhouy = view.getHeight() * 17 / 20 + Util.dip2px(context, 0);
        DistancePointData data21 = new DistancePointData(GuangZhoux, GuangZhouy);

        ShenZhenx = view.getWidth() * 7 / 10 + Util.dip2px(context, 70);
        ShenZheny = view.getHeight() * 17 / 20 + Util.dip2px(context, 15);
        DistancePointData data22 = new DistancePointData(ShenZhenx, ShenZheny);

        XiangGangx = view.getWidth() * 7 / 10 + Util.dip2px(context, 70);
        XiangGangy = view.getHeight() * 17 / 20 + Util.dip2px(context, 30);
        DistancePointData data23 = new DistancePointData(XiangGangx, XiangGangy);

        AoMenx = view.getWidth() * 7 / 10 + Util.dip2px(context, 40);
        AoMeny = view.getHeight() * 9 / 10 - Util.dip2px(context, 20);
        DistancePointData data24 = new DistancePointData(AoMenx, AoMeny);

        HaiKoux = view.getWidth() * 13 / 20 + Util.dip2px(context, 23);
        HaiKouy = view.getHeight() * 19 / 20 + Util.dip2px(context, 18);
        DistancePointData data25 = new DistancePointData(HaiKoux, HaiKouy);

        NanNingx = view.getWidth() * 6 / 10 + Util.dip2px(context, 10);
        NanNingy = view.getHeight() * 17 / 20 + Util.dip2px(context, 15);
        DistancePointData data26 = new DistancePointData(NanNingx, NanNingy);

        GuiYangx = view.getWidth() * 6 / 10 - Util.dip2px(context, 32);
        GuiYangy = view.getHeight() * 15 / 20 + Util.dip2px(context, 35);
        DistancePointData data27 = new DistancePointData(GuiYangx, GuiYangy);

        ChongQingx = view.getWidth() * 6 / 10 - Util.dip2px(context, 30);
        ChongQingy = view.getHeight() * 7 / 10 - Util.dip2px(context, 15);
        DistancePointData data28 = new DistancePointData(ChongQingx, ChongQingy);

        XiAnx = view.getWidth() * 6 / 10 + Util.dip2px(context, 40);
        XiAny = view.getHeight() * 11 / 20 - Util.dip2px(context, 0);
        DistancePointData data29 = new DistancePointData(XiAnx, XiAny);

        ChengDux = view.getWidth() * 5 / 10 + Util.dip2px(context, 18);
        ChengDuy = view.getHeight() * 13 / 20 + Util.dip2px(context, 3);
        DistancePointData data30 = new DistancePointData(ChengDux, ChengDuy);

        KunMingx = view.getWidth() * 5 / 10 + Util.dip2px(context, 18);
        KunMingy = view.getHeight() * 8 / 10 + Util.dip2px(context, 15);
        DistancePointData data31 = new DistancePointData(KunMingx, KunMingy);

        LaSax = view.getWidth() * 3 / 10 - Util.dip2px(context, 15);
        LaSay = view.getHeight() * 7 / 10 - Util.dip2px(context, 35);
        DistancePointData data32 = new DistancePointData(LaSax, LaSay);

        WuLuMUQix = view.getWidth() * 5 / 20 + Util.dip2px(context, 5);
        WuLuMUQiy = view.getHeight() * 5 / 20 + Util.dip2px(context, 20);
        DistancePointData data33 = new DistancePointData(WuLuMUQix, WuLuMUQiy);

        XiNingx = view.getWidth() * 9 / 20 + Util.dip2px(context, 20);
        XiNingy = view.getHeight() * 1 / 2 - Util.dip2px(context, 20);
        DistancePointData data34 = new DistancePointData(XiNingx, XiNingy);

        LanZhoux = view.getWidth() * 11 / 20 - Util.dip2px(context, 30);
        LanZhouy = view.getHeight() * 1 / 2 - Util.dip2px(context, 5);
        DistancePointData data35 = new DistancePointData(LanZhoux, LanZhouy);

        YinChuanx = view.getWidth() * 11 / 20 + Util.dip2px(context, 30);
        YinChuany = view.getHeight() * 9 / 20 - Util.dip2px(context, 5);
        DistancePointData data36 = new DistancePointData(YinChuanx, YinChuany);

        HuHeHaoTex = view.getWidth() * 13 / 20 + Util.dip2px(context, 20);
        HuHeHaoTey = view.getHeight() * 7 / 20 + Util.dip2px(context, 35);
        DistancePointData data37 = new DistancePointData(HuHeHaoTex, HuHeHaoTey);

        TaiYuanx = view.getWidth() * 13 / 20 + Util.dip2px(context, 20);
        TaiYuany = view.getHeight() * 7 / 20 + Util.dip2px(context, 35);
        DistancePointData data38 = new DistancePointData(TaiYuanx, TaiYuany);

        ShiJiaZhuangx = view.getWidth() * 7 / 10 + Util.dip2px(context, 45);
        ShiJiaZhuangy = view.getHeight() * 4 / 10 + Util.dip2px(context, 40);
        DistancePointData data39 = new DistancePointData(ShiJiaZhuangx, ShiJiaZhuangy);
        dataList.add(data1);
        dataList.add(data2);
        dataList.add(data3);
        dataList.add(data4);
        dataList.add(data5);
        dataList.add(data6);
        dataList.add(data7);
        dataList.add(data8);
        dataList.add(data9);
        dataList.add(data10);
        dataList.add(data11);
        dataList.add(data12);
        dataList.add(data13);
        dataList.add(data14);
        dataList.add(data15);
        dataList.add(data16);
        dataList.add(data17);
        dataList.add(data18);
        dataList.add(data19);
        dataList.add(data20);
        dataList.add(data21);
        dataList.add(data22);
        dataList.add(data23);
        dataList.add(data24);
        dataList.add(data25);
        dataList.add(data26);
        dataList.add(data27);
        dataList.add(data28);
        dataList.add(data29);
        dataList.add(data30);
        dataList.add(data31);
        dataList.add(data32);
        dataList.add(data33);
        dataList.add(data34);
        dataList.add(data35);
        dataList.add(data36);
        dataList.add(data37);
        dataList.add(data38);
        dataList.add(data39);
        dataList.add(data1);

    }

    protected SetCicyDistance(Parcel in) {
        BeiJingX = in.readFloat();
        BeiJingy = in.readFloat();
        TianJinx = in.readFloat();
        TianJiny = in.readFloat();
        HaErbinx = in.readFloat();
        HaErbiny = in.readFloat();
        ChangChunx = in.readFloat();
        ChangChuny = in.readFloat();
        ShenYangx = in.readFloat();
        ShenYangy = in.readFloat();
        DaLianx = in.readFloat();
        DaLiany = in.readFloat();
        QingDaox = in.readFloat();
        QingDaoy = in.readFloat();
        JiNanx = in.readFloat();
        JiNany = in.readFloat();
        ZhengZhoux = in.readFloat();
        ZhengZhouy = in.readFloat();
        HeFeix = in.readFloat();
        HeiFeiy = in.readFloat();
        NanJingx = in.readFloat();
        NanJingy = in.readFloat();
        ShangHaix = in.readFloat();
        ShangHaiy = in.readFloat();
        NingBox = in.readFloat();
        NingBoy = in.readFloat();
        HangZhoux = in.readFloat();
        HangZhouy = in.readFloat();
        WuHanx = in.readFloat();
        WuHany = in.readFloat();
        ChangShax = in.readFloat();
        ChangShay = in.readFloat();
        NanChangx = in.readFloat();
        NanChangy = in.readFloat();
        FuZhoux = in.readFloat();
        FuZhouy = in.readFloat();
        TaiBeix = in.readFloat();
        TaiBeiy = in.readFloat();
        XiaMenx = in.readFloat();
        XiaMeny = in.readFloat();
        ShenZhenx = in.readFloat();
        ShenZheny = in.readFloat();
        XiangGangx = in.readFloat();
        XiangGangy = in.readFloat();
        AoMenx = in.readFloat();
        AoMeny = in.readFloat();
        GuangZhoux = in.readFloat();
        GuangZhouy = in.readFloat();
        HaiKoux = in.readFloat();
        HaiKouy = in.readFloat();
        NanNingx = in.readFloat();
        NanNingy = in.readFloat();
        GuiYangx = in.readFloat();
        GuiYangy = in.readFloat();
        ChongQingx = in.readFloat();
        ChongQingy = in.readFloat();
        XiAnx = in.readFloat();
        XiAny = in.readFloat();
        ChengDux = in.readFloat();
        ChengDuy = in.readFloat();
        KunMingx = in.readFloat();
        KunMingy = in.readFloat();
        LaSax = in.readFloat();
        LaSay = in.readFloat();
        WuLuMUQix = in.readFloat();
        WuLuMUQiy = in.readFloat();
        XiNingx = in.readFloat();
        XiNingy = in.readFloat();
        LanZhoux = in.readFloat();
        LanZhouy = in.readFloat();
        YinChuanx = in.readFloat();
        YinChuany = in.readFloat();
        HuHeHaoTex = in.readFloat();
        HuHeHaoTey = in.readFloat();
        TaiYuanx = in.readFloat();
        TaiYuany = in.readFloat();
        ShiJiaZhuangx = in.readFloat();
        ShiJiaZhuangy = in.readFloat();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(BeiJingX);
        dest.writeFloat(BeiJingy);
        dest.writeFloat(TianJinx);
        dest.writeFloat(TianJiny);
        dest.writeFloat(HaErbinx);
        dest.writeFloat(HaErbiny);
        dest.writeFloat(ChangChunx);
        dest.writeFloat(ChangChuny);
        dest.writeFloat(ShenYangx);
        dest.writeFloat(ShenYangy);
        dest.writeFloat(DaLianx);
        dest.writeFloat(DaLiany);
        dest.writeFloat(QingDaox);
        dest.writeFloat(QingDaoy);
        dest.writeFloat(JiNanx);
        dest.writeFloat(JiNany);
        dest.writeFloat(ZhengZhoux);
        dest.writeFloat(ZhengZhouy);
        dest.writeFloat(HeFeix);
        dest.writeFloat(HeiFeiy);
        dest.writeFloat(NanJingx);
        dest.writeFloat(NanJingy);
        dest.writeFloat(ShangHaix);
        dest.writeFloat(ShangHaiy);
        dest.writeFloat(NingBox);
        dest.writeFloat(NingBoy);
        dest.writeFloat(HangZhoux);
        dest.writeFloat(HangZhouy);
        dest.writeFloat(WuHanx);
        dest.writeFloat(WuHany);
        dest.writeFloat(ChangShax);
        dest.writeFloat(ChangShay);
        dest.writeFloat(NanChangx);
        dest.writeFloat(NanChangy);
        dest.writeFloat(FuZhoux);
        dest.writeFloat(FuZhouy);
        dest.writeFloat(TaiBeix);
        dest.writeFloat(TaiBeiy);
        dest.writeFloat(XiaMenx);
        dest.writeFloat(XiaMeny);
        dest.writeFloat(ShenZhenx);
        dest.writeFloat(ShenZheny);
        dest.writeFloat(XiangGangx);
        dest.writeFloat(XiangGangy);
        dest.writeFloat(AoMenx);
        dest.writeFloat(AoMeny);
        dest.writeFloat(GuangZhoux);
        dest.writeFloat(GuangZhouy);
        dest.writeFloat(HaiKoux);
        dest.writeFloat(HaiKouy);
        dest.writeFloat(NanNingx);
        dest.writeFloat(NanNingy);
        dest.writeFloat(GuiYangx);
        dest.writeFloat(GuiYangy);
        dest.writeFloat(ChongQingx);
        dest.writeFloat(ChongQingy);
        dest.writeFloat(XiAnx);
        dest.writeFloat(XiAny);
        dest.writeFloat(ChengDux);
        dest.writeFloat(ChengDuy);
        dest.writeFloat(KunMingx);
        dest.writeFloat(KunMingy);
        dest.writeFloat(LaSax);
        dest.writeFloat(LaSay);
        dest.writeFloat(WuLuMUQix);
        dest.writeFloat(WuLuMUQiy);
        dest.writeFloat(XiNingx);
        dest.writeFloat(XiNingy);
        dest.writeFloat(LanZhoux);
        dest.writeFloat(LanZhouy);
        dest.writeFloat(YinChuanx);
        dest.writeFloat(YinChuany);
        dest.writeFloat(HuHeHaoTex);
        dest.writeFloat(HuHeHaoTey);
        dest.writeFloat(TaiYuanx);
        dest.writeFloat(TaiYuany);
        dest.writeFloat(ShiJiaZhuangx);
        dest.writeFloat(ShiJiaZhuangy);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SetCicyDistance> CREATOR = new Creator<SetCicyDistance>() {
        @Override
        public SetCicyDistance createFromParcel(Parcel in) {
            return new SetCicyDistance(in);
        }

        @Override
        public SetCicyDistance[] newArray(int size) {
            return new SetCicyDistance[size];
        }
    };

    public float getBeiJingX() {
        return BeiJingX;
    }

    public void setBeiJingX(float beiJingX) {
        BeiJingX = beiJingX;
    }

    public float getBeiJingy() {
        return BeiJingy;
    }

    public void setBeiJingy(float beiJingy) {
        BeiJingy = beiJingy;
    }

    public float getTianJinx() {
        return TianJinx;
    }

    public void setTianJinx(float tianJinx) {
        TianJinx = tianJinx;
    }

    public float getTianJiny() {
        return TianJiny;
    }

    public void setTianJiny(float tianJiny) {
        TianJiny = tianJiny;
    }

    public float getHaErbinx() {
        return HaErbinx;
    }

    public void setHaErbinx(float haErbinx) {
        HaErbinx = haErbinx;
    }

    public float getHaErbiny() {
        return HaErbiny;
    }

    public void setHaErbiny(float haErbiny) {
        HaErbiny = haErbiny;
    }

    public float getChangChunx() {
        return ChangChunx;
    }

    public void setChangChunx(float changChunx) {
        ChangChunx = changChunx;
    }

    public float getChangChuny() {
        return ChangChuny;
    }

    public void setChangChuny(float changChuny) {
        ChangChuny = changChuny;
    }

    public float getShenYangx() {
        return ShenYangx;
    }

    public void setShenYangx(float shenYangx) {
        ShenYangx = shenYangx;
    }

    public float getShenYangy() {
        return ShenYangy;
    }

    public void setShenYangy(float shenYangy) {
        ShenYangy = shenYangy;
    }

    public float getDaLianx() {
        return DaLianx;
    }

    public void setDaLianx(float daLianx) {
        DaLianx = daLianx;
    }

    public float getDaLiany() {
        return DaLiany;
    }

    public void setDaLiany(float daLiany) {
        DaLiany = daLiany;
    }

    public float getQingDaox() {
        return QingDaox;
    }

    public void setQingDaox(float qingDaox) {
        QingDaox = qingDaox;
    }

    public float getQingDaoy() {
        return QingDaoy;
    }

    public void setQingDaoy(float qingDaoy) {
        QingDaoy = qingDaoy;
    }

    public float getJiNanx() {
        return JiNanx;
    }

    public void setJiNanx(float jiNanx) {
        JiNanx = jiNanx;
    }

    public float getJiNany() {
        return JiNany;
    }

    public void setJiNany(float jiNany) {
        JiNany = jiNany;
    }

    public float getZhengZhoux() {
        return ZhengZhoux;
    }

    public void setZhengZhoux(float zhengZhoux) {
        ZhengZhoux = zhengZhoux;
    }

    public float getZhengZhouy() {
        return ZhengZhouy;
    }

    public void setZhengZhouy(float zhengZhouy) {
        ZhengZhouy = zhengZhouy;
    }

    public float getHeFeix() {
        return HeFeix;
    }

    public void setHeFeix(float heFeix) {
        HeFeix = heFeix;
    }

    public float getHeiFeiy() {
        return HeiFeiy;
    }

    public void setHeiFeiy(float heiFeiy) {
        HeiFeiy = heiFeiy;
    }

    public float getNanJingx() {
        return NanJingx;
    }

    public void setNanJingx(float nanJingx) {
        NanJingx = nanJingx;
    }

    public float getNanJingy() {
        return NanJingy;
    }

    public void setNanJingy(float nanJingy) {
        NanJingy = nanJingy;
    }

    public float getShangHaix() {
        return ShangHaix;
    }

    public void setShangHaix(float shangHaix) {
        ShangHaix = shangHaix;
    }

    public float getShangHaiy() {
        return ShangHaiy;
    }

    public void setShangHaiy(float shangHaiy) {
        ShangHaiy = shangHaiy;
    }

    public float getNingBox() {
        return NingBox;
    }

    public void setNingBox(float ningBox) {
        NingBox = ningBox;
    }

    public float getNingBoy() {
        return NingBoy;
    }

    public void setNingBoy(float ningBoy) {
        NingBoy = ningBoy;
    }

    public float getHangZhoux() {
        return HangZhoux;
    }

    public void setHangZhoux(float hangZhoux) {
        HangZhoux = hangZhoux;
    }

    public float getHangZhouy() {
        return HangZhouy;
    }

    public void setHangZhouy(float hangZhouy) {
        HangZhouy = hangZhouy;
    }

    public float getWuHanx() {
        return WuHanx;
    }

    public void setWuHanx(float wuHanx) {
        WuHanx = wuHanx;
    }

    public float getWuHany() {
        return WuHany;
    }

    public void setWuHany(float wuHany) {
        WuHany = wuHany;
    }

    public float getChangShax() {
        return ChangShax;
    }

    public void setChangShax(float changShax) {
        ChangShax = changShax;
    }

    public float getChangShay() {
        return ChangShay;
    }

    public void setChangShay(float changShay) {
        ChangShay = changShay;
    }

    public float getNanChangx() {
        return NanChangx;
    }

    public void setNanChangx(float nanChangx) {
        NanChangx = nanChangx;
    }

    public float getNanChangy() {
        return NanChangy;
    }

    public void setNanChangy(float nanChangy) {
        NanChangy = nanChangy;
    }

    public float getFuZhoux() {
        return FuZhoux;
    }

    public void setFuZhoux(float fuZhoux) {
        FuZhoux = fuZhoux;
    }

    public float getFuZhouy() {
        return FuZhouy;
    }

    public void setFuZhouy(float fuZhouy) {
        FuZhouy = fuZhouy;
    }

    public float getTaiBeix() {
        return TaiBeix;
    }

    public void setTaiBeix(float taiBeix) {
        TaiBeix = taiBeix;
    }

    public float getTaiBeiy() {
        return TaiBeiy;
    }

    public void setTaiBeiy(float taiBeiy) {
        TaiBeiy = taiBeiy;
    }

    public float getXiaMenx() {
        return XiaMenx;
    }

    public void setXiaMenx(float xiaMenx) {
        XiaMenx = xiaMenx;
    }

    public float getXiaMeny() {
        return XiaMeny;
    }

    public void setXiaMeny(float xiaMeny) {
        XiaMeny = xiaMeny;
    }

    public float getShenZhenx() {
        return ShenZhenx;
    }

    public void setShenZhenx(float shenZhenx) {
        ShenZhenx = shenZhenx;
    }

    public float getShenZheny() {
        return ShenZheny;
    }

    public void setShenZheny(float shenZheny) {
        ShenZheny = shenZheny;
    }

    public float getXiangGangx() {
        return XiangGangx;
    }

    public void setXiangGangx(float xiangGangx) {
        XiangGangx = xiangGangx;
    }

    public float getXiangGangy() {
        return XiangGangy;
    }

    public void setXiangGangy(float xiangGangy) {
        XiangGangy = xiangGangy;
    }

    public float getAoMenx() {
        return AoMenx;
    }

    public void setAoMenx(float aoMenx) {
        AoMenx = aoMenx;
    }

    public float getAoMeny() {
        return AoMeny;
    }

    public void setAoMeny(float aoMeny) {
        AoMeny = aoMeny;
    }

    public float getGuangZhoux() {
        return GuangZhoux;
    }

    public void setGuangZhoux(float guangZhoux) {
        GuangZhoux = guangZhoux;
    }

    public float getGuangZhouy() {
        return GuangZhouy;
    }

    public void setGuangZhouy(float guangZhouy) {
        GuangZhouy = guangZhouy;
    }

    public float getHaiKoux() {
        return HaiKoux;
    }

    public void setHaiKoux(float haiKoux) {
        HaiKoux = haiKoux;
    }

    public float getHaiKouy() {
        return HaiKouy;
    }

    public void setHaiKouy(float haiKouy) {
        HaiKouy = haiKouy;
    }

    public float getNanNingx() {
        return NanNingx;
    }

    public void setNanNingx(float nanNingx) {
        NanNingx = nanNingx;
    }

    public float getNanNingy() {
        return NanNingy;
    }

    public void setNanNingy(float nanNingy) {
        NanNingy = nanNingy;
    }

    public float getGuiYangx() {
        return GuiYangx;
    }

    public void setGuiYangx(float guiYangx) {
        GuiYangx = guiYangx;
    }

    public float getGuiYangy() {
        return GuiYangy;
    }

    public void setGuiYangy(float guiYangy) {
        GuiYangy = guiYangy;
    }

    public float getChongQingx() {
        return ChongQingx;
    }

    public void setChongQingx(float chongQingx) {
        ChongQingx = chongQingx;
    }

    public float getChongQingy() {
        return ChongQingy;
    }

    public void setChongQingy(float chongQingy) {
        ChongQingy = chongQingy;
    }

    public float getXiAnx() {
        return XiAnx;
    }

    public void setXiAnx(float xiAnx) {
        XiAnx = xiAnx;
    }

    public float getXiAny() {
        return XiAny;
    }

    public void setXiAny(float xiAny) {
        XiAny = xiAny;
    }

    public float getChengDux() {
        return ChengDux;
    }

    public void setChengDux(float chengDux) {
        ChengDux = chengDux;
    }

    public float getChengDuy() {
        return ChengDuy;
    }

    public void setChengDuy(float chengDuy) {
        ChengDuy = chengDuy;
    }

    public float getKunMingx() {
        return KunMingx;
    }

    public void setKunMingx(float kunMingx) {
        KunMingx = kunMingx;
    }

    public float getKunMingy() {
        return KunMingy;
    }

    public void setKunMingy(float kunMingy) {
        KunMingy = kunMingy;
    }

    public float getLaSax() {
        return LaSax;
    }

    public void setLaSax(float laSax) {
        LaSax = laSax;
    }

    public float getLaSay() {
        return LaSay;
    }

    public void setLaSay(float laSay) {
        LaSay = laSay;
    }

    public float getWuLuMUQix() {
        return WuLuMUQix;
    }

    public void setWuLuMUQix(float wuLuMUQix) {
        WuLuMUQix = wuLuMUQix;
    }

    public float getWuLuMUQiy() {
        return WuLuMUQiy;
    }

    public void setWuLuMUQiy(float wuLuMUQiy) {
        WuLuMUQiy = wuLuMUQiy;
    }

    public float getXiNingx() {
        return XiNingx;
    }

    public void setXiNingx(float xiNingx) {
        XiNingx = xiNingx;
    }

    public float getXINingy() {
        return XiNingy;
    }

    public void setXINingy(float XINingy) {
        this.XiNingy = XINingy;
    }

    public float getLanZhoux() {
        return LanZhoux;
    }

    public void setLanZhoux(float lanZhoux) {
        LanZhoux = lanZhoux;
    }

    public float getLanZhouy() {
        return LanZhouy;
    }

    public void setLanZhouy(float lanZhouy) {
        LanZhouy = lanZhouy;
    }

    public float getYinChuanx() {
        return YinChuanx;
    }

    public void setYinChuanx(float yinChuanx) {
        YinChuanx = yinChuanx;
    }

    public float getYinChuany() {
        return YinChuany;
    }

    public void setYinChuany(float yinChuany) {
        YinChuany = yinChuany;
    }

    public float getHuHeHaoTex() {
        return HuHeHaoTex;
    }

    public void setHuHeHaoTex(float huHeHaoTex) {
        HuHeHaoTex = huHeHaoTex;
    }

    public float getHuHeHaoTey() {
        return HuHeHaoTey;
    }

    public void setHuHeHaoTey(float huHeHaoTey) {
        HuHeHaoTey = huHeHaoTey;
    }

    public float getTaiYuanx() {
        return TaiYuanx;
    }

    public void setTaiYuanx(float taiYuanx) {
        TaiYuanx = taiYuanx;
    }

    public float getTaiYuany() {
        return TaiYuany;
    }

    public void setTaiYuany(float taiYuany) {
        TaiYuany = taiYuany;
    }

    public float getShiJiaZhuangx() {
        return ShiJiaZhuangx;
    }

    public void setShiJiaZhuangx(float shiJiaZhuangx) {
        ShiJiaZhuangx = shiJiaZhuangx;
    }

    public float getShiJiaZhuangy() {
        return ShiJiaZhuangy;
    }

    public void setShiJiaZhuangy(float shiJiaZhuangy) {
        ShiJiaZhuangy = shiJiaZhuangy;
    }

    public List<DistancePointData> getDataList() {
        return dataList;
    }

    public void setDataList(List<DistancePointData> dataList) {
        this.dataList = dataList;
    }
}
