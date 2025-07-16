package pase.test.com.database.dto.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pase.test.com.database.dto.driver.DriverResponse;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderResponse {

    private String id;
    private String orderNumber;
    private String origin;
    private String destination;
    private Double distanceKm;
    private Integer estimatedDurationMinutes;
    private OrderStatusInfo orderStatus;
    private DriverResponse driver;
    private AttachmentInfo assignmentAttachment;
    private UserInfo createdByUser;
    private LocalDateTime createdOn;
    private LocalDateTime lastUpdated;
    private String modifiedBy;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class OrderStatusInfo {
        private String id;
        private String statusLabel;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class AttachmentInfo {
        private String id;
        private String fileName;
        private String filePath;
        private Long fileSizeBytes;
        private AttachmentTypeInfo attachmentType;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class AttachmentTypeInfo {
        private String id;
        private String typeLabel;
        private String allowedExtensions;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class UserInfo {
        private Long id;
        private String username;
        private String fullName;
    }
}