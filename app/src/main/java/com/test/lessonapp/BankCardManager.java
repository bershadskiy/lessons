package com.test.lessonapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Part of LessonApp by OasisMediaSystems
 * 2017-2019
 * Created by dimabershadskiy on 2019-10-31.
 */
public class BankCardManager {

	private static List<BankCardModel> bankCards = new ArrayList<BankCardModel>(6) {{
		add(new BankCardModel("owner1", "1234 5678 9012 3456", "08/25", "1234", 1000f));
		add(new BankCardModel("owner2", "1234 5678 9012 3456", "08/25", "1234", 1000f));
		add(new BankCardModel("owner3", "1234 5678 9012 3456", "08/25", "1234", 1000f));
		add(new BankCardModel("owner4", "1234 5678 9012 3456", "08/25", "1234", 1000f));
		add(new BankCardModel("owner5", "1234 5678 9012 3456", "08/25", "1234", 1000f));
		add(new BankCardModel("owner6", "1234 5678 9012 3456", "08/25", "1234", 1000f));
	}};

	public static void addBankCard(BankCardModel bankCardModel) {
		bankCards.add(bankCardModel);
	}

	public static boolean setBankCard(BankCardModel card, int position) {
		boolean result = true;
		try {
			bankCards.set(position, card);
		} catch (Exception e) {
			result = false;
		}
		return result;
	}

	public static BankCardModel getCard(int index) {
		return bankCards.get(index);
	}

	public static int getCardsCount() {
		return bankCards.size();
	}
}
