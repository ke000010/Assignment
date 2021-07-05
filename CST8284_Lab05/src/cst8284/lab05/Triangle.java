package cst8284.lab05;
/**
 * Class Name: CST8284_21S_301
 * @author JieKe 
 * Professor Name: Sandra
 * Date: July 11, 2021 
 * Class Name: Triangle 
 * Description: This program solution the Lab5 task.
 */
public class Triangle extends BasicShape{


	public Triangle() {
		this(minValue);
	};
	public Triangle(double width) {
		super(width);

	}
	public Triangle(Triangle triangle) {
		this(triangle.getWidth());
	}

	public double getArea() {
		return(Math.sqrt(3)/4 )* super.getWidth() * super.getWidth();
	}

	public double getPerimeter() {

		return 3 * super.getWidth();
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Triangle)) {
			return false;
		}
		Triangle triangle = (Triangle) obj;
		return Double.doubleToLongBits(getWidth()) == Double.doubleToLongBits(triangle.getWidth());
	}

	@Override
	public String toString() {

		return ("Triangle " + super.toString());
	}

}
















