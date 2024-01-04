package modelsis.cheikhounadiop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import modelsis.cheikhounadiop.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(value = "select p from Product p")
	@EntityGraph(attributePaths = "type")
	List<Product> findAllProducts();

	Optional<Product> findByName(String name);

}
