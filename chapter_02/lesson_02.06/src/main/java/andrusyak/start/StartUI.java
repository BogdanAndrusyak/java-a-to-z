package andrusyak.start;

import andrusyak.models.*;

class StartUI {
	private final Input input;
	private Tracker tracker = new Tracker();

	public StartUI(Input input) {
		this.input = input;
	}

	public void init() {
		Tracker tracker = new Tracker();
		MenuTracker menu = new MenuTracker(this.input, tracker);
		menu.fillActions();
		UserAction deleteAction = new BaseAction("Delete item.") {

			public int key() {
				return 5;
			}

			public void execute(Input input, Tracker tracker) {
				if (tracker.getAll().length != 0) {
				String id;
				boolean correctId = false;
				do {
					id = input.ask("Please enter the task's id: ");
					for (Item item : tracker.getAll()) {
						if (id.equals(item.getId())) {
							correctId = true;
							break;
						} else {
							throw new InputMismatchException("ID doesn't correct.");
						}
					}
				} while (!correctId);
				tracker.delete(id);
				} else {
					throw new NoItemsException();
				}
			}
		};
		menu.addAction(deleteAction);
		int[] ranges = menu.getRanges();
		do {
			menu.show();
			menu.select(input.ask("Select: ", ranges));
		} while(!"y".equals(this.input.ask("Exit?(y): ")));
	}

	public static void main(String[] args) {
		Input input = new ValidateInput();
		new StartUI(input).init();
	}
}