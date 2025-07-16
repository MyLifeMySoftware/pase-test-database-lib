package pase.test.com.database.repository.order;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pase.test.com.database.entity.order.OrderStatus;

@Repository
public interface OrderStatusRepository extends JpaRepository<OrderStatus, String> {

    Optional<OrderStatus> findByStatusLabel(String statusLabel);

    boolean existsByStatusLabel(String statusLabel);

    @Query("SELECT os FROM OrderStatus os WHERE os.enabled = true AND os.deleted = false ORDER BY os.statusLabel")
    List<OrderStatus> findAllActiveStatuses();

    @Query("SELECT os FROM OrderStatus os WHERE os.enabled = :enabled AND os.deleted = false")
    List<OrderStatus> findByEnabled(@Param("enabled") boolean enabled);
}