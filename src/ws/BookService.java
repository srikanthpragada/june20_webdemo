package ws;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(targetNamespace="com.st") 
public class BookService {

	 @WebMethod
	 public  Book[] getBooks() {
		  ArrayList<Book> books = new ArrayList<>();
		  
		  books.add( new Book("Java Comp. Ref.", 500));
		  books.add( new Book("JSF in Action", 450));
		  books.add( new Book("AngularJS", 400));
		 
		  return  (Book[]) books.toArray(); 
	 }
}
