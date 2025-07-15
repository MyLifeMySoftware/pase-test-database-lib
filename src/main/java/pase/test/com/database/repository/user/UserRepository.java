package pase.test.com.database.repository.user;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pase.test.com.database.entity.user.Role;
import pase.test.com.database.entity.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    @Query("""
            SELECT u FROM User u WHERE
            LOWER(u.username) LIKE LOWER(CONCAT('%', :query1, '%')) OR
            LOWER(u.email) LIKE LOWER(CONCAT('%', :query2, '%'))
            """)
    List<User> findByUsernameContainingIgnoreCaseOrEmailContainingIgnoreCase(
            @Param("query") String query1, @Param("query") String query2);

    long countByEnabled(boolean enabled);

    long countByCreatedAtAfter(LocalDateTime date);

    @Query("SELECT COUNT(u) FROM User u JOIN u.roles r WHERE r = :role")
    long countByRolesContaining(@Param("role") Role role);

    @Query("SELECT u FROM User u JOIN u.roles r WHERE r.name = :roleName")
    List<User> findByRoleName(@Param("roleName") String roleName);

    List<User> findByEnabledTrue();

    List<User> findByEnabledFalse();

    List<User> findByLastLoginAfter(LocalDateTime date);

    List<User> findByLastLoginIsNull();

}