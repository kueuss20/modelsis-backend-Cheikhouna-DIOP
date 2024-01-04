package modelsis.cheikhounadiop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import modelsis.cheikhounadiop.dto.ProductDto;
import modelsis.cheikhounadiop.exception.ProductException;
import modelsis.cheikhounadiop.service.ProductService;

@RestController
@RequestMapping(path = "product", consumes = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

	
	@Autowired
	private ProductService productService;
	
	 @PostMapping
	  public Long addProduct(@RequestBody ProductDto dto) throws ProductException {
		  
		 return productService.add(dto);
	  }
	 @PutMapping
	  public Long updateProduct(@RequestBody ProductDto dto) throws ProductException {
		  
		 return productService.update(dto);
	  }
	 @GetMapping(consumes = MediaType.ALL_VALUE)
	  public List<ProductDto> listProduct() {
		  
		 return productService.list();
	  }
}
