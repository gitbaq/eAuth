/**
 * 
 */
package com.syedbaqirali.EnterpriseAuth.auth;

import java.util.Optional;

/**
 * @author SBA
 *
 */
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUserName(String userName);
}