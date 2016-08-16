package andrusyak.start;

import andrusyak.models.*;

public class StubInput implements Input {

	private String[] answers;
	private int position = 0;

	public StubInput(String[] answers) {
		this.answers = answers;
	}

	public String ask(String question) {
		return answers[position++];
	}
}