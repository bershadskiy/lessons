package com.test.lessonapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DetailFragment extends Fragment {
	private static final String TAG = "DetailFragment";
	private static final String ARG_PARAM1 = "param1";

	private int cardPositionParam;

	private ViewPager pager;

	public DetailFragment() {
		// Required empty public constructor
	}

	/**
	 * Use this factory method to create a new instance of
	 * this fragment using the provided parameters.
	 *
	 * @param param1 Parameter 1.
	 * @return A new instance of fragment DetailFragment.
	 */
	// TODO: Rename and change types and number of parameters
	public static DetailFragment newInstance(int param1) {
		DetailFragment fragment = new DetailFragment();
		Bundle args = new Bundle();
		args.putInt(ARG_PARAM1, param1);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
			cardPositionParam = getArguments().getInt(ARG_PARAM1);
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_detail, container, false);
		pager = view.findViewById(R.id.viewPager);
		pager.setAdapter(new MyFragmentPagerAdapter());
		pager.setCurrentItem(0);
		return view;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

	}

	@Override
	public void onStart() {
		super.onStart();
	}

	private class MyFragmentPagerAdapter extends FragmentPagerAdapter {


		public MyFragmentPagerAdapter() {
			super(DetailFragment.this.getActivity().getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
		}

		@NonNull
		@Override
		public Fragment getItem(int position) {
			Fragment result;
			switch (position) {
				case 9:
				case 8:
				case 7:
				case 6:
				case 5:
				case 4:
				case 3:
				case 2:
				case 1: {
					result = EditCardFragment.newInstance(cardPositionParam);
				}
				break;
				case 0:
				default: {
					result = DetailCardFragment.newInstance(cardPositionParam);
				}
				break;

			}
			Log.e(TAG,String.valueOf(position));
			return result;
		}

		@Override
		public int getCount() {
			return 10;
		}
	}
}
