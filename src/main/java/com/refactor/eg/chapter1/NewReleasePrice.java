package com.refactor.eg.chapter1;

public class NewReleasePrice extends Price {

	@Override
	public int getPriceCode() {
		return Movie.NEW_RELEASE;
	}

}
