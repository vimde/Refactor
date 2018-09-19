package com.refactor.eg.chapter1;

import java.util.Enumeration;
import java.util.Vector;

class Customer {
	private String _name;
	private Vector<Rental> _rentals = new Vector<>();

	public Customer(String name) {
		_name = name;
	};

	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	}

	public String getName() {
		return _name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration<Rental> rentals = _rentals.elements();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasMoreElements()) {
			
			Rental each = (Rental) rentals.nextElement();

			// determine amounts for each line
			double thisAmount = amountFor(each);

			// add frequent renter points
			frequentRenterPoints++;
			// add bonus for a two day new release rental
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
				frequentRenterPoints++;

			// show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;

		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		return result;
	}

	private double amountFor(Rental rental) {
		double amount = 0;
		switch (rental.getMovie().getPriceCode()) {
		case Movie.REGULAR:
			amount += 2;
			if (rental.getDaysRented() > 2)
				amount += (rental.getDaysRented() - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			amount += rental.getDaysRented() * 3;
			break;
		case Movie.CHILDRENS:
			amount += 1.5;
			if (rental.getDaysRented() > 3)
				amount += (rental.getDaysRented() - 3) * 1.5;
			break;
		}
		return amount;
	}
}