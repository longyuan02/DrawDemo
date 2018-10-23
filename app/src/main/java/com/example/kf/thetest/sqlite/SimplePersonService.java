package com.example.kf.thetest.sqlite;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * 使用sqliteDatabase提供的api简单实现数据的增删改查，对于那些不熟悉sql语句的人来用比较方便，但没有直接执行sql语句功能强大
 *
 * @author 程科
 */
public class SimplePersonService {
    private DbHelper dbHelper;

    public SimplePersonService(Context context) {
        dbHelper = new DbHelper(context);
    }

    /**
     * 增加记录
     */
    public void save(PlatformMessage platformMessage) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();// 对于同一个dbHelper对象通过这个方法打开的多个数据对象是同一个

        ContentValues contentValues = new ContentValues();
        contentValues.put(dbHelper.userName, platformMessage.getUserName());
        contentValues.put(dbHelper.password, platformMessage.getPassword());
        contentValues.put(dbHelper.platformId, platformMessage.getPlatformId());
        contentValues.put(dbHelper.saveTime, platformMessage.getSaveTime());
        db.insert(dbHelper.sqliteTable, null, contentValues);
		/*
         * db.execSQL("INSERT INTO person(name, phone) VALUES (?, ?)", new
		 * Object[] { person.getName(), person.getPhone() });
		 */
        db.close();// 当应用中只有一处使用数据库时，不关数据库会提高系统系能，因为不用频繁打开数据库
    }
//	public Person getValue(){
//		SQLiteDatabase db = dbHelper.getWritableDatabase();// 对于同一个dbHelper对象通过这个方法打开的多个数据对象是同一个
//		return
//	}
    /**
     * 删除记录
     *
     * @param id
     */
    public void delete(int id) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();// 对于同一个dbHelper对象通过这个方法打开的多个数据对象是同一个
        db.delete(dbHelper.sqliteTable, dbHelper.userName + "=?", new String[]{dbHelper.userName});/*
        db.execSQL("DELETE FROM person WHERE personid = ? ",
				new Object[] { id });*/
    }
    /**
     * 更新纪录
     */
    public void update(PlatformMessage platformMessage) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();// 对于同一个dbHelper对象通过这个方法打开的多个数据对象是同一个
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbHelper.userName, platformMessage.getUserName());
        contentValues.put(dbHelper.password, platformMessage.getPassword());
        contentValues.put(dbHelper.platformId, platformMessage.getPlatformId());
        contentValues.put(dbHelper.saveTime, platformMessage.getSaveTime());
        db.update(dbHelper.sqliteTable, contentValues, "userName= ? and platformId=?", new String[]{platformMessage.getUserName(),platformMessage.getPlatformId()});
//执行SQL
//        db.execSQL("UPDATE " + dbHelper.sqliteTable + " SET " + dbHelper.userName + "= ?, " + dbHelper.password + "= ? WHERE " + dbHelper.platformId + "= ? and " + dbHelper.saveTime + "= ? ",
//                new Object[]{platformMessage.getUserName(), platformMessage.getPassword(), platformMessage.getPlatformId(), platformMessage.getSaveTime()});
    }
    /**
     * 通过id查询
     *
     * @param id personid
     *           platformMessage
     * @return 查询得到的对象
     */
    public PlatformMessage findById(Integer id) {
        /*
		 * 如果数据库空间还充足，则会调用getWitableDatabase();
		 * 返回的数据库对象可以执行写操作；如果数据库磁盘空间已满，则会返回一个只读的数据库对象
		 */
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(dbHelper.sqliteTable, null, "personid=?", new String[]{id.toString()}, null, null, null);
		/*Cursor cursor = db.rawQuery("SELECT * FROM person WHERE personid = ?",
				new String[] { id.toString() });*/
        PlatformMessage platformMessage = null;
        if (cursor.moveToFirst()) {
            platformMessage = new PlatformMessage();
            platformMessage.setUserName(cursor.getString(cursor.getColumnIndex(dbHelper.userName)));
            platformMessage.setPassword(cursor.getString(cursor.getColumnIndex(dbHelper.password)));
            platformMessage.setPlatformId(cursor.getString(cursor.getColumnIndex(dbHelper.platformId)));
            platformMessage.setSaveTime(cursor.getString(cursor.getColumnIndex(dbHelper.saveTime)));
        }

        return platformMessage;
    }

    /**
     * 条件查询
     *
     * @param condition
     * @return
     */
    public PlatformMessage findByCondition(String condition, String platform) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(dbHelper.sqliteTable, null, dbHelper.userName + "=? and " + dbHelper.platformId + "=?", new String[]{condition, platform}, null, null, null);
        PlatformMessage platformMessage = null;
        if (cursor.moveToFirst()) {
            platformMessage = new PlatformMessage();
            platformMessage.setUserName(cursor.getString(cursor.getColumnIndex(dbHelper.userName)));
            platformMessage.setPassword(cursor.getString(cursor.getColumnIndex(dbHelper.password)));
            platformMessage.setPlatformId(cursor.getString(cursor.getColumnIndex(dbHelper.platformId)));
            platformMessage.setSaveTime(cursor.getString(cursor.getColumnIndex(dbHelper.saveTime)));
        }
        return platformMessage;
    }

    /**
     * 是否有重复条件
     *
     * @param condition
     * @return
     */
    public boolean filtrationData(String condition, String plat) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        boolean filtration = false;
        Cursor cursor = db.query(dbHelper.sqliteTable, null, dbHelper.userName + "=? and "+dbHelper.platformId+"=?", new String[]{condition,plat}, null, null, null);
        if (cursor.moveToFirst()) {
            filtration = true;
            for (int i = 0; i < cursor.getLong(0); i++) {

            }
        } else {
            filtration = cursor.moveToFirst();
        }
        return filtration;
    }

    /**
     * 分页查询
     *
     * @param offset    跳过多少条记录
     * @param maxResult 获取记录数
     * @return
     */
    public List<PlatformMessage> getScrollAll(Integer offset, Integer maxResult) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(dbHelper.sqliteTable, null, null, null, null, null, "personid ASC", offset + "," + maxResult);
		/*Cursor cursor = db.rawQuery(
				"SELECT * FROM person ORDER BY personid ASC LIMIT ?, ?",
				new String[] { offset.toString(), maxResult.toString() });*/
        PlatformMessage platformMessage = null;
        List<PlatformMessage> list = new ArrayList<PlatformMessage>();
        while (cursor.moveToNext()) {
            platformMessage = new PlatformMessage();
            platformMessage.setUserName(cursor.getString(cursor.getColumnIndex(dbHelper.userName)));
            platformMessage.setPassword(cursor.getString(cursor.getColumnIndex(dbHelper.password)));
            platformMessage.setPlatformId(cursor.getString(cursor.getColumnIndex(dbHelper.platformId)));
            platformMessage.setSaveTime(cursor.getString(cursor.getColumnIndex(dbHelper.saveTime)));
            list.add(platformMessage);
        }
        return list;
    }

    /**
     * 获取记录总数
     */
    public long getCount() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        db.query(dbHelper.sqliteTable, new String[]{"COUNT(*)"}, null, null, null, null, null);
        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM" + dbHelper.sqliteTable, null);
        cursor.moveToFirst();
        long result = cursor.getLong(0);
        return result;
    }
}
