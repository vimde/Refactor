package com.refactor.eg.chapter1;

public abstract class Price {
	public abstract int getPriceCode();

	public abstract double getCharge(int daysRented);

	public abstract int getFrequentRenterPoints(int daysRented);
}
