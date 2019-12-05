package com.test.lessonapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements MainFragment.IMainFragment {

	private static final String TAG = "MainActivity!";

	FrameLayout rootView,detailRoot;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		rootView = findViewById(R.id.root);
		detailRoot = findViewById(R.id.detail);
	}

	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		ArrayList<Repo> extra_data = intent.getParcelableArrayListExtra("EXTRA_DATA");
		Log.d(TAG, "onNewIntent: "+extra_data.toString());
	}

	@Override
	protected void onStart() {
		super.onStart();
		getSupportFragmentManager().beginTransaction()
						.replace(R.id.root, MainFragment.newInstance().setListener(this))
						.commit();
	}

	@Override
	public void onItemClick(int position) {
		getSupportFragmentManager().beginTransaction()
						.replace(null != detailRoot ? R.id.detail : R.id.root, DetailFragment.newInstance(position))
						.addToBackStack(null)
						.commit();
	}
}
