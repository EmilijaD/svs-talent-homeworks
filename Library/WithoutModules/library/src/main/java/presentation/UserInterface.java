package presentation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import businessLogic.BookBL;
import dao.Book;

public class UserInterface {

	public static void main(String[] args) throws SQLException {

		System.out.println("Welcome to the Librery Service");
		System.out.println("Your options are: ");
		System.out.println("1 - Register Book");
		System.out.println("2 - List Registered Books");
		System.out.println("3 - Update Book Registrations");
		System.out.println("4 - Unregister Books");
		System.out.println("Insert the number of the option you choose:");

		Scanner scanner = new Scanner(System.in);
		BookBL bookbl = new BookBL();
		while (scanner.hasNext()) {
			int option = scanner.nextInt();
			switch (option) {
			case 1:
				System.out.println("Vnesi isbn i naslov na knigata: ");
				String isbn = scanner.next();
				if (isbn != null) {
					String title = scanner.next();
					Book book = new Book(isbn, title);
					bookbl.insert(book);
				}

				break;
			case 2:
				ArrayList<Book> lista = bookbl.list();
				for (int i = 0; i < lista.size(); i++) {
					System.out.println(lista.get(i));

				}
				break;
			case 3:
				System.out.println("Vnesi go momentalniot isbn na knigata");
				System.out
						.println("Vnesi go noviot isbn na knigata i naslovot");
				String currentIsbn = scanner.next();
				String newIsbn = scanner.next();
				String newTitle = scanner.next();

				bookbl.update(currentIsbn, newIsbn, newTitle);
				break;
			case 4:
				System.out
						.println("Vnesi isbn na knigata koja treba da e izbrisana");
				String BookIsbn = scanner.next();
				bookbl.delete(BookIsbn);
			default:
				break;
			}

		}
		scanner.close();
	}
}
