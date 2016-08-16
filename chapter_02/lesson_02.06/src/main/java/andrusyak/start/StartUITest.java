package andrusyak.start;

class StartUITest {

	public static void main(String[] args) {
		Input input = new StubInput(new String[] {"0", "create stub task", "desc stub task", 
			"n", "1", "n", "2", "100", "new stub task", "new desc", "y"});

		new StartUI(input).init();
	}
} 