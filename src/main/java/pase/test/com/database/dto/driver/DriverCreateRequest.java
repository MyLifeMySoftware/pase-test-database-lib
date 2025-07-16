package pase.test.com.database.dto.driver;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DriverCreateRequest {

    @NotBlank(message = "Driver name is required")
    @Size(min = 3, max = 50, message = "Driver name must be between 3 and 50 characters")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$", message = "Driver name can only contain letters and spaces")
    private String driverName;

    @NotBlank(message = "License number is required")
    @Size(min = 3, max = 50, message = "License number must be between 3 and 50 characters")
    private String licenseNumber;

    @NotBlank(message = "Phone number is required")
    @Size(min = 10, max = 10, message = "Phone number must be exactly 10 digits")
    @Pattern(regexp = "^[0-9]+$", message = "Phone number can only contain digits")
    private String phoneNumber;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @Size(max = 100, message = "Email must not exceed 100 characters")
    private String email;
}
