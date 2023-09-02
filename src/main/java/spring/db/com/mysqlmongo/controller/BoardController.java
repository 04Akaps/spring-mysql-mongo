package spring.db.com.mysqlmongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spring.db.com.mysqlmongo.entity.BoardEntity;
import spring.db.com.mysqlmongo.response.ResourceNotFoundException;
import spring.db.com.mysqlmongo.response.Response;
import spring.db.com.mysqlmongo.service.BoardService;

@RequestMapping("/board")
@ResponseBody
@Controller
public class BoardController {

    @Autowired
    BoardService boardService;


    @PostMapping("/save")
    public ResponseEntity<Object> saveBoard(@Valid @RequestBody BoardEntity board, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return Response.validFailed(bindingResult, null);
        }
        return boardService.findBoardByPrId(1L);
    }

}
