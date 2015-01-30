import java.util.Scanner;

public class FracCalcM2 {

	static Scanner console = new Scanner(System.in);

	public static void main(String[] args) {
		System.out
				.println("Type a fraction expression. Otherwise, type \"quit\"");
		String inputString = "";

		while (!inputString.equals("quit")) {
			System.out.print("FracCalc> ");
			inputString = console.nextLine();
			if (inputString.equals("quit")) { // If the input from user equals quit
				System.out.println("You terminated the program"); 
				System.exit(0); //Termination of program
			}
			fractionOne(inputString); // Gets output from fractionOne method
			findOperator(inputString); // Gets output from findOperator method
			fractionTwo(inputString); // Gets output from the fractionTwo method
			calculateMeFrac(inputString); // Gets output from calculateMeFrac method and solves the expression
		}
	}

	public static void findOperator(String inputString) {
		int numSpot = 0;
		String Operator;
		for (int i = 1; inputString.length() > i; i++) {
			if (inputString.charAt(i) == '+') { // If its addition, print operator addition
				numSpot = i;
				Operator = "+";
				System.out.println("Operator " + Operator + ": Addition");
				
			} else if (inputString.charAt(i) == '-' && inputString.charAt(i + 1) == ' ') { // If its subtraction, print operator subtraction
				numSpot = i;
				Operator = "-";
				System.out.println("Operator " + Operator + ": Subtraction");
				
			} else if (inputString.charAt(i) == '*') { // If its multiplication, print operator multiplication
				numSpot = i;
				Operator = "*";
				System.out.println("Operator " + Operator + ": Multiplication");
				
			} else if (inputString.charAt(i) == '/' && inputString.charAt(i + 1) == ' ') { // If division, print operator division
				numSpot = i;
				Operator = "/";
				System.out.println("Operator " + Operator + ": Division");
				// inputString ignores spaces so it only prints the operator
			}
		}
	}

	public static String fractionOne(String inputString) {
		if (inputString.indexOf(' ') != 0) {
			inputString = inputString.substring(0, inputString.indexOf(' ')); // Gets the first value

			if (inputString.indexOf('/') != -1) {
				System.out.print("Numerator = " + inputString.substring(0, inputString.indexOf('/')) + ","); // Prints numerator
				System.out.println(" Denominator = " + inputString.substring(inputString.indexOf('/') + 1, inputString.length())); //Prints denominator
				return inputString;
			} else { // This else starts if there is a whole number that is entered
				System.out.print("Numerator = " + inputString + ",");
				System.out.println(" Denominator =  1");
				return inputString;
			}

		}
		return inputString;
	}

	public static String fractionTwo(String inputString) {
		if (inputString.indexOf(' ') != 0) {
			inputString = inputString.substring(inputString.indexOf(' ') + 2,
					inputString.length()); // Gets the first value

			if (inputString.indexOf('/') != -1) {
				System.out.print("Numerator = "+ inputString.substring(0, inputString.indexOf('/')) + ",");
				System.out.println(" Denominator: "	+ inputString.substring(inputString.indexOf('/') + 1,
								inputString.length()));
				return inputString;
				
			} else { // This else starts if there is a whole number that is entered
				System.out.print("Numerator = " + inputString + ",");
				System.out.println(" Denominator = 1");
				return inputString;
			}
		}
		return inputString;

	}
	
	public static void calculateMeFrac(String inputString) {
		
		String wholeDivide = "_";
		int numer1 = 0;
		int denom1 = 0;
		int denom2 = 0;
		int numer2 = 0;
		int mixedNumer = 0;
		int mixedDenom1 = 0;
		int wholeNumber = 0;
		
		if (inputString.indexOf('/') > 0) { // Finds first divider, ignores the next if whole
		numer1 = Integer.parseInt(inputString.substring(0, inputString.indexOf('/'))); // Finds first divider to get numer
		denom1 = Integer.parseInt(inputString.substring(inputString.indexOf('/') + 1, inputString.indexOf(' '))); // Finds first divider to space to get denom1
		denom2 = Integer.parseInt(inputString.substring(inputString.lastIndexOf('/') + 1, inputString.length())); // Finds last divider to the end of inputString to get second denom
		numer2 = Integer.parseInt(inputString.substring(inputString.lastIndexOf(' ') + 1, inputString.lastIndexOf('/'))); // Finds first space to the last divider to get numer2
		
		}
		else if (!(inputString.indexOf('/') > 0)) { // Starts if a whole number is inputed
			numer1 = Integer.parseInt(inputString.substring(0, inputString.indexOf(' '))); // Starts at 0 to the space to get first number
			denom1 = 1; // Denom 1 and 2 stay as one
			denom2 = 1;
			numer2 = Integer.parseInt(inputString.substring(inputString.lastIndexOf(' ') + 1, inputString.length())); // Starts at last space to the end of inputString to get next digit
		}
		else if (inputString.indexOf('_') > 0) {
			mixedNumer = Integer
					.parseInt(inputString.substring(inputString.indexOf('_') + 1, inputString.indexOf('/')));
			mixedDenom1 = Integer.parseInt(inputString.substring(inputString.indexOf('/'), inputString.indexOf(' ')));
			wholeNumber = Integer.parseInt(inputString.substring(0, inputString.indexOf('_')));
		}
		int numerMTotal = numer1 * numer2;
		int denomMTotal = denom1 * denom2;
		int denomDTotal = denom1 * numer2;
		int numerDTotal = numer1 * denom2;

		for (int i = 1; inputString.length() > i; i++) {
			if (inputString.charAt(i) == '/' && inputString.charAt(i + 1) == ' ') { // Cross multiply
				if (numerMTotal > denomMTotal) { // BUGS BUGS BUGS BUGS BUGS BUGS BUGS BUGS BUGS BUGS
					System.out.println("Total: " + numerDTotal / denomDTotal);
					System.out.println("Total: " + numerDTotal % denomDTotal);
				}
			}

			if (inputString.charAt(i) == '*') { // Multiple Across
				if (numerMTotal > denomMTotal) {
					System.out.println("Total: " + numerMTotal / denomMTotal + "_" + numerMTotal % denomMTotal + "/"
							+ denom1 * denom2);
				} else {
					if (numerMTotal < denomMTotal) {
						System.out.println("Total: " + numer1 * numer2 + "/" + denom1 * denom2);
					}
				}
			}

			if (inputString.charAt(i) == '+') {
				System.out.println("Total: ");
			}

			if (inputString.charAt(i) == '-') {
				System.out.println("Total: ");
			}
		}
	}
}