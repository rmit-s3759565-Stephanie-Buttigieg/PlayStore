public class Application extends Content{
	
	private String OSType;
	

	// constructor incl. price with addition of OStype
	public Application(String contentId, String contentName, double price, String OSType) {
		super(contentId, contentName, price);
	
		this.OSType = OSType;
		}


	// constructor excl. price with addition of OStype
	public Application(String contentId, String contentName, String OSType) {
		this(contentId, contentName, 0, OSType);
	}
	
	
	// getters
	public String getOSType() {
		return this.OSType;
	}
	
	
	// show content for Application
	public void showContent() {
		System.out.print(super.getStandardContent() + "\t" + getOSType());
	}
}