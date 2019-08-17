public class SimulateTransactions {
	
    public void SimulateTransactions(PlayStore store){
    	
    	try {
	    	
	    	// Simulating transactions, showing content, comments etc etc.  
	        // They can be driven by menu input as well.
    		
    		User u1 = store.getUserFromId("u1");
    		User u2 = store.getUserFromId("u2");
    		User u3 = store.getUserFromId("u3");
    		User u4 = store.getUserFromId("u4");
    		
    		Content b1 = store.getContentFromId("b1");
    		Content b2 = store.getContentFromId("b2");
    		Content b3 = store.getContentFromId("b3");
    		
    		Content m1 = store.getContentFromId("m1");
    		
    		Content g1 = store.getContentFromId("g1");

    		Content app1 = store.getContentFromId("app1");
	 
	    	System.out.println("Simulate transactions\n");
	  
//	    	System.out.printf("Purchases by user 1 with %.2f funds available.\n", u1.getAvailableFund());
//	        u1.buyContent(b1);
//	        u1.buyContent(b3);
//	        u1.buyContent(m1);
//	        
//	    	System.out.println();

//	     	System.out.printf("Purchases by user 4 and Make Premium with %.2f funds available.\n", u4.getAvailableFund());
//	        u4.buyContent(g1);
//	        u4.becomePremium();
//	        u4.buyContent(g1);
//
//	    	System.out.println();

//	     	System.out.printf("Make user 2 Premium and purchase items with %.2f funds available.\n", u2.getAvailableFund());
//	        u2.becomePremium();
//	        u2.becomePremium();
//	        u2.buyContent(b1);
//	        u2.buyContent(g1);
//
//	    	System.out.println();

//	     	System.out.printf("Make user 3 Premium and purchase items with %.2f funds available.\n", u3.getAvailableFund());

//	        u3.becomePremium();
//	        u3.buyContent(b1);
//	        u3.buyContent(g1);

//	    	System.out.println();

//	        System.out.println("Show all content\n");
//	        store.showContent();
//	        System.out.println("");
	        
//	        System.out.println("Applications\n");
//	        store.showContent("Application");
//	    	System.out.println();

//	        System.out.println("Books\n");
//	        store.showContent("Book");
//	    	System.out.println();

//	        System.out.println("Magazines\n");
//	        store.showContent("Magazine");
//	    	System.out.println();

//	        System.out.println("Show Reviews for g1\n");
//	        g1.showReviews();
//	    	System.out.println();

//	        System.out.println("Show Purchases for users");
//	        u1.showContentBought();
//	        u2.showContentBought();
//	        u3.showContentBought();
//	        u4.showContentBought();
	        
    	}

    	catch (PlayStoreException pse) {

        	// validation exception occurred
        	System.err.println(pse);
        }
        
        catch (Exception e) {

        	// runtime error occurred; terminate program
        	System.out.println("Unexpected error occurred.");
        }
        
    }
}