package modelsis.cheikhounadiop.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import modelsis.cheikhounadiop.dto.ProductDto;
import modelsis.cheikhounadiop.entity.Product;
import modelsis.cheikhounadiop.entity.ProductType;
import modelsis.cheikhounadiop.exception.ProductException;
import modelsis.cheikhounadiop.repository.ProductRepository;
import modelsis.cheikhounadiop.repository.ProductTypeRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepos;
	@Autowired
	ProductTypeRepository prdTypeRepos;
	
	public Long add(ProductDto dto) throws ProductException {
		
		Optional<ProductType>  prodType = prdTypeRepos.findById(dto.getType());
		if(prodType.isPresent()) {
		Product product = new Product();
		product.setName(dto.getName());
		product.setType(prodType.get());
		product.setCreateAt(Instant.now());
		productRepos.save(product);
		return product.getId();
		}else  {
			throw new ProductException("le type de produit est invalide");
		}	
	}
public Long update(ProductDto dto) throws ProductException {
		
	Optional<Product>  opProduct = productRepos.findById(dto.getId());
	if(opProduct.isPresent()) {
		Optional<ProductType>  prodType = prdTypeRepos.findById(dto.getType());
		if(prodType.isPresent()) {
		Product product = opProduct.get();
		product.setName(dto.getName());
		product.setType(prodType.get());
		productRepos.save(product);
		return product.getId();
		}else  {
			throw new ProductException("le type de produit est invalide");
		}	
	}else {
		throw new ProductException("le  produit est introuvable");
	}
  }

public List<ProductDto> list()  {
	
	List<Product> allProducts = productRepos.findAllProducts();
	List<ProductDto> results = new ArrayList<>();
	for(Product product:allProducts) {
		results.add(new ProductDto(product));
	}
	return results;
  }
}
