package cst8284.lab05;

/**
 * Class Name: CST8284_21S_301
 * 
 * @author JieKe 
 * Professor Name: Sandra Iroakazi 
 * Date: July 11, 2021 
 * Class Name: Triangle 
 * Description: This program solution the Lab5 task.
 */

public class Triangle extends BasicShape {

	public Triangle() {
		this(minValue);
	};

	public Triangle(double width) {
		super(width);//inheritance from superclass

	}

	public Triangle(Triangle triangle) {
		this(triangle.getWidth());
	}
	//override the getArea() method to calculate the area of subclass
	@Override
	public double getArea() {
		return (Math.sqrt(3) / 4) * super.getWidth() * super.getWidth();//this is the formula
	}
	//override the getPerimeter() method to calculate the perimeter of subclass
	@Override
	public double getPerimeter() {

		return 3 * super.getWidth();//this is the formula
	}
	//override the equals()method to compare the objects
	@Override
	public boolean equals(Object obj) {

		if (!(super.equals(obj))||(!(obj instanceof Triangle))) {
			return false;
		}

		Triangle triangle = (Triangle) obj;
		return Double.doubleToLongBits(getWidth()) 
				== Double.doubleToLongBits(triangle.getWidth());
	}
	//override the toString()method to format the output
	@Override
	public String toString() {

		return ("Triangle " + super.toString());
	}

}
















