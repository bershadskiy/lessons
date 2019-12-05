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

import androidx.annotation.Nullable;

/**
 * Part of LessonApp by OasisMediaSystems
 * 2017-2019
 * Created by dimabershadskiy on 2019-12-03.
 */
public class TestService extends Service {

	private static final String TAG = "TestService";

	public class ITestBinder extends Binder {
		void doStuff() {
			Log.d(TAG, "doStuff: ");
//			m.
		}
	}

	private ITestBinder binder;

//	public static abstract class TestServiceConnection implements ServiceConnection {
//
//		@Override
//		public void onServiceConnected(ComponentName name, IBinder service) {
//			onTypedServiceConnected(name, (ITestBinder) service);
//		}
//
//		public abstract void onTypedServiceConnected(ComponentName name, ITestBinder service);
//	}

	HandlerThread m;

	@Nullable
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	public static Intent getIntent(Context context) {
		return new Intent(context, TestService.class);
	}

	public static Intent getCommandInten(Context context, Uri uri){
		return new Intent(context, TestService.class).setData(uri);
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d(TAG, "onStartCommand: " + intent.getData().toString());
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onCreate() {
		binder = new ITestBinder();
		m = new HandlerThread(TAG);
		Log.d(TAG, "onCreate: ");
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		Log.d(TAG, "onDestroy: ");
		m.quitSafely();
		super.onDestroy();
	}

//	@Override
//	public boolean onUnbind(Intent intent) {
//		Log.d(TAG, "onUnbind: ");
//		return super.onUnbind(intent);
//	}

}
