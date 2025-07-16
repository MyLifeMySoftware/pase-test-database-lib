package pase.test.com.database.uuid;

import java.io.Serial;
import java.lang.annotation.Annotation;
import java.lang.reflect.Member;
import java.util.Objects;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.generator.EventType;
import org.hibernate.id.factory.spi.CustomIdGeneratorCreationContext;
import org.hibernate.id.uuid.UuidGenerator;
import pase.test.com.database.annotations.OptionalUuidGenerator;
import pase.test.com.database.entity.BaseEntity;

@Slf4j
public class ExistingIdOrRandomUuidGenericGenerator extends UuidGenerator {
    @Serial
    private static final long serialVersionUID = -633324292464395571L;

    public ExistingIdOrRandomUuidGenericGenerator(
            OptionalUuidGenerator config,
            Member idMember,
            CustomIdGeneratorCreationContext creationContext
    ) {
        super(
                new org.hibernate.annotations.UuidGenerator() {
                    @Override
                    public Class<? extends Annotation> annotationType() {
                        return org.hibernate.annotations.UuidGenerator.class;
                    }

                    @Override
                    public Style style() {
                        return config.style();
                    }
                },
                idMember,
                creationContext
        );
    }

    @Override
    public Object generate(
            SharedSessionContractImplementor session,
            Object owner,
            Object currentValue,
            EventType eventType
    ) {
        if (owner instanceof BaseEntity baseAuditedEntity) {
            var id = baseAuditedEntity.getId();
            currentValue = Optional.ofNullable(currentValue).orElse(id);
        }
        return Objects.isNull(currentValue) ? super.generate(session, owner, currentValue, eventType) : currentValue;
    }
}
