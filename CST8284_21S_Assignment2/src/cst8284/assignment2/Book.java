package cst8284.assignment2;

/**
 * Class Name: CST8284_21S_301
 * @author JieKe
 * Professor Name: Samira Ouaaz
 * Date: July 16, 2021
 * Class Name: Book
 * Description: This program solution the Assignment2 task. 
 */
/**
 * @author JieKe
 *
 */
public class Book {
	private String title;
	private String author;
	private String publicationDate;
	private String isbnNumber;

	public Book() {
		
	}
	public Book(String title, String author, String publicationDate, String isbnNumber) {

		this.title = title;
		this.author = author;
		this.publicationDate = publicationDate;
		this.isbnNumber = isbnNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getIsbnNumber() {
		return isbnNumber;
	}

	public void setIsbnNumber(String isbnNumber) {

		this.isbnNumber = isbnNumber;
	}


	public String toString() {
		return ("\n*************Title: " + title + "\n*************Author: " + author
				+ "\n*************Publication Year: " + publicationDate + "\n*************ISBN: " + isbnNumber + "\n ");
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Book)) {
			return false;
		}
		Book b = (Book) o;
		if (author == null) {
			if (b.author != null) {
				return false;
			}
		} else if (!author.equals(b.author)) {
			return false;
		}
		if (isbnNumber == null) {
			if (b.isbnNumber != null) {
				return false;
			}
		} else if (!isbnNumber.equals(b.isbnNumber)) {
			return false;
		}
		if (publicationDate == null) {
			if (b.publicationDate != null) {
				return false;
			}
		} else if (!publicationDate.equals(b.publicationDate)) {
			return false;
		}
		if (title == null) {
			if (b.title != null) {
				return false;
			}
		} else if (!title.equals(b.title)) {
			return false;
		}
		return true;
	}
	public Book getBook() {
		return this;
	}

	
}
