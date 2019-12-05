package com.test.lessonapp;

import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;

import androidx.room.Room;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

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

	public AppDatabase getDbInstance() {
		return dbInstance;
	}

	static final ExecutorService databaseWriteExecutor =
					Executors.newFixedThreadPool(1);

	Retrofit retrofit;

	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
		dbInstance = Room
						.databaseBuilder(this
										, AppDatabase.class, "lesson-db")
						.fallbackToDestructiveMigration()

						.build();

		HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
		loggingInterceptor.level(HttpLoggingInterceptor.Level.BASIC);

		OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();

		retrofit = new Retrofit.Builder()
						.baseUrl("https://api.github.com")
						.addConverterFactory(GsonConverterFactory.create())
						.client(okHttpClient)
						.build();
	}
}
