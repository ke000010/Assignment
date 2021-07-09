package cst8284.lab05;
/**
 * Class Name: CST8284_21S_301
 * @author JieKe 
 * Professor Name: Sandra Iroakazi
 * Date: July 11, 2021 
 * Class Name: Circle 
 * Description: This program solution the Lab5 task.
 */

public class Circle extends BasicShape {

	public Circle() {
		this(minValue);
	}
	public Circle(double width) {
		super(width);//inheritance from superclass

	}
	public Circle(Circle circle){
		this(circle.getWidth());
	}
	//override the getArea() method to calculate the area of subclass
	@Override
	public double getArea() {
		return Math.PI * (super.getWidth()/2 * super.getWidth()/2);//this is the formula
	}
	//override the getPerimeter() method to calculate the perimeter of subclass
	@Override
	public double getPerimeter() {
		return Math.PI * super.getWidth();//this is the formula
	}
	//override the equals()method to compare the objects
	@Override
	public boolean equals(Object obj) {
		
		if(!(super.equals(obj))||(!(obj instanceof Circle))) {
			return false;
		}
		
		Circle circle = (Circle) obj;
		return Double.doubleToLongBits(getWidth()) 
				== Double.doubleToLongBits(circle.getWidth());
	}
	//override the toString()method to format the output
	@Override
	public String toString() {

		return ("Circle " + super.toString());
	}

}	










