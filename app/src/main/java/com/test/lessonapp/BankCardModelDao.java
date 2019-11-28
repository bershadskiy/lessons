package com.test.lessonapp;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

/**
 * Part of LessonApp by OasisMediaSystems
 * 2017-2019
 * Created by dimabershadskiy on 2019-11-14.
 */
@Dao
public interface BankCardModelDao {

	@Query("SELECT * FROM bank_card_model")
	LiveData<List<BankCardModel>> getAll();

	@Query("SELECT * FROM bank_card_model WHERE id IN (:ids)")
	List<BankCardModel> getByIds(int[] ids);

	@Query("SELECT * FROM bank_card_model WHERE id = :id")
	BankCardModel getById(int id);

	@Query("SELECT * FROM bank_card_model WHERE num LIKE :number LIMIT 1")
	BankCardModel findCardByNumber(String number);

	@Query("SELECT COUNT(id) FROM bank_card_model")
	int getCount();

	@Insert
	void insertAll(BankCardModel... cards);

	@Delete
	void delete(BankCardModel card);

	@Update
	void update(BankCardModel card);
}
