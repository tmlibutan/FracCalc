import java.io.*;
import java.util.*;

public class Calculator {
	public static void main(String[] args) {
		System.out.println("Enter fraction 1:");

		Scanner console = new Scanner(System.in);
		String fractionString = console.next();

		int indexOfEndofNumerator = fractionString.indexOf("/");
		int indexOfEndofWholeNumber = fractionString.indexOf("_");

		String wholeNumber = fractionString.substring(0, indexOfEndofWholeNumber);
		int whole = Integer.parseInt(wholeNumber);

		String num = fractionString.substring(indexOfEndofWholeNumber + 1, indexOfEndofNumerator);
		int numerator = Integer.parseInt(num);

		String den = fractionString.substring(indexOfEndofNumerator + 1, fractionString.length());
		int denominator = Integer.parseInt(den);


		int calc = 1;
		while (!fractionString.equals("quit") && calc < 10) {
			if (fractionString.equals("quit")) {
				System.out.println("Quit");

		System.out.println("Enter fraction 2: ");
		fractionString = console.next();
		calc++;
			}
		}
	}
}