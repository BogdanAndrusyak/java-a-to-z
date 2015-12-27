package home12_2;

public class CalcInit {
	
	public static void main(String[] args) {

		Calculator calculator = new Calculator();

		calculator.add(4, 2);
		System.out.println(calculator.result);

		calculator.subtract(4, 2);
		System.out.println(calculator.result);

		calculator.div(4, 2);
		System.out.println(calculator.result);

		calculator.multiple(4, 2);
		System.out.println(calculator.result);
	}
}