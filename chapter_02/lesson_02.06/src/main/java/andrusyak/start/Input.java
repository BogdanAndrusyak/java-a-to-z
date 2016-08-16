package andrusyak.start;

interface Input {
	
	String ask(String question);

	int ask(String question, int[] range);

}