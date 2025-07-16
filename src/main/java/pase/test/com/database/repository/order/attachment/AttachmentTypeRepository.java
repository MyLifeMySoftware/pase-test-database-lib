package pase.test.com.database.repository.order.attachment;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pase.test.com.database.entity.order.attachment.AttachmentType;

@Repository
public interface AttachmentTypeRepository extends JpaRepository<AttachmentType, String> {

    Optional<AttachmentType> findByTypeLabel(String typeLabel);

    boolean existsByTypeLabel(String typeLabel);

    @Query("SELECT at FROM AttachmentType at WHERE at.enabled = true AND at.deleted = false ORDER BY at.typeLabel")
    List<AttachmentType> findAllActiveTypes();

    @Query("""
        SELECT at FROM AttachmentType at WHERE at.enabled = true AND at.deleted = false
        AND LOWER(at.allowedExtensions) LIKE LOWER(CONCAT('%', :extension, '%'))
            """)
    List<AttachmentType> findByAllowedExtension(@Param("extension") String extension);
}