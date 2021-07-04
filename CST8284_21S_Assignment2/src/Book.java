
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((isbnNumber == null) ? 0 : isbnNumber.hashCode());
		result = prime * result + ((publicationDate == null) ? 0 : publicationDate.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (isbnNumber == null) {
			if (other.isbnNumber != null)
				return false;
		} else if (!isbnNumber.equals(other.isbnNumber))
			return false;
		if (publicationDate == null) {
			if (other.publicationDate != null)
				return false;
		} else if (!publicationDate.equals(other.publicationDate))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	public Book() {

	}

	/**
	 * 
	 * @param title
	 * @param author
	 * @param publicationDate
	 * @param isbnNumber
	 */
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

	public boolean verifyISBNNumber(String s) {

		if (s.length() == 10) {
			return true;

		}
		return false;
	}

	public String toString() {
		return ("\n*************Title: " + title + "\n*************Author: " + author
				+ "\n*************Publication Year: " + publicationDate + "\n*************ISBN: " + isbnNumber + "\n ");
	}

	public Book getBook() {
		return this;
	}
}
