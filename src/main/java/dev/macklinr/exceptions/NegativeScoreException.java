package dev.macklinr.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY, reason = "Score can't be negative")
public class NegativeScoreException extends RuntimeException
{
}
