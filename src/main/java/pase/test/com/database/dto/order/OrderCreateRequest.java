package pase.test.com.database.dto.order;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreateRequest {

    @NotBlank(message = "Origin is required")
    @Size(min = 3, max = 100, message = "Origin must be between 3 and 100 characters")
    private String origin;

    @NotBlank(message = "Destination is required")
    @Size(min = 3, max = 100, message = "Destination must be between 3 and 100 characters")
    private String destination;

    @DecimalMin(value = "0.1", message = "Distance must be greater than 0")
    private Double distanceKm;

    @Min(value = 1, message = "Estimated duration must be at least 1 minute")
    private Integer estimatedDurationMinutes;
}