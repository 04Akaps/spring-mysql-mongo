package spring.db.com.mysqlmongo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.db.com.mysqlmongo.controller.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> { }
