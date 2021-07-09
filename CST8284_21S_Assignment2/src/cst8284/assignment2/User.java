package cst8284.assignment2;

/**
 * Class Name: CST8284_21S_301
 * @author JieKe 
 * Professor Name: Samira Ouaaz 
 * Date: June 15, 2021 
 * Class Name:User 
 * Description: This program solution the Assignment1 task.
 */
public class User {
	private static int userNextId = 1000;
	private static int userAge = 18;
	private int id;
	private String firstName;
	private String lastName;
	private String address;
	private int age;

	public User() {

	}

	public User(int id, String firstName, String lastName, String address, int age) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.age = age;

	}

	public User(String firstName, String lastName, String address, int age) {

		this(userNextId++, firstName, lastName, address, age);

	}

	public User(String firstName, String lastName, String address) {
		this(firstName, lastName, address, userAge);

	}

	public String toString() {
		return "\n*********User id: " + getId() + "\n*********User name: " + getFirstName() + " " + getLastName()
		+ "\n*********Age: " + getAge() + "\n*********Address: " + getAddress();

	}


	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof User)) {
			return false;
		}
		User u = (User) o;
		if (address == null) {
			if (u.address != null) {
				return false;
			}
		} else if (!address.equals(u.address)) {
			return false;
		}
		if (age != u.age) {
			return false;
		}
		if (firstName == null) {
			if (u.firstName != null) {
				return false;
			}
		} else if (!firstName.equals(u.firstName)) {
			return false;
		}
		if (lastName == null) {
			if (u.lastName != null) {
				return false;
			}
		} else if (!lastName.equals(u.lastName)) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @return
	 */
	public static int getUserNextId() {
		return userNextId;
	}

	public static void setUserNextId(int userNextId) {
		User.userNextId = userNextId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
