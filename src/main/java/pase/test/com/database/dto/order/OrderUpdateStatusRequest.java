package pase.test.com.database.dto.order;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderUpdateStatusRequest {

    @NotBlank(message = "Status is required")
    private String statusLabel;
}
