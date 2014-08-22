package data.repository;

import data.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * @author Dmitry Tsydzik
 * @since Date: 22.08.2014
 */
@RestResource(path = "users", rel = "users")
public interface UserRepository extends JpaRepository<User, Long> {
}
