package com.test.lessonapp;

import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

	static final ExecutorService databaseWriteExecutor =
					Executors.newFixedThreadPool(1);

	MyReceiver receiver;

	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
		dbInstance = Room
						.databaseBuilder(this
										, AppDatabase.class, "lesson-db")
						.fallbackToDestructiveMigration()

						.build();

		receiver = new MyReceiver();
		registerReceiver(receiver, new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED));
	}
}
