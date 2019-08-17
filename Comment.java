public class Comment {
	
	private User	user;
	private String	comment;
	
	
	public Comment (User user, String comment) {
		this.user	= user;
		this.comment= comment;
	}
	
	
	// get user who wrote review
	public User getUser() {
		return user;
	}

	
	// get review
	public String getComment() {
		return comment;
	}

}
