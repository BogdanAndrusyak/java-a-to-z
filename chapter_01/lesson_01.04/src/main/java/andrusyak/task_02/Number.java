package andrusyak.task_02;

public class Number {

	int numb;

	public Number(int numb) {

		this.numb = numb;
	}

	public int calculateFactorial() {

		int factorial = 0;

		if (numb < 0) {

			System.out.println("Factorial doesn't exist!");

		} else if (numb == 0) {		

			factorial = 1;

		} else {
			
			factorial = 1;

			for (int i = 1; i <= numb; i++) {
				factorial *= i;
			}
		}	

		return factorial;
	}
}