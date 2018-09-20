package com.refactor.eg.chapter1;

public class NewReleasePrice extends Price {

	@Override
	public int getPriceCode() {
		return Movie.NEW_RELEASE;
	}
	
	@Override
	public double getCharge(int daysRented) {
		double amount = 0;
		amount += daysRented * 3;
		return amount;
	}

}
