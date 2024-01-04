package modelsis.cheikhounadiop.service;

import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import modelsis.cheikhounadiop.entity.ProductType;
import modelsis.cheikhounadiop.exception.ProductException;
import modelsis.cheikhounadiop.repository.ProductTypeRepository;

@Service
public class ProductTypeService {

	@Autowired
	ProductTypeRepository prdTypeRepos;
	
	
public String add(ProductType dto) throws ProductException {
		
		Optional<ProductType>  prodType = prdTypeRepos.findById(dto.getName());
		if(prodType.isEmpty()) {
		dto.setCreateAt(Instant.now());
		prdTypeRepos.save(dto);
		return dto.getName();
		}else  {
			throw new ProductException("le type de produit existe dej");
		}	
	}
}
