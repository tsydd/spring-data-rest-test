package data.repository;

import data.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Dmitry Tsydzik
 * @since Date: 22.08.2014
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
