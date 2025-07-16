package pase.test.com.database.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.hibernate.annotations.IdGeneratorType;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.annotations.ValueGenerationType;
import pase.test.com.database.uuid.ExistingIdOrRandomUuidGenericGenerator;

@IdGeneratorType(ExistingIdOrRandomUuidGenericGenerator.class)
@ValueGenerationType(generatedBy = ExistingIdOrRandomUuidGenericGenerator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface OptionalUuidGenerator {
    UuidGenerator.Style style() default UuidGenerator.Style.AUTO;
}
