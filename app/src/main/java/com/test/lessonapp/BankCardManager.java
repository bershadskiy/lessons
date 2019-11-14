package com.test.lessonapp;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;

/**
 * Part of LessonApp by OasisMediaSystems
 * 2017-2019
 * Created by dimabershadskiy on 2019-10-31.
 */
public class BankCardManager {

	private static final String TAG = "BankCardManager";

	private static AppDatabase appDatabase;

	public static AppDatabase getAppDatabase(Context context) {
		Log.d(TAG, "getAppDatabase");
		if (null == appDatabase) {
			appDatabase = Room
							.databaseBuilder(context.getApplicationContext()
											, AppDatabase.class, "lesson-db")
							.allowMainThreadQueries()
							.fallbackToDestructiveMigration()
							.build();
		}
		return appDatabase;
	}

	public static void addBankCard(Context context, BankCardModel bankCardModel) {
		Log.d(TAG, "addBankCard");
		getAppDatabase(context).bankCardModelDao().insertAll(bankCardModel);
	}

	public static void setBankCard(Context context, BankCardModel card) {
		Log.d(TAG, "setBankCard");
		getAppDatabase(context).bankCardModelDao().update(card);
	}

	public static BankCardModel getCard(Context context, int id) {
		Log.d(TAG, "getCard");

		return getAppDatabase(context).bankCardModelDao().getById(id);
	}

	public static int getCardsCount(Context context) {
		Log.d(TAG, "getCardsCount");
		return getAppDatabase(context).bankCardModelDao().getCount();
	}
}
