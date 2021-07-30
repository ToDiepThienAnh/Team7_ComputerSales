package cybersoft.backend.finalproject.ecommerce.commondata.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import cybersoft.backend.finalproject.ecommerce.utils.ErrorUtils;


public class ResponseHandler {
	private static List<String> emptyStringList = new LinkedList<String>();
	
	public static ResponseEntity<Object> getResponse(Object content, HttpStatus status){
		Map<String, Object> map = new HashMap<>();
		map.put("content", content);
		map.put("message", emptyStringList);
		map.put("status", status.value());
		
		return new ResponseEntity<>(map, status);
	}
	
	public static ResponseEntity<Object> getResponse(BindingResult bindingResult, HttpStatus status){
		Map<String, Object> map = new HashMap<>();
		map.put("content", emptyStringList);
		map.put("message", ErrorUtils.getErrorMessages(bindingResult));
		map.put("status", status.value());
		
		return new ResponseEntity<>(map, status);
	}
	
	public static ResponseEntity<Object> getResponse(String error, HttpStatus status){
		Map<String, Object> map = new HashMap<>();
		map.put("content", emptyStringList);
		map.put("message", ErrorUtils.errorOf(error));
		map.put("status", status.value());
		
		return new ResponseEntity<>(map, status);
	}
	
	public static ResponseEntity<Object> getResponse(HttpStatus status){
		Map<String, Object> map = new HashMap<>();
		map.put("content", emptyStringList);
		map.put("message", emptyStringList);
		map.put("status", status.value());
		
		return new ResponseEntity<>(map, status);
	}
}
