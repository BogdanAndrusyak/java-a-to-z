package andrusyak.start;

import andrusyak.models.*;
import java.util.*;
import java.util.InputMismatchException;

class EditItem implements UserAction {
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
			throw new NoItemsException("No items.");
		}
	}

	public String info() {
		return String.format("%s - %s", this.key(), "Edit the item.");
	}
}

public class MenuTracker {
	private Input input;
	private Tracker tracker;
	private UserAction[] actions = new UserAction[6];

	public MenuTracker(Input input, Tracker tracker) {
		this.input = input;
		this.tracker = tracker;
	}

	public void fillActions() { 
		this.actions[0] = this.new AddItem();
		this.actions[1] = new ShowItems();
		this.actions[2] = new EditItem();
		this.actions[3] = new FindByName();
		this.actions[4] = new DeleteItem();
		this.actions[5] = new AddComment();
	}

	public int[] getRanges() {
		int[] ranges = new int[] {0, 1, 2, 3, 4, 5};
		return ranges;
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

	private class AddItem implements UserAction {
		public int key() {
			return 0;
		}

		public void execute(Input input, Tracker tracker) {
			String name = input.ask("Please enter the task's name: ");
			String desc = input.ask("Please enter the task's desc: ");
			tracker.add(new Task(name, desc));
		}

		public String info() {
			return String.format("%s - %s", this.key(), "Add the new item.");
		}
	}

	private static class ShowItems implements UserAction {
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
				throw new NoItemsException("No items.");
			}
		}

		public String info() {
			return String.format("%s - %s", this.key(), "Show all items.");
		}
	}

	private class FindByName implements UserAction {
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
				throw new NoItemsException("No items.");
			}
		}

		public String info() {
			return String.format("%s - %s", this.key(), "Find item by name.");
		}
	}

	private class DeleteItem implements UserAction {
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
							throw new java.util.InputMismatchException("ID doesn't correct.");
						}
					}
				} while (!correctId);
				tracker.delete(id);
			} else {
				throw new NoItemsException("No items.");
			}
		}

		public String info() {
			return String.format("%s - %s", this.key(), "Delete item.");
		}
	}

	private class AddComment implements UserAction {
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
				String comment = input.ask("Please enter the task's comment: ");
				tracker.addComment(id, new Comment(comment, new Date().getTime()));
			} else {
				throw new NoItemsException("No items.");
			}
		}

		public String info() {
			return String.format("%s - %s", this.key(), "Add comment.");
		}
	}
}