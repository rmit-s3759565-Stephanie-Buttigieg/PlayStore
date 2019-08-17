import java.util.ArrayList;

public class User {
	
	// instance variables for user class
	private String userId;
	private String userName;

	private double	availableFund;
	private boolean	isPremium;
	
	// HashMap to contain user purchases
	private ArrayList<Content>	userPurchases = new ArrayList<Content>();

	// set constants (defaults)
	// Available fund				- 500
	// Discount for Premium Users	- 20%
	// Cost to become Premium user	- 100
	final static double DEFAULTFUND 	= 500;
	final static double PREMIUMDISCOUNT = 0.2;
	final static double PREMIUMCOST 	= 100;
	
	private Utilities util = new Utilities();

	
	// constructor with a specific fund
	public User (String userId, String userName, String userPhone, double availableFund) {
		this.userId			= userId;
		this.userName		= userName;
		this.availableFund	= availableFund;
		this.isPremium		= false;
	}

	
	// constructor with fund set as default 
	public User (String userId, String userName, String userPhone) {
		this(userId, userName, userPhone, DEFAULTFUND);
	}
	
	
	// getters
	public String getUserId() {
		return this.userId;
	}
	
	
	public String getUserName() {
		return this.userName;
	}
	
	
	public double getAvailableFund() {
		return this.availableFund;
	}


	// decrease funds
	public void decreaseFund(double val) {
		this.availableFund -= val;
	}

	
	// increase funds
	public void increaseFund(double val) {
		this.availableFund += val;
	}
	

	// check funds available
	public boolean hasFunds(double val) {
		boolean returnVal = false;
		
		// check if value passed is available in user's funds
		if (val <= this.getAvailableFund()) {
			returnVal = true;
		}
		
		return returnVal;
	}

	
	// returns true when user is Premium	
	public boolean isPremium() {
		return this.isPremium;
	}

	
	// make user Premium
	public void makePremium() {
		this.isPremium = true;
	}

	
	// remove user from Premium
	public void removePremium() {
		this.isPremium = false;
	}

	
	// transactional methods
	// purchases
	public void buyContent(Content content) throws PlayStoreException {
		
		// get price for content being purchased
		double	price		= content.getPrice();
		String	isPremium	= "";
		
		// check if user is Premium
		if (this.isPremium()) {
			// apply discount
			price = price - (price * PREMIUMDISCOUNT);
			isPremium = "[P]";			
		}
		
		// check if user has enough available funds to make purchase
		if ( this.hasFunds(price) == false) {
			throw new PlayStoreException ("Not enough funds available for user " + this.getUserId() + ". Purchase declined.");
		}
		
		// record purchase
		userPurchases.add(content);
		
		// deduct purchase from funds
		this.decreaseFund(price);
		
		// add downloads
		content.addDownload();

		System.out.printf("Purchase of %s completed @ $%.2f%s. Remaining funds: $%.2f.\n", content.getContentName(), price, isPremium, this.getAvailableFund());
	}
	
	
	// upgrade status
	public void becomePremium() throws PlayStoreException {
		
		// check if user is already Premium
		if (this.isPremium()) {
			throw new PlayStoreException ("User is already Premium.");
		}
		
		// check if user has funds available to become premium
		if ( this.hasFunds(PREMIUMCOST) == false) {
			throw new PlayStoreException ("Not enough funds available to make user premium. Request declined.");
		}
		
		// make user premium
		this.makePremium();
		this.decreaseFund(PREMIUMCOST);
				
		System.out.println("User " + this.getUserName() + " (" + this.getUserId() + ") is upgraded to Premium.");
		System.out.printf("Remaining funds: $%.2f.\n", this.getAvailableFund());
	}
	
	
	// report user's purchases
	public void showContentBought() {
		
		int size = userPurchases.size();
		
		if (size == 0) {
			System.out.println("\nUser " + this.userName + "(" + this.userId + ") made no purchases.");

		} else {
			System.out.println("\nPurchases for " + this.userName + "(" + this.userId + ")\n" +
									util.getReportHeader());
		
			// list the purchases
			for (int i = 0; i < size; i++) {
			
				String classname = userPurchases.get(i).getClass().getName();
				
				switch (classname) {
				
					case "Application":	((Application) userPurchases.get(i)).showContent();
										break;
					
					case "Book":		((Book) userPurchases.get(i)).showContent();
										break;
	
					case "Magazine":	((Magazine) userPurchases.get(i)).showContent();
										break;
										
					default:			System.out.println("Unrecognised content type purchased.");
										break;
				}
	
				System.out.println();
			}
		}

		System.out.println(util.getReportFooter() + "\n");
	}	
}