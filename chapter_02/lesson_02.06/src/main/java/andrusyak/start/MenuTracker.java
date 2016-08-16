package andrusyak.start;

import andrusyak.models.*;
import java.util.*;
import java.util.InputMismatchException;

class EditItem extends BaseAction {

	public EditItem() {
		super("Edit the item.");
	}

	public int key() {
		return 2;
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
						throw new java.util.InputMismatchException("ID doesn't correct.");
					}
				}
			} while (!correctId);

			String name = input.ask("Please enter the new task's name: ");
			String desc = input.ask("Please enter the new task's desc: ");
			Task task = new Task(name, desc);
			task.setId(id);
			tracker.edit(task);
		} else {
			throw new NoItemsException();
		}
	}
}

public class MenuTracker {
	private final Input input;
	private final Tracker tracker;
	private final UserAction[] actions = new UserAction[6];
	private int position = 0;

	public MenuTracker(Input input, Tracker tracker) {
		this.input = input;
		this.tracker = tracker;
	}

	public void fillActions() { 
		this.actions[position++] = this.new AddItem();
		this.actions[position++] = new ShowItems();
		this.actions[position++] = new EditItem();
		this.actions[position++] = new FindByName();
		this.actions[position++] = new AddComment();
	}

	public void addAction(UserAction action) {
		this.actions[position++] = action;
	} 

	public int[] getRanges() {
		return new int[] {0, 1, 2, 3, 4, 5};
	}

	public void select(int key) {
		boolean invalid = true;
		do {
			try {
				this.actions[key].execute(this.input, this.tracker);
				invalid = false;
			} catch (NoItemsException nie) {
				System.out.println("Please first add the item.");
				invalid = false;
			} catch (java.util.InputMismatchException ime) {
				System.out.println("Please enter the correct data.");	
			}
		} while(invalid);	
	}

	public void show() {
		System.out.println("\nMenu:");

		for (UserAction action : this.actions) {
			if (action != null) {
				System.out.println(action.info());
			}
		}
	}

	private class AddItem extends BaseAction {

		public AddItem() {
			super("Add the new item.");
		}

		public int key() {
			return 0;
		}

		public void execute(Input input, Tracker tracker) {
			String name = input.ask("Please enter the task's name: ");
			String desc = input.ask("Please enter the task's desc: ");
			tracker.add(new Task(name, desc));
		}
	}

	private static class ShowItems extends BaseAction {

		public ShowItems() {
			super("Show all items.");
		}

		public int key() {
			return 1;
		}

		public void execute(Input input, Tracker tracker) {
			if(tracker.getAll().length != 0) {
				for (Item item : tracker.getAll()) {
					System.out.println(
						String.format("ID: %s, Name: %s.", item.getId(), item.getName())
					);
				}
			} else {
				throw new NoItemsException();
			}
		}
	}

	private class FindByName extends BaseAction {

		public FindByName() {
			super("Find item by name.");
		}

		public int key() {
			return 3;
		}

		public void execute(Input input, Tracker tracker) {
			if (tracker.getAll().length != 0) {
				String name;
				boolean correctName = false;
				do {
					name = input.ask("Please enter the task's name: ");
					for (Item item : tracker.getAll()) {
						if (name.equals(item.getName())) {
							correctName = true;
							break;
						} else {
							throw new java.util.InputMismatchException("Name doesn't correct.");
						}
					}
				} while (!correctName);

				for (Item item : tracker.getAll()) {
					if (name.equals(item.getName())) {
						System.out.println(
							String.format("ID: %s, Name: %s", item.getId(), item.getName())
						);
					}
				}
			} else {
				throw new NoItemsException();
			}
		}
	}

	private class AddComment extends BaseAction {

		public AddComment() {
			super("Add comment.");
		}

		public int key() {
			return 4;
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
				String comment = input.ask("Please enter the task's comment: ");
				tracker.addComment(id, new Comment(comment, new Date().getTime()));
			} else {
				throw new NoItemsException();
			}
		}
	}
}