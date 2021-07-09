package cst8284.lab05;

/**
 * Class Name: CST8284_21S_301
 * @author JieKe 
 * Professor Name: Sandra Iroakazi
 * Date: July 11, 2021 
 * Class Name: IsoscelesTriangle 
 * Description: This program solution the Lab5 task.
 */
public class IsoscelesTriangle extends Triangle {

	private double length;//declare a length variable of the new class 
	//default constructor
	public IsoscelesTriangle(){
		this(minValue,minValue);
	}

	public IsoscelesTriangle(double width, double length) {
		super(width);//inheritance from superclass
		this.length = length;

	}

	public IsoscelesTriangle(IsoscelesTriangle isoscelesTriangle) {
		this(isoscelesTriangle.getWidth(), isoscelesTriangle.getLength());
	}
	//override the getArea() method to calculate the area of subclass
	@Override
	public double getArea() {
		IsoscelesTriangle isos = new IsoscelesTriangle(getWidth(), getLength());
		double perimeter = isos.getPerimeter()/2;//get the half of the perimeter to use in the formula
		return (perimeter - getLength())* Math.sqrt(perimeter*(perimeter-getWidth()));//this is the formula
	}
	//override the getPerimeter() method to calculate the perimeter of subclass
	@Override
	public double getPerimeter() {
		return 2 * getLength() + super.getWidth();//this is the formula
	}

	/**
	 * @return the length
	 */
	public double getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(double length) {
		this.length = length;
	}

	@Override
	public boolean equals(Object obj) {
		if(!super.equals(obj)) {
			return false;
		}
		if(obj instanceof Triangle) {
			return Double.doubleToLongBits(getLength())
					==Double.doubleToLongBits(getWidth());
		}
		if(obj instanceof IsoscelesTriangle) {
		IsoscelesTriangle isos = (IsoscelesTriangle)obj;
		return Double.doubleToLongBits(getLength())
				== Double.doubleToLongBits(isos.getLength());
		}
		return false;

	}
	//override the toString()method to format the output
	@Override
	public String toString() {

		return ("IsoscelesTriangle extends Triangle " + super.toString());
	}

}
