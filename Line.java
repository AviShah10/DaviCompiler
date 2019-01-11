import java.awt.*;

public class Line extends Function{
	private double slope;
	private double yInt;
	private Point p1;
	private Point p2;
	private double aStand;
	private double bStand;
	private double cStand;
	public Line(String equation) {
		super(equation);
	}
	public Line(Point p1, Point p2, double xMin, double xMax) {
		super("", xMin, xMax);
		this.p1 = p1;
		this.p2 = p2;
		getTwoPointLine();
	}	
	public Line(double slope, Point p1, double xMin, double xMax) {
		super("", xMin, xMax);
		this.slope = slope;
		this.p1 = p1;
		getPointSlopeLine();
	}
	public Line(double aStand, double bStand, double cStand, double xMin, double xMax) {
		super("", xMin, xMax);
		this.aStand= aStand;
		this.bStand= bStand;
		this.cStand= cStand;
		getStandFormLine();
	}
	public void getTwoPointLine() {
		this.slope = (p2.getY()-p1.getY())/(p2.getX()-p1.getX());
		this.yInt = (this.slope*this.p1.getX()*-1)+this.p1.getY();
//		if(-yInt/slope > 0) {
//			this.xMin = -1;
//			this.xMax = (-yInt/slope)+1;
//		}
//		else {
//			this.xMin = -yInt/slope;
//			this.xMax = 1;
//		}
		this.equation = slope + "x + " + yInt;
	}
	public void getPointSlopeLine() {
		this.yInt = (this.slope*this.p1.getX()*-1)+this.p1.getY();
//		if(-yInt/slope > 0) {
//			this.xMin = -1;
//			this.xMax = (-yInt/slope)+1;
//		}
//		else {
//			this.xMin = -yInt/slope;
//			this.xMax = 1;
//		}
		this.equation = slope + "x + " + yInt;
	}
	public void getStandFormLine() {
		this.slope = (this.aStand*-1)/this.bStand;
		this.yInt = this.cStand/this.bStand;
//		if(-yInt/slope > 0) {
//			this.xMin = -1;
//			this.xMax = (-yInt/slope)+1;
//		}
//		else {
//			this.xMin = -yInt/slope;
//			this.xMax = 1;
//		}
		this.equation = slope + "x + " + yInt;
	}
	
}
