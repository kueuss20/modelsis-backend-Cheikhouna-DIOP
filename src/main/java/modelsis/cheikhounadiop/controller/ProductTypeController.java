package modelsis.cheikhounadiop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import modelsis.cheikhounadiop.entity.ProductType;
import modelsis.cheikhounadiop.exception.ProductException;
import modelsis.cheikhounadiop.service.ProductTypeService;

@RestController
@RequestMapping(path = "productType", consumes = MediaType.APPLICATION_JSON_VALUE)
public class ProductTypeController {

	
	@Autowired
	private ProductTypeService prodTypeService;
	
	 @PostMapping
	  public String addProduct(@RequestBody ProductType dto) throws ProductException {
		  
		 return prodTypeService.add(dto);
	  }
	 
	 
}
