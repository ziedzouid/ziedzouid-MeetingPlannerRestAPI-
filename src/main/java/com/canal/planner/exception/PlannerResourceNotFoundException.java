/**
 * 
 */
package com.canal.planner.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author zzouid
 *
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PlannerResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;



	public PlannerResourceNotFoundException() {
		super();
	}

	public PlannerResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public PlannerResourceNotFoundException(String message) {
		super(message);
	}

	public PlannerResourceNotFoundException(Throwable cause) {
		super(cause);
	}

}
