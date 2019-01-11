import java.awt.Point;
import java.util.*;

public class Runner {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the Davi Mathematica Compiler!\nTired of writing "
				+ "Mathematica code?\nUse the Davi Mathematica Compiler!\n"
				+ "Using the Davi Mathematica Compiler,\nyou have the ability to get "
				+ "Mathematica code for\ntrigonometry, calculus, conics, and more graphing.\n");
		System.out.print("What Mathematica code would you like? (trigonometry, calculus, conic, or line): ");
		String type = scan.next();
		System.out.println();
		if(type.equals("trigonometry")) {
			System.out.print("Are the angles in degrees?: ");
			String degree = scan.next();
			boolean isDegrees = false;
			if (degree.toLowerCase().charAt(0) == 'y') {
				isDegrees = true;
			}
			System.out.println();
			System.out.print("What is the expression?: ");
			String input = scan.next();
			Trigonometry trig = new Trigonometry(isDegrees, input);
			System.out.println();
			System.out.println(trig.getMathematicaCode());
		}
		else if(type.equals("calculus")) {
			System.out.print("What are you calculating? (derivative or integral): ");
			String isDerivative = scan.next();
			if(isDerivative.equals("derivative")) {
				System.out.println();
				System.out.print("How many derivatives do you want?: ");
				int numDerivatives = scan.nextInt();
				System.out.println();
				System.out.print("What variable are you using?: ");
				String variable = scan.next();
				System.out.println();
				System.out.print("Is the derivative at a point? (yes or no): ");
				String atPoint = scan.next();
				boolean atP = false;
				double point = 0;
				if(atPoint.equals("yes")) {
					System.out.println();
					atP = true;
					System.out.print("What point is the derivative at? (give a number for the " + variable + "): ");
					point = scan.nextDouble();
				}
				System.out.println();
				System.out.print("What is the equation?: ");
				String equation = scan.next();
				Calculus calc = new Calculus(0.0, 0.0, atP, point, numDerivatives, variable, true, false, equation);
				System.out.println();
				System.out.println(calc.getMathematicaCode());
			}
			else {
				System.out.println();
				System.out.print("Is this a definite integral? (yes or no): ");
				String definiteIntegral = scan.next();
				boolean defInt = false;
				double lowerBound = 0;
				double upperBound = 0;
				if(definiteIntegral.equals("yes")) {
					System.out.println();
					defInt = true;
					System.out.print("What is the lower bound?: ");
					lowerBound = scan.nextInt();
					System.out.println();
					System.out.print("What is the upper bound?: ");
					upperBound = scan.nextInt();
				}
				System.out.println();
				System.out.print("What variable are you using?: ");
				String variable = scan.next();
				System.out.println();
				System.out.print("What is the equation?: ");
				String equation = scan.next();
				System.out.println();
				Calculus calc = new Calculus(lowerBound, upperBound, false, 0, 0, variable, false, false, equation);
				System.out.println(calc.getMathematicaCode());
			}
		}
		else if(type.equals("conic")) {
			System.out.print("What type of conic? (circle, ellipse, parabola, or hyperbola): ");
			type = scan.next();
			System.out.println();
			if(type.equals("circle")) {
				System.out.print("What is the center of the circle? in form (h,k): ");
				String center = scan.next();
				double h = Double.parseDouble(center.substring(1, center.indexOf(",")));
				double k = Double.parseDouble(center.substring(center.indexOf(",")+1, center.indexOf(")")));
				System.out.println();
				System.out.print("What is the radius?: ");
				double r = scan.nextDouble();
				System.out.println();
				System.out.print("What is your minimum x value?: ");
				double xMin = scan.nextDouble();
				System.out.println();
				System.out.print("What is your maximum x value?: ");
				double xMax = scan.nextDouble();
				System.out.println();
				Conics conic = new Conics(h, k, r, type, xMin, xMax);
				System.out.println(conic.getMathematicaCode());
			}
			else if(type.equals("ellipse")) {
				System.out.print("What is the center of the ellipse? in form (h,k): ");
				String center = scan.next();
				double h = Double.parseDouble(center.substring(1, center.indexOf(",")));
				double k = Double.parseDouble(center.substring(center.indexOf(",")+1, center.indexOf(")")));
				System.out.println();
				System.out.print("What is the a squared value?: ");
				double aSquared = scan.nextDouble();
				System.out.println();
				System.out.print("What is the b squared value?: ");
				double bSquared = scan.nextDouble();
				System.out.println();
				System.out.print("What is your minimum x value?: ");
				double xMin = scan.nextDouble();
				System.out.println();
				System.out.print("What is your maximum x value?: ");
				double xMax = scan.nextDouble();
				System.out.println();
				Conics conic = new Conics(h, k, aSquared, bSquared, type, xMin, xMax);
				System.out.println();
				System.out.println(conic.getMathematicaCode());
			}
			else if(type.equals("parabola")) {
				System.out.print("What is the orientation of the parabola? (sideways or vertical): ");
				String parab = scan.next();
				if(parab.equals("sideways")) {
					type = "parabolaS";
				}
				else {
					type = "parabolaV";
				}
				System.out.println();
				System.out.print("What is the vertex of the parabola? in form (h,k): ");
				String center = scan.next();
				double h = Double.parseDouble(center.substring(1, center.indexOf(",")));
				double k = Double.parseDouble(center.substring(center.indexOf(",")+1, center.indexOf(")")));
				System.out.println();
				System.out.print("What is the a value?: ");
				double a = scan.nextDouble();
				System.out.println();
				System.out.print("What is your minimum x value?: ");
				double xMin = scan.nextDouble();
				System.out.println();
				System.out.print("What is your maximum x value?: ");
				double xMax = scan.nextDouble();
				System.out.println();
				Conics conic = new Conics(h, k, a, type, xMin, xMax);
				System.out.println(conic.getMathematicaCode());
			}
			else if(type.equals("hyperbola")) {
				System.out.print("What is the orientation of the hyperbola? (sideways or vertical): ");
				String parab = scan.next();
				if(parab.equals("sideways")) {
					type = "hyperbolaS";
				}
				else {
					type = "hyperbolaV";
				}
				System.out.println();
				System.out.print("What is the vertex of the hyperbola? in form (h,k): ");
				String center = scan.next();
				double h = Double.parseDouble(center.substring(1, center.indexOf(",")));
				double k = Double.parseDouble(center.substring(center.indexOf(",")+1, center.indexOf(")")));
				System.out.println();
				System.out.print("What is the a squared value?: ");
				double aSquared = scan.nextDouble();
				System.out.println();
				System.out.print("What is the b squared value?: ");
				double bSquared = scan.nextDouble();
				System.out.println();
				System.out.print("What is your minimum x value?: ");
				double xMin = scan.nextDouble();
				System.out.println();
				System.out.print("What is your maximum x value?: ");
				double xMax = scan.nextDouble();
				System.out.println();
				Conics conic = new Conics(h, k, aSquared, bSquared, type, xMin, xMax);
				System.out.println();
				System.out.println(conic.getMathematicaCode());
			}
			else {
				System.out.print("Nah dawg");
			}
		}
		else if(type.equals("line")) {
			System.out.print("What type of line? (two-point, point-slope, standard-form): ");
			String line = scan.next();
			System.out.println();
			if(line.equals("two-point")) {
				System.out.print("What is the first point? in form (h,k): ");
				String p1 = scan.next();
				double p1x = Double.parseDouble(p1.substring(1, p1.indexOf(",")));
				double p1y = Double.parseDouble(p1.substring(p1.indexOf(",")+1, p1.indexOf(")")));
				Point point1 = new Point((int)p1x, (int)p1y);
				System.out.println();
				System.out.print("What is the second point? in form (h,k): ");
				String p2 = scan.next();
				double p2x = Double.parseDouble(p2.substring(1, p2.indexOf(",")));
				double p2y = Double.parseDouble(p2.substring(p2.indexOf(",")+1, p2.indexOf(")")));
				Point point2 = new Point((int)p2x, (int)p2y);
				System.out.println();
				System.out.print("What is your minimum x value?: ");
				double xMin = scan.nextDouble();
				System.out.println();
				System.out.print("What is your maximum x value?: ");
				double xMax = scan.nextDouble();
				System.out.println();
				Line lines = new Line(point1, point2, xMin, xMax);
				System.out.println(lines.getMathematicaCode());
			}
			else if(line.equals("point-slope")) {
				System.out.print("What is the point? in form (h,k): ");
				String p1 = scan.next();
				double p1x = Double.parseDouble(p1.substring(1, p1.indexOf(",")));
				double p1y = Double.parseDouble(p1.substring(p1.indexOf(",")+1, p1.indexOf(")")));
				Point point1 = new Point((int)p1x, (int)p1y);
				System.out.println();
				System.out.print("What is the slope?: ");
				double slope = scan.nextDouble();
				System.out.println();
				System.out.print("What is your minimum x value?: ");
				double xMin = scan.nextDouble();
				System.out.println();
				System.out.print("What is your maximum x value?: ");
				double xMax = scan.nextDouble();
				System.out.println();
				Line lines = new Line(slope, point1, xMin, xMax);
				System.out.println(lines.getMathematicaCode());
			}
			else {
				System.out.print("What is the A value?: ");
				double aStand = scan.nextDouble();
				System.out.println();
				System.out.print("What is the B value?: ");
				double bStand = scan.nextDouble();
				System.out.println();
				System.out.print("What is the C value?: ");
				double cStand = scan.nextDouble();
				System.out.println();
				System.out.print("What is your minimum x value?: ");
				double xMin = scan.nextDouble();
				System.out.println();
				System.out.print("What is your maximum x value?: ");
				double xMax = scan.nextDouble();
				System.out.println();
				Line lines = new Line(aStand, bStand, cStand, xMin, xMax);
				System.out.println(lines.getMathematicaCode());
			}
		}
		else {
			System.out.println("The Davi Mathemtatica Compiler does not have the capability of understanding this mathematical concept. Please try again.");
		}
	}

}
