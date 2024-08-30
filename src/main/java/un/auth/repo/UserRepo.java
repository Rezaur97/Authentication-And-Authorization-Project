package un.auth.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import un.auth.entity.Users;

public interface UserRepo extends JpaRepository<Users, Integer> {
	
	@Query("select u from Users u where u.email = :email")
	public Users getUserByEmail(@Param("email") String email);

}
