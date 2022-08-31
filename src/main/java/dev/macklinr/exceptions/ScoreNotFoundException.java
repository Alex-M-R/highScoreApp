package dev.macklinr.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Score not found")
public class ScoreNotFoundException extends RuntimeException
{
}
