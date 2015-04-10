package presentation;

import template.DbOperations;

public class MainApp {

	public static void main(String[] args) {

		DbOperations db = new DbOperations();
		db.unregisterBook("isbn1");
		db.updateBook("newISBN", "777", "7777777");
		System.out.println(db.listregisteredBooks());
	}

}
