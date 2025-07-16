package pase.test.com.database.repository.driver;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pase.test.com.database.entity.driver.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, String> {

    Optional<Driver> findByDriverName(String driverName);

    Optional<Driver> findByLicenseNumber(String licenseNumber);

    Optional<Driver> findByEmail(String email);

    Optional<Driver> findByPhoneNumber(String phoneNumber);

    boolean existsByDriverName(String driverName);

    boolean existsByLicenseNumber(String licenseNumber);

    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phoneNumber);

    @Query("SELECT d FROM Driver d WHERE d.enabled = true AND d.deleted = false")
    List<Driver> findAllActiveDrivers();

    @Query("SELECT d FROM Driver d WHERE d.enabled = :enabled AND d.deleted = false")
    List<Driver> findByEnabled(@Param("enabled") boolean enabled);

    @Query("""
            SELECT d FROM Driver d WHERE d.deleted = false AND (
            LOWER(d.driverName) LIKE LOWER(CONCAT('%', :query, '%')) OR
            LOWER(d.email) LIKE LOWER(CONCAT('%', :query, '%')) OR
            LOWER(d.licenseNumber) LIKE LOWER(CONCAT('%', :query, '%'))
            )
            """)
    List<Driver> searchDrivers(@Param("query") String query);
}