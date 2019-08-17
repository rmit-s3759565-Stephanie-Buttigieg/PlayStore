public class Magazine extends Publication{
		
	private double volume;

	
	// constructor incl. price with addition of OStype
	public Magazine (String contentId, String contentName, double price, String publisher, int pages, double volume) {
		super(contentId, contentName, price, publisher, pages);
			
		this.volume = volume;
		}

	// constructor excl. price with addition of OStype
	public Magazine(String contentId, String contentName, String publisher, int pages, double volume) {
		this(contentId, contentName, 0.00, publisher, pages, volume);
	}
	
	
	// get volume
	public double getVolume() {
		return this.volume;
	}
	
	
	// show content for magazine
	public void showContent() {
		System.out.print(super.getStandardContent() + "\t" + (int)this.volume);
	}

}