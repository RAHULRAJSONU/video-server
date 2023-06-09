package io.github.rahulrajsonu.videoserver.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Content with this name already exists.")
public class ContentAlreadyExistsException extends RuntimeException {

}
