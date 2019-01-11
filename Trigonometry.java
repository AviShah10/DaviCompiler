import java.util.*;

public class Trigonometry {
	public HashMap<String, String> map = new HashMap<>();
	public boolean degrees;
	public String input = "";

	public Trigonometry(boolean degrees, String expression) {
		this.degrees = degrees;
		this.map.put("S", "Sin[");
		this.map.put("C", "Cos[");
		this.map.put("T", "Tan[");
		this.map.put("A", "Sec[");
		this.map.put("B", "Cot[");
		this.map.put("D", "Csc[");
		this.input = expression;
	}

	public String getMathematicaCode() {
		String code = "";
		code += "N[";
		for (int i = 0; i < this.input.length(); i++) {
			if (this.map.containsKey(Character.toString(this.input.charAt(i)))) {
				code += this.map.get(Character.toString(this.input.charAt(i)));
			} else {
				code += this.input.charAt(i);
			}
			if(i < this.input.length()-1 && this.input.charAt(i+1)==']' && this.degrees) {
				code=code+" Degree";
			}
		}
		
		code += "]";
		return code;
	}
}