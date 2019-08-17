import java.util.Scanner;

public class PlayStoreMain {

	public static void main(String[] args) {

        PlayStore		store	= new PlayStore();
        PlayStoreMenu	menu	= new PlayStoreMenu();

        Scanner	console = new Scanner(System.in);

        String	option		= "";
    
        boolean returnVal	= true;

        // display the menu
        do {
        	try {
	        	menu.showMenu();
	
	        	// get option
	        	option = console.nextLine();
	        	
	        	// check option entered is valid
	        	menu.isValidMenuOption(option);
	        		
	       		// action the selected option
	        	returnVal = menu.actionMenu(Integer.parseInt(option), store);

        	}

        	// catch any program exceptions
        	catch (PlayStoreException pse) {

            	// error occurred; show menu again
            	System.out.println(pse.getMessage());
           	
            }

        	// catch any runtime exceptions
        	// this will terminate program
            catch (Exception e) {

            	// runtime error occurred; terminate program
            	System.out.println("Unexpected error occurred. " + e.getMessage() + ". Program terminated.");
           	
            	returnVal = false;
            }

        } while (returnVal == true);
    }
}