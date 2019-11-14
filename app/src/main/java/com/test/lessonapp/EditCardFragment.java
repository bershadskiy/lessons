package com.test.lessonapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;


public class EditCardFragment extends Fragment implements View.OnClickListener {
	// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
	private static final String ARG_PARAM1 = "param1";

	private int mParam1;

	public EditCardFragment() {
		// Required empty public constructor
	}

	/**
	 * Use this factory method to create a new instance of
	 * this fragment using the provided parameters.
	 *
	 * @param param1 Parameter 1.
	 * @return A new instance of fragment EditCardFragment.
	 */
	// TODO: Rename and change types and number of parameters
	public static EditCardFragment newInstance(int param1) {
		EditCardFragment fragment = new EditCardFragment();
		Bundle args = new Bundle();
		args.putInt(ARG_PARAM1, param1);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
			mParam1 = getArguments().getInt(ARG_PARAM1, -1);
		}
	}

	EditText cardNumber, ownerName, expires, pin;
	Button addCardBtn;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.activity_add_card, container, false);
		cardNumber = view.findViewById(R.id.cardNumber);
		ownerName = view.findViewById(R.id.ownerName);
		expires = view.findViewById(R.id.expires);
		pin = view.findViewById(R.id.pin);

		addCardBtn = view.findViewById(R.id.addCardBtn);
		addCardBtn.setOnClickListener(this);
		return view;
	}

	@Override
	public void onStart() {
		super.onStart();
		BankCardModel card = BankCardManager.getCard(getContext(), mParam1);
		cardNumber.setText(card.getNum());
		ownerName.setText(card.getOwnerName());
		expires.setText(card.getDate());
		pin.setText(card.getPin());
	}

	@Override
	public void onClick(View v) {
		BankCardModel card = BankCardManager.getCard(getContext(), mParam1);
		card.setNum(cardNumber.getText().toString());
		card.setOwnerName(ownerName.getText().toString());
		card.setDate(expires.getText().toString());
		card.setPin(pin.getText().toString());
		BankCardManager.setBankCard(getContext(), card);
	}

}
