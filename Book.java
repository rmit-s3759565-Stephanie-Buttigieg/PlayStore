import java.util.Arrays;

public class Book extends Publication {
	
	private String author[];


	// constructor incl. price with addition of publisher, pages and author
	public Book (String contentId, String contentName, double price, String publisher, int pages, String author[]) {
		super(contentId, contentName, price, publisher, pages);
		
		this.author = Arrays.copyOf(author, author.length);
		}

	
	// constructor excl. price with addition of publisher, pages and author
	public Book(String contentId, String contentName, String publisher, int pages, String author[]) {
		this(contentId, contentName, 0.00, publisher, pages, author);
	}
	
	
	// get author(s)
	public String[] getAuthor() {
		return this.author;
	}
	
	
	// number of authors for the book
	public int getNoOfAuthors() {
		return this.author.length;
	}
	
	
	// show contents for books
	public void showContent() {
		
		System.out.print(super.getStandardContent() + "\t");
		
		for (int i=0; i < getNoOfAuthors(); i++) {

			System.out.print(this.getAuthor()[i]);
			
			if (i != getNoOfAuthors() - 1) {
				System.out.print(", ");
			}
		}
	}
}