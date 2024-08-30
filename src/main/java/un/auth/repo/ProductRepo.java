package un.auth.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import un.auth.entity.Products;

public interface ProductRepo extends JpaRepository<Products, Integer> {

}
