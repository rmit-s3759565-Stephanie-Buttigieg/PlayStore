//You may need the following packages
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class PlayStore {
	
	// Instance variables that you need.
	// They must all be marked as private
	private HashMap<String, Content>	contentMap	= new HashMap<String, Content>();

	// Declare a private variable (array or similar) to store your User objects here
	private HashMap<String, User>		userMap		= new HashMap<String, User>();
	
	// instantiate the utilities class
	private Utilities util = new Utilities();


	public PlayStore() {
		
	}


	// *** USER RELATED UTILITIES
	
	// add a user
	public boolean addUser(User user) {
		
		boolean returnVal = false;

		String userId = user.getUserId();
		
		// check if we already have the content id registered
		if (userExists(userId) == false){

			userMap.put(userId, user);
			
			System.out.println("User " + userId + " added to store.");
			
			returnVal = true;
		}

		return returnVal;
	}	

	
	// get user from userId
	public User getUserFromId(String userId) throws PlayStoreException{

		User returnUser = null;
		
		if ( util.GetMapSize(userMap) <= 0 )
			throw new PlayStoreException ("Store has no users.");

		if(userExists(userId)) {
			
			for (Map.Entry<String, User> entry : userMap.entrySet()) {
			
				if (userId.equals(entry.getKey())) {
					returnUser = entry.getValue();
				}
			}
			
		} else {
			
			throw new PlayStoreException("User not found.");
		}

		return returnUser;
	}

	
	// check if user exists
	public boolean userExists(String userId) {
		
		boolean returnVal = false;
		
		if (userMap.containsKey(userId)){
			
			returnVal = true;
		}
		
		return returnVal;
	}

	
	// *** Content related utilities ***
	
	// add content
	public boolean addContent(Content content) {
		
		boolean returnVal = false;

		String contentId = content.getContentId();
		
		// check if we already have the content id registered
		if (contentExists(contentId) == false){
			
			contentMap.put(contentId, content);
			
			returnVal = true;
		}

		return returnVal;
	}
	
	
	// get content from Id
	public Content getContentFromId(String contentId) throws PlayStoreException{
		
		Content returnContent = null;
		
		if ( util.GetMapSize(contentMap) <= 0 )
			throw new PlayStoreException ("Store has no contents.");

		if(contentExists(contentId)) {
			
			for (Map.Entry<String, Content> entry : contentMap.entrySet()) {
			
				if (contentId.equals(entry.getKey())) {
				
					returnContent = entry.getValue();
				}
			}
			
		} else {
			
			throw new PlayStoreException("Content not found.");
		}

		return returnContent;
	}


	// returns true when the contentId exists
	public boolean contentExists(String contentId){
		
		boolean returnVal = false;

		if (contentMap.containsKey(contentId)){
			
			returnVal = true;
		}
		
		return returnVal;
	}
	
	
	// show content with no parameter passed
	// this will default to All
	public void showContent() {
		
		this.showContent("All");
	}

	
	// show the content
	// mode can be 'All' to show all content
	// or a specific content type
	// output is sorted by content id
	public void showContent(String mode){

		// check if any content has been added to the store
		if (util.GetMapSize(contentMap) == 0) {
		
			System.out.println("No content added to store.");

		} else { 
			
			// sort content by contentId
			TreeMap <String, Content> contentMapSorted = new TreeMap<>();
			
			contentMapSorted.putAll(contentMap);
			
			// show report header
			System.out.println(util.getReportHeader());
	
			for (Map.Entry<String, Content> entry : contentMapSorted.entrySet()) {
				
				// showContent
				if (mode == "All" || (entry.getValue().getClass().getName() == mode)) {
					
					if (entry.getValue() instanceof Application)
						((Application) entry.getValue()).showContent();
					
					if (entry.getValue() instanceof Book)
						((Book) entry.getValue()).showContent();
					
					if (entry.getValue() instanceof Magazine)
						((Magazine) entry.getValue()).showContent();
					
					System.out.println();
				} 
			}

			// show report footer
			System.out.println(util.getReportFooter());
		}
	}
}