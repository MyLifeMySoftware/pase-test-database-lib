package pase.test.com.database.entity.order;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Comment;
import pase.test.com.database.entity.BaseEntity;
import pase.test.com.database.entity.driver.Driver;
import pase.test.com.database.entity.order.attachment.AssignmentAttachment;
import pase.test.com.database.entity.user.User;

@Getter
@Setter
@Entity
@NoArgsConstructor
@SuperBuilder
@Table(name = "tr_order")
@Comment("Order management")
public class Order extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 4005399473005749088L;

    @Comment("Order number")
    private String orderNumber;

    @Comment("Order origin")
    private String origin;

    @Comment("Order destination")
    private String destination;

    @Comment("Order distance in km")
    private Double distanceKm;

    @Comment("Order estimated duration in minutes")
    private Integer estimatedDurationMinutes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_user_id")
    @Comment("Created by user reference")
    private User createdByUser;

    @ManyToOne
    @Comment("Order status reference")
    private OrderStatus orderStatus;

    @ManyToOne
    @Comment("Driver reference")
    private Driver driver;

    @ManyToOne
    @Comment("Assignment attachment reference")
    private AssignmentAttachment assignmentAttachment;
}