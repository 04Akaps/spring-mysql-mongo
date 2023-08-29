package spring.db.com.mysqlmongo.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

public class Response {

    public static ResponseEntity<Object> success(String message, Object object) {
        // 성공시 사용되는 Response
        return new ResponseEntity<>(Response.getHashMap(message, HttpStatus.OK, object), HttpStatus.OK);
    }

    public static ResponseEntity<Object> validFailed(BindingResult bindingResult, Object object) {
        // Valid 옵션에서 실패시 사용 되는 Response
        StringBuilder errors = new StringBuilder();

        bindingResult.getAllErrors().forEach(error -> {
            errors.append(error.getDefaultMessage()).append(", ");
        });
        errors.append(" is need");

        return new ResponseEntity<>(Response.getHashMap(errors, HttpStatus.BAD_REQUEST, object), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Object> failed(String message, Object object) {
        // 그냥 실패시 사용되는 Response
        return new ResponseEntity<>(Response.getHashMap(message, HttpStatus.BAD_REQUEST, object), HttpStatus.BAD_REQUEST);
    }

    private static Map<String, Object> getHashMap(Object message, HttpStatus status, Object result) {
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("message", message);
        map.put("status", status);
        map.put("result", result);

        return map;
    }


}


