package andrusyak.start;

public class StartUITest {

	public static void main(String[] args) {
		Input input = new StubInput(new String[] {"1", "create stub task", "desc stub task", "7"});

		new StartUI(input).init();
	}
} 