

public class Book {

	private int id;
	private String isbn;
	private String title;

	public Book(int id, String isbn, String title) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.title = title;
	}

	public Book() {
	};

	public Book(String isbn, String title) {
		super();
		this.isbn = isbn;
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + "]";
	}

}
