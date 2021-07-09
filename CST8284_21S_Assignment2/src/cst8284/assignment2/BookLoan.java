package cst8284.assignment2;

/**
 * Class Name: CST8284_21S_301
 * @author JieKe
 * Professor Name: Samira Ouaaz
 * Date: July 16, 2021
 * Class Name: BookLoan
 * Description: This program solution the Assignment2 task. 
 */

public class BookLoan {
	private User user;
	private Book book;
	private String dueDate;

	public BookLoan() {

	}

	public BookLoan(User user, Book book, String dueDate) {
		this.user = user;
		this.book = book;
		this.dueDate = dueDate;

	}
	public String toString() {
		return "\n*********User name: "
				+ user.getFirstName() + " " + user.getLastName() +
				"\n*********Title: "
				+ book.getTitle() +
				"\n*********Author: "
				+ book.getAuthor() +
				"\n********ISBN: "
				+ book.getIsbnNumber() + 
				"\n*********Due Date: "
				+ dueDate + "\n";

	}
	

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof BookLoan)) {
			return false;
		}
		BookLoan l = (BookLoan) o;
		if (book == null) {
			if (l.book != null) {
				return false;
			}
		} else if (!book.equals(l.book)) {
			return false;
		}
		if (dueDate == null) {
			if (l.dueDate != null) {
				return false;
			}
		} else if (!dueDate.equals(l.dueDate)) {
			return false;
		}
		if (user == null) {
			if (l.user != null) {
				return false;
			}
		} else if (!user.equals(l.user)) {
			return false;
		}
		return true;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}



}
