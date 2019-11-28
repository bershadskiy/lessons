package com.test.lessonapp;

import android.util.Log;

/**
 * Part of LessonApp by OasisMediaSystems
 * 2017-2019
 * Created by dimabershadskiy on 2019-10-31.
 */
public class BankCardManager {

	private static final String TAG = "BankCardManager";

	public static AppDatabase getAppDatabase() {
		Log.d(TAG, "getAppDatabase");
		return LessonApplication.getInstance().getDbInstance();
	}

	public static void addBankCard(final BankCardModel bankCardModel) {
		Log.d(TAG, "addBankCard");
		LessonApplication.databaseWriteExecutor.execute(new Runnable() {
			@Override
			public void run() {
				getAppDatabase().bankCardModelDao().insertAll(bankCardModel);
			}
		});

	}

	public static void setBankCard(BankCardModel card) {
		Log.d(TAG, "setBankCard");
		getAppDatabase().bankCardModelDao().update(card);
	}

	public static BankCardModel getCard(int id) {
		Log.d(TAG, "getCard");

		return getAppDatabase().bankCardModelDao().getById(id);
	}

}
