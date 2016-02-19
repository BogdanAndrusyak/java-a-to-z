package home15_1;

public class ArrayInit {

	public static void main(String[] args) {

		int values[] = {5, 3, 7, 9, 0, 2};

		Array array = new Array(values);

		array.bubbleSort();

		for(int i = 0; i < values.length; i++) {
			System.out.print(values[i] + " ");
		}

		System.out.println();
	}
}