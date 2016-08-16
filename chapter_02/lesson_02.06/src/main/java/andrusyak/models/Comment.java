package andrusyak.models;

public class Comment {

	private final String desc;
	private final long createDate;

	public Comment(String desc, long createDate) {
		this.desc = desc;
		this.createDate = createDate;
	}
}