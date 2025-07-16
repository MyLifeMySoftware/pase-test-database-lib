package pase.test.com.database.repository.order.attachment;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pase.test.com.database.entity.order.attachment.AssignmentAttachment;
import pase.test.com.database.entity.order.attachment.AttachmentType;

@Repository
public interface AssignmentAttachmentRepository extends JpaRepository<AssignmentAttachment, String> {

    @Query("SELECT aa FROM AssignmentAttachment aa WHERE aa.deleted = false ORDER BY aa.createdOn DESC")
    List<AssignmentAttachment> findAllActive();

    @Query("SELECT aa FROM AssignmentAttachment aa WHERE aa.attachmentType = :type AND aa.deleted = false")
    List<AssignmentAttachment> findByAttachmentType(@Param("type") AttachmentType type);

    @Query("""
        SELECT aa FROM AssignmentAttachment aa WHERE aa.deleted = false
        AND LOWER(aa.fileName) LIKE LOWER(CONCAT('%', :fileName, '%'))
            """)
    List<AssignmentAttachment> findByFileNameContaining(@Param("fileName") String fileName);
}