package engine;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.function.Supplier;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "question not found")
public class NotFoundException extends RuntimeException implements Supplier<NotFoundException> {


    @Override
    public NotFoundException get() {
        return new NotFoundException();
    }
}
