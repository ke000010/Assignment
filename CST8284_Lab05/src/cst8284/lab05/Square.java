package cst8284.lab05;
/**
 * Class Name: CST8284_21S_301
 * @author JieKe 
 * Professor Name: Sandra
 * Date: July 11, 2021 
 * Class Name: Square 
 * Description: This program solution the Lab5 task.
 */
public class Square extends BasicShape {

	public Square() {
		this(minValue);	
	}

	public Square(double width) {
		super(width);

	}
	public Square(Square square) {
		this(square.getWidth());
	}

	public double getArea() {
		return super.getWidth() * super.getWidth();
	}

	public double getPerimeter() {

		return 4 * super.getWidth();
	}
	@Override
	public boolean equals(Object obj) {

		if(!(obj instanceof Square)) {
			return false;
		}

		Square square = (Square) obj;
		return Double.doubleToLongBits(getWidth()) == Double.doubleToLongBits(square.getWidth());
	}

	@Override
	public String toString() {

		return ("Square " + super.toString());
	}

}



