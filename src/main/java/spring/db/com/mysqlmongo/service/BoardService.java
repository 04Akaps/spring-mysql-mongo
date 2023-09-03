package spring.db.com.mysqlmongo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import spring.db.com.mysqlmongo.entity.BoardEntity;
import spring.db.com.mysqlmongo.repository.BoardRepository;
import spring.db.com.mysqlmongo.response.Response;

import java.util.Collections;
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

    public ResponseEntity<Object> findAllByPaging(Pageable pageable) {
        Page<BoardEntity> boardPage = boardRepository.findAll(pageable);

        if (boardPage.isEmpty()) {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.OK);
        }

        return Response.success("Success To Get Board", boardPage.getContent());
    }

    public ResponseEntity<Object> findBoardByPrId(Long boardId) {
        Optional<BoardEntity> boardOptional = boardRepository.findById(boardId);
        if (boardOptional.isPresent()){
            return Response.success("findBoardByPrId Success", boardOptional.get());
        }else {
            return Response.failed("Board Not Found", null, HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Object> findBoardByTitle(String title) {
        List<BoardEntity> boardList = boardRepository.findByTitle(title);
        return Response.success("findBoardByPrId Success", boardList);
    }

    public ResponseEntity<Object> saveBoard(BoardEntity board) {
        try {
            BoardEntity savedBoard = boardRepository.save(board);
            return Response.success("Success To Save Board", savedBoard);
        } catch (Exception e) {
            String errorMessage = "Failed to save board: " + e.getMessage();
            return Response.failed(errorMessage, board, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public ResponseEntity<Object> updateBoard(BoardEntity beforeEntity, BoardEntity newEntity) {
        if (beforeEntity != null){
            return Response.failed("Not Existed BeforeEntity", beforeEntity, HttpStatus.BAD_REQUEST);
        }

        beforeEntity.setTitle(newEntity.getTitle());
        beforeEntity.setContent(newEntity.getContent());

        return this.saveBoard(beforeEntity);
    }

    public ResponseEntity<Object> deleteBoard(Long  boardId) {
        try {
            boardRepository.deleteById(boardId);
            return new ResponseEntity<>("Board deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete board", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
