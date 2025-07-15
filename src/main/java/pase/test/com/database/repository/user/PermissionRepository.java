package pase.test.com.database.repository.user;

import java.util.Optional;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pase.test.com.database.entity.user.UserPermission;

@Repository
public interface PermissionRepository extends JpaRepository<UserPermission, Long> {

    Optional<UserPermission> findByName(String name);

    boolean existsByName(String name);

    @Query("SELECT p FROM UserPermission p WHERE p.resource = :resource AND p.action = :action")
    Optional<UserPermission> findByResourceAndAction(
            @Param("resource") String resource,
            @Param("action") String action
    );

    @Query("SELECT p FROM UserPermission p WHERE p.active = true")
    Set<UserPermission> findAllActivePermissions();

    Set<UserPermission> findByResource(String resource);
}
