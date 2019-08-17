public class CreateTestData {
	
    public void CreateTestData(PlayStore store){
    	
        // new publications
     	System.out.println("Add Publications to store\n");
        
    	String[] authors1 = {"L. Tolstoy"};
        Book b1 = new Book ("b1", "War and Peace", 12.55, "The Russian Messenger", 1225, authors1);
                
        String[] authors2 = {"F. Scott Fitzgerald"};
        Book b2 = new Book ("b2", "The great gatsby", 10, "Charles Scribner's Sons", 180, authors2);
                
        String[] authors3 = {"Thomas H. Cormen", "Charles E. Leiserson", "Ronald L. Rivest", "Clifford Stein"};
        Book b3 = new Book ("b3", "Introduction to algorithms", 100, "MIT Press", 1312, authors3);

        Magazine m1 = new Magazine("m1", "Forbes", 8.99, "Forbes Media", 50, 201904);
              
        store.addContent(b1);
        store.addContent(b2);
        store.addContent(b3);
        store.addContent(m1);
        
    	System.out.println();

        // new applications
    	System.out.println("Add Applications to Store\n");

        Application g1 = new Application("g1", "Pokemon", 5.3, "androidV4");   
        Application g2 = new Application("g2", "Pokemon", 5, "iOSV10");

        //a free app
        Application app1 = new Application("app1", "Calendar", "androidV3"); 

        store.addContent(g1);
        store.addContent(g2);
        store.addContent(app1);

    	System.out.println();
                
        // Adding new users

    	System.out.println("Add Users to Store\n");

        User u1 = new User("u1", "John Doe", "0412000", 50);
        User u2 = new User("u2", "Mary Poppins", "0433191");  
        User u3 = new User("u3", "Dave Smith", "0413456", 1000);
        User u4 = new User("u4", "Jackie Chan", "0417654");
                
        store.addUser(u1);
        store.addUser(u2);
        store.addUser(u3);
        store.addUser(u4);

    	System.out.println();
   
        // Adding comments

    	System.out.println("Add comments\n");

        Comment comment1 = new Comment(u1, "This is a fantastic game!");
        g1.addReview(comment1);
                
        Comment comment2 = new Comment(u2, "I never liked this game!");
        g1.addReview(comment2);
                
        g1.addReview(new Comment(u3, "The game crashes frequently"));
 
        b1.addReview(new Comment(u2, "I love Tolstoy!"));
                                
    	System.out.println();
	    	
    }
}