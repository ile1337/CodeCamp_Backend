package mk.ukim.finki.codecamp.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoSuchIdException extends RuntimeException {
    public NoSuchIdException(Long id) {
        super(String.format("Can't find id: %d", id));
    }
}
