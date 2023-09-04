package spring.db.com.mysqlmongo.service;

import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.mongodb.client.MongoClient;
import spring.db.com.mysqlmongo.repository.BlogRepository;

@Service
public class BlogService {

    private BlogRepository blogRepository;

    public ResponseEntity<Object> findAllBlog() {
        return blogRepository.findAll();
    }
}
