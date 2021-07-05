package cst8284.lab05;
/**
 * Class Name: CST8284_21S_301
 * @author JieKe 
 * Professor Name: Sandra 
 * Date: July 11, 2021 
 * Class Name: Circle 
 * Description: This program solution the Lab5 task.
 */
public class Circle extends BasicShape {

	public Circle() {
		this(minValue);
	}
	public Circle(double width) {
		super(width);

	}
	public Circle(Circle circle){
		this(circle.getWidth());
	}

	public double getArea() {
		return Math.PI * (super.getWidth()/2 * super.getWidth()/2);
	}

	public double getPerimeter() {
		return Math.PI * super.getWidth();
	}
	@Override
	public boolean equals(Object obj) {
		
		if(!(obj instanceof Circle)) {
			return false;
		}

		Circle circle = (Circle) obj;
		return Double.doubleToLongBits(getWidth()) == Double.doubleToLongBits(circle.getWidth());
	}

	@Override
	public String toString() {

		return ("Circle " + super.toString());
	}

}	










