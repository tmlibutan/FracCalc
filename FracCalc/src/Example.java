import java.util.*;

public class Example {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		boolean run = true;

		while (run == true) {
			System.out.println("FracCalc: ");
			String str = console.nextLine();

			if (str.equalsIgnoreCase("quit")) {
				run = false;
			} 
			else {
				String frac1 = str.substring(0, str.indexOf(' '));
				str = str.substring(str.indexOf(' ') + 1, str.length());
				String oper = str.substring(0, str.indexOf(' '));
				String frac2 = str.substring(str.indexOf(' ') + 1, str.length());
				
				int nume1 = 0, nume2 = 0, deno1 = 1, deno2 = 1;
				int frac1index = frac1.indexOf('/');
				int frac2index = frac2.indexOf('/');

				if (frac1index != -1) {
					if (largeIfFrac1(frac1) == true) {
						nume1 = Integer.parseInt(frac1.substring(0,frac1index));
						deno1 = Integer.parseInt(frac1.substring(frac1index + 1));
					}
					else {
						System.out.println("ERROR!");
					}
				} 
				else {
					if (isInt(frac1) == true) {
						nume1 = Integer.parseInt(frac1);
					}
					else {
						System.out.println("ERROR!");
					}
				}

				if (frac2.indexOf('/') != -1) {
					if (largeIfFrac2(frac2) == true) {
						nume2 = Integer.parseInt(frac2.substring(0,frac2index));
						deno2 = Integer.parseInt(frac2.substring(frac2index + 1));
					}
					else {
						System.out.println("ERROR!");
					}
				} 
				else {
					if (isInt(frac2)== true) {
						nume2 = Integer.parseInt(frac2);
					}
					else {
						System.out.println("ERROR!");
					}
				}

				System.out.println("Fraction " + frac1 + ": numerator = " + nume1 + ", denominator = " + deno1);

				String operName;
				if (oper.equals("+")) {
					operName = "addition";
				} 
				else if (oper.equals("-")) {
					operName = "subtraction";
				} 
				else if (oper.equals("*")) {
					operName = "multiplication";
				} 
				else if (oper.equals("/")) {
					operName = "division";
				} 
				else {
					System.out.println("ERROR!");
					operName = "ERROR!";
				}
				
				System.out.println("Operator " + oper + ": " + operName);

				System.out.println("Fraction " + frac2 + ": numerator = " + nume2 + ", denominator = " + deno2);
			}
		}

		System.out.println("Terminated");
		console.close();
	}

	public static boolean isInt(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } 
	    catch(NumberFormatException nfe) { 
	        return false; 
	    }
	    return true;
	}
	
	public static boolean largeIfFrac1(String frac1) {
		int frac1index = frac1.indexOf('/');
		if (frac1.indexOf('/') != -1) {
			if ((isInt(frac1.substring(0,frac1index)) == true)&&(isInt(frac1.substring(frac1index + 1)) == true)) {
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
	public static boolean largeIfFrac2(String frac2) {
		int frac2index = frac2.indexOf('/');
		if (frac2.indexOf('/') != -1) {
			if ((isInt(frac2.substring(0,frac2index)) == true)&&(isInt(frac2.substring(frac2index + 1)) == true)) {
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
}
