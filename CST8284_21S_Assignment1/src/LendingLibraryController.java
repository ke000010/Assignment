import java.util.Objects;
import java.util.Scanner;
/**
 * Class Name: CST8284_21S_301
 * Author Name: Jie Ke
 * Class Name: LendingLibraryController
 * Professor Name: Samira Ouaaz
 * Date: June 15, 2021
 * Class Name: LendingLibraryController
 * Description: This program solution the Assignment1 task. 
 */
public class LendingLibraryController{
	private LendingLibrary bookLib;
	private static Scanner input = new Scanner(System.in);

	public LendingLibraryController(){
		bookLib = new LendingLibrary();
	}
	/**
	 * Call getResponseTo() and makeUser() methods to
	 * add the users information
	 *  
	 */

	public void addUser() {
		String lastName = getResponseTo("New User Entry\nLast name:");
		String firstName = getResponseTo("First name:");
		String inputAge = getResponseTo("Age:");
		int age = -1;
		boolean choose = true;
		while(choose) {
			if(isValidNumber(inputAge)) {
				age = Integer.valueOf(inputAge);
				if (age >=18) {
					break;
				}
			}
			inputAge = getResponseTo("Age:");
		}

		String address = getResponseTo("address:");	

		User u = new User();
		bookLib.makeUser(u.getId(), firstName, lastName, address, age);
		System.out.println("User was added");

	}
	//modify the user's address.
	public void changeUser(){
		String last = getResponseTo("Change User\nLast name");
		String first = getResponseTo("First name");
		User user = new User();
		user = bookLib.findUser(first, last);
		if (Objects.isNull(user)) {
			System.out.println("No user with this name!");
		}else {
			String address = getResponseTo("Change address");
			user.setAddress(address);
		}
	}
	//searched the user by the the names.
	public void findUser(){

		String last = getResponseTo("Find User\nLast name");
		String first = getResponseTo("First name");
		User user = bookLib.findUser(first, last);
		if(Objects.isNull(user)) {
			System.out.println("No user with this name!");
		}else {
			System.out.println(user.toString());
		}

	}
	//display all the added users.
	public void listUsers() {
		int i = 0;

		for(User user : bookLib.getUserReg()) {		
			if(user == null) break;
			System.out.printf("User #%d\n",i+1);
			System.out.println(user.toString());				
			i++;

		}
	}
	//Add the book in array
	public void addBook() {

		String title = getResponseTo("New Book Entry\nTitle:");
		String author = getResponseTo("Author:");
		String date = getResponseTo("Publication date (year in NNNN format)");
		String isbn = getResponseTo("ISBN number(10 digits):");
		Book b = new Book(title, author, date, isbn);
		boolean choose = true;
		while(choose) {
			if(!(b.verifyISBNNumber(isbn))) {
				isbn = getResponseTo("ISBN number(10 digits): ");
				b.setIsbnNumber(isbn);
			}else
				break;
		}
		bookLib.addBook(b);
	}
	//change the book's author, the title, or the publication date identified by the ISBN	
	public void changeBook() {
		//	Book book = new Book();
		Book book = bookLib.findBook(getResponseTo("ISBN:"));
		if (Objects.isNull(book)) {
			System.out.println("Could not find a book with this isbn");
		} else {
			String t = getResponseTo("Change Book\nChange title:");
			book.setTitle(t);
			String a = getResponseTo("Change author:");
			book.setAuthor(a);
			String d = getResponseTo("Change publication date:");
			book.setPublicationDate(d);
		}
	}
	//Search a book by the ISBN.
	public void findBook() {

		String isbn = getResponseTo("Find Book\nISBN:");
		Book book = bookLib.findBook(isbn);
		if (Objects.isNull(book)) {
			System.out.println("No book with this ISBN!");
		} else {
			System.out.println(book.toString());
		}
	}
	public void listBooks() {

		int i = 0;

		for(Book book : bookLib.getBookReg()) {		
			if(book == null) break;
			System.out.printf("Book #%d\n",i+1);
			System.out.println(book.toString());				
			i++;

		}
	}
	//add a bookloan based on the various conditions.
	public void addBookLoan() {


		String lastName = getResponseTo("New Loan Entry\nUser last name:");
		String firstName = getResponseTo("User first name:");
		String isbn = getResponseTo("Book isbn number:");


		User user = bookLib.findUser(firstName, lastName);
		Book book = bookLib.findBook(isbn);
		if (Objects.isNull(user)) {
			System.out.println("No user with this name!");
		} else if (Objects.isNull(book)) {
			System.out.println("Could not find a book with this isbn!");
		} else if (bookLib.isBookLoaned(book)) {
			System.out.println("Book is already loaned");
		} else if (!(bookLib.userCanBorrow(user))) {
			System.out.println("This user is not allowed to borrow more books");
		} else {
			String date = getResponseTo("Loan date (format yyyy-mm-dd): ");
			BookLoan bookLoan = new BookLoan(user, book, date);
			bookLib.addLoan(bookLoan);
			System.out.println("Loan added");
			System.out.println(bookLoan.toString());
		}

	}

	//change the bookloan's date.

	public void changeBookLoan() {

		String isbn = getResponseTo("Modify loan details\nISBN number for the loan you want to modify:");
		//Modified in Jun 26,2021
		BookLoan bookLoan = bookLib.findLoan(isbn);
		if (Objects.isNull(bookLoan)) {
			System.out.println("No book with this ISBN!");
		} else {
			System.out.println(bookLoan.toString());
			String dueDate = getResponseTo("Change due date (Hit Enter key for no change):");
			bookLoan.setDueDate(dueDate);
		}
	}
	//search a loan based on ISBN.
	public void findBookLoan() {
		String isbn = getResponseTo("Find a book loan. Enter ISBN nubmer");
		BookLoan loan = bookLib.findLoan(isbn);
		if(Objects.isNull(loan)) {
			System.out.println("No book with this ISBN");
			return;
		}else {
			System.out.println(loan.toString());
		}


	}
	//Display all added bookloans
	public void listBookLoans() {

		int i = 0;
		for(BookLoan loan : bookLib.getLoanReg()) {
			if(loan == null) break;
			System.out.printf("Book loan #%d\n",(i+1));
			System.out.println(loan.toString());
			i++;
		}
	}

	//get the input value	
	private static String getResponseTo(String s)	{
		System.out.println(s);
		return (input.nextLine());
	}
	//verify the valid number
	private static boolean isValidNumber(String input) {
		for(int i = 0; i < input.length(); i++) {
			if(Character.isDigit(input.charAt(i))) {
				return true;
			}
		}

		return false;
	}

}
