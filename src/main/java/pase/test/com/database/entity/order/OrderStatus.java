package pase.test.com.database.entity.order;

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
@Table(name = "tc_order_status")
@Comment("Order status list")
public class OrderStatus extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 4005399473005749088L;

    @NotBlank(message = "Order status is required")
    @Size(min = 3, max = 30, message = "Order status must be between 3 and 50 characters")
    @Comment("Order status to display")
    @Column(unique = true, nullable = false)
    private String statusLabel;
}
