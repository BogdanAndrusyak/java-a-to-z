package home15_3;

public class Array {

	String[] values;

	public Array(String[] values) {

		this.values = values;
	}

	public void removeDuplicates() {

		for (int i = 0; i < values.length; i++) {

    		for (int j = i + 1; j < values.length; j++) {

       			if (values[i].equals(values[j])) {

	            	values[j] = "";

	            	for(int k = j; k < values.length - 1; k++) {

	                       values[k] = values[k+1];
		            }

		            values[values.length-1] = "";
		        }
		    }
		}
	}

	public void printArray() {

		for(int i = 0; i < values.length; i++) {

			System.out.print(values[i] + ", ");
		}

		System.out.println();
	}
}