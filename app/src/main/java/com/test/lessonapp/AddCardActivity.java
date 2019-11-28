package com.test.lessonapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddCardActivity extends AppCompatActivity implements View.OnClickListener {

	EditText cardNumber, ownerName, expires, pin;
	Button addCardBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_card);
		cardNumber = findViewById(R.id.cardNumber);
		ownerName = findViewById(R.id.ownerName);
		expires = findViewById(R.id.expires);
		pin = findViewById(R.id.pin);

		addCardBtn = findViewById(R.id.addCardBtn);
		addCardBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		String ownerNameStr = ownerName.getText().toString();
		String numStr = cardNumber.getText().toString();
		String dateStr = expires.getText().toString();
		String pinStr = pin.getText().toString();
		BankCardModel bankCardModel = new BankCardModel(ownerNameStr, numStr, dateStr, pinStr, 0f);
		BankCardManager.addBankCard(bankCardModel);
		finish();
	}
}
