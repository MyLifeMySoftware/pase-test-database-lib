package pase.test.com.database.repository.order;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pase.test.com.database.entity.driver.Driver;
import pase.test.com.database.entity.order.Order;
import pase.test.com.database.entity.order.OrderStatus;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

    Optional<Order> findByOrderNumber(String orderNumber);

    boolean existsByOrderNumber(String orderNumber);

    @Query("SELECT o FROM Order o WHERE o.deleted = false ORDER BY o.createdOn DESC")
    Page<Order> findAllActiveOrders(Pageable pageable);

    @Query("SELECT o FROM Order o WHERE o.orderStatus = :status AND o.deleted = false ORDER BY o.createdOn DESC")
    Page<Order> findByOrderStatus(@Param("status") OrderStatus status, Pageable pageable);

    @Query("SELECT o FROM Order o WHERE o.driver = :driver AND o.deleted = false ORDER BY o.createdOn DESC")
    List<Order> findByDriver(@Param("driver") Driver driver);

    @Query("""
        SELECT o FROM Order o WHERE o.deleted = false
        AND o.createdOn BETWEEN :startDate AND :endDate
        ORDER BY o.createdOn DESC
            """)
    Page<Order> findByDateRange(@Param("startDate") LocalDateTime startDate,
                                @Param("endDate") LocalDateTime endDate,
                                Pageable pageable);

    @Query("""
        SELECT o FROM Order o WHERE o.deleted = false AND (
        LOWER(o.origin) LIKE LOWER(CONCAT('%', :location, '%')) OR
        LOWER(o.destination) LIKE LOWER(CONCAT('%', :location, '%'))
        ) ORDER BY o.createdOn DESC
            """)
    Page<Order> findByOriginOrDestination(@Param("location") String location, Pageable pageable);

    @Query("""
        SELECT o FROM Order o WHERE o.deleted = false
        AND (:status IS NULL OR o.orderStatus = :status)
        AND (:startDate IS NULL OR o.createdOn >= :startDate)
        AND (:endDate IS NULL OR o.createdOn <= :endDate)
        AND (:location IS NULL OR LOWER(o.origin) LIKE LOWER(CONCAT('%', :location, '%'))
             OR LOWER(o.destination) LIKE LOWER(CONCAT('%', :location, '%')))
        ORDER BY o.createdOn DESC
            """)
    Page<Order> findWithFilters(@Param("status") OrderStatus status,
                                @Param("startDate") LocalDateTime startDate,
                                @Param("endDate") LocalDateTime endDate,
                                @Param("location") String location,
                                Pageable pageable);

    @Query("SELECT COUNT(o) FROM Order o WHERE o.orderStatus = :status AND o.deleted = false")
    long countByOrderStatus(@Param("status") OrderStatus status);

    @Query("SELECT COUNT(o) FROM Order o WHERE o.driver = :driver AND o.deleted = false")
    long countByDriver(@Param("driver") Driver driver);
}