package com.app.Interview.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/* Handler for better response's quality */
public class ResponseHandler {
	public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, String errorMessage) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", message);
		map.put("status", status.value());
		map.put("error_message", errorMessage);

		return new ResponseEntity<Object>(map, status);
	}
}
