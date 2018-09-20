package com.refactor.eg.chapter1;

public class Movie {

	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	private String _title;
	private int _priceCode;
	private Price _price;

	public Movie(String title, int priceCode) {
		_title = title;
		setPriceCode(priceCode);
	}

	public int getPriceCode() {
		return _price.getPriceCode();
	}

	public void setPriceCode(int arg) {
		switch (arg) {
		case REGULAR:
			_price = new RegularPrice();
			break;
		case CHILDRENS:
			_price = new ChildrenPrice();
			break;
		case NEW_RELEASE:
			_price = new NewReleasePrice();
			break;
		default:
			throw new IllegalArgumentException("Incorrect Price Code");
		}
		_priceCode = arg;
	}

	public String getTitle() {
		return _title;
	}

	public double getCharge(int daysRented) {
		double amount = 0;
		switch (getPriceCode()) {
		case Movie.REGULAR:
			amount += 2;
			if (daysRented > 2)
				amount += (daysRented - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			amount += daysRented * 3;
			break;
		case Movie.CHILDRENS:
			amount += 1.5;
			if (daysRented > 3)
				amount += (daysRented - 3) * 1.5;
			break;
		}
		return amount;
	}

	public int getFrequentRenterPoints(int daysRented) {
		if ((getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1)
			return 2;
		return 1;
	}
}
