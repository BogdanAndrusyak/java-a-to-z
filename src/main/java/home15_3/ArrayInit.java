package home15_3;

public class ArrayInit {

	public static void main(String[] args) throws Exception {

		String[] values = {"First", "First", "Second", "Third", "Second"};

		Array array = new Array(values);

		array.printArray();

		array.removeDuplicates();

		array.printArray();
	}
}