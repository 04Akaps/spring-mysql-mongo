package spring.db.com.mysqlmongo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spring.db.com.mysqlmongo.dto.BoardDTO;

@Controller
@RequestMapping("/board")
@ResponseBody
public class Board {
    @PostMapping("/save")
    public String saveBoard(@RequestBody BoardDTO board) {
        return board.getWriter();
    }

}
