package modelsis.cheikhounadiop.entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "CD_PRODUCT_TYPE")
public class ProductType {

	
	@Column(name ="PT_NAME",length = 90)
	@Id
	@EqualsAndHashCode.Include
	private String name;
	@Column(name ="PT_CREATE_AT")
	private Instant createAt;
}
