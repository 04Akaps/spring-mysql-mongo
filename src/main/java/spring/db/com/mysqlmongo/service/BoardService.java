package spring.db.com.mysqlmongo.service;


import org.springframework.stereotype.Service;
import spring.db.com.mysqlmongo.repository.BoardRepository;

@Service
public class BoardService {
    BoardRepository boardRepository;
}
