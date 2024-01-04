package modelsis.cheikhounadiop.entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "CD_PRODUCT")
@SequenceGenerator(name = "SEQ_FACTURES", sequenceName = "SEQ_PRODUCT", initialValue = 100, allocationSize = 10)
public class Product {

	
	@Column(name="P_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_PRODUCT")
	@EqualsAndHashCode.Include
	private Long id;
	private String name;
	@JoinColumn(name ="P_TYPE")
	@ManyToOne(fetch = FetchType.LAZY)
	private ProductType type;
	@Column(name ="P_CREATE_AT")
	private Instant createAt;
}
