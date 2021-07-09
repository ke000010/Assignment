package cst8284.lab05;
/**
 * Class Name: CST8284_21S_301
 * @author JieKe 
 * Professor Name: Sandra Iroakazi
 * Date: July 11, 2021 
 * Class Name: Square 
 * Description: This program solution the Lab5 task.
 */
public class Square extends BasicShape {

	public Square() {
		this(minValue);	
	}

	public Square(double width) {
		super(width);//inheritance from superclass

	}
	public Square(Square square) {
		this(square.getWidth());
	}
	//override the getArea() method to calculate the area of subclass
	@Override
	public double getArea() {
		return super.getWidth() * super.getWidth();//this is the formula
	}
	//override the getPerimeter() method to calculate the perimeter of subclass
	@Override
	public double getPerimeter() {

		return 4 * super.getWidth();//this is the formula
	}
	//override the equals()method to compare the objects
	@Override
	public boolean equals(Object obj) {

		if(!(super.equals(obj))||(!(obj instanceof Square))) {
			return false;
		}

		Square square = (Square) obj;
		return Double.doubleToLongBits(getWidth()) 
				== Double.doubleToLongBits(square.getWidth());
	}
	//override the toString()method to format the output
	@Override
	public String toString() {

		return ("Square " + super.toString());
	}

}



