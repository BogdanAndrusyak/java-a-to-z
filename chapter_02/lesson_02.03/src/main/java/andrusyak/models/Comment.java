package andrusyak.models;

public class Comment {

	public String desc;
	public long createDate;

	public Comment(String desc, long createDate) {
		this.desc = desc;
		this.createDate = createDate;
	}
}