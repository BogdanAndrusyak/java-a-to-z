package home15_2;

public class ArrayInit {

	public static void main(String[] args) {

		int values[][] = {
			{3, 5, 6, 8},
			{7, 8, 0, 1},
			{5, 7, 3, 1},
			{5, 4, 2, 6}
		};

		Array array = new Array(values);

		array.printArray();

		array.rotateArray();

		System.out.println();
		
		array.printArray();
	}
}