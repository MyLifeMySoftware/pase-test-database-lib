package pase.test.com.database.entity.order.attachment;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Comment;
import pase.test.com.database.entity.BaseEntity;

@Getter
@Setter
@Entity
@NoArgsConstructor
@SuperBuilder
@Table(name = "tr_assignment_attachment")
@Comment("Assignment attachment allowed")
public class AssignmentAttachment extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 7332315631459191054L;

    @ManyToOne
    @Comment("Attachment type reference")
    private AttachmentType attachmentType;

    @Size(min = 3, max = 100, message = "File name must be between 3 and 50 characters")
    @Comment("File name or title")
    private String fileName;

    @Size(min = 3, max = 1000, message = "File path must be between 3 and 1000 characters")
    @Comment("File path")
    private String filePath;

    @Comment("File size in bytes")
    private Long fileSizeBytes;
}