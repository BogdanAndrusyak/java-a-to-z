package andrusyak.start;

import java.util.*;

public class Menu {
	private MenuEntry[] entries = new MenuEntry[7];
	private int position = 0;
	private boolean isExit = false; 
	private Input input;
	private String choice;

	public Menu(Input input) {
		this.input = input;
		entries[entries.length-1] = new MenuEntry("Exit") {
			public void run() {
				isExit = true;
			}
		};
	}

	public void run() {
		while (!isExit) {
			printMenu();
			int intChoice = Integer.parseInt(choice);
			MenuEntry entry = entries[intChoice - 1];
			entry.run();
		}
	}

	public Menu addEntry(MenuEntry entry) {
		entries[position++] = entry;
		return this;
	}

	private void printMenu() {
		System.out.println("\nMenu:");
		for(int i = 0; i < entries.length; i++) {
			String title = entries[i].getTitle();
			System.out.println((i + 1) + " - " + title);
		}
		choice = input.ask("Enter: ");
	}
}