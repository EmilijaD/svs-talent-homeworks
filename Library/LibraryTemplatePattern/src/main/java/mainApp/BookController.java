package mainApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.Book;

@Controller
@RequestMapping("/books")
public class BookController {

	private BookService service;

	@Autowired
	public BookController(BookService service) {
		super();
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.GET)
	String index(Model model) {
		model.addAttribute("books", service.listregisteredBooks());
		Book book = new Book();
		model.addAttribute("book", book);
		return "BookManagement";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String createOrUpdateBook(@ModelAttribute("book") Book book) {

		service.registerBook(book);

		return "redirect:/books";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable("id") Long id, Model model) {
		final Book book = service.findBook(id);
		model.addAttribute("book", book);
		return "EditBook";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Book updateBookRegistration(@RequestBody Book book,
			@PathVariable("id") Long id) {
		book.setId(id);
		service.registerBook(book);
		return book;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id, Model model) {
		this.deleteBook(id);
		return "redirect:/books";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String deleteBook(@RequestParam("id") Long id) {
		service.unregisterBookById(id);
		return "redirect:/books";
	}

}
