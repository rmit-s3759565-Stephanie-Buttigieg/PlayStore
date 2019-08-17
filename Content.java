import java.util.ArrayList;

abstract class Content {
	
	private	String		contentId;
	private String		contentName;

	private int			numberOfDownloads;
	private double		price;
	
	final static double DEFAULTPRICE = 0;
	
	private ArrayList<Comment> commentList	= new ArrayList<Comment>();
	
	// instantiate the utilities class
	private Utilities util = new Utilities();


	// constructor incl. price
	public Content (String contentId, String contentName, double price) {
		this.contentId			= contentId;
		this.contentName		= contentName;
		this.numberOfDownloads	= 0;
		this.price				= price;
	}

	
	// constructor excl. price
	public Content(String contentId, String contentName) {
		this(contentId, contentName, DEFAULTPRICE);
	}
	
	
	// get content id
	public String getContentId() {
		return this.contentId;
	}

	
	// get content name
	public String getContentName() {
		return this.contentName;
	}

	
	// get number of downloads
	public int getNumberOfDownloads() {
		return this.numberOfDownloads;
	}
	
	
	// get price
	public double getPrice() {
		return this.price;
	}

	
	// total number of comments for a content
	public int totalComments() {
		return commentList.size();
	}
	

	// content details common for all content types
	public String getStandardContent() {
		return this.getContentId() + "\t" + util.padStr(this.getContentName(), ' ', 30) + "\t" 
					+ this.getNumberOfDownloads() + "\t\t" + String.format("$%.2f", this.getPrice());
	}	
	

	// increase downloads
	public void addDownload() {
		this.numberOfDownloads ++;
	}
	
	
	// add comment
	public void addReview(Comment comment) {
		commentList.add(comment);		
	}
	

	// remove comment
	public void removeReview(String userId) throws PlayStoreException {
		
		boolean success = false;

		// get number of comments
		if (totalComments() == 0) {

			// No reviews for content
			throw new PlayStoreException("No reviews for " + this.contentName + ".");

		} else {
		
			for (int i = 0; i < totalComments(); i++) {
				
				if (commentList.get(i).getUser().getUserId().equals(userId)) {
					commentList.remove(i);
					
					System.out.println("Reviews by user " + userId + " for " + this.contentName + " removed.");

					success = true;
				}
			}
			
			// check if any reviews by user were found (and removed)
			if (!success) {

				// No reviews by user
				throw new PlayStoreException("No reviews by user " + userId + " found.");
			}
		}
	}
	
		
	// show comments
	public void showReviews() throws PlayStoreException {
		
		String	userId;
		String	comment;
		
		if (totalComments() == 0) {
			
			// No reviews for content
			throw new PlayStoreException("No reviews.");

		} else {
		
			for (int i = 0; i < totalComments(); i++) {
				userId	= commentList.get(i).getUser().getUserId();
				comment = commentList.get(i).getComment();
				
				System.out.println(userId + ": " + comment);
			}
		}
	}
}