package pase.test.com.database.exception.order;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AttachmentTypeNotFoundException extends RuntimeException {

    public AttachmentTypeNotFoundException(String message) {
        super(message);
    }

    public AttachmentTypeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}