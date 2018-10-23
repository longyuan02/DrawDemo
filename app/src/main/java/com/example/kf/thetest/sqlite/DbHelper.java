package com.example.kf.thetest.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
	public String sqliteTable="account";
	public String platformId="platformId";
	public String userName="userName";
	public String password="password";
	public String saveTime="saveTime";
	public DbHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}
	public DbHelper(Context context) {
		super(context, "sqlitetest", null, 4);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE account(platformId varchar(20) ,userName varchar(20), password varchar(20), saveTime varchar(20))");
//		db.execSQL("CREATE TABLE account(platformId varchar(20) ,userName varchar(20), password varchar(20), saveTime varchar(20),primary key(userName,platformId))");
//		db.execSQL("CREATE TABLE person(personid integer, primary key autoincrement, name varchar(20))");
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("ALTER TABLE account ADD userName varchar(20)");
	}
}
