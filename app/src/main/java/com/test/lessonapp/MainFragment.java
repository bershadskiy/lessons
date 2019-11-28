package com.test.lessonapp;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements View.OnClickListener {
	private static final String TAG = "MainFragment";

	private MyAdapter adapter;

	interface IMainFragment {
		void onItemClick(int position);
	}

	public static MainFragment newInstance() {

		Bundle args = new Bundle();

		MainFragment fragment = new MainFragment();
		fragment.setArguments(args);
		return fragment;
	}


	public MainFragment() {
		// Required empty public constructor
	}

	RecyclerView recyclerView;
	Button button;
	IMainFragment listener;

	MainFragment setListener(IMainFragment listener) {
		this.listener = listener;
		return this;
	}

	@Override
	public void onResume() {
		super.onResume();
		adapter.notifyDataSetChanged();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_main, container, false);
		recyclerView = view.findViewById(android.R.id.list);
		adapter = new MyAdapter();
		recyclerView.setAdapter(adapter);
		recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

		button = view.findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getContext(), AddCardActivity.class);
				startActivity(intent);
			}
		});
		return view;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		MainFragmentVM model = ViewModelProviders.of(this).get(MainFragmentVM.class);
		model.getBankCardModelList().observe(getActivity(), new Observer<List<BankCardModel>>() {
			@Override
			public void onChanged(List<BankCardModel> bankCardModels) {
				Log.d(TAG, "onChanged: " + bankCardModels.size());
				adapter.bankCardModels = bankCardModels;
				adapter.notifyDataSetChanged();
			}
		});
	}

	@Override
	public void onClick(View v) {
		int itemPosition = (int) v.getTag();
		if (null != listener) {
			listener.onItemClick(itemPosition);
		}
	}

	private class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

		List<BankCardModel> bankCardModels = new ArrayList<>(0);

		public class ViewHolder extends RecyclerView.ViewHolder {

			TextView text1, text2;

			public ViewHolder(@NonNull View itemView) {
				super(itemView);
				text1 = itemView.findViewById(android.R.id.text1);
				text2 = itemView.findViewById(android.R.id.text2);
			}

			void bind(BankCardModel data, int position) {
				text2.setText(data.getNum());
				text1.setText(data.getOwnerName());
				itemView.setTag(position);
				itemView.setOnClickListener(MainFragment.this);
			}
		}

		@NonNull
		@Override
		public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
			View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_2, parent, false);
			return new MyAdapter.ViewHolder(view);
		}

		@Override
		public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
			holder.bind(bankCardModels.get(position), position);
		}

		@Override
		public int getItemCount() {
			Log.d(TAG, "getItemCount: " + bankCardModels.size());
			return bankCardModels.size();
		}
	}

}
