package andrusyak.start;

import andrusyak.models.*;
import java.util.*;

public class Tracker {
	private Item[] items = new Item[10];
	private int position = 0;
	private int idPosition = 100;
	//private static final Random RN = new Random();

	public Item add(Item item) {
		item.setId(this.generateId());
		this.items[position++] = item;
		return item;
	}

	protected Item findById(String id) {
		Item result = null;
		for (Item item : items) {
			if (item != null && item.getId().equals(id)){
				result = item;
				break;
			}
		}
		return result;
	}

	String generateId() {
		//return String.valueOf(System.currentTimeMillis() + RN.nextInt());
		return String.valueOf(idPosition++);
	}

	public Item[] getAll() {
		Item[] result = new Item[position];
		for (int index=0; index!=this.position; index++) {
			result[index] = this.items[index];
		}
		return result;
	}

	public void edit(Item item) {
		for(int i = 0; i < items.length; i++) {
			if(items[i] != null && item.getId().equals(items[i].getId())) {
				items[i] = item;
				break;
			}
		}
	}

	public void delete(String id) {
		for(int i = 0; i < items.length; i++) {
			if(items[i] != null && items[i].getId().equals(id)) {
				items[i] = null;
				position--; 
				break;
			}
		}
	}

	public Item findByName(String name) {
		Item result = null;
		for (Item item : items) {
			if (item != null && item.getName().equals(name)){
				result = item;
				break;
			}
		}
		return result;
	}

	public Item findByCreate(long create) {
		Item result = null;
		for(Item item : items) {
			if(item != null && item.getCreate() == create) {
				result = item;
				break;
			}
		}
		return result;
	}

	public void addComment(String id, Comment comment) {
		for (int i = 0; i < items.length; i++) {
			if (items[i] != null && id.equals(items[i].getId())) {
				items[i].comments[items[i].positionComment++] = comment;
			}
		}
	}
}