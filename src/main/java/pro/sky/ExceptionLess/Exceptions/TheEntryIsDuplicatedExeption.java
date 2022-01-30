package pro.sky.ExceptionLess.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TheEntryIsDuplicatedExeption extends RuntimeException {
}
