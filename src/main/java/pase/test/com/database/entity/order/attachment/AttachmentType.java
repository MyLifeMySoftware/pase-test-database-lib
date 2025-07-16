package pase.test.com.database.entity.order.attachment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "tc_attachment_type")
@Comment("Attachment type to be used")
public class AttachmentType extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 4005399473005749088L;

    @NotBlank(message = "Attachment type is required")
    @Size(min = 3, max = 30, message = "Attachment type must be between 3 and 50 characters")
    @Comment("Attachment type allowed")
    @Column(unique = true, nullable = false)
    private String typeLabel;

    @NotBlank(message = "Allowed extensions is required")
    @Size(min = 3, max = 30, message = "Allowed extensions must be between 3 and 50 characters")
    @Comment("Allowed extensions")
    private String allowedExtensions;
}
