package andrusyak.start;

import andrusyak.models.*;

public interface Input {
	
	String ask(String question);

	int ask(String question, int[] range);

}