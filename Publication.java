public class Publication extends Content{
	
	private String publisher;
	private int pages;
	
	Utilities util = new Utilities();
	
	// constructor incl. price with addition of OStype
	public Publication(String contentId, String contentName, double price, String publisher, int pages) {
		super(contentId, contentName, price);
		
		this.publisher	= publisher;
		this.pages		= pages;
		}

	
	// constructor excl. price with addition of OStype
	public Publication(String contentId, String contentName, String publisher, int pages) {
		this(contentId, contentName, 0.00, publisher, pages);
	}


	// getters
	public String getPublisher() {
		return this.publisher;
	}
	
	
	public int getPages() {
		return this.pages;
	}
	

	// get content for publication
	public String getStandardContent() {
		return super.getStandardContent() + "\t" + util.padStr(this.publisher, ' ', 30) + "\t" + (int)this.pages;
	}
}