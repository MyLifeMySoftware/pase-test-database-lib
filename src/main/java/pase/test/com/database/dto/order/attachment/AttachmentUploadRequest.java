package pase.test.com.database.dto.order.attachment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttachmentUploadRequest {

    @NotNull(message = "File is required")
    private MultipartFile file;

    @NotBlank(message = "Attachment type is required")
    private String attachmentTypeLabel;
}
