package com.test.lessonapp;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Binder;
import android.os.HandlerThread;
import android.os.IBinder;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Part of LessonApp by OasisMediaSystems
 * 2017-2019
 * Created by dimabershadskiy on 2019-12-03.
 */
public class TestService extends Service implements Callback<ArrayList<Repo>> {

	private static final String TAG = "TestService";

	@Nullable
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}


	public static Intent getCommandIntent(Context context, String username) {
		return new Intent(context, TestService.class).putExtra("EXTRA_USERNAME", username);
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {

		String username = intent.getStringExtra("EXTRA_USERNAME");
		Log.d(TAG, "onStartCommand: "+ username);
		GithubAPIService githubAPIService = LessonApplication.getInstance().retrofit.create(GithubAPIService.class);
		githubAPIService.listRepos(username).enqueue(this);
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onCreate() {
		Log.d(TAG, "onCreate: ");
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		Log.d(TAG, "onDestroy: ");
		super.onDestroy();
	}

	@Override
	public void onResponse(Call<ArrayList<Repo>> call, Response<ArrayList<Repo>> response) {
		if (!response.isSuccessful())
			return;

		ArrayList<Repo> body = response.body();
		Intent intent = new Intent();
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		String packName = this.getClass().getPackage().getName();
		String canonicalName = MainActivity.class.getCanonicalName();
		ComponentName component = new ComponentName(packName, canonicalName);
		intent.setComponent(component);
		intent.putParcelableArrayListExtra("EXTRA_DATA", body);
		startActivity(intent);
	}

	@Override
	public void onFailure(Call<ArrayList<Repo>> call, Throwable t) {

	}
}
