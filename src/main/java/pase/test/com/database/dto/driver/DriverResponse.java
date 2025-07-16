package pase.test.com.database.dto.driver;

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
public class DriverResponse {

    private String id;
    private String driverName;
    private String licenseNumber;
    private String phoneNumber;
    private String email;
    private Boolean enabled;
    private LocalDateTime createdOn;
    private LocalDateTime lastUpdated;
    private String modifiedBy;
}