import java.util.Scanner;
/**
 * Class Name: CST8284_21S_301
 * Author Name: Jie Ke
 * Class Name: LendingLibraryController
 * Professor Name: Samira Ouaaz
 * Date: June 15, 2021
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
	String l = getResponseTo("New User Entry\nLast name:");
	String f = getResponseTo("First name:");
	String ages = getResponseTo("Age:");
	String address = getResponseTo("address:");	
	int age = Integer.valueOf(ages);
	User u = new User();
	bookLib.makeUser(u.getId(), f, l, address, age);
	System.out.println("User was added");
 
}
//modify the user's address.
public void changeUser(){
	String last = getResponseTo("Change User\nLast name");
	String first = getResponseTo("First name");
	User user = new User();
	user = bookLib.findUser(first, last);
	String address = getResponseTo("Change address");
	user.setAddress(address);
	
}
//searched the user by the the names.
public void findUser(){
	
	String last = getResponseTo("Find User\nLast name");
	String first = getResponseTo("First name");
	System.out.println(bookLib.findUser(first, last).toString());

	
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
	
	String t = getResponseTo("New Book Entry\nTitle:");
	String a = getResponseTo("Author:");
	String d = getResponseTo("Publication date (year in NNNN format)");
	String i = getResponseTo("ISBN number(10 digits):");
	Book b = new Book(t, a, d, i);
	bookLib.addBook(b);

}
//change the book's author, the title, or the publication date identified by the ISBN	
public void changeBook() {
	Book book = new Book();
	book = bookLib.findBook(getResponseTo("ISBN:"));
	String t = getResponseTo("Change Book\nChange title:");
	book.setTitle(t);
	String a = getResponseTo("Change author:");
	book.setAuthor(a);
	String d = getResponseTo("Change publication date:");
	book.setPublicationDate(d);
	
}
//Search a book by the ISBN.
public void findBook() {

	String isbn = getResponseTo("Find Book\nISBN:");
	bookLib.findBook(isbn);
	System.out.println(bookLib.findBook(isbn).toString());
	
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
	User user = new User();
	Book book = new Book();
	user.setLastName(getResponseTo("New Loan Entry\nUser last name:"));
	user.setFirstName(getResponseTo("User first name:"));
	book.setIsbnNumber(getResponseTo("Book isbn number"));	
	String date = getResponseTo("Loan date (format yyyy-mm-dd)");
	BookLoan Loan = new BookLoan(user, book, date);
	bookLib.addLoan(Loan);
	System.out.println("Loan added.");


	
}

//change the bookloan's date.
public void changeBookLoan() {
	
	String isbn = getResponseTo("Modify loan details\nISBN number for the loan you want to modify:");
	
	String date = getResponseTo("Change due date(Hit Enter key for no change):");
	bookLib.findLoan(isbn).setDueDate(date);
	
}
//search a loan based on ISBN.
public void findBookLoan() {
	String isbn = getResponseTo("Find a book loan. Enter ISBN nubmer");
	bookLib.findLoan(isbn);
	System.out.println(bookLib.findLoan(isbn).toString());

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
//	int testInput = Integer.valueOf(input);
//	
//	if( testInput < 18) {
//		
//		System.out.println("This age is not allowed.");
//	return false;
//}
			
		return true;
	
}

	
	
	
}
