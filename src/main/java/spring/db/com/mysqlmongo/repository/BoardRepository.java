package spring.db.com.mysqlmongo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.db.com.mysqlmongo.entity.BoardEntity;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    // 원하는 인터페이스를 선언하세요 :)
    List<BoardEntity> findByTitle(String title);
}
