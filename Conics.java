
public class Conics extends Function{
	private double aSquared;
	private double bSquared;
	private double h;
	private double k;
	private double r;
	private double a;
	private double x;
	private double y;
	private String type;
	public Conics(String equation) {
		super(equation);
	}
	public Conics(double h, double k, double r, String type, double xMin, double xMax) {
		super("", xMin, xMax);
		this.h = h;
		this.k = k;
		this.type = type;
		if(type.equals("circle")) this.r = r;
		else this.a = r;
		setEquation();
	}
	public Conics(double h, double k, double aSquared, double bSquared, String type, double xMin, double xMax) {
		super("", xMin, xMax);
		this.h = h;
		this.k = k;
		if(type.equals("parabolaS") || type.equals("parabolaV")) {
			this.x = aSquared;
			this.y = bSquared;
			calcA();
		}
		this.aSquared = aSquared;
		this.bSquared = bSquared;
		this.type = type;
		setEquation();
	}
	public void calcA(){
		this.a = (x-h)/((y-k)*(y-k));
	}
	public void setEquation() {
		if(this.type.equals("circle")) {
			this.equation = "x^2 + y^2 +" + (-2 * this.h) + "x +" + (-2 * this.k) + "y == " + (this.r*this.r) + " - " + (this.h*this.h) + " - " + (this.k*this.k);
		}
		else if(this.type.equals("ellipse")) {
			this.equation = this.bSquared + "x^2 + " + this.aSquared + "y^2 +" + (-2 * this.bSquared * h) + "x +" + (-2 * this.aSquared * k) + "y == " + (this.aSquared*this.bSquared) + " + " + (-1*this.aSquared* this.k * this.k) + " - " + (this.bSquared*this.h*this.h);
		}
		else if(this.type.equals("parabolaS")) {
			this.equation = "y^2 +" + (-1/this.a) + "x +" + (-2*this.k) + "y == " + (-1/this.a*this.h) + " - " + (this.k*this.k);
		}
		else if(this.type.equals("parabolaV")) {
			this.equation = "x^2 +" + (-1/this.a) + "y +" + (-2*this.h) + "x == " + (-1/this.a*this.k) + " - " + (this.h*this.h);
		}
		else if(this.type.equals("hyperbolaV")) {
			this.equation = this.bSquared + "x^2 - " + this.aSquared + "y^2 +" + (-2 * this.bSquared * h) + "x +" + (2 * this.aSquared * k) + "y == " + (this.aSquared*this.bSquared) + " + " + (this.aSquared* this.k * this.k) + " - " + (this.bSquared*this.h*this.h);
		}
		else {
			this.equation = (-1*this.aSquared) + "x^2 + " + this.bSquared + "y^2 +" + (2 * this.aSquared * h) + "x +" + (-2 * this.bSquared * k) + "y == " + (-1*this.aSquared*this.bSquared) + " + " + (-1*this.bSquared* this.k * this.k) + " + " + (this.aSquared*this.h*this.h);
		}
	}
	public String getMathematicaCode() {
		return "Plot[y /. Solve[" + equation + "], {x, " + xMin + ", " + xMax + "}, AspectRatio -> Automatic]";
	}
}
