

public class Calculus extends Function{
	private double lowerBound;
	private double upperBound;
	private boolean atPoint;
	private boolean definiteIntegral;
	private double point;
	private int numDerivatives;
	private String variable;
	private boolean isDerivative;
	private String mathematicaCode;
	
	public Calculus(double lowerBound, double upperBound, boolean atPoint, double point, int numDerivatives, String variable, boolean isDerivative, boolean definiteIntegral, String equation) {
		super("", -5, 5);
		this.equation = equation;
		this.variable=variable;
		this.isDerivative=isDerivative;
		if (isDerivative) {
			this.numDerivatives=numDerivatives;
			if(atPoint) {
				this.point=point;
			}
		}else {
			if(definiteIntegral) {
				this.lowerBound=lowerBound;
				this.upperBound=upperBound;
			}
		}
	}
	public String getMathematicaCode() {
		if(isDerivative) {
			mathematicaCode="f["+variable+"_]:="+equation+"\nf";
			for(int i=1; i<=numDerivatives; i++) {
				mathematicaCode=mathematicaCode+"'";
			}
			if(atPoint) {
				mathematicaCode=mathematicaCode+"["+point+"]";
			}else {
				mathematicaCode=mathematicaCode+"["+variable+"]";
			}
		}else {
			if(definiteIntegral) {
				mathematicaCode="Integrate["+equation+", {"+variable+", "+lowerBound+", "+upperBound+"}]";
			}else {
				mathematicaCode="Integrate["+equation+", "+variable+"]";
			}
		}
		return mathematicaCode;
	}
	

}
