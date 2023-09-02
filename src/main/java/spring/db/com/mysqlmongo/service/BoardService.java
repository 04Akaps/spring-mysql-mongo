package spring.db.com.mysqlmongo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import spring.db.com.mysqlmongo.controller.BoardController;
import spring.db.com.mysqlmongo.entity.BoardEntity;
import spring.db.com.mysqlmongo.repository.BoardRepository;
import spring.db.com.mysqlmongo.response.ResourceNotFoundException;
import spring.db.com.mysqlmongo.response.Response;

import java.util.List;
import java.util.Optional;


@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    public ResponseEntity<Object> findAll() {
        List<BoardEntity> boardList = boardRepository.findAll();
        return new ResponseEntity<>(boardList, HttpStatus.OK);
    }

    public ResponseEntity<Object> findBoardByPrId(Long boardId) {
        BoardEntity board = boardRepository.findById(boardId)
                .orElseThrow(() -> new ResourceNotFoundException("Board", "id", boardId));

        return new ResponseEntity<>(board, HttpStatus.OK);
    }


}
