import java.util.Scanner;

public class testOneByOne {

	static Scanner console = new Scanner(System.in);

	public static void main(String[] args) {
		System.out
				.println("Type a fraction expression. Otherwise, type \"quit\"");
		String inputString = "";

		while (!inputString.equals("quit")) {
			System.out.print("FracCalc> ");
			inputString = console.nextLine();
			if (inputString.equals("quit")) { // If the input from user equals
												// quit
				System.out.println("You terminated the program");
				System.exit(0); // Termination of program
			}
			fractionOne(inputString); // Gets output from fractionOne method
			findOperator(inputString); // Gets output from findOperator method
			fractionTwo(inputString); // Gets output from the fractionTwo method
			calculateMe(inputString); // Gets output from calculateMe method and solves the expression
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

			} else if (inputString.charAt(i) == '-'
					&& inputString.charAt(i + 1) == ' ') { // If its subtraction, print operator subtraction
				numSpot = i;
				Operator = "-";
				System.out.println("Operator " + Operator + ": Subtraction");

			} else if (inputString.charAt(i) == '*') { // If its multiplication, print operator multiplication
				numSpot = i;
				Operator = "*";
				System.out.println("Operator " + Operator + ": Multiplication");

			} else if (inputString.charAt(i) == '/'
					&& inputString.charAt(i + 1) == ' ') { // If division, print operator division
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
				System.out.print("Numerator = "
						+ inputString.substring(0, inputString.indexOf('/'))
						+ ","); // Prints numerator
				System.out.println(" Denominator = "
						+ inputString.substring(inputString.indexOf('/') + 1,
								inputString.length())); // Prints denominator
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
				System.out.print("Numerator = "
						+ inputString.substring(0, inputString.indexOf('/'))
						+ ",");
				System.out.println(" Denominator: "
						+ inputString.substring(inputString.indexOf('/') + 1,
								inputString.length()));
				return inputString;

			} else { // This else starts if there is a whole number that is
						// entered
				System.out.print("Numerator = " + inputString + ",");
				System.out.println(" Denominator = 1");
				return inputString;
			}
		}
		return inputString;

	}

	public static void calculateMe(String inputString) {
		if (inputString.indexOf(' ') != -1){
			String fractionOne = inputString.substring(0, inputString.indexOf(' '));
			inputString = inputString.substring(inputString.indexOf(' ') + 1, inputString.length());
			if (inputString.indexOf(' ') != -1) {
				String operator = inputString.substring(0, inputString.indexOf(' '));
				String fractionTwo = inputString.substring(inputString.indexOf(' ') + 1, inputString.length());
				
				
				int numerator = 0, denominator = 1; // Variables
				int numer1 = 0, numer2 = 0, denom1 = 1, denom2 = 1;
				int fractioneOneIndex = fractionOne.indexOf('_');
				int fractionTwoIndex = fractionTwo.indexOf('_');
				
				
				if (fractioneOneIndex != -1) { //Checking fraction 1 if mixed fraction
					if (ifItsInt(fractionOne.substring(0, fractionOne.indexOf('_'))) == true) {
						int wholeNum = Integer.parseInt(fractionOne.substring(0, fractionOne.indexOf('_')));
						fractionOne = fractionOne.substring(fractionOne.indexOf('_') + 1, fractionOne.length());
						
						fractioneOneIndex = fractionOne.indexOf('/');
						
						if (fractioneOneIndex != -1) { //checking if a fraction
							if (FracInt1(fractionOne) == true) {
								numer1 = Integer.parseInt(fractionOne.substring(0,fractioneOneIndex));
								denom1 = Integer.parseInt(fractionOne.substring(fractioneOneIndex + 1));
								numer1 += wholeNum * denom1;
							}
						}
				else { //if not mixed fraction
					fractioneOneIndex = fractionOne.indexOf('/'); 
					
					if (fractioneOneIndex != -1) { //checking if a fraction
						if (FracInt1(fractionOne) == true) { //checking if there are non-numeral characters in the fraction
							numer1 = Integer.parseInt(fractionOne.substring(0,fractioneOneIndex));
							denom1 = Integer.parseInt(fractionOne.substring(fractioneOneIndex + 1));
						}
						else {
							System.out.println("ERROR: nonIntegerFrac1");
						}
					} 
					else {
						if (ifItsInt(fractionOne) == true) { //checking if value is a number
							numer1 = Integer.parseInt(fractionOne);
							if (fractionOne.equals("0")) {
								denom1 = 0;
							}
						}
					}
				}
				
				if (fractionTwoIndex != -1) {     //Checking Fraction 2 for a mixed fraction
					if (ifItsInt(fractionTwo.substring(0, fractionTwo.indexOf('_'))) == true) { //checking if there are non-numeral characters in the fraction
						int wholeNum = Integer.parseInt(fractionTwo.substring(0, fractionTwo.indexOf('_')));
						fractionTwo = fractionTwo.substring(fractionTwo.indexOf('_') + 1, fractionTwo.length());
						
						fractionTwoIndex = fractionTwo.indexOf('/');
						
						if (fractionTwoIndex != -1) { //checking if a fraction
							if (FracInt2(fractionTwo) == true) { //checking if there are non-numeral characters in the fraction
								numer2 = Integer.parseInt(fractionTwo.substring(0,fractionTwoIndex));
								denom2 = Integer.parseInt(fractionTwo.substring(fractionTwoIndex + 1));
								numer2 += wholeNum * denom2;
							}
						}
				else { //if not a mixed fraction
					fractionTwoIndex = fractionTwo.indexOf('/');
					
					if (fractionTwoIndex != -1) { //checking if a fraction
						
						if (FracInt2(fractionTwo) == true) { //checking if there are non-numeral characters in the fraction
							numer2 = Integer.parseInt(fractionTwo.substring(0,fractionTwoIndex));
							denom2 = Integer.parseInt(fractionTwo.substring(fractionTwoIndex + 1));
						}
					} 
					else {
						if (ifItsInt(fractionTwo)== true) { //checking if there are non-numeral characters in the fraction
							numer2 = Integer.parseInt(fractionTwo);
							if (fractionTwo.equals("0")) {
								denom2 = 1;
							}
						}
					}
				}

				if (operator.equals("+")) { // Addition
					numerator = (numer1 * denom2) + (numer2 * denom1);
					denominator = denom2 * denom1;
					
					while (reduceCheck(numerator, denominator) == false) {
						for (int i = numerator * -1; i <= numerator; i++) {
							if (numerator % i == 0 && denominator % i == 0 && i != 1 && i != numerator && i != numerator * -1) {
								numerator /= i;
								denominator /= i;
							}
						}
					}
				} 
				else if (operator.equals("-")) { // Subtraction
					numerator = (numer1 * denom2) - (numer2 * denom1);
					denominator = denom2 * denom1;
					
					while (reduceCheck(numerator, denominator) == false) {
						for (int i = numerator * -1; i <= numerator; i++) {
							if (numerator % i == 0 && denominator % i == 0 && i != 1 && i != numerator && i != numerator * -1) {
								numerator /= i;
								denominator /= i;
							}
						}
					}
				} 
				else if (operator.equals("*")) { // Multiplication
					numerator = numer1 * numer2;
					denominator = denom1 * denom2;
					
					while (reduceCheck(numerator, denominator) == false) {
						for (int i = numerator * -1; i <= numerator; i++) {
							if (numerator % i == 0 && denominator % i == 0 && i != 1 && i != numerator && i != numerator * -1) {
								numerator /= i;
								denominator /= i;
							}
						}
					}
				} 
				else if (operator.equals("/")) { // Division
					numerator = numer1 * denom2;
					denominator = denom1 * numer2;
					
					while (reduceCheck(numerator, denominator) == false) {
						for (int i = numerator * -1; i <= numerator; i++) {
							if (numerator % i == 0 && denominator % i == 0 && i != 1 && i != numerator && i != numerator * -1) {
								numerator /= i;
								denominator /= i;
							}
						}
					}
				}

				else if (numerator == 0) {
					System.out.println("0");
				}
				else if (denominator == numerator) {
					System.out.println("1");
				}
				else if (denominator == 1) {
					System.out.println(numerator);
				}
				else if (numerator > denominator || numerator < denominator * -1) { // Mixed fraction conversion
					int finalWhole = 0;
					if (numerator >= denominator) {
						while (numerator >= denominator) {
							numerator -= denominator;
							finalWhole++;
						}
					}
					else if (numerator * -1 >= denominator) {
						while (numerator * -1 >= denominator) {
							numerator += denominator;
							finalWhole++;
						}
						finalWhole*= -1;
						numerator *= -1;
					}
					if (numerator < 0 && denominator < 0) { // Pesky negative numbers GONE
						numerator *= -1;
						denominator *= -1;
					}
					if (numerator == 0) {
						System.out.println(finalWhole);
					}
					else {
						System.out.println(finalWhole + "_" + numerator + "/" + denominator);
					}
				}
				else {
						if (numerator < 0 && denominator < 0) { // Pesky negative numbers GONE
							numerator *= -1;
							denominator *= -1;
						}
						System.out.println(numerator + "/" + denominator);
				}
			}
		}
	}
				}
			}
		}
	}
	public static boolean ifItsInt(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public static boolean FracInt1(String fractionOne) { // checking if fractionOne is filled just integers
		int fractionOneIndex = fractionOne.indexOf('/');
		if (fractionOne.indexOf('/') != -1) {
			if ((ifItsInt(fractionOne.substring(0, fractionOneIndex)) == true)
					&& (ifItsInt(fractionOne.substring(fractionOneIndex + 1)) == true)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public static boolean FracInt2(String fractionTwo) { // Checking if fractionTwo is just integers
		int fractionTwoIndex = fractionTwo.indexOf('/');
		if (fractionTwo.indexOf('/') != -1) {
			if ((ifItsInt(fractionTwo.substring(0, fractionTwoIndex)) == true)
					&& (ifItsInt(fractionTwo.substring(fractionTwoIndex + 1)) == true)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public static boolean reduceCheck(int num1, int denom1) { // Checking of reduction of number
		if (denom1 == 0) {
			return true;
		}
		for (int i = num1 + 1; i <= num1; i++) {
			if (num1 % i == 0 && denom1 % i == 0 && i != 1 && i != num1
					&& i != num1 * -1) {
				return false;
			}
		}
		return true;
	}
}
