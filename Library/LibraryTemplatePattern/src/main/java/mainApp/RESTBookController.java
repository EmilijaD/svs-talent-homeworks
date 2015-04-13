package mainApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dao.Book;

@RestController
@RequestMapping("/rest")
public class RESTBookController {

	private BookService service;

	@Autowired
	public RESTBookController(BookService service) {
		super();
		this.service = service;
	}

	@RequestMapping(value = "/listBook", method = RequestMethod.GET)
	public List<Book> listProducts() {
		return service.listregisteredBooks();

	}

	@RequestMapping(method = RequestMethod.POST)
	public Book registerBook(@RequestBody Book book) {
		service.registerBook(book);
		return book;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Book updateBookRegistration(@RequestBody Book book,
			@PathVariable("id") Long id) {
		book.setId(id);
		service.registerBook(book);
		return book;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String unregisterBook(@PathVariable("id") Long id) {
		service.unregisterBookById(id);
		return "Success";
	}

}
