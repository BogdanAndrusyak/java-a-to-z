package home15_1;

public class Array {

	int values[];

	public Array(int values[]) {
		
		this.values = values;
	}

	public void bubbleSort() {

		for (int i = values.length - 1; i > 0; i--) {

			for(int j = 0; j < i; j++) {

				if (values[j] > values[j+1]) {
					int tmp = values[j];
					values[j] = values[j+1];
					values[j+1] = tmp;
				}
			}
		}
	}
}
