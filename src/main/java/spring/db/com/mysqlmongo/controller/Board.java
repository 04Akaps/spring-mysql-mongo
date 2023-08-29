package spring.db.com.mysqlmongo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import spring.db.com.mysqlmongo.dto.BoardDTO;
import spring.db.com.mysqlmongo.response.FailedResponse;
import spring.db.com.mysqlmongo.response.Response;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/board")
@ResponseBody
public class Board {

    @PostMapping("/save")
    public ResponseEntity<Object> saveBoard(@Valid @RequestBody BoardDTO board, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return Response.validFailed(bindingResult, null);
        }




        return null;
    }

}
