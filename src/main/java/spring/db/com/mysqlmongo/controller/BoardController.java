package spring.db.com.mysqlmongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spring.db.com.mysqlmongo.entity.BoardEntity;
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
        return boardService.saveBoard(board);
    }

    @GetMapping("board-paging/{page}/{size}")
    public ResponseEntity<Object> getBoardByPaging(
            @PathVariable(value = "page") int page,
            @PathVariable(value = "size") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return boardService.findAllByPaging(pageable);
    }

    @GetMapping("/board/{id}")
    public ResponseEntity<Object> getBoardById(@PathVariable(value = "id") Long boardId) {
        return boardService.findBoardByPrId(boardId);
    }

    @GetMapping("/find-all")
    public ResponseEntity<Object> findAllBoard(){
        return boardService.findAll();
    }

    @GetMapping("/find-by-title/{title}")
    public  ResponseEntity<Object> getBoardByTitle(
            @PathVariable(value = "title") String title
    ) {
        return boardService.findBoardByTitle(title);
    }

    @PutMapping("/notes/{id}")
    public ResponseEntity<Object> updateBoard(
            @PathVariable(value = "id") Long boardId,
            @Valid @RequestBody BoardEntity board)
    {

        ResponseEntity<Object> responseEntity = boardService.findBoardByPrId(boardId);

        if (responseEntity.getStatusCode() == HttpStatus.OK){
            BoardEntity existingBoard = (BoardEntity) responseEntity.getBody();
            return boardService.updateBoard(existingBoard, board);
        }else {
            return responseEntity;
        }
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<Object> deleteBoard(
            @PathVariable(value = "id") Long boardId
    ) {
        return boardService.deleteBoard(boardId);
    }







}
