package cst8284.lab05;

/**
 * Class Name: CST8284_21S_301
 * @author JieKe 
 * Professor Name: Sandra
 * Date: July 11, 2021 
 * Class Name: IsoscelesTriangle 
 * Description: This program solution the Lab5 task.
 */
public class IsoscelesTriangle extends Triangle {

	private double length;

	public IsoscelesTriangle(){
		this(minValue,minValue);
	}

	public IsoscelesTriangle(double width, double length) {
		super(width);
		this.length = length;

	}

	public IsoscelesTriangle(IsoscelesTriangle isoscelesTriangle) {
		this(isoscelesTriangle.getWidth(), isoscelesTriangle.getLength());
	}
	/**
	 * 
	 * 
	 * 
	 */
	public double getArea() {
		IsoscelesTriangle isos = new IsoscelesTriangle(getWidth(), getLength());
		double perimeter = isos.getPerimeter()/2;
		return (perimeter - getLength())* Math.sqrt(perimeter*(perimeter-getWidth()));
	}
	/**
	 * 
	 * 
	 */
	public double getPerimeter() {
		return 2 * getLength() + super.getWidth();
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
		if(!(obj instanceof IsoscelesTriangle)) {
			return false;
		}
		IsoscelesTriangle isosceles = (IsoscelesTriangle) obj;
		return Double.doubleToLongBits(getWidth()) == Double.doubleToLongBits(isosceles.getWidth())
				&& Double.doubleToLongBits(getLength()) == Double.doubleToLongBits(isosceles.getLength());

	}

	@Override
	public String toString() {

		return ("IsoscelesTriangle extends Triangle " + super.toString());
	}

}
