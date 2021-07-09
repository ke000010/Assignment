package cst8284.assignment2;
import java.util.Scanner;
/**
 * Class Name: CST8284_21S_301
 * @author JieKe
 * Professor Name: Samira Ouaaz
 * Date: July 16, 2021
 * Class Name: AppDriver
 * Description: This program solution the Assignment2 task. 
 */
/**
 * This class represents the display view.
 * This class contains the main loop of the application to 
 * accept and process the user choices. It verifies the user’s 
 * input and based on the selection, the relevant method to 
 * execute is called.
 * @author JieKe
 *
 */
public class AppDriver {

	private static final int APP_EXIT = 0;
	private static final int APP_ADD_BOOK = 1;
	private static final int APP_MOD_BOOK = 2;
	private static final int APP_FIND_BOOK = 3;
	private static final int APP_LIST_BOOKS = 4;
	private static final int APP_ADD_USER = 5;
	private static final int APP_MOD_USER = 6;
	private static final int APP_FIND_USER = 7;
	private static final int APP_LIST_USERS = 8;
	private static final int APP_ADD_LOAN = 9;
	private static final int APP_MOD_LOAN = 10;
	private static final int APP_FIND_LOAN = 11;
	private static final int APP_LIST_LOANS = 12;
	private static final int APP_DEL_BOOK = 13;
	private static final int APP_DEL_USER = 14;
	private static final int APP_DEL_LOAN = 15;

	private static Scanner input = new Scanner(System.in);
	LendingLibraryController appController = new LendingLibraryController();
	/**
	 * 
	 * This method will call displayAppMenu() to display the menu to the user.
	 * Then call the executeMenultem().
	 */

	public void startApp() {
		int i = -1;
		while (i != 0 ) {
			i = displayAppMenu();
			executeMenuItem(i);
		}  

	}
	//Display the menu items
	/**
	 * 
	 * @return
	 */
	private static int displayAppMenu() {
		System.out.printf("Enter a selection from the following menu:\n\t%s\n\t%s\n\t%s\n\t%s\n\t%s\n\t%s\n\t%s\n\t%s\n\t%s\n\t%s\n\t%s\n\t%s\n\t%s\n\t%s\n\t%s\n\t%s\n", 
				APP_ADD_BOOK + ". Enter a new book",
				APP_MOD_BOOK + ". Modify book details. Enter the book isbn number",
				APP_FIND_BOOK + ". Find a book by isbn number",
				APP_LIST_BOOKS + ". Display list of all books\n",
				APP_ADD_USER + ". Add a new user",
				APP_MOD_USER + ". Modify user details",
				APP_FIND_USER + ". Find a user by name",
				APP_LIST_USERS + ". Display all users\n",
				APP_ADD_LOAN + ". Add a loan. Link a user name to a book by isbn number",
				APP_MOD_LOAN + ". Modify a loan. Loan is identified by isbn number",
				APP_FIND_LOAN + ". Find a loan. Loan is identified by isbn number",
				APP_LIST_LOANS + ". Dispaly all loans\n",
				APP_DEL_BOOK + ". Delet a book by isbn number",
				APP_DEL_USER + ". Delet a user by name",
				APP_DEL_LOAN + ". Delet a loan. Loan is identified by isbn number\n",
				APP_EXIT + ". Exit program");

		return(input.nextInt());

	}
	//based on the menu call the corresponding method
	/**
	 * 
	 * @param choice
	 * @
	 */
	private void executeMenuItem(int choice) {

		switch(choice) {
		case APP_ADD_BOOK:
			appController.addBook();
			break;
		case APP_MOD_BOOK:
			appController.changeBook();
			break;
		case APP_FIND_BOOK:
			appController.findBook();
			break;
		case APP_LIST_BOOKS:
			appController.listBooks();
			break;
		case APP_ADD_USER:
			appController.addUser();
			break;
		case APP_MOD_USER:
			appController.changeUser();
			break;
		case APP_FIND_USER:
			appController.findUser();
			break;
		case APP_LIST_USERS:
			appController.listUsers();
			break;
		case APP_ADD_LOAN:
			appController.addBookLoan();
			break;
		case APP_MOD_LOAN:
			appController.changeBookLoan();
			break;
		case APP_FIND_LOAN:
			appController.findBookLoan();;
			break;
		case APP_LIST_LOANS:
			appController.listBookLoans();
			break;
		case APP_DEL_BOOK:
			appController.deleteBook();
			break;
		case APP_DEL_USER:
			appController.deleteUser();
			break;
		case APP_DEL_LOAN:
			appController.deleteBookLoan();
			break;
		case APP_EXIT:
			System.out.println("Good Bye!");
			break;
		default:
			System.out.println("Please input 0-12.");


		}
	}

}