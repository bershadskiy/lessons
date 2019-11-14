package com.test.lessonapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Part of LessonApp by OasisMediaSystems
 * 2017-2019
 * Created by dimabershadskiy on 2019-10-29.
 */
@Entity(tableName = "bank_card_model")
public class BankCardModel {

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@PrimaryKey(autoGenerate = true)
	private int id;

	@ColumnInfo(name = "owner_name")
	private String ownerName;
	private String num;
	private String date;
	private String pin;
	private float balance;

	public BankCardModel(String ownerName, String num, String date, String pin, float balance) {
		this.ownerName = ownerName;
		this.num = num;
		this.date = date;
		this.pin = pin;
		this.balance = balance;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}
}
