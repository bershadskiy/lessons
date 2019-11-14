package com.test.lessonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Locale;

public class DetailActivity extends AppCompatActivity {
	public static final String EXTRA_KEY_POSITION = "extra_key_position";

	TextView cardNumber, ownerName, expires, pin, balance;

	BankCardModel bankCardModel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);

		cardNumber = findViewById(R.id.cardNumber);
		ownerName = findViewById(R.id.ownerName);
		expires = findViewById(R.id.expires);
		pin = findViewById(R.id.pin);
		balance = findViewById(R.id.balance);

		int itemPosition = getIntent().getIntExtra(EXTRA_KEY_POSITION, -1);

		if (0 > itemPosition)
			finish();

		bankCardModel = BankCardManager.getCard(getApplicationContext(), itemPosition);

		cardNumber.setText(bankCardModel.getNum());
		ownerName.setText(bankCardModel.getOwnerName());
		expires.setText(bankCardModel.getDate());
		pin.setText(bankCardModel.getPin());
		balance.setText(String.format(Locale.getDefault(), "%.2f", bankCardModel.getBalance()));
	}
}
