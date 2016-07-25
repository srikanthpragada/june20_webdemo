package ws;

import java.io.Serializable;

public class Book implements Serializable {
	private String title;

	public Book(String title, int price) {
		super();
		this.title = title;
		this.price = price;
	}

	public Book() {
		super();
	}

	private int price;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
