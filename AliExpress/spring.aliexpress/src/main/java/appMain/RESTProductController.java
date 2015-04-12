package appMain;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/com")
public class RESTProductController {

	private ProductService productService;

	@Autowired
	public RESTProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@RequestMapping(value = "/rest", method = RequestMethod.GET)
	public ArrayList<Produkt> listProducts() {
		return productService.listProducts();

	}

	@RequestMapping(value = "/restAdd" ,method = RequestMethod.POST)
	public @ResponseBody Produkt registerBook(@RequestBody Produkt produkt) {
		productService.addProduct(produkt);
		return produkt;
	}
}
