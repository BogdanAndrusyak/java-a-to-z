package home15_2;

public class Array {

	int values[][];

	public Array(int values[][]) {

		this.values = values;
	}

	public void rotateArray() {

		int n = values.length;
		int tmp;

		for (int i = 0; i < n/2; i++){

		        for (int j=i; j < n-i-1; j++){

		                tmp = values[i][j];
		                values[i][j] = values[j][n-i-1];
		                values[j][n-i-1] = values[n-i-1][n-j-1];
		                values[n-i-1][n-j-1] = values[n-j-1][i];
		                values[n-j-1][i]=tmp;
		        }
		}
	}

	public void printArray() {

		for(int i = 0; i < values.length; i++) {

			for(int j = 0; j < values.length; j++) {

				System.out.print(values[i][j]);
			}
			System.out.println();
		}
	}
}