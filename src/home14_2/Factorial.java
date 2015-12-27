package home14_2;

public class Factorial {

	public static void main(String[] args) {

		int numb = Integer.parseInt(args[0]);
		int factorial = 1;

		if (numb < 0) {

			System.out.println("Factorial doesn't exist!");

		} else if (numb == 0) {		

			System.out.println(factorial);

		} else {

			for (int i = 1; i <= numb; i++) {
				factorial *= i;
			}

			System.out.println(factorial);
		}	
	}
}