  
/**
 * Class Name: CST8284_21S_301
 * Author Name: Jie Ke
 * Professor Name: Samira Ouaaz
 * Date: June 15, 2021
 * Description: This program solution the Assignment1 task. 
*/
/**
 * This class is the The add/find methods process the addition 
 * and searching of items in the corresponding arrays. 
 */
public class LendingLibrary {
	private static final int MAX_BOOK_NUMBER = 10;
	private static final int MAX_USER_NUMBER = 5;
	private static final int MAX_LOAN_NUMBER = 5;
	private static final int MAX_LOAN_PER_USER = 2;

	private static int lastBookIndex;
	private static int lastUserIndex;
	private static int lastLoanIndex;

	private Book[] bookReg;
	private User[] userReg;
	private BookLoan[] loanReg;

	public LendingLibrary() {
		bookReg = new Book[MAX_BOOK_NUMBER];
		userReg = new User[MAX_USER_NUMBER];
		loanReg = new BookLoan[MAX_LOAN_NUMBER];
	}
	//assign the value into user 
	public User makeUser(int id, String firstName, 
			String lastName, String address, int age){

		User u = new User();
		u.setId(u.getId());
		u.setFirstName(firstName);
		u.setLastName(lastName);
		u.setAddress(address);
		u.setAge(age);
		addUser(u);

		return u;

	}
	//add the user in the corresponding position
	public boolean addUser(User u) {
		int i = -1;
		setLastUserIndex(i);
		i = getLastUserIndex();
		if(i >= MAX_USER_NUMBER-1) {
			//		i = MAX_USER_NUMBER;
			return false; 
		}
		userReg[i] = u;
		userReg[i].setId(userReg[i].getId() + i + User.getUserNextId());

		return true;
	}
	//add the book in the corresponding position
	public boolean addBook(Book b) {
		int i = -1;
		setLastBookIndex(i);
		i = getLastBookIndex();
		if(i >= MAX_BOOK_NUMBER -1) {
			System.out.println("");
			i = MAX_BOOK_NUMBER -1;
			return false; // can't add a new book
		}
		bookReg[i] = b; // book add in the last index of array
		return true;

	}
	//Add the loan in the corresponding position
	public boolean addLoan(BookLoan l) {
		int i = -1;
		setLastLoanIndex(i);
		i = getLastLoanIndex();
		if (i >= MAX_LOAN_NUMBER-1) { 
			i = MAX_LOAN_NUMBER-1;   
			return false;			
		}
//		int bookIndex = -1;
		int j = 0;
		for(User user : userReg) {
			if(user == null) {
				break;
			}
			if((l.getUser().getFirstName().equals(user.getFirstName())) ||
					(l.getUser().getLastName().equals(user.getLastName()))){
				l.setUser(user);
//				bookIndex = j;
				break;
			}else {
				j++;
			}
		}
//		bookIndex = -1;
		j = 0;
		for(Book book : bookReg) {

			if(book == null) {

				break;
			}
			if(l.getBook().getIsbnNumber().equals(book.getIsbnNumber())) {
				l.setBook(book);
//				bookIndex = j;
				break;

			}else {
				j++;
			}

		}
		if(userCanBorrow(l.getUser()) || ( isBookLoaned(l.getBook()))){			

			loanReg[i] = l;

		}

		return true;
	}
	//search a added user based on name
	public User findUser(String firstName, String lastName){

		for(User user : userReg) {
			if ((firstName.equals(user.getFirstName())) && 
					(lastName.equals(user.getLastName())))
				return user;
		}
		System.out.println("No user with this name!");
		return null;
	}
	//search a added book based on ISBN
	public Book findBook(String isbnNumber) {

		for(Book book : bookReg) {
			if(book.getIsbnNumber().equals(isbnNumber)) 
				return book;
		}
		return null;
	}	
	//Search a loan
	public BookLoan findLoan(String isbnNumber) {

		for(BookLoan loan : loanReg) {
			if(loan.getBook().getIsbnNumber().equals(isbnNumber)) {
				return loan;
			}	
			System.out.println("No book loan found with this isbn number");
		}
		return null;
	}
	//Verified that the user has not borrowed more than 2 books.
	public boolean userCanBorrow(User u) {
		int j = 0;
		for (BookLoan loan: loanReg) {
			if(loan == null) break;
			if(u.getId() == loan.getUser().getId()) {
				j++;
			}
		}				
		if(j >= MAX_LOAN_PER_USER) {	
			System.out.println("Can not loan more");
			return false;  
		}else {

			return true;  	
		}
	}
	//Verified if the book is loaned.
	public boolean isBookLoaned(Book b) {
		for(BookLoan loan : loanReg) {
//			if (loan == null) {
//				break;
//			}
			if((loan.getBook().getIsbnNumber()).equals(b.getIsbnNumber())){
				loan.setBook(b);
				return true;  
			}
		}	
		return false;
	}
	public int getLastBookIndex() {
		return lastBookIndex;
	}
	public void setLastBookIndex(int lastBookIndex) {

		int i = 0;
		for(Book book : bookReg) {
			if(book == null) {
				lastBookIndex = i;
				break;
			}
			i++;	
		}
		LendingLibrary.lastBookIndex = lastBookIndex;
	}
	public int getLastUserIndex() {
		return lastUserIndex;
	}
	public void setLastUserIndex(int lastUserIndex) {
		int i = 0;
		for(User user : userReg) {
			if(user == null) {
				lastUserIndex = i;
				break;
			}
			i++;
		}
		LendingLibrary.lastUserIndex = lastUserIndex;
	}
	public int getLastLoanIndex() {
		return lastLoanIndex;
	}
	public void setLastLoanIndex(int lastLoanIndex) {
		int i = 0;
		for(BookLoan loan : loanReg) {
			if(loan == null) {
				lastLoanIndex =i;
				break;
			}
			i++;
		}
		LendingLibrary.lastLoanIndex = lastLoanIndex;
	}
	public Book[] getBookReg() {
		return bookReg;
	}
	public void setBookReg(Book[] bookReg) {
		this.bookReg = bookReg;
	}
	public User[] getUserReg() {
		return userReg;
	}
	public void setUserReg(User[] userReg) {
		this.userReg = userReg;
	}
	public BookLoan[] getLoanReg() {
		return loanReg;
	}
	public void setLoanReg(BookLoan[] loanReg) {
		this.loanReg = loanReg;
	}

}
