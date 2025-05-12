package com.workshop4;

public class Book {

	public String bookName;
	public int bookPrice;
	public double bookDiscountRate;
	
	public Book(String bookName, int bookPrice, double bookDiscountRate) {
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bookDiscountRate = bookDiscountRate;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	public double getBookDiscountRate() {
		return bookDiscountRate;
	}

	public void setBookDiscountRate(double bookDiscountRate) {
		this.bookDiscountRate = bookDiscountRate;
	}
	
	public double getDiscountBookPrice() {
		return (double)this.getBookPrice()*(1-this.getBookDiscountRate()/(double)100);
	}
}
