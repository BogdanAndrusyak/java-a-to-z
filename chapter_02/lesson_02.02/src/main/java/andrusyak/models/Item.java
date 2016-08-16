package andrusyak.models;

public class Item {
	private String id;

	public String name;

	public String description;

	public long create;

	public String author;

	public Comment[] comments = new Comment[10];
	public int positionComment = 0;

	public Item() {

	}

	public Item(String name, String description, long create) {
		this.name = name;
		this.description = description;
		this.create = create;
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	public long getCreate() {
		return this.create;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Comment[] getAllComments() {
		Comment[] result = new Comment[positionComment];
		for (int index=0; index!=positionComment; index++) {
			result[index] = this.comments[index];
		}
		return result;
	}
}