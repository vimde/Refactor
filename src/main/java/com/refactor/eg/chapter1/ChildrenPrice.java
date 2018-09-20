package com.refactor.eg.chapter1;

public class ChildrenPrice extends Price {

	@Override
	public int getPriceCode() {
		return Movie.CHILDRENS;
	}
	
	@Override
	public double getCharge(int daysRented) {
		double amount = 1.5;
        if (daysRented > 3)
            amount += (daysRented - 3) * 1.5;
        return amount;
	}

}
