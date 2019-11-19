package com.test.lessonapp;

import android.app.Application;

import androidx.room.Room;

/**
 * Part of LessonApp by OasisMediaSystems
 * 2017-2019
 * Created by dimabershadskiy on 2019-11-19.
 */
public class LessonApplication extends Application {

	private static LessonApplication instance;

	public static LessonApplication getInstance() {
		return instance;
	}

	private AppDatabase dbInstance;

	public AppDatabase getDbInstance(){
		return dbInstance;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
		dbInstance = Room
						.databaseBuilder(this
										, AppDatabase.class, "lesson-db")
						.fallbackToDestructiveMigration()
						.build();
	}
}
