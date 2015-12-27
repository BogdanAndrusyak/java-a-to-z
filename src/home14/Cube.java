package home14;

public class Cube {

	public static void main(String[] args) {
		int x1 = Integer.parseInt(args[0]);
		int x2 = Integer.parseInt(args[1]);

		CubeFunction cubeFunction = new CubeFunction(1, 2, 3);

		for (int i = x1; i <= x2; i++) {
			System.out.println(cubeFunction.calculate(i));
		}
	}
}