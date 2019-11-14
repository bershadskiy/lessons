package com.test.lessonapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * Part of LessonApp by OasisMediaSystems
 * 2017-2019
 * Created by dimabershadskiy on 2019-11-14.
 */
@Database(version = 2, entities = {BankCardModel.class}, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
	public abstract BankCardModelDao bankCardModelDao();
}
