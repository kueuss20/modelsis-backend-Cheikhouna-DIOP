package modelsis.cheikhounadiop.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import modelsis.cheikhounadiop.entity.Product;

@NoArgsConstructor
@Data
public class ProductDto {

	
	private Long id;
	private String name;
	private String type;
	
	public ProductDto(Product product) {
	  this.id = product.getId();
	  this.name = product.getName();
	  this.type = product.getType().getName();
	}
}
