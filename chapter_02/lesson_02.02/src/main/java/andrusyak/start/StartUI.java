package andrusyak.start;

import andrusyak.models.*;

public class StartUI {

	public static void main(String[] args) {
		Tracker tracker = new Tracker();
		Task task = new Task("first task", "first desc");

		tracker.add(task);

		for (Item item : tracker.getAll()) {
			System.out.println(item.getName());
		}

		tracker.edit(new Task("second task", "second desc"), task);

		for (Item item : tracker.getAll()) {
			System.out.println(item.getName());
		}

		tracker.addComment(task, new Comment("desc", 10l));

		for(Comment comment : task.getAllComments()) {
			System.out.println(comment.desc + " " + comment.createDate);
		}
	}
}