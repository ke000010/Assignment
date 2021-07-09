package cst8284.assignment2;
import java.util.Objects;

import java.util.Scanner;

//import cst8284.s21.assignment1.sample.Book;
/**
 * Class Name: CST8284_21S_301
 * Author Name: Jie Ke
 * Professor Name: Samira Ouaaz
 * Date: July 16, 2021
 * Class Name: LendingLibraryController
 * Description: This program solution the Assignment2 task. 
 */

public class LendingLibraryController{
	private LendingLibrary bookLib;
	private static Scanner input = new Scanner(System.in);
	private static final int ISBN_NUMBER = 10;

	public LendingLibraryController(){
		bookLib = new LendingLibrary();	
	}
	/**
	 * Call getResponseTo() methods to
	 * add the users information
	 *  
	 */

	public void addUser() {
		String lastName = getResponseTo("New User Entry\nLast name:");
		String firstName = getResponseTo("First name:");
		String inputAge = getResponseTo("Age:");
		int age = -1;

		while(true) {
			if(isValidNumber(inputAge)) {
				age = Integer.valueOf(inputAge);
				if (age >= 18) {
					break;
				}
			}
			inputAge = getResponseTo("Age:");
		}

		String address = getResponseTo("address:");	

		User u = new User(firstName, lastName, address, age);
		bookLib.addUser(u);
		System.out.println("User was added");

	}

	/**
	 * 
	 */
	public void changeUser(){
		String last = getResponseTo("Change User\nLast name");
		String first = getResponseTo("First name");
		User user = bookLib.findUser(first, last);
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

		if(verifyISBNNumber(isbn)) {
			if(bookLib.findBook(isbn) != null) {
				System.out.println("This book already exists can not be added");
			} else {
				Book b= new Book(title, author, date, isbn);
				if ( !bookLib.addBook(b) ) {
					System.out.println("Book can not be added");
				} 
			}
		} else {
			System.out.println("Invalid ISBN number");
		}System.out.println("Book was added.");
	}
	//change the book's author, the title, or the publication date identified by the ISBN	
	public void changeBook() {

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
	public void deleteUser() {
		String last = getResponseTo("Find User\nLast name");
		String first = getResponseTo("First name");
		User user = bookLib.findUser(first, last);
		if (Objects.isNull(user)) {
			System.out.println("Could not find a user with this name");
		} else {
			if(bookLib.deleteUser(first, last)) {
				System.out.println("This user was deleted.");

			}else {
				System.out.println("This user has loaned books, can not be deleted.");
			}
		}
	}
	public void deleteBook() {
		Book book = bookLib.findBook(getResponseTo("ISBN:"));
		if (Objects.isNull(book)) {
			System.out.println("Could not find a book with this isbn");
		} else {
			if(bookLib.deleteBook(book.getIsbnNumber())) {
				System.out.println("This book was deleted.");

			}else {
				System.out.println("This book was loaned, can not be deleted.");
			}
		}
	}
	public void deleteBookLoan() {
		BookLoan loan = bookLib.findLoan(getResponseTo("ISBN:"));
		if (Objects.isNull(loan)) {
			System.out.println("Could not find a bookLoan with this isbn");
		} else {
			if(bookLib.deleteLoan(loan.getBook().getIsbnNumber())) {
				System.out.println("This bookLoan was deleted.");

			}else {
				System.out.println("This bookLoan is not exist, can not be deleted.");
			}
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
	public boolean verifyISBNNumber(String s) {

		int j = 0;
		for(int i = 0; i < s.length(); i++) {
			if(Character.isDigit(s.charAt(i))) {
				j++;
			}
		}
		return j == ISBN_NUMBER;
	}

}

