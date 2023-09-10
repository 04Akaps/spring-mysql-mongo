package spring.db.com.mysqlmongo.repository;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.db.com.mysqlmongo.entity.Blog;

@Repository
public interface BlogRepository extends CrudRepository<Blog, String> { }
