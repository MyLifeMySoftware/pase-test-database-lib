package pase.test.com.database.dto.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderStatusResponse {

    private String id;
    private String statusLabel;
    private Boolean enabled;
    private LocalDateTime createdOn;
    private LocalDateTime lastUpdated;
}