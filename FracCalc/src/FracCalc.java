import java.util.*;

public class FracCalc {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		boolean run = true;

		while (run == true) {
			System.out.println("FracCalc: ");
			String inputString = console.nextLine();

			if (inputString.equalsIgnoreCase("quit")) { //Loop exit command
				run = false;
			} 
			else {
				if (inputString.indexOf(' ') != -1){
					String frac1 = inputString.substring(0, inputString.indexOf(' '));
					inputString = inputString.substring(inputString.indexOf(' ') + 1, inputString.length());
					if (inputString.indexOf(' ') != -1) {
						String oper = inputString.substring(0, inputString.indexOf(' '));
						String frac2 = inputString.substring(inputString.indexOf(' ') + 1, inputString.length());
						
						int finalNume = 0, finalDeno = 1; //Variable initialization
						int nume1 = 0, nume2 = 0, deno1 = 1, deno2 = 1;
						int frac1index = frac1.indexOf('_');
						int frac2index = frac2.indexOf('_');
						
						
						if (frac1index != -1) { //Checking fraction 1 if mixed fraction
							if (isInt(frac1.substring(0, frac1.indexOf('_'))) == true) {
								int wholeNum = Integer.parseInt(frac1.substring(0, frac1.indexOf('_')));
								frac1 = frac1.substring(frac1.indexOf('_') + 1, frac1.length());
								
								frac1index = frac1.indexOf('/');
								
								if (frac1index != -1) { //checking if a fraction
									if (largeIfFrac1(frac1) == true) {
										nume1 = Integer.parseInt(frac1.substring(0,frac1index));
										deno1 = Integer.parseInt(frac1.substring(frac1index + 1));
										nume1 += wholeNum * deno1;
									}
									else {
										System.out.println("ERROR: nonIntegerFrac1");
									}
								} 
								else {
										System.out.println("ERROR: incorrectFormat");
								}
							}
							else {
								System.out.println("ERROR: nonIntegerFrac1");
							}
						}
						else { //if not mixed fraction
							frac1index = frac1.indexOf('/'); 
							
							if (frac1index != -1) { //checking if a fraction
								if (largeIfFrac1(frac1) == true) { //checking if there are non-numeral characters in the fraction
									nume1 = Integer.parseInt(frac1.substring(0,frac1index));
									deno1 = Integer.parseInt(frac1.substring(frac1index + 1));
								}
								else {
									System.out.println("ERROR: nonIntegerFrac1");
								}
							} 
							else {
								if (isInt(frac1) == true) { //checking if value is a number
									nume1 = Integer.parseInt(frac1);
									if (frac1.equals("0")) {
										deno1 = 0;
									}
								}
								else {
									System.out.println("ERROR: nonIntegerFrac1");
								}
							}
						}
						
						if (frac2index != -1) {     //Checking Fraction 2 for a mixed fraction
							if (isInt(frac2.substring(0, frac2.indexOf('_'))) == true) { //checking if there are non-numeral characters in the fraction
								int wholeNum = Integer.parseInt(frac2.substring(0, frac2.indexOf('_')));
								frac2 = frac2.substring(frac2.indexOf('_') + 1, frac2.length());
								
								frac2index = frac2.indexOf('/');
								
								if (frac2index != -1) { //checking if a fraction
									if (largeIfFrac2(frac2) == true) { //checking if there are non-numeral characters in the fraction
										nume2 = Integer.parseInt(frac2.substring(0,frac2index));
										deno2 = Integer.parseInt(frac2.substring(frac2index + 1));
										nume2 += wholeNum * deno2;
									}
									else {
										System.out.println("ERROR: nonIntegerFrac2");
									}
								} 
								else {
									System.out.println("ERROR: incorrectFormat");
							    }
							}
							else {
								System.out.println("ERROR: nonIntegerFrac2");
							}
						}
						else { //if not a mixed fraction
							frac2index = frac2.indexOf('/');
							
							if (frac2index != -1) { //checking if a fraction
								
								if (largeIfFrac2(frac2) == true) { //checking if there are non-numeral characters in the fraction
									nume2 = Integer.parseInt(frac2.substring(0,frac2index));
									deno2 = Integer.parseInt(frac2.substring(frac2index + 1));
								}
								else {
									System.out.println("ERROR: nonIntegerFrac2");
								}
							} 
							else {
								if (isInt(frac2)== true) { //checking if there are non-numeral characters in the fraction
									nume2 = Integer.parseInt(frac2);
									if (frac2.equals("0")) {
										deno2 = 1;
									}
								}
								else {
									System.out.println("ERROR: nonIntegerFrac2");
								}
							}
						}

						if (oper.equals("+")) {     //ADDITION CODE
							finalNume = (nume1 * deno2) + (nume2 * deno1);
							finalDeno = deno2 * deno1;
							
							while (checkReduced(finalNume, finalDeno) == false) {
								for (int i = finalNume * -1; i <= finalNume; i++) {
									if (finalNume % i == 0 && finalDeno % i == 0 && i != 1 && i != finalNume && i != finalNume * -1) {
										finalNume /= i;
										finalDeno /= i;
									}
								}
							}
						} 
						else if (oper.equals("-")) {     //SUBTRACTION CODE
							finalNume = (nume1 * deno2) - (nume2 * deno1);
							finalDeno = deno2 * deno1;
							
							while (checkReduced(finalNume, finalDeno) == false) {
								for (int i = finalNume * -1; i <= finalNume; i++) {
									if (finalNume % i == 0 && finalDeno % i == 0 && i != 1 && i != finalNume && i != finalNume * -1) {
										finalNume /= i;
										finalDeno /= i;
									}
								}
							}
						} 
						else if (oper.equals("*")) {     //MULTIPLICATION CODE
							finalNume = nume1 * nume2;
							finalDeno = deno1 * deno2;
							
							while (checkReduced(finalNume, finalDeno) == false) {
								for (int i = finalNume * -1; i <= finalNume; i++) {
									if (finalNume % i == 0 && finalDeno % i == 0 && i != 1 && i != finalNume && i != finalNume * -1) {
										finalNume /= i;
										finalDeno /= i;
									}
								}
							}
						} 
						else if (oper.equals("/")) {     //DIVISION CODE
							finalNume = nume1 * deno2;
							finalDeno = deno1 * nume2;
							
							while (checkReduced(finalNume, finalDeno) == false) {
								for (int i = finalNume * -1; i <= finalNume; i++) {
									if (finalNume % i == 0 && finalDeno % i == 0 && i != 1 && i != finalNume && i != finalNume * -1) {
										finalNume /= i;
										finalDeno /= i;
									}
								}
							}
						} 
						else {
							System.out.println("ERROR: unknownOperand"); //unknown operator
						}
						
						if (finalDeno == 0) {
							System.out.println("undefined fraction");
						}
						else if (finalNume == 0) {
							System.out.println("0");
						}
						else if (finalDeno == finalNume) {
							System.out.println("1");
						}
						else if (finalDeno == 1) {
							System.out.println(finalNume);
						}
						else if (finalNume > finalDeno || finalNume < finalDeno * -1) { //converting to mixed fraction
							int finalWhole = 0;
							if (finalNume >= finalDeno) {
								while (finalNume >= finalDeno) {
									finalNume -= finalDeno;
									finalWhole++;
								}
							}
							else if (finalNume * -1 >= finalDeno) {
								while (finalNume * -1 >= finalDeno) {
									finalNume += finalDeno;
									finalWhole++;
								}
								finalWhole*= -1;
								finalNume *= -1;
							}
							if (finalNume < 0 && finalDeno < 0) { //removing double negatives
								finalNume *= -1;
								finalDeno *= -1;
							}
							if (finalNume == 0) {
								System.out.println(finalWhole);
							}
							else {
								System.out.println(finalWhole + "_" + finalNume + "/" + finalDeno);
							}
						}
						else {
								if (finalNume < 0 && finalDeno < 0) { //removing double negatives
									finalNume *= -1;
									finalDeno *= -1;
								}
								System.out.println(finalNume + "/" + finalDeno);
						}
					}
					else {
						System.out.println("ERROR: incorrectFormat");
					}
				}
				else {
					System.out.println("ERROR: incorrectFormat");
				}
			}
		}

		console.close();
	}

	public static boolean isInt(String s) { //int checking method
	    try { 
	        Integer.parseInt(s); 
	    } 
	    catch(NumberFormatException nfe) { 
	        return false; 
	    }
	    return true;
	}
	
	public static boolean largeIfFrac1(String frac1) { //checking if frac1 is nothing but integers
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
	public static boolean largeIfFrac2(String frac2) { //checking if frac2 is nothing but integers
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
	public static boolean checkReduced(int nume, int deno) { //reduced checker for reducing loop
		if (deno == 0) {
			return true;
		}
		for (int i = nume + 1; i <= nume; i++) {
			if (nume % i == 0 && deno % i == 0 && i != 1 && i != nume && i != nume * -1) {
				return false;
			}
		}
		return true;
	}
}
