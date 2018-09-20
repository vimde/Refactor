package com.refactor.eg.chapter1;

public class RegularPrice extends Price {

	@Override
	public int getPriceCode() {
		return Movie.REGULAR;
	}

	@Override
	public double getCharge(int daysRented) {
		return daysRented * 3.0;
	}
}
