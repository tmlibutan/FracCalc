import java.util.Scanner;

public class dangerousTesting {

	static Scanner console = new Scanner(System.in);

	public static void main(String[] args) {
		System.out
				.println("Type a fraction expression. Otherwise, type \"quit\"");
		String inputString = "";

		while (!inputString.equals("quit")) {
			System.out.print("FracCalc> ");
			inputString = console.nextLine();
			fractionOne(inputString);
			findOperator(inputString);
			fractionTwo(inputString);
		}
		if (inputString.equals("quit")) {
			System.out.println("You terminated the program");
			System.exit(0);
		}
	}

	public static void findOperator(String inputString) {
		int numSpot = 0;
		String Operator;
		for (int i = 1; inputString.length() < i; i++) {
			if (inputString.charAt(i) == '+') {
				numSpot = i;
				Operator = inputString.substring(0, inputString.charAt('+'));
				System.out.println(Operator);
			} else if (inputString.charAt(i) == '-') {
				numSpot = i;
				Operator = inputString.substring(0, inputString.indexOf('-'));
			} else if (inputString.charAt(i) == '*') {
				numSpot = i;
				Operator = inputString.substring(0, inputString.indexOf('*'));
			} else if (inputString.charAt(i) == '/') {
				numSpot = i;
				Operator = inputString.substring(0, inputString.indexOf('/'));
			}
		}
	}

	public static String fractionOne(String inputString) {
		String infoFrac;
		String firstFraction;
		String numer;
		String denom;
		int dividePlace;

		System.out.println(inputString);
		dividePlace = inputString.indexOf("/");
		numer = inputString.substring(0, dividePlace);
		denom = inputString
				.substring(dividePlace + 1, inputString.indexOf(' '));
		infoFrac = "Fraction "
				+ inputString.substring(0, inputString.indexOf(' '))
				+ ": Numerator = " + numer + ", Denominator = " + denom;
		System.out.println(infoFrac);
		return infoFrac;
	}

	public static String fractionTwo(String inputString) {
		String infoFrac;
		String secondFraction;
		String numer;
		String denom;
		int dividePlace;

		dividePlace = inputString.lastIndexOf("/");
		numer = inputString
				.substring(inputString.lastIndexOf(' '), dividePlace);
		denom = inputString.substring(dividePlace - 1,
				inputString.lastIndexOf(' ') + 1);
		infoFrac = "Fraction "
				+ inputString.substring(inputString.lastIndexOf(' ') + 1,
						inputString.length()) + ": Numerator = " + numer
				+ ", Denominator = " + denom;
		System.out.println(infoFrac);
		return infoFrac;
	}
}