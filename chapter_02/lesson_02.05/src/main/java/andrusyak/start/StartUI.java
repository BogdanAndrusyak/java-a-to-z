package andrusyak.start;

import andrusyak.models.*;
import java.util.*;

public class StartUI {
	private int[] ranges;
	private Input input;
	private Tracker tracker = new Tracker();

	public StartUI(Input input) {
		this.input = input;
	}

	public void init() {
		Tracker tracker = new Tracker();
		MenuTracker menu = new MenuTracker(this.input, tracker);
		menu.fillActions();
		ranges = menu.getRanges();
		do {
			menu.show();
			menu.select(input.ask("Select: ", this.ranges));
		} while(!"y".equals(this.input.ask("Exit?(y): ")));
	}

	public static void main(String[] args) {
		Input input = new ValidateInput();
		new StartUI(input).init();
	}
}