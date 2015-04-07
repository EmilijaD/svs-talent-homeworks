package presentation;

import java.util.Date;
import java.util.List;

import template.Template;
import dao.Book;
import dao.Loan;
import dao.Magazine;
import dao.Member;
import dao.Membership;
import dao.Publications;

public class MainApp {

	public static void main(String[] args) {

		Book book = new Book();
		book.setIsbn("luckyTry");
		book.setTitle("luckyTry1");
		new Template().save(book);
		List listBooks = new Template().listPublications(book);
		System.out.println(listBooks);

	}

}
