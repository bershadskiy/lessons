package com.test.lessonapp;

import android.content.Intent;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Part of LessonApp by OasisMediaSystems
 * 2017-2019
 * Created by dimabershadskiy on 2019-11-19.
 */
public class MainFragmentVM extends ViewModel {

	private static final String TAG = "MainFragmentVM";

	private LiveData<List<BankCardModel>> bankCardModelList;

	public LiveData<List<BankCardModel>> getBankCardModelList() {
		if (null == bankCardModelList)
			bankCardModelList = BankCardManager.getAppDatabase().bankCardModelDao().getAll();
		return bankCardModelList;
	}

	@Override
	protected void onCleared() {
		super.onCleared();
		Log.e(TAG, "onCleared: ", null);
	}
}
