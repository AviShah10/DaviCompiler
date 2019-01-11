

public class Function {
	protected String equation;
	protected double xMin;
	protected double xMax;
	public Function(String equation) {
		this.equation = equation;
		this.xMin = -10;
		this.xMax = 10;
	}
	public Function(String equation, double xMin, double xMax) {
		this.equation = equation;
		this.xMin = xMin;
		this.xMax = xMax;
	}
	public String getMathematicaCode() {
		return "Plot[" + equation + ", {x, " + xMin + ", " + xMax + "}]";
	}
}
