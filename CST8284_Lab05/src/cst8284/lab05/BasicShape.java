package cst8284.lab05;

import java.util.Objects;

/**
 * Class Name: CST8284_21S_301
 * @author JieKe 
 * Professor Name: Sandra Iroakazi
 * Date: July 11, 2021 
 * Class Name: BasicShape
 * Description: This program solution the Lab5 task.
 */
public class BasicShape {
	private double width;
	public static final double minValue = 1.0;

	protected BasicShape(double width) {setWidth(width);}

	public double getWidth(){return width;}
	public void setWidth(double width){this.width = width;}

	@Override
	public String toString(){
		return ("BasicShape extends " + super.toString());
	}
	public double getArea()  { return 0.0; }
	public double getPerimeter() { return 0.0; }



	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		return true;
		
	}


}
