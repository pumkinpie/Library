import java.util.ArrayList;
import java.util.List;

public class Library {
	  
	private final String address;
	private List<Book> books;
	
	public Library(String address) {
		this.address = address;
		this.books = new ArrayList<Book>();
	}
    
    public void addBook(Book book) {
    	this.books.add(book);
    }
    
    public void borrowBook(String bookTitle) {
    	boolean existBook = false;
    	for(Book book : this.books) {
    		if(book.getTitle().equals(bookTitle)) {
    			if(book.isBorrowed()) {
    				System.out.println("Sorry this book is already borrowed");
    			}else {
    				book.borrowed();
    				System.out.println("Congrats! You rented the book");
    			}
    			existBook = true;
    			break;
    		}
    	}
    	if(!existBook) {
    		System.out.println("Sorry we don't have that in our store");
    	}
    } 
    
    public void returnBook(String bookTitle) {
    	boolean existBook = false;
    	for(Book book : this.books) {
    		if(book.getTitle().equals(bookTitle)) {
    			if(book.isBorrowed()) {
    				book.returned();
    				System.out.println("You have returned the book: " + bookTitle);
    			}else {
    				System.out.println("This book is already returned");
    			}
    			existBook = true;
    			break;
    			}
    		}
    	    if(!existBook) {
    	    	System.out.println("This book is not in the Store");
    	    }
    	}

	public void printOpeningHours() {
		System.out.println("Library opens at 9:00AM to 5:00PM");
		
	}
	public void printAddress() {
		System.out.println(" "+ this.address);
	}
	public void printAvailableBooks() {
		boolean booksAvailableInStore = false;
		for(Book book: this.books) {
		if(!book.isBorrowed()) {
			booksAvailableInStore = true;
			System.out.println(" " + book.getTitle());
		    }
		}
		if(!booksAvailableInStore) {
			System.out.println("No books in the store");
		}
	}
}




    







