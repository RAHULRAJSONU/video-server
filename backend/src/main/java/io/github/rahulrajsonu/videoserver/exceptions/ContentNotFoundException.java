package io.github.rahulrajsonu.videoserver.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Content with that id was not found")
public class ContentNotFoundException extends RuntimeException{


}
