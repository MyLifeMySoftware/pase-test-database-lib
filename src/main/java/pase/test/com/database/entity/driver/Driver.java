package pase.test.com.database.entity.driver;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
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
@Table(name = "tr_driver")
@Comment("Drivers registered in the system")
public class Driver extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 4005399473005749088L;

    @NotBlank(message = "Driver name is required")
    @Size(min = 3, max = 50, message = "Driver name must be between 3 and 50 characters")
    @Comment("Driver name or username")
    @Column(unique = true, nullable = false)
    private String driverName;

    @NotBlank(message = "License number is required")
    @Size(min = 3, max = 50, message = "License number must be between 3 and 50 characters")
    @Column(unique = true, nullable = false)
    @Comment("Driver license number")
    private String licenseNumber;

    @NotBlank(message = "Phone number is required")
    @Size(min = 3, max = 10, message = "Phone number must be between 3 and 10 characters")
    @Column(unique = true, nullable = false)
    @Comment("Driver phone number")
    private String phoneNumber;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @Column(unique = true, nullable = false)
    @Comment("Driver email")
    private String email;
}