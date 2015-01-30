import java.util.Scanner;
public class Program {
	static Scanner console = new Scanner(System.in);
	
	public static void main (String[] args) {

		System.out.println("Welcome to TextExcel!");
		System.out.print("Command/> ");
		String userInput = console.nextLine();
		while(!userInput.equals("exit")){
			System.out.print("Command/> ");
			userInput = console.nextLine();
		}
	}
}