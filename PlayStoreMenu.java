import java.util.Scanner;

// this class contains methods relating to the PlayStore Menu
public class PlayStoreMenu {
	
    // display the main menu
    public void showMenu() {
    	System.out.print("\nPlaystore menu\n\n" +
    						"1. Upgrade a member to premium\n" +
    						"2. Purchase an item for a user\n" +
    						"3. List available content\n" +
    						"4. List all purchases for a member\n" +
    						"5. List all comments for an item\n" +
    						"----------------------------------\n" +
    						"6. Create test data\n" +
    						"7. Simulate transactions\n" +
    						"----------------------------------\n" +
    						"8. Create a new user\n" +
    						"9. Remove a comment\n" +
    						"----------------------------------\n" +
    						"10.Quit\n");
    }

    
    // validate the selected menu option
    public void isValidMenuOption(String selectedOption) throws PlayStoreException {
    	
    	try {

    		this.isValidMenuOption(Integer.parseInt(selectedOption));
    	}
    	
    	catch (NumberFormatException nse){
 
    		throw new PlayStoreException("Selected Option not available. Must be an number between 1 and 8.");

    	}
    }
 

    // validate the selected menu option; must be an integer 1-8
    public void isValidMenuOption(int selectedOption) throws NumberFormatException{
    	
    	if (selectedOption < 1 || selectedOption > 10) {
    		
    		throw new NumberFormatException("Selected Option not available. Must be an number between 1 and 8.");

    	}
    }
    

    // action user's selection
    public boolean actionMenu(int selectedOption, PlayStore store) throws PlayStoreException{

        Scanner console = new Scanner(System.in);

        String	input1  = "";
        String	input2  = "";
        String	input3  = "";

        boolean	returnval = true;
        
        try {

	    	switch (selectedOption) {
		
				// user selected to upgrade a member to premium
				case 1:	

						for (int tries=2; tries > 0; tries--) {
							
							System.out.println("Please enter the ID for the member to upgrade to premium: ");

							input1 = console.next();
							
							// check if user exists
							if (store.userExists(input1)) {

								// user exists, make Premium
								store.getUserFromId(input1).becomePremium();
								
								// force exit loop
								tries = 0;

							} else {

								System.out.println("User does not exist.");								
							}
						}

						break;

				// user selected to purchase an item for a member; has two tries for correct input
				case 2:	for (int tries=2; tries > 0; tries--) {
							
							System.out.println("Please enter the ID for the member making the purchase: ");
		
							input1 = console.next();
							
							// check if user exists
							if (!store.userExists(input1)) {
								
								System.out.println("User does not exist.");	
								input1 = "";

							} else {
								
								// force exit loop
								break;
							}
						}				

						// check if we have a valid user; go back to calling function when not
						if (input1 == "") {
							
							break;
						}

						// enter the content id; user has two tries to enter the correct content id
						for (int tries=2; tries > 0; tries--) {
							
							System.out.println("Please enter the ID for the content being purchased: ");
		
							input2 = console.next();
							
							// check if content exists
							if (store.contentExists(input2)) {
		
								// content exists; make purchase
								store.getUserFromId(input1).buyContent(store.getContentFromId(input2));
								
								// force exit loop
								break;
		
							} else {
		
								System.out.println("Content does not exist.");								
							}
						}								
				
						break;

				// user selected to list contents
				// a submenu will be displayed for user to choose 
				// the content to display or all content
				case 3: System.out.println("Select type of content to display: (A)pplication (B)ook (M)agazine or (X) to display all");

						input1 = console.next().toUpperCase();
						
						// show content for selected type
						if (input1.equals("A")) {
							store.showContent("Application");
							
						} else if (input1.equals("B")) {
							store.showContent("Book");
							
						} else if (input1.equals("M")) {
							store.showContent("Magazine");
							
						} else if (input1.equals("X")) {
							store.showContent();
						}
						
						break;
	
				// user selected to list all purchases for a member
				case 4:	System.out.println("Please enter the ID for the member to list all purchases: ");
						
						input1 = console.next();

						store.getUserFromId(input1).showContentBought();

						break;
	
				// user selected to list all comments for an item
				case 5:	System.out.println("Please enter the ID for the content: ");
						
						input1 = console.next();
		        		
		        		// get reviews for content
		        		store.getContentFromId(input1).showReviews();
	
						break;
				
				// user selected to create default test data 
				case 6:	CreateTestData	test = new CreateTestData();
						
						test.CreateTestData(store);
						
						break;
						
				// user selected to create default test data 
				case 7:	SimulateTransactions sim = new SimulateTransactions();
						
						sim.SimulateTransactions(store);
						
						break;
						
				case 8:	System.out.println("Enter new user Id: ");
						
						input1 = console.next();
						
						if (store.userExists(input1)) {
							
							System.out.println("User Id already exists. User not added.");
						
						} else { 
							
							System.out.println("Enter new user Name: ");
						
							// the following line has been added to force the scanner 
							// to read the full name and surname
							console.nextLine();
							input2 = console.nextLine();
							
							System.out.println("Enter new user Phone: ");
							input3 = console.next();							
						}
				
				        User u = new User(input1, input2, input3);
		                
				        store.addUser(u);

				        break;
						
				case 9:	System.out.println("Enter content Id:");
						
						input1 = console.next();
						
						if (!store.contentExists(input1)) {
							
							System.out.println("Content Id not found.");

						} else {
							
							System.out.println("Enter user Id:");
							
							input2 = console.next();
							
							if (!store.userExists(input2)) {
								
								System.out.println("User Id not found.");

							} else {
								
								store.getContentFromId(input1).removeReview(input2);
							
							}
						}
						
						break;

				// user select to quit
				case 10:returnval = false;
						
						System.out.println("*** End Playstore ***");
						
						break;
						
				// any other input; do nothing, return true to display the menu again
				default:
						break;
	    	}
        }

        catch (PlayStoreException pse) {

        	// validation exception occurred
        	System.err.println(pse.getMessage());
        }

        return returnval;
    }
}